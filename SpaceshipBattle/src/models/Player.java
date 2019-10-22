package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Player {

    private int x, y;
    private int dx, dy;
    private Image image;
    private int width, height;
    private List<Shot> shots;
    private boolean isVisible;
    private int score = 0;
    private int playerVelocity = 2;
    private Sound soundMovement = new Sound();
    private Sound soundShot = new Sound();

    public Player() {
        this.x = 550;
        this.y = 600;
        isVisible = true;
        shots = new ArrayList<Shot>();
        soundMovement.setFile("src\\sources\\movement.wav");
        soundShot.setFile("src\\sources\\shot.wav");
    }

    public void load() {
        ImageIcon spaceship = new ImageIcon("src\\sources\\spaceship.png");
        image = spaceship.getImage();
        height = 100;
        width = 30;
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void singleShot() {
        this.shots.add(new Shot(x + (width / 2), y + height));
        soundShot.play();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_SPACE) {
            singleShot();
            soundShot.play();
        }
        if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
            soundMovement.play();
            if (x < 20) {
                x = 20;
                dx = 0;
            } else {
                dx = playerVelocity * -1;
            }
        }
        if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
            soundMovement.play();
            if (x > 1080) {
                x = 1080;
                dx = 0;
            } else {
                dx = playerVelocity;
            }
        }

    }

    public void keyRelease(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
            dx = 0;
        }
        if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
            dx = 0;
        }

    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public List<Shot> getShots() {
        return shots;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlayerVelocity(int playerVelocity) {
        this.playerVelocity = playerVelocity;
    }

    public void addScore(int i) {
        this.score = this.score + i;
        if (this.score == 5000) {
        }
    }

}
