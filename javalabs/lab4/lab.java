package com.zadanie_4;

import java.net.*;

public class Main
{
    public static void main(String[] args)
    {
        if (args.length < 1) {
            System.out.println("Brak argumentów!");
            System.exit(0);
        }
        InetAddress[] ips = null;
        String hostName = args[0];
        try {
            ips = InetAddress.getAllByName(hostName);
        }
        catch(UnknownHostException e){
            System.out.println(
                    "Problemy z uzyskaniem adresów IP dla " + hostName + "\n" +
                            "Sprawdź nazwę hosta i spróbuj ponownie");
            System.exit(0);
        }
        System.out.println("Uzyskane adresy IP dla " + hostName + " to:");
        for (int i = 0; i < ips.length; i++) {
            String ip = ips[i].getHostAddress();
            System.out.println("IP[" + i + "] = " + ip);
        }
    }
}
