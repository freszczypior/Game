package pl.com.knowosad.game2.input;


import pl.com.knowosad.game2.objects.Enemy;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Controller {

    private static LinkedList<Enemy> enemyList = new LinkedList<>();
    private Enemy tempEnemy;

    public Controller(){
        addEnemy(new Enemy(100, 100));
        addEnemy(new Enemy(100, 150));
        addEnemy(new Enemy(100, 200));
    }

    public void draw(Graphics2D g2d) {
        for (int i = 0; i < enemyList.size(); i++) {
            tempEnemy = enemyList.get(i);
            tempEnemy.draw(g2d);
        }
    }

    public void update(){
        for (int i = 0; i < enemyList.size(); i++) {
            tempEnemy = enemyList.get(i);
            tempEnemy.update();
        }
    }

    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }
    public void removeEnemy(Enemy enemy){
        enemyList.remove(enemy);
    }

    public static LinkedList<Enemy> getEnemyBoounds(){
        return enemyList;
    }
}
