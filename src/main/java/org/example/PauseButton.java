package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseButton extends JButton {

    public PauseButton(GamePanel gamePanel) {
        this.setText("Pause");
        this.setBounds(130,15,80,30);
        this.setBackground(Color.YELLOW);
        this.setFont(new Font("Arial",Font.BOLD,12));

        this.setFocusable(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.togglePause();

                if(getText().equals("Pause")) {
                    setText("Play");
                    setBackground(Color.GREEN);
                } else {
                    setText("Pause");
                    setBackground(Color.YELLOW);
                }
                gamePanel.requestFocusInWindow();
            }
        });
    }
}
