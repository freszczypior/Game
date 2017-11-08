package pl.com.knowosad.game1;

import pl.com.knowosad.game1.objects.Bullet;
import pl.com.knowosad.game1.objects.Player;
import pl.com.knowosad.game1.objects.Target;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game extends JFrame implements KeyListener {

    private Player player;
    private Image image;
    private Graphics graphics;
    private Bullet bullet;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    public CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Target> targets = initTargets();
    private int bulletsCounter;
    private int amounOfTargets;

    public Game() {
        setTitle("Shooter game");
        setLocation(100, 100);
        setResizable(false);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        addKeyListener(this);
        setVisible(true);
        player = new Player(280, 350, 40, 40, 10, "images/player.gif");
        amounOfTargets = targets.size();
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());       // createImage - metoda klasy Component
        graphics = image.getGraphics();                     // getGraphiccs - metoda klasy Image
        g.fillRect(0, 0, getWidth(), getHeight());    // fillRect - metoda klasy Graphics
        paintComponent(graphics);
        g.drawImage(image, 0, 0, null);      // drawIMage - metoda klasy Graphics
        repaint();                                          // repaint - metoda klasy Component
    }

    public void paintComponent(Graphics g) {
        if (targets.isEmpty()) {
            g.setColor(Color.WHITE);
            g.drawString("You Won!", 250, 190);
            g.drawString((String.format("You shooted %d times.", bulletsCounter)), 225, 205);
            g.drawString((String.format("You hit the target %d times.", amounOfTargets)), 225, 220);

        }
        player.draw(g);
        player.update(this);
        for (Bullet bullet : bullets) {
            bullet.draw(g);
            bullet.update(this);
        }
        for (Target target : targets) {
            target.draw(g);
            target.update(this);
        }
    }

    public CopyOnWriteArrayList<Target> initTargets() {
        CopyOnWriteArrayList<Target> targets = new CopyOnWriteArrayList<>();
        for (int i = 25; i < 575; i += 25)
            for (int j = 50; j <= 100; j += 25)
                targets.add(new Target(i, j, 20, 20, 1, "images/target.gif"));
        return targets;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            moveLeft = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            moveRight = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //player
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            moveLeft = false;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            moveRight = false;
        //bullet
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bullet = new Bullet(player, targets, -1, player.getXpos() + 18, player.getYpos(),
                    4, 10, "images/bullet.gif");
            bulletsCounter++;
            bullets.add(bullet);
        }
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

}
