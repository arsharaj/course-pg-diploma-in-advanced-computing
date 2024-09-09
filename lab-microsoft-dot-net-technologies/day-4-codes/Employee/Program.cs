namespace Employee
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Manager empManager = new Manager("John", 1, "Developer", 70000);
            Console.WriteLine(empManager.Name + " " + empManager.GetNetSalary() + " " + empManager.Designation);

            GeneralManager genManager = new GeneralManager("Sam", 2, "Tester", 50000);
            genManager.Perks = "Playing during work time";
            Console.WriteLine(genManager.Name + " " + genManager.GetNetSalary() + " " + genManager.Designation + " " + genManager.Perks);

            Employee ceo = new CEO("Amar", 1, 900000);
            Console.WriteLine(ceo.Name + " " + ceo.GetNetSalary() + " " + ceo.DeptNo);
        }
    }

    interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }

    abstract class Employee : IDbFunctions
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

        public Employee(string name = "", short deptNo = 0, decimal basic = 0)
        {
            empNo = ++empNoGenerator;
            Name = name;
            DeptNo = deptNo;
            Basic = basic;
        }

        public decimal GetNetSalary()
        {
            Console.WriteLine("In Virtual Method");
            return Basic + (Basic * (decimal)0.10);
        }

        public void Insert()
        {
            Console.WriteLine("Employee Insert");
        }

        public void Update()
        {
            Console.WriteLine("Employee Update");
        }

        public void Delete()
        {
            Console.WriteLine("Employee Delete");
        }
    }

    class Manager : Employee, IDbFunctions
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

        public Manager(string name, short deptNo, string designation, decimal basic) : base(name: name, deptNo: deptNo, basic: basic)
        {
            Designation = designation;
        }

    }

    class GeneralManager : Manager, IDbFunctions
    {
        public string Perks { get; set; }

        public GeneralManager(string name, short deptNo, string designation, decimal basic) : base(name: name, deptNo: deptNo, designation: designation, basic: basic)
        {

        }
    }

    class CEO : Employee, IDbFunctions
    {
        private decimal basic;
        public override decimal Basic
        {
            get
            {
                return basic;
            }
            set
            {
                if (value < 100000 || value > 1000000)
                {
                    Console.WriteLine("CEOs basic not within the valid range!");
                }
                else
                {
                    basic = value;
                }
            }
        }

        public CEO(string name, short deptNo, decimal basic) : base(name: name, deptNo: deptNo, basic: basic)
        {
        }

        public new decimal GetNetSalary()
        {
            Console.WriteLine("In Sealed Method");
            return Basic + (Basic * (decimal)0.20);
        }
    }
}