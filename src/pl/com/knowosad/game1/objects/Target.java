package pl.com.knowosad.game1.objects;


import pl.com.knowosad.game1.Game;

import java.awt.*;

public class Target extends GameObject{

    protected int health;

    public Target(final int xPos, final int yPos, final int width, final int height, final int health, final String img){
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.health = health;
        this.rect = new Rectangle(xPos, yPos, width, height);
        this.img = getImage(img);
    }

    @Override
    public Image getImage(String img) {
        return Toolkit.getDefaultToolkit().getImage(img);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, xPos, yPos, width, height, null);
    }

    @Override
    public void update(Game game) {
    }

}
