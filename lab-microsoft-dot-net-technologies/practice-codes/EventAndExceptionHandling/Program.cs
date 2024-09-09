namespace EventHandling
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            AnyClass firstObject = new AnyClass();
            firstObject.OnValidation += IsNotValid;
            firstObject.OnValidation += Message;
            firstObject.Num = 200;
        }

        private static void IsNotValid()
        {
            Console.WriteLine("Number is not valid.");
        }
        private static void Message()
        {
            Console.WriteLine("Enter a valid number.");
        }
    }

    // Step 1 : Create a delegate class having the same signature as the event
    public delegate void EventHandler();

    public class AnyClass
    {
        // Step 2 : Declare the event of the delegate type
        public event EventHandler? OnValidation;

        private int num;
        public int Num
        {
            get { return num; }
            set
            {
                if (value < 100)
                {
                    num = value;
                }
                else
                {
                    // Step 3 : Raise the event whenever you want to
                    if (OnValidation != null)
                    {
                        OnValidation();
                    }
                }
            }
        }
    }
}

namespace EventHandlingWithParameter
{
    internal class Program
    {
        static void Main2(string[] args)
        {
            AnyClass firstObject = new AnyClass();
            firstObject.OnValidation += IsNotValid;
            firstObject.OnValidation += Message;
            firstObject.Num = 200;
        }

        private static void IsNotValid(int num)
        {
            Console.WriteLine(num + " is not a valid number.");
        }
        private static void Message(int num)
        {
            Console.WriteLine(num + " is not greater than 100.");
        }
    }

    // Step 1 : Create a delegate class having the same signature as the event
    public delegate void EventHandler(int InvalidValue);

    public class AnyClass
    {
        // Step 2 : Declare the event of the delegate type
        public event EventHandler? OnValidation;

        private int num;
        public int Num
        {
            get { return num; }
            set
            {
                if (value < 100)
                {
                    num = value;
                }
                else
                {
                    // Step 3 : Raise the event whenever you want to
                    if (OnValidation != null)
                    {
                        OnValidation(value);
                    }
                }
            }
        }
    }
}