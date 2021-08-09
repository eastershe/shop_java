package com.kevin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    JPanel panel = new JPanel();
    JButton ok = new JButton("確認");
    JButton cancel = new JButton("取消");

    public MainFrame(){
        setSize(new Dimension(300,300));
        setLocation(new Point(300,150));
        panel.add(ok);
        panel.add(cancel);
        add(panel);
        setVisible(true);
    }


    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
}


