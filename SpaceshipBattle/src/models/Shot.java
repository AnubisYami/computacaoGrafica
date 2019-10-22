package models;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Shot {

    private Image imagem;
    private int x, y;
    private int altura, largura;
    private boolean isVisible;

    private static final int ALTURA = 860;
    private static int VELOCIDADE = 30;

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;

    }

    public void load() {
        ImageIcon referencia = new ImageIcon("src\\sources\\shot.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void update() {
        this.y -= VELOCIDADE;
        if (this.y > ALTURA) {
            isVisible = false;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        Shot.VELOCIDADE = VELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }

}
