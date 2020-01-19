static double MonteCarloPi(int n) {
    int inside = 0;
    Random r = new Random();

    for (int i = 0; i < n; i++) {
        if (Math.Pow(r.NextDouble(), 2)+ Math.Pow(r.NextDouble(), 2) <= 1) {
            inside++;
        }
    }
    return 4.0 * inside / n;
}


static void Main(string[] args)
{
    string pathString = @"E:\test\test5.txt";
    int n1 = 0;
    int n2 = 1000;
    int n3 = 100000;            
    
    
    
    try
    {   
        using (StreamReader sr = new StreamReader(pathString))
        {
            // liczba losowań
            n1 = Int32.Parse(sr.ReadToEnd());
        }
    }
    catch (IOException e)
    {
        Console.WriteLine("Nie można odczytać pliku.");
        Console.WriteLine(e.Message);
    }

   
    Console.WriteLine("{0}:{1}", n1.ToString("#,###").PadLeft(11, ' '), MonteCarloPi(n1));
    
   
    Console.WriteLine("{0}:{1}", n2.ToString("#,###").PadLeft(11, ' '), MonteCarloPi(n2));

 
    Console.WriteLine("{0}:{1}", n3.ToString("#,###").PadLeft(11, ' '), MonteCarloPi(n3));
    
   
    using (StreamWriter outputFile = new StreamWriter(pathString, true))
    {
        outputFile.WriteLine("{0}:{1}", n1.ToString("#,###").PadLeft(11, ' '), MonteCarloPi(n1));
        outputFile.WriteLine("{0}:{1}", n2.ToString("#,###").PadLeft(11, ' '), MonteCarloPi(n2));
        outputFile.WriteLine("{0}:{1}", n3.ToString("#,###").PadLeft(11, ' '), MonteCarloPi(n3));
    }
