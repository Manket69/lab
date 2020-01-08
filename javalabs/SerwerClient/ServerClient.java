/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author mateusz
 */
public class ServerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        String userInput = null;
        for(int i=0; i<5; i++){
            socket = new Socket(host.getHostName(), 9876);
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Podaj input");
            
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter username");
            
            String userName = myObj.nextLine();
            System.out.println("Username is: " + userName);
            
            oos.writeObject("cokolwiek");
            if(i==4)oos.writeObject("exit");
            else oos.writeObject(""+i);
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message" + message);
            System.out.println("IP" + host.getHostAddress());
            System.out.println("Port" + socket.getPort());
            System.out.println("LocalPort" + socket.getLocalPort());
            ois.close();
            oos.close();
            Thread.sleep(100);
            
            
        }
    }
    
}
