package pl.com.knowosad.game2.objects;

import pl.com.knowosad.game2.MainClass;

import java.awt.*;


public class Enemy extends GlobalPosition {

    private String enemyImage = "img/mrYellow.png";
    private int ENEMY_SPEED = 3;
    private int ENEMY_WIDTH = 15;
    private int ENEMY_HEIGHT = 15;

    public Enemy(int x, int y) {
        super(x, y);
    }

    Image getEnemyImage() {
        return Toolkit.getDefaultToolkit().getImage(enemyImage);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getEnemyImage(), x, y, null);
    }

    public void update() {
        x+= ENEMY_SPEED;
        if (x > MainClass.WIDTH - ENEMY_WIDTH)
            ENEMY_SPEED = -3;
        if (x < 0)
            ENEMY_SPEED = 3;
    }
    public Rectangle getEnemyBounds(){
        return new Rectangle(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
    }


}
