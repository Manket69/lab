public interface Interfejs2 {
    void wyszukajMinMax(int[] liczby);
}


public class Klasa2 : Interfejs2
{

    public void wyszukajMinMax(int[] liczby)
    {
        int min, max = 0;

        min = liczby[0];
        max = liczby[0];

        for (int i = 1; i < liczby.Length; i++)
        {
            if (liczby[i] > max)
            {
                max = liczby[i];
            }

            if (liczby[i] < min)
            {
                min = liczby[i];
            }
        }

        Console.WriteLine("Minimalna wartość to: " + min);
        Console.WriteLine("Maksymalna wartość to: " + max);

    }
}



        static void Main(string[] args)
        {

            int[] liczby = new int[] {4, 6, 3, 1, 8, 44, 6, 3, 1, 8, 4};
            
            Klasa2 klasa2 = new Klasa2();
            klasa2.wyszukajMinMax(liczby);
            
        }
