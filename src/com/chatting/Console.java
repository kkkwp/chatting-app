package com.chatting;

import javax.swing.*;
import java.awt.*;

public class Console {
    public static final JTextArea textarea = new JTextArea();
    public static final JScrollPane scroll = new JScrollPane(textarea);
    static final JFrame frame = new JFrame("Server Console");
    static final JPanel panel = new JPanel();
    static final int WIDTH = 450;
    static final int HEIGHT = 700;

    public Console() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scroll.setPreferredSize(new Dimension(WIDTH - 32, HEIGHT - 64));
        textarea.setEditable(false);

        panel.add(scroll);
        frame.add(panel);
    }

    public void writeToConsole(String text) {
        textarea.append(text + "\n");
    }
}