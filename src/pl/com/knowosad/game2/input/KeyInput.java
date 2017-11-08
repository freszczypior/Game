package pl.com.knowosad.game2.input;

import pl.com.knowosad.game2.objects.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

    Player player;

    public KeyInput(Player player) {
        this.player = player;
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }
}
