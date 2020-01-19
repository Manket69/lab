public interface Interfejs {
        
    void liczbaM(int m);
    void liczbaN(int n);
}

public class Klasa : Interfejs
{
    private int m;
    private int n;
        
    public void liczbaM(int m)
    {
        this.m = m;
    }
        
    public void liczbaN(int n)
    {
        this.n = n;
    }

    public int getLiczbaM()
    {
        return m;
    }

    public int getLiczbaN()
    {
        return n;
    }

    public void NWW(int m, int n)
    {
        int NWW = 0;
        int c = m * n;    

        while (n!=0)
        {
            if (m != n)
            {
                if (m > n)
                {
                    m = m - n;
                }
                else
                {
                    n = n - m;
                }
            }
            else
            {
                NWW = c / n;
                Console.WriteLine("NWW: " + NWW);
                break;
            }
        }

    }
}
static void Main(string[] args)
{
   
    Klasa klasa = new Klasa();
    klasa.liczbaM(10);
    klasa.liczbaN(5);
    
    klasa.NWW(klasa.getLiczbaM(), klasa.getLiczbaN());
}
