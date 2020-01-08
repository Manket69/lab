package serwerek25.pkg11;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
 
 
public class Client {
    public static void main(String args[]) {
        String host = "localhost";
        int port = 0;
        try
        {
            port = 6666;
        }
        catch(NumberFormatException e){
            System.out.println("Nieprawidlowy argument: port");
            System.exit(-1);
        }
        Socket clientSocket = null;
        try{
            clientSocket = new Socket(host,port);
        }
        catch(Exception ex)
        {
            System.out.println("Błąd." + ex);
        }
        System.out.println("Polaczono z " + clientSocket);
 
        String line = null;
        BufferedReader brSocklnp = null;
        BufferedReader brLocallnp = null;
        DataOutputStream out = null;
 
        //siemanko, utworzmy strumienie
        try{
            out = new DataOutputStream(clientSocket.getOutputStream());
            brSocklnp = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            brLocallnp = new BufferedReader(new InputStreamReader(System.in));
        } catch(IOException e){
            System.out.println("Błąd strumienia:" + e);
            System.exit(-1);
        }
        //petla glowna klienta
        while(true){
            try{
                line = brLocallnp.readLine();
            } catch(IOException ex){
                System.out.println("Błąd " + ex);
            }
            if(line != null){
                System.out.println("Wysylam dzieciaka " + line);
                try{
                    out.writeBytes(line + '\n');
                    out.flush(); //oproznia bufor - wysyla dane dzieciaku
                } catch(IOException ex) {
                    System.out.println("Błąd " + ex);
                }
                if (line == null || "quit".equals(line))
                {
                    System.out.println("Konczenie pracy...");
                    try{
                        clientSocket.close();
                    }
                    catch(Exception ex){
                        System.out.println("Błąd ");
                    }
                    System.exit(0);
                }
                try{
                    line = brSocklnp.readLine();
                    System.out.print("Otrzymano " + line);
                }
                catch(Exception ex){
                    System.out.println("Błąd" + ex);
                }
                EchoServerThread e = new EchoServerThread(clientSocket);
                e.run();
            }
        }
    }
}