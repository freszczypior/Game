package pl.com.knowosad.game2.objects;

import pl.com.knowosad.game2.input.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Player extends GlobalPosition {

    private String playerImage = "img/mrGreen.png";
    private int velx = 0;
    private int vely = 0;
    private int playerWidth = 15;
    private int playerHeigth = 15;
    private int playerHealth = 10;
    private LinkedList<Enemy> enemyList = Controller.getEnemyBoounds();

    public Player(int x, int y) {
        super(x, y);
    }

    public void update() {
        x += velx;
        y += vely;
        if (x < 0)
            x = 0;
        if (x > 640 - playerWidth)
            x = 640 - playerWidth;
        if (y < 0)
            y = 0;
        if (y > 462 - playerHeigth)
            y = 462 - playerHeigth;
        collision();

    }

    public Image getPlayerImage() {
        return Toolkit.getDefaultToolkit().getImage(playerImage);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getPlayerImage(), x, y, null);
    }

    private void collision() {
        for (int i = 0; i < enemyList.size(); i++)
            if (getPlayerBounds().intersects(enemyList.get(i).getEnemyBounds())) {
                playerHealth--;
            }
    }

    public Rectangle getPlayerBounds() {
        return new Rectangle(x, y, playerWidth, playerHeigth);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            velx = 5;
        } else if (key == KeyEvent.VK_LEFT) {
            velx = -5;
        } else if (key == KeyEvent.VK_UP) {
            vely = -5;
        } else if (key == KeyEvent.VK_DOWN) {
            vely = 5;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            velx = 0;
        } else if (key == KeyEvent.VK_LEFT) {
            velx = 0;
        } else if (key == KeyEvent.VK_UP) {
            vely = 0;
        } else if (key == KeyEvent.VK_DOWN) {
            vely = 0;
        }
    }
}
