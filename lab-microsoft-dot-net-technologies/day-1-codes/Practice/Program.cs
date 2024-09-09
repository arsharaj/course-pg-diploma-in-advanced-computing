namespace Practice
{
   internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(FirstClass.x);
            FirstClass firstClass = new FirstClass();
            Console.WriteLine(firstClass.Sum(a:12));

        }
    }


    public class FirstClass
    {
        public static int x;

        static FirstClass()
        {
            x = 15;
        }

        public int firstProp;
        public int FirstProp 
        {
            get
            {
                return firstProp;
            }

            set
            {
                if (firstProp > 100)
                {
                    firstProp = value;
                } 
                else
                {
                    Console.WriteLine("Invalid value.");
                }
            }
        }


        public int Sum(int a, int b = 12)
        {
            return a + b;
        }
    }
}

namespace FirstNamespace
{
    class SecondClass
    {
        private int x;
    }

}