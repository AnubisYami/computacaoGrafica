package models;

import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Spaceship extends JFrame {

    public Spaceship() {
        setSize(250, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawLine(10, 10, 100, 100);
        g.drawRect(40, 100, 20, 20);
        g.drawOval(40, 100, 10, 10);
        g.fillRect(100, 100, 150, 250);
    }

}
