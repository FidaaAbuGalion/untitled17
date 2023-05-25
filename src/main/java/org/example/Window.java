package org.example;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame  {

    //Final//
    public static final int SIZE = 500;
    //obj//
    LogIn logIn =  new LogIn(this);

    private PageState pS;


    public Window(){

        this.setTitle("Whatsapp");
        this.setVisible(true);
        this.setSize(SIZE , SIZE);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        start();



    }

    public void start(){

       pS = PageState.LogInP;
       render();

    }

    public void render (){
        if (pS == PageState.LogInP){
            logIn.render();
            if (logIn.isLogged){
                pS = PageState.TransInfoP;
            }
        } else if (pS == PageState.TransInfoP) {

        }
    }




}
