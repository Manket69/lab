using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab2
{
    class Appka
    {
        double liczba;
        char znak;

        Appka(double liczba)
        {
            this.liczba = liczba;
        }
        Appka(char znak)
        {
            this.znak = znak;
        }
        Appka(double liczba, char znak)
        {
            this.liczba = liczba;
            this.znak = znak;
        }
        Appka()
        {
            int a, b;
            Console.WriteLine("a:");
            a = int.Parse(Console.ReadLine());
            Console.WriteLine("b:");
            b = int.Parse(Console.ReadLine());
            while (a != b)
            {
                if (a > b)
                    a -= b;
                else
                    b -= a;
            }
            Console.WriteLine("(NWD): " + a);
        }

        Appka(int[] array)
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

        static void Main(string[] args)
        {
            Appka p = new Appka();
            Appka p2 = new Appka(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
            46, 47, 48, 49, 50});
        }
    }
}
