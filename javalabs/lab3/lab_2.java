// PAKIET ECHOSERVER - KLASA ECHOSERVER
package echoserver;

import java.net.*;
import java.io.*;

public class Echoserver {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(6668);
        } catch (IOException e) {
            System.out.println("Błąd przy tworzeniu gniazda serwerowego " + e);
            System.exit(-1);
        }

        System.out.println("Inicjalizacja gniazda zakończona ...");
        System.out.println("Parametry gniazda: " + serverSocket);

        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Błąd wejścia wyjścia: " + e);
            }

            System.out.println("Nadeszło połączenie...");
            System.out.println("Parametry połączenia: " + socket);

            new Thread(new EchoServerThread(socket)).start();
        }

    }

}



// PAKIET ECHOSERVER - KLASA ECHOSERVERTHREAD
package echoserver;

import java.io.*;
import java.net.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;

public class EchoServerThread implements Runnable {

    protected Socket socket;

    EchoServerThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
       
        BufferedReader brinp = null;
        DataOutputStream out = null;
        String threadName = Thread.currentThread().getName();

        
        try {
            brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println(threadName + "| Błąd przy tworzeniu strumieni " + e);
            return;
        }

        String line = null;
      
        while (true) {
            try {
                line = brinp.readLine();
                System.out.println(threadName + "| Odczytano linię: " + line);

               
                if ((line == null) || "quit".equals(line)) {
                    System.out.println(threadName + "| Zakończenie pracy z klientem: " + socket);

                    socket.close();
                    return;
                } else {
                    
                    String[] tab = line.split(" ");

                    int a = Integer.parseInt(tab[0]);
                    int b = Integer.parseInt(tab[1]);

                    switch (tab[2]) {
                        case "+":
                            System.out.println("Wynik z dodawania: ");
                            line = Integer.toString(a + b);
                            break;
                        case "-":
                            System.out.println("Wynik z odejmowania: ");
                            line = Integer.toString(a - b);
                            break;
                        case "*":
                            System.out.println("Wynik z mnożenia: ");
                            line = Integer.toString(a * b);
                            break;
                        case "/":
                            try {
                                System.out.println("Wynik z dzielenia: ");
                                line = Integer.toString(a / b);
                                break;
                            } catch (ArithmeticException e) {
                                System.out.println(e);
                            }
                    }

                    out.writeBytes(line + "\n");
                    System.out.println(threadName + "| Wysłano linię: " + line);
                }
            } catch (IOException e) {
                System.out.println(threadName + "| Błąd wejścia wyjścia: " + e);
                return;
            }
        }

    }

}

