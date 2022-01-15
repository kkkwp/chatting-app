package com.chatting;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Window extends JFrame {
    static final int WIDTH = 640;
    static final int HEIGHT = WIDTH / 16 * 9;
    static final JPanel panel = new JPanel();
    static final JTextArea textarea = new JTextArea();
    static final JScrollPane scroll = new JScrollPane(textarea);
    static final JTextField msgField = new JTextField();
    static final JButton sendButton = new JButton("Send");
    @Serial
    private static final long serialVersionUID = 1L;

    public Window() {
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        scroll.setPreferredSize(new Dimension(WIDTH - 32, HEIGHT - 100));
        msgField.setPreferredSize(new Dimension(WIDTH - 32, 25));

        panel.add(scroll);
        panel.add(msgField);
        panel.add(sendButton);
        this.add(panel);

        sendButton.addActionListener(arg0 -> {
            String text = msgField.getText();
            Client.out.println(Client.username + " : " + text);
            msgField.setText("");
        });
    }

    public static void writeToChat(String text) {
        textarea.append(text + "\n");
    }
}