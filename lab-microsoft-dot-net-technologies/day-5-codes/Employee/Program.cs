namespace Employee
{
    delegate string ValidationHandler(string message);

    internal class Program
    {
        static void Main()
        {
            try
            {
                Manager empManager = new Manager("John", 1, "Developer", 344);
                Console.WriteLine(empManager.Name + " " + empManager.GetNetSalary() + " " + empManager.Designation);
                empManager.OnValidation += EmpManager_OnValidation;

                GeneralManager genManager = new GeneralManager("Sam", 2, "Tester", 50000);
                genManager.Perks = "Playing during work time";
                Console.WriteLine(genManager.Name + " " + genManager.GetNetSalary() + " " + genManager.Designation + " " + genManager.Perks);

                Employee ceo = new CEO("Amar", 1, 900000);
                Console.WriteLine(ceo.Name + " " + ceo.GetNetSalary() + " " + ceo.DeptNo);
            }
            catch (ApplicationException e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                Console.WriteLine("Finally closing the program.");
            }
        }

        private static string EmpManager_OnValidation(string message)
        {
            return "No Blank Designation is allowed.";
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
                    throw new InvalidationNameException("No blank names allowed.");
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
                    throw new InvalidationDepartmentException("Department no cannot be 0.");
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
        public string message;
        public event ValidationHandler OnValidation;

        private string designation;
        public string Designation
        {
            get
            {
                return designation;
            }
            set
            {
                if (value.Length == 0)
                {
                    message = OnValidation(value);
                    // throw new InvalidationDesignationException("No Blank Designation is allowed.");
                }
                else
                {
                    designation = value;
                    message = null;
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
                    throw new InvalidationBasicException("Employee basic not within the valid range!");
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
                    throw new InvalidationBasicException("CEOs basic not within the valid range!");
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
            return Basic + (Basic * (decimal)0.20);
        }
    }

    class InvalidationException : ApplicationException
    {
        public InvalidationException(string message) : base(message) { }
    }

    class InvalidationRangeException : InvalidationException
    {
        public InvalidationRangeException(string message) : base(message) { }
    }

    class InvalidationBasicException : InvalidationException
    {
        public InvalidationBasicException(string message) : base(message) { }
    }

    class InvalidationDesignationException : InvalidationException
    {
        public InvalidationDesignationException(string message) : base(message) { }
    }

    class InvalidationDepartmentException : InvalidationException
    {
        public InvalidationDepartmentException(string message) : base(message) { }
    }

    class InvalidationNameException : InvalidationException
    {
        public InvalidationNameException(string message) : base(message) { }
    }
}