package pl.com.knowosad.shooter.objects;

import pl.com.knowosad.shooter.Game;

import java.awt.*;

public abstract class GameObject {

    protected Rectangle rect;
    protected Image img;
    protected int xPos;
    protected int yPos;
    protected int height;
    protected int width;

    abstract Image getImage(String img);

    abstract void draw(Graphics g);

    abstract void update(Game game);
}
