package pl.com.bottega.game.engine;

public class BosseDevice implements SoundDevice {

    @Override
    public void playSound(String sound) {
        System.out.println(sound);
    }
}