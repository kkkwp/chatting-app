package com.chatting;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static PrintWriter out;
    public static BufferedReader in;
    public static String username = "";
    Socket sock;

    public Client() throws IOException {
        new Window();

        try {
            sock = new Socket("111.11.1.11", 8790);
            out = new PrintWriter(sock.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            while (true) {
                String msg = in.readLine();
                Window.writeToChat(msg);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        username = JOptionPane.showInputDialog("Enter your name!");
        new Client();
    }
}
