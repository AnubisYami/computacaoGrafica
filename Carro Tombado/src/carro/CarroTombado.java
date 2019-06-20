package carro;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;

//Eduardo Luiz Schade Soares - 16016923
public class CarroTombado extends Frame {

    {
        addWindowListener(new FecharJanela());
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath gp = new GeneralPath();

        // CARRO
        gp.moveTo(0, 80);
        gp.lineTo(1500, 80);
        gp.moveTo(60, 120);
        gp.lineTo(80, 120);
        gp.quadTo(90, 140, 100, 120);
        gp.lineTo(160, 120);
        gp.quadTo(170, 140, 180, 120);
        gp.lineTo(200, 120);
        gp.curveTo(195, 100, 200, 80, 160, 80);
        gp.lineTo(110, 80);
        gp.lineTo(90, 100);
        gp.lineTo(60, 100);

        // TRAILER
        gp.moveTo(200, 119);
        gp.lineTo(210, 119);
        gp.moveTo(210, 119);
        gp.lineTo(210, 110);
//        gp.moveTo(210, 110);
        gp.lineTo(220, 110);
//        gp.moveTo(220, 110);
        gp.lineTo(220, 120);
        gp.moveTo(220, 120);
        gp.lineTo(280, 120);
        gp.quadTo(290, 140, 300, 120);
        gp.lineTo(335, 120);
        gp.moveTo(335, 120);
        gp.lineTo(335, 100);
        gp.lineTo(220, 100);
        gp.lineTo(220, 120);
        gp.moveTo(220, 120);
        gp.lineTo(220, 85);
        gp.moveTo(220, 85);
        gp.lineTo(258, 85);
        gp.moveTo(258, 85);
        gp.lineTo(258, 100);
        gp.moveTo(258, 100);
        gp.lineTo(258, 85);
        gp.moveTo(258, 85);
        gp.lineTo(296, 85);
        gp.moveTo(296, 85);
        gp.lineTo(296, 100);
        gp.moveTo(296, 100);
        gp.lineTo(296, 85);
        gp.moveTo(296, 85);
        gp.lineTo(335, 85);
        gp.moveTo(335, 85);
        gp.lineTo(335, 116);
        gp.moveTo(335, 116);
        gp.lineTo(340, 116);
//        gp.moveTo(340, 116);
        gp.lineTo(340, 120);
//        gp.moveTo(340, 120);
        gp.lineTo(335, 120);
        
        g2d.rotate(Math.PI, 350, 220);
        g2d.translate(50,50); // mover
        g2d.setColor(Color.black);
        g2d.draw(gp);
        g2d.fill(gp);
    }

    public class FecharJanela extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        CarroTombado f = new CarroTombado();
        f.setTitle("Carro com trailer");
        f.setBackground(Color.WHITE);
        f.setSize(640, 480);
        f.setVisible(true);
    }
}
