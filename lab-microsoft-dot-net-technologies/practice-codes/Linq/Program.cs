namespace Linq
{
    internal class Program
    {
        static List<Employee> listEmp = new List<Employee>();
        static List<Department> listDept = new List<Department>();
        public static void AddRecords()
        {
            listDept.Add(new Department { DeptNo = 10, DeptName = "SALES" });
            listDept.Add(new Department { DeptNo = 20, DeptName = "MKTG" });
            listDept.Add(new Department { DeptNo = 30, DeptName = "IT" });
            listDept.Add(new Department { DeptNo = 40, DeptName = "HR" });

            listEmp.Add(new Employee { EmpNo = 1, Name = "Vikram", Basic = 10000, DeptNo = 10, Gender = "M" });
            listEmp.Add(new Employee { EmpNo = 2, Name = "Vishal", Basic = 11000, DeptNo = 10, Gender = "M" });

            listEmp.Add(new Employee { EmpNo = 3, Name = "Abhijit", Basic = 12000, DeptNo = 20, Gender = "M" });
            listEmp.Add(new Employee { EmpNo = 4, Name = "Mona", Basic = 11000, DeptNo = 20, Gender = "F" });
            listEmp.Add(new Employee { EmpNo = 5, Name = "Shweta", Basic = 12000, DeptNo = 20, Gender = "F" });

            listEmp.Add(new Employee { EmpNo = 6, Name = "Sanjay", Basic = 11000, DeptNo = 30, Gender = "M" });
            listEmp.Add(new Employee { EmpNo = 7, Name = "Arpan", Basic = 10000, DeptNo = 30, Gender = "M" });

            listEmp.Add(new Employee { EmpNo = 8, Name = "Shraddha", Basic = 11000, DeptNo = 40, Gender = "F" });
        }
        static void Main(string[] args)
        {
            AddRecords();
            // Linq Syntax : var returnValue = from single_obj in collection select something
            // var emps = from emp in listEmp select emp;
            // IEnumerable<Employee> emps = from emp in listEmp select emp;
            // var emps = from emp in listEmp select emp.Name;
            // IEnumerable<string> empNames = from emp in listEmp select emp.Name;
            // var empInfo = from emp in listEmp select new { emp.Name, emp.DeptNo };
            // var empsOnCondition = from emp in listEmp where emp.Basic > 10000 && emp.Basic < 20000 select emp;
            // var empsOnCondition = from emp in listEmp where emp.Name.StartsWith("A") select emp;
            // var empsByOrder = from emp in listEmp orderby emp.Basic select emp;
            // var empsByOrder = from emp in listEmp orderby emp.Name descending select emp;
            // var empsByOrder = from emp in listEmp orderby emp.DeptNo ascending, emp.Name descending select emp;
            // var empsJoin = from emp in listEmp join dept in listDept on emp.DeptNo equals dept.DeptNo select emp;
            // var empsJoin = from emp in listEmp join dept in listDept on emp.DeptNo equals dept.DeptNo select new { emp, dept };
            // var empsJoin = from emp in listEmp join dept in listDept on emp.DeptNo equals dept.DeptNo select new { emp.Name, dept.DeptName };
            // var emps = listEmp.Select(emp => emp);
            // var empsName = listEmp.Select(emp => emp.Name);
            // var empsInfo = listEmp.Select(emp => new { emp.Name, emp.Basic });
            // var emps = listEmp.Where(emp => emp.Basic > 10000 && emp.Basic < 20000);
            // var empsName = listEmp.Where(emp => emp.Basic > 10000 && emp.Basic < 20000).Select(emp => emp.Name);
            // var empsByOrder = listEmp.OrderBy(emp => emp.Name);
            // var empsByDescOrder = listEmp.OrderByDescending(emp => emp.Name);
            // var empsByOrder = listEmp.OrderByDescending(emp => emp.Name).ThenBy(emp => emp.Basic);
            // var empsByJoin = listEmp.Join(listDept, emp => emp.DeptNo, dept => dept.DeptNo, (emp, dept) => new { emp.Name, dept.DeptName });
            // var emp = listEmp.Single(emp => emp.EmpNo == 3);
            // var emp = listEmp.SingleOrDefault(emp => emp.EmpNo == 1);
            // Note : By default every query has deferred (delayed) execution but we can explicitly enable immediate execution using some functions
            // var emps = (from emp in listEmp select emp).ToList();
            // Employee[] empsArr = emps.ToArray();
            // Dictionary<int, Employee> empsDict = emps.ToDictionary(emp => emp.EmpNo, emp => emp);   
            // var empsGroup = from emp in listEmp group emp by emp.DeptNo;
            // var empsGroup = from emp in listEmp group emp by emp.DeptNo into empGroup select empGroup;
            // var empsGroup = from emp in listEmp group emp by emp.DeptNo into empGroup select new { empGroup, Count = empGroup.Count(), Max = empGroup.Max(emp => emp.Basic), Min = empGroup.Min(emp => emp.Basic) };
            var emps = listEmp.AsParallel().AsOrdered().Select(x => x);
            foreach (var emp in emps) 
            { 
                Console.WriteLine(emp);
            }
        }
    }
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
        public string Gender { get; set; }
        public override string ToString()
        {
            string s = Name + "," + EmpNo.ToString() + "," + Basic.ToString() + "," + DeptNo.ToString();
            return s;
        }
    }
    public class Department
    {
        public int DeptNo { get; set; }
        public string DeptName { get; set; }
    }
}