package application;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import models.Level;

public class Main extends JFrame {

    public Main() {
        add(new Level());
        ImageIcon img = new ImageIcon("src\\sources\\enemy.png");
        this.setIconImage(img.getImage());
        setTitle("Spaceship Battle - ULTIMATE");
        setSize(1200, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
