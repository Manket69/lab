
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwerek25.pkg11;
import java.net.*;
import java.io.*;

public class Serwerek2511 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServerSocket serverSocket = null;   
        Socket socket = null;   
       BufferedReader brinp = null;  
     DataOutputStream out = null;   
     //OutputStream out;
     // InputStream brinp;
        try{      
            serverSocket = new ServerSocket(6666); 
        }  
        catch(IOException e){   
            System.out.println(  "Błąd przy tworzeniu gniazda serwerowego.");  
            System.exit(-1);  
        }  
        System.out.println("Inicjalizacja gniazda zakończona...");
        System.out.println("Parametry gniazda: " + serverSocket);  
        try{     
            System.out.println("Trwa oczekiwanie na połączenie...");
        socket = serverSocket.accept();  
        }    
        catch(IOException e){      System.out.println(e);   
        System.exit(-1);  
        }  
        System.out.println("Nadeszło połączenie..."); 
        System.out.println("Parametry połączenia: " + socket); 
        try{      
            System.out.println("Inicjalizacja strumieni...");  
        brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
        out = new DataOutputStream(socket.getOutputStream());   
     // out = socket.getOutputStream();    
    // brinp= socket.getInputStream();
        }    
        catch(IOException e){    
            System.out.println("Błąd przy tworzeniu strumieni.");  
      
        System.exit(-1); 
        }    System.out.println("Zakończona inicjalizacja strumieni...");

      System.out.println("Rozpoczęcie pętli głównej..."); 
      while(true){    
          try{      
              String line = brinp.readLine();  
            // int line = brinp.read(); 
              System.out.println("Odczytano linię: " + line);   
              if(line == null || "quit".equals(line)){       
                  try{            socket.close();       
                  serverSocket.close();        
                  }       
                  catch(IOException e){     
                      System.out.println( "Błąd przy zamykaniu gniazda serwerowego.");  
                  }         
                  System.out.println("Zakończenie pracy...");  
                  System.exit(0); 
              }  
              out.writeBytes(line + "\n");   
           // out.write(line + "\n\r");
              System.out.println("Wysłano linię: " + line); 
              
          }   
          catch(IOException e){    
              System.out.println("Błąd wejścia-wyjścia.");  
              System.exit(-1);    
          }  
      } 
} 
    
}
