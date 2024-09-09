namespace ImplicitVariables
{
    internal class Program
    {
        static void Main(string[] args) 
        {
            // Can only be used for local variables,
            // not for class level variables.
            // not for function parameters
            // not for return values
            var i = 100; // implicit variable

            //var j;

            var s = 1234;
            // s = "";
            s = 100;

            int a = 100;
            int b = 100;

            Console.WriteLine(i.GetType());
        }
    }
}