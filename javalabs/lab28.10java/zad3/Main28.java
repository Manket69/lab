/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2810;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.sound.sampled.Port;

/**
 *
 * @author mateusz
 */
public class Java2810 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket mySocket = null;
        try {
            mySocket = new ServerSocket(1234);
            mySocket.setSoTimeout(0);
        } catch (Exception e) {
            System.out.println("error");
        }
        try {
            Socket abc = mySocket.accept();
            abc.setSoTimeout(666666);
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
    
}
