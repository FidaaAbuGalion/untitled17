package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private final int SIZE = 500 ;
    JButton button;
    JButton sendButton;
    private JTextField phoneNumberField;
    private JTextField messageField;
    private boolean notLogged = true;
    private SendingMessage sm = new SendingMessage(this);
    ChromeDriver driver;
    public static void main(String[] args) {
        new Main();

    }

    public Main(){
        this.setTitle("Whatsapp");
        this.setVisible(true);
        this.setSize(SIZE , SIZE);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);


        button = new JButton("log in whatsapp") ;
        button.setBounds(SIZE - 470 , SIZE - 430 , SIZE - 360 , SIZE -460);
        button.setBackground(Color.green);
        button.addActionListener(this);

        this.add(button);

    }   @Override
    public void actionPerformed(ActionEvent m) {

        if (m.getSource() == button){
            System.setProperty("webdriver.openqa.driver", "C:\\Users\\IMOE001\\Downloads\\chromedriver_win32\\1.exe");
            driver = new ChromeDriver();
            driver.get("https://web.whatsapp.com");
            driver.manage().window().maximize();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            WebElement webElement = driver.findElement(By.id("app"));
            if (webElement != null){
              //  Success(getGraphics());
            }
            webElement.click();

                    WebElement qrElement = driver.findElement(By.xpath("//*[@id=\"app\"]"));
                    if (qrElement != null) {
                        sendAlert(getGraphics());
                    }


                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                WebElement loggedElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]"));
                if (loggedElement != null) {
                System.out.println("---------------------------------------");
                success(getGraphics());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    sm.render(getGraphics());
                    this.remove(button);



                }
        }
    }


    private void success(Graphics g) {
        g.setFont(new Font("Times New Roman", Font.BOLD, 16));
        FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
        g.drawString("Logged in successfully!",SIZE - 435, SIZE - 300);
        g.setColor(Color.BLACK);
    }
    private void sendAlert (Graphics g){
        g.setFont(new Font("Times New Roman", Font.BOLD, 18));
        FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
        g.drawString("Please scan the QR code to log in to your WhatsApp account.",SIZE - 455, SIZE - 320);
        g.setColor(Color.BLACK);
    }
    private void messageSending(Graphics g){

        g.setColor(Color.BLUE);
        g.fillRect(0,0,500,500);
        g.setColor(Color.cyan);
       g.drawString("fgfgdgsg", 300,300);

        sendButton = new JButton("send message") ;
        sendButton.setBounds(SIZE - 470 , SIZE - 430 , SIZE - 360 , SIZE -460);
        sendButton.setBackground(Color.green);
        sendButton.addActionListener(this);

        this.add(sendButton);



    }

}