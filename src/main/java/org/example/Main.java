package org.example;

import javax.swing.*;
import java.awt.*;

public class Main{
    public static final Color LIGHT_GREEN = new Color(180,220,180);

    public static void main(String[] args) {
        JFrame window = new JFrame("Catch the object!");
        window.setSize(700,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        MenuPanel menuPanel = new MenuPanel(window);
        window.add(menuPanel);
        window.setVisible(true);




    }

}
