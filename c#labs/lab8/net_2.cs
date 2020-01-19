public void szyfruj()
{
    String s = "lokomotywa";
    Char[] sChar = new Char[s.Length];
    Char[] spolgloski = new Char[]
    {
        'b', 'c', 'ć', 'd', 'f', 'g', 'h', 'j', 'l', 'k', 'm', 'n', 'ń', 'p', 'r', 's', 'ś', 't', 'w', 'z', 'ź', 'ż'};
    int pierwszaSpolgloska = -1;
    char zapamietanaSpolgloska = ' ';
    
    for (int i = 0; i < s.Length; i++)
    {
        sChar[i] = s[i];
    }

    for (int j = 0; j < sChar.Length; j++)
    {
        for (int i = 0; i < spolgloski.Length; i++)
        {
            if ((sChar[j] == spolgloski[i]) && (pierwszaSpolgloska == -1))
            {
                pierwszaSpolgloska = j;
                zapamietanaSpolgloska = sChar[j];                            
            }
            else if (sChar[j] == spolgloski[i])
            {
                char temp = sChar[j];
                sChar[j] = zapamietanaSpolgloska;
                zapamietanaSpolgloska = temp;
            }
        }
    }

    sChar[pierwszaSpolgloska] = zapamietanaSpolgloska;


    foreach (var x in sChar)
    {
        Console.Write(x);
    }

public class InnaKlasa { 

    static public void Main() 
    { 
        ZewnetrznaKlasa.WewnetrznaKlasa obj2 =  new ZewnetrznaKlasa.WewnetrznaKlasa();
        obj2.szyfruj();
    } 
