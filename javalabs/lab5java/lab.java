package com.zadanie_5;

import java.io.IOException;
import java.net.*;

public class Main {

    public static void main(String[] args) {
	    String[] urls = new String[] {"www.wp.pl", "www.ug.gda.pl", "www.onet.pl", "www.interia.pl"};
        for (String s : urls) {
            try {
                URL url = new URL("https://" + s);
                System.out.println("Strona: " + s + ", port domyślny: " + url.getDefaultPort() +
                        ", port: " + url.getPort());
            } catch (IOException e) {
                System.out.println("Error: " + e + " na stronie: " + s);
            }
        }
    }
}
