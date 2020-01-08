using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab1
{
    class Program
    {
        static void Main(string[] args)
        {
            Zad1();
            Zad2();
            Zad3();
        }

        static void Zad1()
        {
            // for
            Console.WriteLine("=======for");
            for(int i = 100; i > 0; i--)
            {
                if (i % 3 == 0 && i % 2 != 0)
                {
                    Console.WriteLine(i);
                }
            }

            // while
            Console.WriteLine("while");
            int x = 100;
            while(x-- > 0)
            {
                if (x % 3 == 0 && x % 2 != 0)
                {
                    Console.WriteLine(x);
                }
            }

            // do...while
            x = 100;
            Console.WriteLine("do...while");
            do
            {
                if (x % 3 == 0 && x % 2 != 0)
                {
                    Console.WriteLine(x);
                }
            } while (x-- > 0);
        }

        static void Zad2()
        {
            Console.WriteLine("=======Triangle");
            int[] array = new int[10];
            for (int i = 10; i > 0; i--)
            {
                array[i - 1] = i;
            }

            int k = 1;
            for (int i = 1; i <= 4; i++)
            {
                for (int j = 0; j < i; j++, k++)
                {
                    Console.Write(array[k-1]);
                }
                Console.WriteLine();
            }
        }

        static void Zad3()
        {
            Console.WriteLine("=======Fibb");
            int[][] array = new int[10][];

            array[0] = new int[1];
            array[0][0] = 1;
            Console.WriteLine(array[0][0]);

            array[1] = new int[1];
            array[1][0] = 1;
            Console.WriteLine(array[1][0]);

            for (int i = 2; i < 10; i++){
                int actual = array[i - 1][0] + array[i - 2][0];
                array[i] = new int[actual];
                array[i][0] = actual;

                int temp = actual;
                for (int j = 0; j < actual; j++) 
                {
                    array[i][j] = (temp--);
                    Console.Write("{0} ", array[i][j]);
                }
                Console.WriteLine();
                }      
            }
    }
}
