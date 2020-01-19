// KLASA KLIENT_1
package klient_1;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Klient_1 {

    public static void main(String args[]) {
        String host = "localhost";
        int port1 = 6666;
        int port2 = 6667;
        int port3 = 6668;
        String line1 = "2 2 +";
        String line2 = "3 3 -";
        String line3 = "2 5 *";
        String line4 = "2 2 /";
        ExecutorService executorservice = Executors.newFixedThreadPool(3);
        executorservice.submit(() -> metoda(host, port1, line1));
        executorservice.submit(() -> metoda(host, port2, line2));
        executorservice.submit(() -> metoda(host, port3, line3));
    }

    private static void metoda(String host, int port, String line) {

        
        try {
            port = new Integer(port).intValue();
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowy argument: port");
            System.exit(-1);
        }

        
        Socket clientSocket = null;

        try {
            clientSocket = new Socket(host, port);
        } catch (UnknownHostException e) {
            System.out.println("Nieznany host.");
            System.exit(-1);
        } catch (ConnectException e) {
            System.out.println("Połączenie odrzucone.");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Błąd wejścia wyjścia: " + e);
            System.exit(-1);
        }

        System.out.println("Połączono z " + clientSocket);

       
        BufferedReader brSockInp = null;
        BufferedReader brLocalInp = null;
        DataOutputStream out = null;

        
        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            brSockInp = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            brLocalInp = new BufferedReader(new InputStreamReader(System.in));

        } catch (IOException e) {
            System.out.println("Błąd przy tworzeniu strumieni: " + e);
            System.exit(-1);
        }

       
        try {
            if (line != null) {
                System.out.println("Wysyłam " + line);
                out.writeBytes(line + '\n');
                out.flush();
            }
            if (line == null || "quit".equals(line)) {
                System.out.println("Kończenie pracy...");
                clientSocket.close();
                System.exit(0);
            }
            line = brSockInp.readLine();
            System.out.println("Otrzymano: " + line);
        } catch (IOException e) {
            System.out.println("Błąd wejścia wyjścia: " + e);
            System.exit(-1);
        }
    }
}
