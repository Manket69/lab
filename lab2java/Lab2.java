/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateusz
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zad1();
        Zad2();
        Zad3(args);
        Zad4();
    }

    private static void Zad1() {
        try {
            Socket ug = new Socket("www.ug.gda.pl", 80);
            System.out.println(ug.getInetAddress());
            System.out.println(ug.getPort());
            System.out.println(ug.getLocalPort());
            ug.close();
            Socket wp = new Socket("www.wp.pl", 80);
            System.out.println(wp.getInetAddress());
            System.out.println(wp.getPort());
            System.out.println(wp.getLocalPort());
            wp.close();
            Socket onet = new Socket("www.onet.pl", 80);
            System.out.println(onet.getInetAddress());
            System.out.println(onet.getPort());
            System.out.println(onet.getLocalPort());
            onet.close();
            Socket interia = new Socket("www.interia.pl", 80);
            System.out.println(interia.getInetAddress());
            System.out.println(interia.getPort());
            System.out.println(interia.getLocalPort());
            interia.close();
        } catch (IOException ex) {
            Logger.getLogger(Lab2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void Zad2() {
        try {
            InetAddress inet = InetAddress.getLocalHost();
            System.out.println(inet);
            String ip = inet.getHostAddress();
            System.out.println(ip);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Lab2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void Zad3(String[] args) {
        try {
            // e.g yahoo.com or www.youtube.com
            InetAddress[] machines = InetAddress.getAllByName(args[0]);
            for (InetAddress address : machines) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Zad4() {
        try {
           for(int i = 0; i <= 65535; i++) {
               System.out.println("Port: " + i + " jest " + (checkPort(i) ? "otwarty" : "zamknięty"));
           }
        } catch (Exception ex) {
            Logger.getLogger(Lab2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private static boolean checkPort(int portNumber) {
        try {
            new Socket("www.ug.edu.pl", portNumber).close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
