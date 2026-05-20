package org.example;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Apple {
    private int x;
    private int y;
    private final int size = 25;
    private int speed = 5;

    public Apple() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //נפילת התפוח
    public void fall() {
        this.y += this.speed;
    }
    // ציור התפוח
    public void draw(Graphics graphics) {
        graphics.setFont(new Font("Segue UI Emoji", Font.PLAIN, this.size));
        graphics.setColor(Color.RED);
        graphics.drawString("🍎", this.x, this.y + this.size);
    }






}
