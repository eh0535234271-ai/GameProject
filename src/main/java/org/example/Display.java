package org.example;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Display {
    public void drawScoreAndHearts(Graphics graphics, int score, int lives, int yHeartPosition, int windowWidth) {
        // ציור הלבבות
        graphics.setFont(new Font("Arial", Font.BOLD, 40));
        for (int i = 0; i < lives; i++) {
            int heartX = 20 + (i * 30);
            graphics.drawString("♥", heartX, yHeartPosition);
        }

        // ציור הניקוד
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 24));
        String stepText = (score < 10) ? "Step 1" : "Step 2";
        graphics.drawString(stepText + "| Score :" + (score % 10) + "/10", (windowWidth * 65) / 100, yHeartPosition);
    }

    // 2. ציור מסך GAME OVER
    public void drawGameOver(Graphics graphics, int windowWidth, int windowHeight) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("Arial", Font.BOLD, 40));
        int gameOverX = (windowWidth / 2) - 120;
        int gameOverY = windowHeight / 2;
        graphics.drawString("GAME OVER", gameOverX, gameOverY);
    }

    // 3. ציור מסך YOU WON
    public void drawYouWon(Graphics graphics, int windowWidth, int windowHeight) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("Arial", Font.BOLD, 50));
        graphics.drawString("YOU WON!", (windowWidth / 2) - 120, windowHeight / 2);
    }
}
