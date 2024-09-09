namespace Assignment
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] array = new int[10];
            read(array);
            Console.Write("Integer Array : ");
            print(array);
            Console.WriteLine();
            List<int> intList = array.ToList();
            Console.Write("Integer List : ");
            print(intList);
            Console.WriteLine();
            int[] newArray = intList.ToArray();
            Console.Write("New Integer List : ");
            print(newArray);
        }
        static void read(int[] array)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.Write($"Enter {i + 1} integer : ");
                array[i] = Convert.ToInt32(Console.ReadLine());
            }
        }

        static void print<T>(IList<T> list)
        {
            foreach (var i in list)
            {
                Console.Write(i + " ");
            }
        }
    }
}