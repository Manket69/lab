package com.zadanie_9;

import java.net.*;
import java.io.*;

public class EchoServerThread implements Runnable {

    protected Socket socket;

    public EchoServerThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        BufferedReader brinp = null;
        DataOutputStream out = null;
        String line;

        try {
            brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                assert brinp != null;
                line = brinp.readLine();
                assert out != null;
                out.writeBytes(line + "\n\r");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}