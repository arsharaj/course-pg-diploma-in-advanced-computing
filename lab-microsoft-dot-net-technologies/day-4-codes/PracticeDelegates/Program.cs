namespace Delegates
{
    // Step 1: Create a delegate class that matches the function signature
    public delegate void PrintDelegate();
    public delegate int MathFuncDelegate(int a, int b);

    // Object
    // Delegate
    // MulticastDelegate
    // PrintDelegate
    internal class Program
    {
        static void Main() 
        {
            // Step 2 : Create a delegate reference and point it to an object of the delegate class
            // The delegate object will take the function name as a parameter
            //PrintDelegate printDelegate = new PrintDelegate(Show);
            PrintDelegate printDelegate = Display;

            // Step 3 : Call the delegate function reference
            printDelegate();

            MathFuncDelegate mathFuncDelegate = Add;
            mathFuncDelegate += Subtract;
            mathFuncDelegate += Multiply;
            mathFuncDelegate += Divide;
            Console.WriteLine(mathFuncDelegate(10, 5));
        }

        static void Display()
        {
            Console.WriteLine("Display Method");
        }

        static void Show()
        {
            Console.WriteLine("Show Method");
        }

        static int Add(int a, int b)
        { 
            return a + b;
        }

        static int Subtract(int a, int b)
        { 
            return a - b;
        }

        static int Multiply(int a, int b)
        { 
            return a * b;
        }

        static int Divide(int a, int b) 
        {
            if (b == 0)
            {
                Console.WriteLine("0 could not divide any other number.");
                return -1;
            }
            return a / b;
        }

    }
}