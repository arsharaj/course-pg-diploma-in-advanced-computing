using Microsoft.Data.SqlClient;
using System.Data;

namespace ConnectSqlDatabaseConsole
{
    internal class Program
    {
        private static async Task<SqlConnection> OpenConnectionAsync()
        {
            SqlConnection? connection = null;
            try
            {
                connection = new SqlConnection();
                connection.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=CdacActs;Integrated Security=True;";
                await connection.OpenAsync();
                Console.WriteLine("Success! Got the connection.");
            }
            catch (Exception e)
            {
                Console.WriteLine("Problem connecting to the sql database.");
                Console.WriteLine(e.Message);
            }
            return connection!;
        }
        private static void CloseConnection(SqlConnection connection)
        {
            try
            {
                if (connection == null)
                {
                    Console.WriteLine("Connection not found.");
                    return;
                }

                connection.Close();
                Console.WriteLine("Connection closed successfully.");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
        static void Main(string[] args)
        {
            try
            {
                int choice = 0;
                do
                {
                    Console.WriteLine("--- Basic CRUD Operations using C# and SqlClient ---");
                    Console.WriteLine("1. Add a new employee to the DB");
                    Console.WriteLine("2. Update an employee's information");
                    Console.WriteLine("3. Delete an employee from DB");
                    Console.WriteLine("4. Show all employees from DB");
                    Console.WriteLine("5. Use dataset to show all employees from DB");
                    Console.WriteLine("0. Exit");
                    Console.WriteLine("Enter your choice : ");
                    choice = Convert.ToInt32(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:
                            InsertNewEmployee();
                            break;
                        case 2:
                            UpdateExistingEmployee();
                            break;
                        case 3:
                            DeleteExistingEmployee();
                            break;
                        case 4:
                            ShowAllEmployees();
                            break;
                        case 5:
                            ShowAllEmployeesUsingDataset();
                            break;
                        case 0: 
                            Console.WriteLine("Thank you for using our services.");
                            break;
                        default:
                            Console.WriteLine("Enter a valid value!");
                            break;
                    }
                } while (choice != 0);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }

        private static void ShowAllEmployeesUsingDataset()
        {
            bool status = ShowAllEmployeesFromDBWithProceduresUsingDataSet();
            if (status)
            {
                Console.WriteLine("Success !");
            }
            else
            {
                Console.WriteLine("Error !");
            }
        }

        private static bool ShowAllEmployeesFromDBWithProceduresUsingDataSet()
        {
            bool status = false;
            Task<SqlConnection>? connection = null;
            try
            {
                connection = OpenConnectionAsync();
                SqlCommand command = new SqlCommand();
                command.Connection = connection.Result;
                command.CommandType = CommandType.StoredProcedure;
                command.CommandText = "GetEmployeesAndDepartments";

                using (SqlDataAdapter sqlDataAdapter = new SqlDataAdapter())
                using (DataSet dataSet = new DataSet())
                {
                    sqlDataAdapter.SelectCommand = command;
                    sqlDataAdapter.Fill(dataSet, "Employees");
                    Console.WriteLine(dataSet.Tables[1].Columns[1]);
                }

                status = true;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                CloseConnection(connection!.Result);
            }
            return status;
        }

        private static void ShowAllEmployees()
        {
            bool status = ShowAllEmployeesFromDBWithProcedures();
            if (status)
            {
                Console.WriteLine("Success !");
            }
            else
            {
                Console.WriteLine("Error !");
            }
        }
        private static bool ShowAllEmployeesFromDBWithProcedures()
        {
            bool status = false;
            Task<SqlConnection>? connection = null;
            try
            {
                connection = OpenConnectionAsync();
                SqlCommand command = new SqlCommand();
                command.Connection = connection.Result;
                command.CommandType = CommandType.StoredProcedure;
                command.CommandText = "GetEmployeesAndDepartments";

                using (SqlDataReader reader = command.ExecuteReader(CommandBehavior.CloseConnection))
                {
                    do
                    {
                        Console.WriteLine($"---------------------------------------");
                        while (reader.Read())
                        {
                            for (int i = 0; i < reader.FieldCount; i++)
                            {
                                Console.Write(reader[i] + "\t");
                            }
                            Console.WriteLine();
                        }
                        Console.WriteLine("---------------------------------------");
                    } while (reader.NextResult());
                }

                status = true;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                CloseConnection(connection!.Result);
            }
            return status;
        }
        private static void DeleteExistingEmployee()
        {
            Console.WriteLine("Enter employee number : ");
            int empNo = Convert.ToInt32(Console.ReadLine());

            bool status = DeleteFromDBWithProcedure(empNo);
            if (status)
            {
                Console.WriteLine("Employee deleted successfully.");
            }
            else
            {
                Console.WriteLine("Employee could not be deleted from the database.");
            }
        }
        private static bool DeleteFromDBWithProcedure(int empNo)
        {
            bool status = false;
            Task<SqlConnection>? connection = null;
            try
            {
                connection = OpenConnectionAsync();
                SqlCommand command = new SqlCommand();
                command.Connection = connection.Result;
                command.CommandType = CommandType.StoredProcedure;
                command.CommandText = "DeleteEmployee";

                command.Parameters.AddWithValue("ExistingEmpNo", empNo);

                int affectedRows = command.ExecuteNonQuery();
                if (affectedRows > 0)
                {
                    status = true;
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                CloseConnection(connection!.Result);
            }
            return status;
        }
        private static void UpdateExistingEmployee()
        {
            Console.Write("Enter employee number of existing employee : ");
            int existingEmpNo = Convert.ToInt32(Console.ReadLine());
            
            Employee existingEmp = new Employee();
            existingEmp.EmpNo = existingEmpNo;
            Console.Write("Enter employee name : ");
            existingEmp.Name = Console.ReadLine();
            Console.Write("Enter employee basic : ");
            existingEmp.Basic = Convert.ToDecimal(Console.ReadLine());
            Console.Write("Enter employee department number : ");
            existingEmp.DeptNo = Convert.ToInt32(Console.ReadLine());

            bool status = UpdateIntoDBWithProcedure(existingEmp);
            if (status)
            {
                Console.WriteLine("Employee Updated successfully.");
            }
            else
            {
                Console.WriteLine("Employee could not be updated in the database.");
            }
        }
        private static bool UpdateIntoDBWithProcedure(Employee existingEmp)
        {
            bool status = false;
            Task<SqlConnection>? connection = null;
            try
            {
                connection = OpenConnectionAsync();
                SqlCommand command = new SqlCommand();
                command.Connection = connection.Result;
                command.CommandType = CommandType.StoredProcedure;
                command.CommandText = "UpdateProcedure";
              
                command.Parameters.AddWithValue("Name", existingEmp.Name);
                command.Parameters.AddWithValue("Basic", existingEmp.Basic);
                command.Parameters.AddWithValue("DeptNo", existingEmp.DeptNo);
                command.Parameters.AddWithValue("ExistingEmpNo", existingEmp.EmpNo);

                int affectedRows = command.ExecuteNonQuery();
                if (affectedRows > 0)
                {
                    status = true;
                }
            } 
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                CloseConnection(connection!.Result);
            }
            return status;
        }
        private static void InsertNewEmployee()
        {
            Employee newEmployee = new Employee();
            Console.Write("Enter employee number : ");
            newEmployee.EmpNo = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter employee name : ");
            newEmployee.Name = Console.ReadLine();
            Console.Write("Enter employee basic : ");
            newEmployee.Basic = Convert.ToDecimal(Console.ReadLine());
            Console.Write("Enter employee department number : ");
            newEmployee.DeptNo = Convert.ToInt32(Console.ReadLine());

            // bool status = InsertIntoDB(newEmployee);
            bool status = InsertIntoDBWithProcedure(newEmployee);
            if (status)
            {
                Console.WriteLine("Employee added successfully to the database.");
            }
            else
            {
                Console.WriteLine("Employee could not be added to the database.");
            }
        }
        private static async Task<bool> InsertIntoDBAsync(Employee newEmployee)
        {
            bool status = false;
            Task<SqlConnection>? connection = null;
            try
            {
                connection = OpenConnectionAsync();
                SqlCommand command = new SqlCommand();
                command.Connection = connection.Result;
                command.CommandType = CommandType.Text;
                command.CommandText = "insert into Employees values (@EmpNo, @Name, @Basic, @DeptNo)";
                command.Parameters.AddWithValue("EmpNo", newEmployee.EmpNo);
                command.Parameters.AddWithValue("Name", newEmployee.Name);
                command.Parameters.AddWithValue("Basic", newEmployee.Basic);
                command.Parameters.AddWithValue("DeptNo", newEmployee.DeptNo);
                int affectedRows = command.ExecuteNonQuery();
                Console.WriteLine("Updated rows : " + affectedRows);

                if (affectedRows > 0)
                {
                    status = true;
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                CloseConnection(connection!.Result);
            }
            return status;
        }
        private static bool InsertIntoDBWithProcedure(Employee newEmployee)
        {
            bool status = false;
            Task<SqlConnection>? connection = null;
            SqlTransaction? transaction = null;
            try
            {
                connection = OpenConnectionAsync();
                SqlCommand command = new SqlCommand();
                command.Connection = connection.Result;
                transaction = connection.Result!.BeginTransaction();
                command.Transaction = transaction;
                command.CommandType = CommandType.StoredProcedure;
                command.CommandText = "InsertEmployee";
                command.Parameters.AddWithValue("EmpNo", newEmployee.EmpNo);
                command.Parameters.AddWithValue("Name", newEmployee.Name);
                command.Parameters.AddWithValue("Basic", newEmployee.Basic);
                command.Parameters.AddWithValue("DeptNo", newEmployee.DeptNo);
                int affectedRows = command.ExecuteNonQuery();
                Console.WriteLine("Updated rows : " + affectedRows);
                if (affectedRows > 0)
                {
                    status = true;
                }
                transaction.Commit();
                Console.WriteLine("Transaction commited successfully.");
            }
            catch (Exception e)
            {
                transaction!.Rollback();
                Console.WriteLine("Transaction rolled back to previous state.");
                Console.WriteLine(e.Message);
            }
            finally
            {
                CloseConnection(connection!.Result);
            }
            return status;
        }
    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public string? Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
        public override string ToString()
        {
            return EmpNo + ", " + Name + ", " + Basic + ", " + DeptNo;
        }
    }
}