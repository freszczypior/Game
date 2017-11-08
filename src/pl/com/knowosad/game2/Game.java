package pl.com.knowosad.game2;

import pl.com.knowosad.game2.input.Controller;
import pl.com.knowosad.game2.input.KeyInput;
import pl.com.knowosad.game2.objects.Enemy;
import pl.com.knowosad.game2.objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    Timer gameLoopTimer;
    Player player;
    Controller controler;
    private String backgroundImage = "img/moonBackground.png";

    public Game() {
        setFocusable(true);
        gameLoopTimer = new Timer(10, this);
        gameLoopTimer.start();
        player = new Player(100, 100);
        controler = new Controller();
        addKeyListener(new KeyInput(player));

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getBackgroundImage(), 0, 0, this);
        player.draw(g2d);
        controler.draw(g2d);
    }

    public Image getBackgroundImage() {
        return Toolkit.getDefaultToolkit().getImage(backgroundImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        controler.update();
        repaint();
    }
}
