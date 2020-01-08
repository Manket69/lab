using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Wyjatki_22._10
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                int a = 12;
                int b = 0;
                int score = a / b;

                try
            {
                int c = 15;
                int d = 0;
                int wynik = c / d;
            }
            catch(ArithmeticException e)
            {
                Console.WriteLine(e);
                Console.ReadKey();
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                Console.ReadKey();
            }
            
        }
    }
}
