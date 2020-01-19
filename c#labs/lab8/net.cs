public class ZewnetrznaKlasa { 

    public class WewnetrznaKlasa { 

        public void obliczPierwiastek(int pole)
        {
            double epsilon = 0.000001;
            double a = 1;
            double b = pole;

            while (Math.Abs(a - b) >= epsilon)
            {
                a = (a + b) / 2;
                b = pole / a;
            }

            Console.WriteLine("Pierwiastek z " + pole + " to: " + b);
        }
    } 
} 


public class InnaKlasa { 

    static public void Main() 
    { 
        ZewnetrznaKlasa.WewnetrznaKlasa obj2 =  new ZewnetrznaKlasa.WewnetrznaKlasa();
        obj2.obliczPierwiastek(3); 
        obj2.obliczPierwiastek(5); 
        obj2.obliczPierwiastek(27); 
    } 
} 
