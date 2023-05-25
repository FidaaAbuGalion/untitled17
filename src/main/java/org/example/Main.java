package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private final int size = 500 ;
    JButton button;
    JLabel label ;

    public static void main(String[] args) {
        new Main() ;

    }

    public Main(){
        this.setTitle("Whatsapp");
        this.setVisible(true);
        this.setSize(size , size);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);


          button = new JButton("log in whatsapp") ;
         button.setBounds(size - 470 , size - 430 , size - 360 , size -460);
         button.setBackground(Color.green);
         button.addActionListener(this);

         this.add(button);






    }   @Override
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
                Success();
            }

            webElement.click();

//            webElement.sendKeys("");
        }
    }



    public void Success (){

            Panel m = new Panel();
            m.setBounds(size - 470, size - 380, size - 360, size - 460);
            m.setBackground(Color.green);
            this.add(m);
            JLabel jLabel = new JLabel("logged in successfully");
            jLabel.setBounds(size - 470, size - 380, size - 360, size - 460);
            jLabel.setBackground(Color.BLACK);

            m.add(jLabel);
//       label = new JLabel("logged in successfully");
//       label.setBackground(Color.GREEN);
//       label.setBounds(size - 470, size - 380, size - 360, size - 460);
//       this.add(label);

            System.out.println("logged in successfully");

    }



}