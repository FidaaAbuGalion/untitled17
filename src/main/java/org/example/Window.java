package org.example;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int SIZE = 500;
    LogIn logIn = new LogIn(this);
    PageState ps;

    public Window() {
        this.setTitle("WhatsApp");
        this.setVisible(true);
        this.setSize(SIZE, SIZE);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        start();
    }

    public void start() {
        logIn.render();
    }




}




