package com.zadanie_6;

import java.net.*;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP: " + inetAddress.getHostAddress());
        System.out.println("Host: " + inetAddress.getHostName());
    }
}
