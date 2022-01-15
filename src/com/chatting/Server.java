package com.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static Console console;
    static ArrayList<User> users = new ArrayList<>();
    ServerSocket serSock;
    Socket sock;
    PrintWriter out;
    BufferedReader in;

    public Server() {
        try {
            serSock = new ServerSocket(8790);

            new Thread(() -> {
                while (true) {
                    try {
                        sock = serSock.accept();
                        out = new PrintWriter(sock.getOutputStream(), true);
                        in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                        User user = new User(out, in);
                        user.userThread.start();
                        user.out.println("welcome to the chat!");
                        users.add(user);
                        console.writeToConsole(sock.getInetAddress() + " has connected!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        console = new Console();
    }

    public static void main(String[] args) {
        new Server();
        console.writeToConsole("Server started!");
    }

    public static void broadcast(String text) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user == null || user.out == null) users.remove(user);
            else user.out.println(text);
        }
    }
}
