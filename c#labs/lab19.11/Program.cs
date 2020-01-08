using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Second
{
    class Program
    {
        public static void Main(string[] args)
        {
            try
            {

                //Random rand = new Random(10);
                string[] tablica = new String[10];
                using (StreamReader sr = new StreamReader("TestFile.txt"))
                    
                {
                    string line;
                    while ((line = sr.ReadLine()) != null)
                    {
                        Console.Write(line);
                    } 
                   catch(Exception e)
            {
                Console.WriteLine("Plik nie może zostać odczytany");
                Console.WriteLine(e.Message);
            }
                    int n, i;
                    int[] a = new int[10];
                    Console.Write("Podaj liczbe do przekonwertowania:");

                    n = int.Parse(Console.ReadLine());
                    for (i = 0; n > 0; i++)
                    {
                        a[i] = n % 2;
                        n = n / 2;

                    }
                    Console.Write("Wersja binarna podanej liczby dziesietnej=");
                    for (i = i - 1; i >= 0; i--)
                    {
                        Console.Write(a[i]);
                    }
                    string path = @"C:\pliczek\pliczek.txt";

                    if (!File.Exists(path))
                    {
                        //string createText = ("  =" + pi) + Environment.NewLine;
                        //File.WriteAllText(path, createText);
                    }
                    Console.ReadKey();
                }
        
    }
}
