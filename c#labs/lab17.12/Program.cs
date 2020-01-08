using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _17._12
{
    class Appka
    {
        static double EPSILON = 0.000001;
        static void Main(string[] args)
        {
            new Appka().zrob();
        }

        public class Pierwsza
        {
            public void pierwiastek()
            {
                double a = 1, P = 3, b = 3;

                while((a-b)<EPSILON)
                {
                    a = (a + b) / 2;
                    b = P / a;
                }
                Console.WriteLine(" a =" + a);
                Console.ReadKey();
            }
        }

        public void zrob()
        {
            Pierwsza pierwsza = new Pierwsza();
            pierwsza.pierwiastek();

        }
        public class Druga
        {
            private object vowels;

            public void f(string word)
            {
                Dictionary<int, char> dict = new Dictionary<int, char>();
                string[] vowels = { "a", "e", "i", "o", "u", "y" };
                List<int> indexes = new List<int>();
                List<char> values = new List<char>();
                for (int i = 0; i < word.Length; i++)
                {
                    dict.Add(i, word[i]);
                }
                foreach (KeyValuePair<int, char> kvp in dict)
                {
                    if(!vowels.Contains(kvp.Value.ToString()))
                    {
                        indexes.Add(kvp.Key);
                        values.Add(kvp.Value);
                    }
                }
                char lastLetter = values[values.Count() - 1];
                for (int i = 1; i < indexes.Count - 1; i++)
                {
                    dict[indexes[i]] = values[i-1];
                }
                dict[indexes[0]] = lastLetter;
                for (int i = 1; i < indexes.Count; i++) 
                {
                    dict[indexes[i]] = values[i - 1];
                }
                dict[indexes[0]] = lastLetter;
                foreach (KeyValuePair<int, char> kvp in dict)
                {
                    Console.Write(kvp.Value);
                }
            }
        }
        
        
    }
    
}
