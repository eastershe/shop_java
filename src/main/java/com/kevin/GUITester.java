package com.kevin;

import javax.swing.*;

public class GUITester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setLocation(200,200);

        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");

        panel.add(ok);
        panel.add(cancel);
        frame.add(panel);

        frame.setVisible(true);
    }
}
