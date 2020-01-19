package com.zadanie_7;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Wywołanie programu: Client host port");
            System.exit(-1);
        }
        String host = args[0];
        int port = 0;
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowy argument: port");
            System.exit(-1);
        }
        Socket socket = null;
        try {
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            System.out.println("Nieznany host.");
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        }
        System.out.println(socket);
    }
}