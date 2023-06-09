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

    public LogIn(Window w) {
        this.w = w;
    }

    public void actionPerformed(ActionEvent m) {
        if (m.getSource() == button) {
            System.setProperty("webdriver.openqa.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\1.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://web.whatsapp.com");
            driver.manage().window().maximize();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            WebElement qrCodeElement = driver.findElement(By.xpath("//canvas[@aria-label='Scan me!']"));
            if (qrCodeElement != null) {
                Success(w.getGraphics());
                isLogged = true;
                JOptionPane.showMessageDialog(null, "Please scan the QR code to log in to your WhatsApp account.");
            }

            driver.quit();
        }
    }

    public void render() {
        button = new JButton("Log in to WhatsApp");
        button.setBounds(w.SIZE - 470, w.SIZE - 430, w.SIZE - 360, w.SIZE - 460);
        button.setBackground(Color.green.darker());
        button.addActionListener(this);
        w.add(button);
    }

    private void Success(Graphics g) {
        g.setFont(new Font("Times New Roman", Font.BOLD, 18));
        FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
        g.drawString("Logged in successfully!", w.SIZE - 455, w.SIZE - 320);
        g.setColor(Color.BLACK);
    }
}