package models;

import java.awt.event.ActionListener;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.Player;
import models.Shot;
import models.Enemy;

public class Level extends JPanel implements ActionListener {

    private Image background;
    private Player player;
    private Timer timer;
    private Shot shot;
    private List<Enemy> enemy;
    private int gameState;
    private final int enemyQnty = 30;
    private final int scoreValue = 100;
    private int gameProgress = 0;
    private Sound soundEnviroment = new Sound();
    private Sound soundGameOver = new Sound();
    private Sound soundExplosion = new Sound();
    private Sound soundEndGame = new Sound();

    public Level() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon source = new ImageIcon("src\\sources\\background.png");

        background = source.getImage();

        player = new Player();
        player.load();

        addKeyListener(new KeyBoardAdapter());

        timer = new Timer(5, this);
        timer.start();

        spawnEnemies();

        gameState = 0;

        soundEnviroment.setFile("src\\sources\\soundtrack.wav");
        soundGameOver.setFile("src\\sources\\gameover.wav");
        soundEndGame.setFile("src\\sources\\endgame.wav");
        soundExplosion.setFile("src\\sources\\explosion.wav");
        soundEnviroment.play();
        soundEnviroment.repeat();
    }

    public void spawnEnemies() {
        int start[] = new int[enemyQnty];
        enemy = new ArrayList<Enemy>();
        int spawnPosition = 0;

        Random rand = new Random();

        for (int i = 0; i < start.length; i++) {
            enemy.add(new Enemy(((int) rand.nextInt((1080 - 10) + 1080) + 10), 0, (int) rand.nextInt((1 - 0) + 1) + 0));

        }
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        if (gameState == 0) {
            graphics.drawImage(background, 0, 0, null);
            graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
            graphics.setColor(Color.white);
            graphics.drawString("SCORE: " + player.getScore(), 920, 40);

            List<Shot> shots = player.getShots();
            for (int i = 0; i < shots.size(); i++) {
                Shot m = shots.get(i);
                m.load();
                graphics.drawImage(m.getImagem(), m.getX() - 15, m.getY() - 100, this);
            }

            for (int o = 0; o < enemy.size(); o++) {
                Enemy in = enemy.get(o);
                in.load();
                graphics.drawImage(in.getImagem(), in.getX(), in.getY(), this);

            }
        } else if (gameState == 1) {
            ImageIcon gameOver = new ImageIcon("src\\sources\\gameover.png");
            graphics.drawImage(gameOver.getImage(), 0, 0, null);
            graphics.setFont(new Font("Arial", Font.BOLD, 40));
            graphics.setColor(Color.white);
            graphics.drawString("SCORE: " + player.getScore(), 10, 600);
        } else {
            graphics.drawImage(background, 0, 0, null);
            graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);
            graphics.setFont(new Font("Arial", Font.BOLD, 40));
            graphics.setColor(Color.white);
            graphics.drawString("CONGRATS!", 460, 250);
            graphics.drawString("YOU SAVED THE UNIVERSE!", 320, 350);
            graphics.drawString("FINAL SCORE: " + player.getScore(), 460, 450);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        player.update();
        List<Shot> shots = player.getShots();
        for (int i = 0; i < shots.size(); i++) {
            Shot m = shots.get(i);
            if (m.isIsVisible()) {
                m.update();
            } else {
                shots.remove(i);
            }
        }

        for (int o = 0; o < enemy.size(); o++) {
            Enemy in = enemy.get(o);
            if (in.isIsVisible()) {
                in.update();
            } else {
                enemy.remove(o);
            }

        }
        collision();
        repaint();
        checkProgress();

    }

    public void checkProgress() {
        if (gameProgress == enemyQnty) {
            gameState = 2;
        }
    }

    public void collision() {
        Rectangle shapeSpaceship = player.getBounds();
        Rectangle shapeEnemy;
        Rectangle shapeShot;

        for (int i = 0; i < enemy.size(); i++) {
            Enemy tempEnemy = enemy.get(i);
            shapeEnemy = tempEnemy.getBounds();
            if (shapeSpaceship.intersects(shapeEnemy)) {
                soundGameOver.play();
                soundEndGame.play();
                soundEndGame.repeat();
                player.setIsVisible(false);
                tempEnemy.setIsVisible(false);
                gameState = 1;
            }
        }

        List<Shot> shots = player.getShots();
        for (int t = 0; t < shots.size(); t++) {
            Shot tempShot = shots.get(t);
            shapeShot = tempShot.getBounds();
            for (int o = 0; o < enemy.size(); o++) {
                Enemy tempEnemy = enemy.get(o);
                shapeEnemy = tempEnemy.getBounds();
                if (shapeShot.intersects(shapeEnemy)) {
                    tempEnemy.setIsVisible(false);
                    tempShot.setIsVisible(false);
                    player.addScore(scoreValue);
                    gameProgress += 1;
                    soundExplosion.play();
                }
            }
        }

    }

    private class KeyBoardAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyRelease(e);
        }
    }

}
