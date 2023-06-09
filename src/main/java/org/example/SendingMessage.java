package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendingMessage implements ActionListener {
    private Main main;
    private JButton sendButton;
    private final int SIZE = 500;
    private JTextField phoneNumberField;
    private JTextField messageField;
    private String phoneNumber;
    private String message;
    private JLabel phoneNumberLabel;
    private JLabel messageLabel;


    public SendingMessage(Main main) {
        this.main = main;
        phoneNumberField = new JTextField();
        messageField = new JTextField();
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 500, 500);

        sendButton = new JButton("Send Message");
        sendButton.setBounds(200, 400, SIZE - 360, SIZE - 460);
        sendButton.setBackground(Color.GREEN.darker());
        sendButton.addActionListener(this);

        main.add(sendButton);

        phoneNumberLabel = new JLabel("Phone Number:");
        messageLabel = new JLabel("Message:");

        phoneNumberLabel.setBounds(50, 100, 100, 30);
        messageLabel.setBounds(50, 200, 100, 30);
        phoneNumberField.setBounds(170, 100, 200, 30);
        messageField.setBounds(170, 200, 200, 100);

        main.add(phoneNumberLabel);
        main.add(messageLabel);
        main.add(phoneNumberField);
        main.add(messageField);

        g.setColor(Color.CYAN);
        g.drawString("Phone Number: " + phoneNumber, 50, 150);
        g.drawString("Message: " + message, 50, 300);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        phoneNumber = phoneNumberField.getText();
        message = messageField.getText();

        if (phoneNumber.isEmpty() || !phoneNumber.matches("\\d+") || phoneNumber.length() < 10) {
            JOptionPane.showMessageDialog(main, "Invalid phone number!");
            return;
        }

        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(main, "Message content is empty!");
            return;
        }
        String nP = "972" + phoneNumber.substring(1);
        String link = "https://web.whatsapp.com/send?phone="+ nP +"&text=" + message;

        main.driver.get(link);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        WebElement sendMessage =  main.driver.findElement(By.xpath("//span[@data-icon='send']"));
        sendMessage.click();

        //main.driver.quit();
        messageHaveBeenSend(main.getGraphics());

    }



    public void messageHaveBeenSend(Graphics g){

        main.remove(phoneNumberLabel);
        main.remove(messageLabel);
        main.remove(phoneNumberField);
        main.remove(messageField);
        main.remove(sendButton);


        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 500, 500);

        g.setFont(new Font("Times New Roman", Font.BOLD, 18));
        FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
        g.setColor(Color.lightGray);
        g.drawString("Message Send Successfully !",150,200);


        // Check the status
        WebElement status ;
        WebElement doubleCheckMark = main.driver.findElement(By.xpath("//*[@id='main']//span[contains(@data-icon, 'checkmark-double')]"));
        WebElement singleCheckMark = main.driver.findElement(By.xpath("//*[@id='main']//span[contains(@data-icon, 'checkmark')]"));
        WebElement blueCheckMark = main.driver.findElement(By.xpath("//*[@id='main']//span[contains(@data-icon, 'checkmark') and @style='color: #075e54;']"));

        g.setColor(Color.cyan);
        if (doubleCheckMark.isDisplayed()) {
            g.drawString("(double checkmark)!",150,250);
        } else if (singleCheckMark.isDisplayed()) {
            g.drawString("(single checkmark)!",150,250);
        } else if (blueCheckMark.isDisplayed()) {
            g.drawString("(blue checkmark)!",150,250);
        } else {
            g.drawString("(send message failed)!",150,250);        }

        // Close the browser if the status changes to blue checkmark
        if (blueCheckMark.isDisplayed()) {
            main.driver.quit();
        }
    }


}