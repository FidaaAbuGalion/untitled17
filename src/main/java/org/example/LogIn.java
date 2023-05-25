package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn implements ActionListener {

    JButton button;
    Window w;
    public boolean isLogged;

    public LogIn (Window w) {

        this.w = w;

    }

    public void actionPerformed(ActionEvent m) {

        if (m.getSource() == button){
            System.setProperty("webdriver.openqa.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\1.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://web.whatsapp.com");
            driver.manage().window().maximize();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            WebElement webElement = driver.findElement(By.id("app"));
            if (webElement!= null){
                Success(w.getGraphics());
                isLogged = true;
            }

            webElement.click();

//            webElement.sendKeys("");
        }

    }
    public void render(){
        button = new JButton("log in whatsapp");
        button.setBounds(w.SIZE - 470, w.SIZE - 430, w.SIZE - 360, w.SIZE - 460);
        button.setBackground(Color.green.darker());
        button.addActionListener(this);
        w.add(button);
    }

    private void Success (Graphics g){

        g.setFont(new Font("Times New Roman",Font.BOLD,18));
        FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
        g.drawString("logged in successfully !",w.SIZE - 455, w.SIZE - 320);
        g.setColor(Color.BLACK);

    }



}
