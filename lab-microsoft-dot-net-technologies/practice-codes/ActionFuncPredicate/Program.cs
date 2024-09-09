namespace ActionFuncPredicate
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            Action firstObject = Display;
            firstObject();

            Action<string> secondObject = Display;
            secondObject("Hello World!");

            Action<string, int, bool> thirdObject = Display;
            thirdObject("Hello Arsh", 1, true);

            Func<int> firstSummation = Sum;
            Console.WriteLine(firstSummation());

            Func<int, int, int> secondSummation = Sum;
            Console.WriteLine(secondSummation(2, 5));

            Predicate<int> checkEven = isEven;
            Console.WriteLine(checkEven(123123421));
        }
        private static bool isEven(int num)
        {
            return num % 2 == 0;
        }
        private static int Sum(int arg1, int arg2)
        {
            return arg1 + arg2;
        }

        private static int Sum()
        {
            return 2 + 8;
        }
        private static void Display()
        {
            Console.WriteLine("Display");
        }
        private static void Display(string str)
        {
            Console.WriteLine("Display : " + str);
        }
        private static void Display(string str, int i, bool b)
        {
            Console.WriteLine("Display : " + str + " " + i + " " + b);
        }
    }
}

namespace AnonymousMethods
{
    internal class Program
    {
        static void Main2(string[] args)
        {
            Action firstObject = delegate ()
            {
                Console.WriteLine("Display");
            };
            firstObject();

            Action<string> secondObject = delegate (string str)
            {
                Console.WriteLine("Display : " + str);
            };
            secondObject("Hello World!");

            Action<string, int, bool> thirdObject = delegate (string str, int i, bool b)
            {
                Console.WriteLine("Display : " + str + " " + i + " " + b);
            };
            thirdObject("Hello Arsh", 1, true);

            Func<int> firstSummation = delegate ()
            {
                return 2 + 8;
            };
            Console.WriteLine(firstSummation());

            Func<int, int, int> secondSummation = delegate (int arg1, int arg2)
            {
                return arg1 + arg2;
            };
            Console.WriteLine(secondSummation(2, 5));

            Predicate<int> checkEven = delegate (int num)
            {
                return num % 2 == 0;
            };
            Console.WriteLine(checkEven(123123421));
        }
    }
}

namespace Lambdas
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Action firstObject = () => Console.WriteLine("Display");
            firstObject();

            Action<string> secondObject = str => Console.WriteLine("Display : " + str);
            secondObject("Hello World!");

            Action<string, int, bool> thirdObject = (str, i, b) => Console.WriteLine("Display : " + str + " " + i + " " + b);
            thirdObject("Hello Arsh", 1, true);

            Func<int> firstSummation = () => 2 + 8;
            Console.WriteLine(firstSummation());

            Func<int, int, int> secondSummation = (arg1, arg2) => arg1 + arg2;
            Console.WriteLine(secondSummation(2, 5));

            Predicate<int> checkEven = num => num % 2 == 0;
            Console.WriteLine(checkEven(123123421));
        }
    }
}