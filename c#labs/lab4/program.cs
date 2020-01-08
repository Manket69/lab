using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Parameters: {0}, {1}", args[0], args[1]);
            Zad1(args);
            Zad2(args);
            Zad3(args);
            Zad4();
        }

        static void Zad1(string[] args)
        {
            int[] array = new int[10];

            Random r = new Random();

            for(int i = 0; i < 10; i++)
            {
                array[i] = r.Next(1, 100);
            }

            QuickSort(ref array, 0, array.Length - 1);

            try
            {
                using (FileStream fs = File.Create(args[0]))
                {
                    string res = "";
                    for(int i = 0; i < 10; i++)
                    {
                        res += array[i] + ", ";
                    }
                    byte[] info = new UTF8Encoding(true).GetBytes(res);
                    fs.Write(info, 0, info.Length);
                }
            }

            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
        }

        static void Zad2(string[] args)
        {
            Console.WriteLine("Czy na pewno chcesz usunąć plik {0}? y/n", args[0]);
            while (true)
            {
                string response = Console.ReadLine().ToUpper();
                if (response == "Y")
                {
                    Console.WriteLine("Usuwanie");
                    File.Delete(args[0]);
                    break;
                }
                else if (response == "N")
                {
                    Console.WriteLine("Nie Usuwanie");
                    break;
                }
                else
                {
                    Console.WriteLine("");
                }

            }

        }

        static void Zad3(string[] args)
        {
            // Drugi parametr, żeby aplikacja działała z jednym wywołaniem
            string[] a = Directory.GetFiles(args[1], "*.*");
            long b = 0;
            foreach (string name in a)
            {
                FileInfo info = new FileInfo(name);
                b += info.Length;
            }
            Console.WriteLine(b);
        }

        static void Zad4()
        {
            StreamReader ifile = new StreamReader(@"C:\Users\numbers.txt");
            string line = ifile.ReadLine();
            ifile.Close();
            string[] temp = line.Split(new char[] { ',' }, StringSplitOptions.None);
            int[] numbers = new int[20];
            for(int i = 0; i < 20; i++)
            {
                numbers[i] = Int32.Parse(temp[i]);
            }
            using (System.IO.StreamWriter ofile = new System.IO.StreamWriter(@"C:\Users\resultsLab4Zad4.txt", false))
            {
                int max = numbers[0];
                for(int i = 1; i < 20; i++)
                {
                    if(numbers[i] > max)
                    {
                        max = numbers[i];
                    }
                }
                ofile.WriteLine("Największa wartość: {0}", max);

                int sum = 0;
                for(int i = 0; i < 20; i++)
                {
                    int value = numbers[i];
                    do
                    {
                        sum += value % 10;
                        value /= 10;
                    } while (value != 0);
                }
                ofile.WriteLine("Suma wszystkich wartości: {0}", sum);

                int number = 0;
                int maxCount = 0;
                for(int i = 0; i <  20; i++)
                {
                    int count = 0;
                    for(int j = 0; j < 20; j++)
                    {
                        if (numbers[j] == numbers[i])
                        {
                            count++;
                        }
                    }
                    if (count > maxCount)
                    {
                        maxCount = count;
                        number = numbers[i];
                    }
                }
                ofile.WriteLine("Najczęściej występująca: {0} - {1} times", number, maxCount);
            }
            HeapSort(numbers, 20);
            for (int i = 0; i < 20; i++)
            {
                Console.Write("{0}, ", numbers[i]);
            }
        }

        private static void QuickSort(ref int[] array, int left, int right)
        {
            var i = left;
            var j = right;
            var pivot = array[(left + right) / 2];
            while (i < j)
            {
                while (array[i] < pivot) i++;
                while (array[j] > pivot) j--;
                if (i <= j)
                {
                    var tmp = array[i];
                    array[i++] = array[j];
                    array[j--] = tmp;
                }
            }
            if (left < j) QuickSort(ref array, left, j);
            if (i < right) QuickSort(ref array, i, right);
        }

        static void HeapSort(int[] arr, int n)
        {
            for (int i = n / 2 - 1; i >= 0; i--)
                Heapify(arr, n, i);
            for (int i = n - 1; i >= 0; i--)
            {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                Heapify(arr, i, 0);
            }
        }
        static void Heapify(int[] arr, int n, int i)
        {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[left] > arr[largest])
                largest = left;
            if (right < n && arr[right] > arr[largest])
                largest = right;
            if (largest != i)
            {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;
                Heapify(arr, n, largest);
            }
        }
    }
}
