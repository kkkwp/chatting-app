package com.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class User implements Runnable {
    public PrintWriter out;
    public BufferedReader in;
    public Thread userThread = new Thread(this);

    public User(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        while (true) {
            try {
                String text = in.readLine();
                Server.broadcast(text);

            } catch (IOException e) {
                userThread.stop();
                e.printStackTrace();
            }
        }
    }
}
