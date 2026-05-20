package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButtonListener implements ActionListener {
    private JFrame window;

    public MenuButtonListener(JFrame window) {
        this.window = window;

    }
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        if(buttonText.equals("Start play ->")) {
            window.getContentPane().removeAll();
            int width = window.getWidth();
            int height = window.getHeight();
            GamePanel gamePanel = new GamePanel(width,height);
            window.add(gamePanel);

            window.getContentPane().revalidate();
            window.getContentPane().repaint();
            gamePanel.requestFocusInWindow();



        } else if(buttonText.equals("Instructions ->")) {
            Instructions instructions = new Instructions(window);
            instructions.show();

        }
    }
}
