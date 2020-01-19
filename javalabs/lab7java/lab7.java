package com.zadanie_7;

import java.net.*;
import java.io.*;

public class Server
{
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println(
                    "Błąd przy tworzeniu gniazda serwerowego.");
            System.exit(-1);
        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println(e);
                System.exit(-1);
            }
            try {
                brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                System.out.println("Błąd przy tworzeniu strumieni.");
                System.exit(-1);
            }
            while (true) {
                try {
                    String line = brinp.readLine();
                    if (line == null || line.equals("quit")) {
                        try {
                            socket.close();
//                        serverSocket.close();
                            break;
                        } catch (IOException e) {
                            System.out.println(
                                    "Błąd przy zamykaniu gniazd.");
                        }
                    } else {
                        System.out.println("Inicjalizacja gniazda zakończona...");
                        System.out.println("Parametry gniazda: " + serverSocket);
                        System.out.println("Trwa oczekiwanie na połączenie...");
                        System.out.println("Nadeszło połączenie...");
                        System.out.println("Parametry połączenia: " + socket);
                        System.out.println("Inicjalizacja strumieni...");
                        System.out.println("Zakończona inicjalizacja strumieni...");
                        System.out.println("Rozpoczęcie pętli głównej...");
                        System.out.println("Odczytano linię: " + line);
                        System.out.println("Zakończenie pracy...");
                        System.out.println("Wysłano linię: " + line);
                    }
                } catch (IOException e) {
                    System.out.println(e);
                    System.out.println("Błąd wejścia-wyjścia.");
                    System.exit(-1);
                }
            }
        }
    }
}