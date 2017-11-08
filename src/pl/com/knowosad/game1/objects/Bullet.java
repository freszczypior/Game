package pl.com.knowosad.game1.objects;

import pl.com.knowosad.game1.Game;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Bullet extends GameObject {

    private Player player;
    private CopyOnWriteArrayList<Target> targets;
    private int deltaY;
    private int hitCounter;

    public Bullet(final Player player, CopyOnWriteArrayList<Target> targets, final int deltaY, final int xPos, final int yPos, final int width, final int height, final String img){
        this.player = player;
        this.targets = targets;
        this.deltaY = deltaY;
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
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
        for (Target target: targets)
        if (rect.intersects(target.rect)) {
            game.targets.remove(target);
            game.bullets.remove(this);
            hitCounter++;
        }
        yPos += deltaY;
        rect.y += deltaY;

        if (yPos < 30)
            game.bullets.remove(this);
    }

    public int getHitCounter() {
        return hitCounter;
    }
}
