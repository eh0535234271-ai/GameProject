package org.example;

import java.awt.*;

public class Basket {
    private int x;
    private int y;
    private int width = 80;
    private int height = 30;
    private int speed = 25;

    public Basket(int windowWidth, int windowHeight) {
        this.x = (windowWidth / 2) - (this.width / 2);
        this.y = windowHeight - this.height - 40;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //הוזזת הסל ימינה בתנאי שלא יוצא מהגבול הימני
    public void moveRight(int windowWidth) {
        if (this.x + this.speed <= windowWidth - this.width) {
            this.x += this.speed;
        }
    }
    //הוזזת הסל שמאלה בתנאי שלא יוצא מהגבול השמאלי
    public void moveLeft() {
        if (this.x - this.speed >= 0) {
            this.x -= this.speed;
        }
    }

    //ציור הסל
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 100, 0));
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }

}
