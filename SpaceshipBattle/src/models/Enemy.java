package models;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy {

    private Image imagem;
    private int x, y;
    private int dx, dy;
    private int width, height;
    private boolean isVisible;
    private int side = 0;

    private static double speed = 0.9;

    public Enemy(int x, int y, int side) {
        this.x = x;
        this.y = y;
        this.side = side;
        isVisible = true;
    }

    public void load() {
        ImageIcon enemy = new ImageIcon("src\\sources\\enemy.png");
        imagem = enemy.getImage();
        this.width = 20;
        this.height = 20;
    }

    public void update() {

        if (side == 1) {
            if (this.x > 10) {
                this.x -= 10 * speed;
            } else {
                this.y += 35;
                side = 0;
            }
        } else {
            if (this.x < 1080) {
                this.x += 10 * speed;
            } else {
                this.y += 35;
                side = 1;
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x + 50, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public static double getSpeed() {
        return speed;
    }

    public static void setSpeed(double speed) {
        Enemy.speed = speed;
    }

    public Image getImagem() {
        return imagem;
    }

}
