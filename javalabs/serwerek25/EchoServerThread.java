/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwerek25.pkg11;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author mateusz
 */
public class EchoServerThread implements Runnable{
protected Socket socket;    
public EchoServerThread(Socket clientSocket){
    this.socket = clientSocket;
}
    @Override
    public void run() {
       int result = 0;
        String[] parts = null;
        String line = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        String threadName = Thread.currentThread().getName();
        try {
            brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
            line = brinp.readLine();
            parts = line.split(" ");
             if (parts[0].equals("+")) {
                 result = Integer.parseInt(parts[1]) + Integer.parseInt(parts[2]);
                 out.writeBytes(parts[1] + "+" + parts[2] + "=" + result + "\n");
             }
             else if (parts[0].equals("-")) {
                 result = Integer.parseInt(parts[1]) - Integer.parseInt(parts[2]);
                 out.writeBytes(parts[1] + "-" + parts[2] + "=" + result + "\n");
             }
             else if (parts[0].equals("*")) {
                 result = Integer.parseInt(parts[1]) * Integer.parseInt(parts[2]);
                 out.writeBytes(parts[1] + "*" + parts[2] + "=" + result + "\n");
             }
             else if (parts[0].equals("/")) {
                 if (Integer.parseInt(parts[2]) == 0) {
                     out.writeBytes("dzielenie przez 0!" + "\n");
                 }
                 result = Integer.parseInt(parts[1]) / Integer.parseInt(parts[2]);
                 out.writeBytes(parts[1] + "/" + parts[2] + "=" + result + "\n");
             }
             else{
                 out.writeBytes("nieprawidłowe działanie" + "\n");
             }
        } catch (IOException e) {
            System.out.println("Błąd: "+e);
        }
    }
}
