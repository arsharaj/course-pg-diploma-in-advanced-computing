namespace Arrays
{
    internal class Program
    {
        static void MainArray(string[] args)
        {
            // CDAC -> Batches -> Students -> Marks
            Console.Write("Enter the number of batches : ");
            int batchCount = Convert.ToInt32(Console.ReadLine());
            int[][] cdac = new int[batchCount][];
            for (int i = 0; i < batchCount; i++)
            {
                Console.Write($"Enter the no of students in Batch {i} : ");
                int studentCount = Convert.ToInt32(Console.ReadLine());
                int[] batchStudents = new int[studentCount];
                for (int j = 0; j < studentCount; j++)
                {
                    Console.Write($"Enter Batch {i} Student No {j} Marks : ");
                    int marks = Convert.ToInt32(Console.ReadLine());
                    batchStudents[j] = marks;
                }
                cdac[i] = batchStudents;
            }

            Console.WriteLine("--- Cdac Details ---");
            foreach (int[] arr in cdac)
            {
                Console.WriteLine("Batch details : ");
                foreach (int x in arr)
                {
                    Console.WriteLine($"Student Marks : {x}");
                }
            }
        }

        static void Main(string[] args)
        {
            Console.Write("Enter the number of employees : ");
            int employeesCount = Convert.ToInt32(Console.ReadLine());

            Employee[] employees = new Employee[employeesCount];
            for (int i = 0; i < employeesCount; i++)
            {
                Console.Write($"Enter employee {i + 1} details (name, deptNo, basic) : ");
                employees[i] = new Employee(Console.ReadLine(), Convert.ToInt16(Console.ReadLine()), Convert.ToDecimal(Console.ReadLine()));
            }

            Employee highestSalaryEmp = null;
            decimal highestSalary = 0;
            foreach (Employee employee in employees)
            {
                decimal empSalary = employee.GetNetSalary();
                if (empSalary > highestSalary)
                {
                    highestSalary = empSalary;
                    highestSalaryEmp = employee;
                }
            }
            Console.WriteLine($"Highest Salary Emp Details : {highestSalaryEmp.Name}, {highestSalaryEmp.DeptNo}, {highestSalaryEmp.GetNetSalary()}");

            Console.WriteLine("Enter employee no to be searched : ");
            int empNo = Convert.ToInt32(Console.ReadLine());
            int index = Array.BinarySearch(employees, new Employee(empNo));
            if (index < 0)
            {
                Console.WriteLine("Employee Not Found.");
            }
            else
            {
                Employee employee = employees[index];
                Console.WriteLine($"Employee Details : {employee.Name}, {employee.DeptNo}, {employee.GetNetSalary()}");
            }
        }
    }

    class Employee : IComparable<Employee>
    {
        private string name;
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (value.Length == 0)
                {
                    Console.WriteLine("No blank names should be allowed.");
                }
                else
                {
                    name = value;
                }
            }
        }

        private static int empNoGenerator = 0;
        private int empNo;
        public int EmpNo
        {
            get
            {
                return empNo;
            }
        }

        private decimal basic;
        public decimal Basic
        {
            get
            {
                return basic;
            }
            set
            {
                if (value < 10000 || value > 100000)
                {
                    Console.WriteLine("Employee basic not within the valid range!");
                }
                else
                {
                    basic = value;
                }
            }
        }

        private short deptNo;
        public short DeptNo
        {
            get
            {
                return deptNo;
            }
            set
            {
                if (value <= 0)
                {
                    Console.WriteLine("Must be > 0");
                }
                else
                {
                    deptNo = value;
                }
            }
        }

        public Employee(string name = "", short deptNo = 0, decimal basic = 0)
        {
            empNo = ++empNoGenerator;
            Name = name;
            DeptNo = deptNo;
            Basic = basic;
        }

        public Employee(int empNo)
        {
            this.empNo = empNo;
        }

        public decimal GetNetSalary()
        {
            return Basic + (Basic * (decimal)0.10);
        }

        public int CompareTo(Employee other)
        {
            if (this.empNo < other.empNo)
            {
                return -1;
            }
            else if (this.empNo > other.empNo) 
            {
                return 1; 
            }
            else
            {
                return 0;
            }
        }
    }
}