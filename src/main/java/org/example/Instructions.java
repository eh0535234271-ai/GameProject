package org.example;

import javax.swing.*;
import java.awt.*;

public class Instructions {

    private JDialog infoWindow;

    public Instructions(JFrame window) {
        // יצירת חלון ההוראות המקורי שלך
        this.infoWindow = new JDialog(window, "Game instructions:", true);
        this.infoWindow.setSize(600, 600);
        this.infoWindow.setLocationRelativeTo(null);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Main.LIGHT_GREEN);

        JLabel details = new JLabel("These are the game instructions:");
        details.setFont(new Font("Arial", Font.PLAIN, 24));
        infoPanel.add(details);

        JTextArea instructionText = getJTextArea();
        infoPanel.add(instructionText);

        this.infoWindow.add(infoPanel);
    }

    private static JTextArea getJTextArea() {
        JTextArea instructionText = new JTextArea(" Apples are falling from the sky!" + "🍎" + "🍎" +
                "\n\n Help the basket catch as many apples as possible" +
                "\n\n THE GAME RULES:" +
                "\n\n For every apple you catch, you will earn 1 point" +
                "\n After 10 points - you will get to the tougher step!" +
                "\n\n For every apple that misses, you will lose 1 " + "❤️" +
                "\n\n The game ends when all the hearts are gone" +
                "\n\n\t\tGOOD LUCK!!");
        instructionText.setFont(new Font("Segue UI Emoji", Font.PLAIN, 18));
        return instructionText;
    }

    // פונקציה שמציגה את החלון
    public void show() {
        this.infoWindow.setVisible(true);
    }
}
