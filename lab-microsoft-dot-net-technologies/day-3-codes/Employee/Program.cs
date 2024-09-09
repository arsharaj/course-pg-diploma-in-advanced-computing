namespace Employee
{
    internal class Program
    {
        static void Main(string[] args)
        {

        }
    }

    abstract class Employee
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

        public abstract decimal Basic
        {
            get;
            set;
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

        public Employee(string name = "", short deptNo = 0)
        {
            empNo = ++empNoGenerator;
            Name = name;
            DeptNo = deptNo;
        }

        public decimal GetNetSalary()
        {
            return Basic + (Basic * (decimal)0.10);
        }
    }

    class Manager : Employee
    {
        private string designation;
        public String Designation
        {
            get
            {
                return designation;
            }
            set
            {
                if (value.Length == 0)
                {
                    Console.WriteLine("No Blank Designation is allowed.");
                }
                else
                {
                    designation = value;
                }
            }
        }

        private decimal basic;
        public override decimal Basic
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

        public Manager(string name, short deptNo, string designation, decimal basic) 
        {

        }
    }
}