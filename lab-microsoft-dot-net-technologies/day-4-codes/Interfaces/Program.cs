namespace Interfaces
{
    internal class Program
    {
        static void Main(string[] args)
        {
            FirstClass firstClass = new FirstClass();
            firstClass.Delete();
            firstClass.Insert();

            Functions functions;
            functions = firstClass;
            functions.Update();
            FirstClass newClass = (FirstClass) functions;
            newClass.Insert();

            Exercise exercise = firstClass;
            exercise.Walk();

            SubInterface secondClass = new FirstClass();
            secondClass.Insert();
            secondClass.Jog();

            ((Functions)secondClass).Delete();

            (firstClass as Exercise).Walk();
        }
    }

    public interface SubInterface : Functions, Exercise
    {

    }

    public interface Functions
    {
        void Insert();
        void Update();
        void Delete();
    }

    public interface Exercise
    {
        void Run();
        void Walk();
        void Jog();
    }

    class  FirstClass : SubInterface
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
    }
}