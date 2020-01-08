using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3
{
    class Appka
    {
        static void Main(string[] args)
        {
            Encode();
            Row_Kwa();
            Eratostenes();
        }

        private static void Encode()
        {
            int move;
            char character;
            Console.WriteLine("Podaj przesunięcie: ");
            move = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Zacznij wpisywać szyfr (q aby zakończyć)");
            character = Console.ReadKey(true).KeyChar;
            while(character != 'q')
            {
                Console.Write((char)(character + move));
                character = Console.ReadKey(true).KeyChar;
            }
            Console.WriteLine();
        }

        private static void Row_Kwa()
        {
            Console.WriteLine("ax^2+bx+c=0");
            Console.WriteLine("Podaj wartość a");
            int a = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj wartość b");
            int b = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Podaj wartość c");
            int c = Int32.Parse(Console.ReadLine());

            int delta = b * b - (4 * a * c);
            Console.WriteLine("Delta {0}", delta);
            if (delta < 0)
            {
                Console.WriteLine("Brak pierwiastków");
            }
            else if (delta > 0)
            {
                double x1 = ((-b + Math.Sqrt(delta)) / (2 * a));
                double x2 = ((-b - Math.Sqrt(delta)) / (2 * a));
                Console.WriteLine("Dokładnie dwa pierwiastki: {0}, {1}", x1, x2);
            }
            else if (delta == 0)
            {
                double x0 = (-b) / (2 * a);
                Console.WriteLine("Jeden pierwiastek: {0}", x0);
            }
            else
            {
                throw new Exception("Błędne dane");
            }
        }

        private static void Eratostenes()
        {
            Console.WriteLine("Podaj liczby odzielone przecinkami");
            string line = Console.ReadLine();
            string[] arr = line.Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries);
            int len = arr.Length;
            int[] array = new int[len];
            for (int i = 0; i < len; i++)
            {
                array[i] = Int32.Parse(arr[i]);
            }
            Erato(array);
        }


        static void Erato(int[] array)
        {
            int i, j, range, to;
            Array.Sort(array);
            Console.WriteLine("Liczby pierwsze");
            range = array.Max() - 1;
            int min = array.Min();
            Console.WriteLine(range);
            to = (int)Math.Floor(Math.Sqrt(range));

            for (i = 2; i <= to; i++)
            {
                if (array[i] != 0)
                {
                    j = i + i;
                    while (j < range)
                    {
                        array[j] = 0;
                        j += i;
                    }
                }
            }

            Console.WriteLine("Liczby pierwsze z zakresu od {0} do {1}", min, range + 1);
            for (i = 2; i < range; i++)
                if (array[i] != 0)
                    Console.Write(i + ", ");
        }
    }
}
