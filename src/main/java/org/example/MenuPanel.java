package org.example;
import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(JFrame window) {
       this.setBackground(Main.LIGHT_GREEN);
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       JLabel title = new JLabel("Catch the object!");
       title.setFont(new Font("Arial",Font.BOLD,36));
        title.setAlignmentX(0.5f);
        this.add(title);
        this.add(Box.createVerticalStrut(50));
        JButton startButton = new JButton("Start play ->");
        startButton.setFont(new Font("Arial",Font.PLAIN,24));
        startButton.setAlignmentX(0.5f);
        this.add(startButton);
        //הוספת רווח בין הכפתורים
        this.add(Box.createVerticalStrut(20));

        JButton infoButton = new JButton("Instructions ->");
        infoButton.setFont(new Font("Arial",Font.PLAIN,24));
        infoButton.setAlignmentX(0.5f);
        this.add(infoButton);

        //חיבור הכפתור למחלקה MenuButtonListener
        startButton.addActionListener(new MenuButtonListener(window));
        infoButton.addActionListener(new MenuButtonListener(window));
    }

}
