namespace DefaultImplementation
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Exercise firstClass = new FirstClass();
            firstClass.Display();
        }
    }
    public interface Functions
    {
        void Insert();
        void Update();
        void Delete();
        void Display()
        {
            Console.WriteLine("Display from Functions");
        }
    }

    public interface Exercise
    {
        void Run();
        void Walk();
        void Jog();
        void Display()
        {
            Console.WriteLine("Display from Functions");
        }
    }

    class FirstClass : Functions, Exercise
    {
        public void Delete()
        {
            Console.WriteLine("Delete FirstClass");
        }

        public void Insert()
        {
            Console.WriteLine("Insert FirstClass");
        }

        public void Jog()
        {
            Console.WriteLine("Jog FirstClass");
        }

        public void Run()
        {
            Console.WriteLine("Run FirstClass");
        }

        public void Update()
        {
            Console.WriteLine("Update FirstClass");
        }

        public void Walk()
        {
            Console.WriteLine("Walk FirstClass");
        } 

        void Functions.Display()
        {
            Console.WriteLine("First Class Display");
        }
    }

}