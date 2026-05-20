package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.io.File;
import javax.sound.sampled.*;

public class GamePanel extends JPanel {
 private Basket basket;
private Apple apple;
private Display display;
private int lives = 3;
private final int yHeartPosition = 45;
private int score = 0;
private Thread gameThread;
private boolean isPaused = false;


    public GamePanel(int windowWidth, int windowHeight) {
        this.basket = new Basket(windowWidth,windowHeight);
        this.apple = new Apple();
        this.display = new Display();
        this.setBackground(Color.BLUE);
        this.setFocusable(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if(keyCode == KeyEvent.VK_RIGHT) {
                basket.moveRight(getWidth());
                }
                else if(keyCode == KeyEvent.VK_LEFT) {
                    basket.moveLeft();
                }
                //    repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.gameThread = new Thread(() -> {
                while (true) {
                    long sleepTime = 30;
                    if(!isPaused) {
                        apple.fall();
                        if (apple.getY() > getHeight() && getHeight() > 0) {
                            playSound("fall");
                            lives--;
                            if (lives <= 0) {
                                repaint();
                                break;
                            }
                            resetObject();
                        } else if (isCaught()) {
                            playSound("catch");
                            this.score++;
                            if (this.score == 10) {
                                apple.setSpeed(8);
                            }
                            if (this.score == 20) {
                                repaint();
                                break;
                            }
                            repaint();
                            sleepTime = 150;
                            resetObject();
                        }
                    }
                    repaint();
                    try{
                        Thread.sleep(sleepTime);
                    }catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                }
            }
        });this.gameThread.start();

        this.setLayout(null);
        PauseButton pauseButton = new PauseButton(this);
        this.add(pauseButton);

    }
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x,y,width,height);
        if(this.basket.getX() == 0) {
            this.basket.setX((getWidth() / 2) - (basket.getWidth() / 2));
            this.basket.setY(getHeight() - basket.getHeight() - 40);
            resetObject();
        }
        this.requestFocusInWindow();
    }


    protected void paintComponent(Graphics graphics) {
       super.paintComponent(graphics);
       graphics.setColor(new Color(135,200,235));
       graphics.fillRect(0,0,getWidth(),getHeight());
        //עיצוב הסל
        basket.draw(graphics);
       //החפצים שנופלים מלמעלה
        apple.draw(graphics);
        //ציור הלבבות והניקוד
        display.drawScoreAndHearts(graphics,score,lives,yHeartPosition,getWidth());
        //ציור תצוגת סיום
if(lives <= 0) {
    display.drawGameOver(graphics,getWidth(),getHeight());
} else if(score == 20) {
    display.drawYouWon(graphics,getWidth(),getHeight());
}

    }

    private void resetObject() {
      this.apple.setY(0);
      if(getWidth() <= 0) {
        this.apple.setX(0);
        return;
      }

        int maxWidth = getWidth() - apple.getSize();
        Random random = new Random();
        this.apple.setX(random.nextInt(maxWidth));
    }

    private boolean isCaught() {
        //בדיקת גובה: האם תחתית החפץ הגיעה לגובה של הסל
      boolean yOverlap = (apple.getY() + apple.getSize() >= basket.getY()) && (apple.getY() <= basket.getY() + basket.getHeight());
        //בדיקת רוחב: האם החפץ נמצא בטווח של הסל
      boolean xOverlap = (apple.getX() + apple.getSize() >= basket.getX()) && (apple.getX() <= basket.getX() + basket.getWidth());

    return xOverlap && yOverlap;
    }

    private void playSound(String fileName) {
        try {
            File file = new File(fileName + ".wav");
            if (!file.exists()) {
                file = new File(fileName); // ליתר ביטחון אם הסיומת מוסתרת
            }

            if (file.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } else {
                System.out.println("The file " + fileName + " is not in the folder!");
            }
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }

    public void togglePause() {
        this.isPaused = !this.isPaused;
    }

}
