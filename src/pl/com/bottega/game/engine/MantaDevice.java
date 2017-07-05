package pl.com.bottega.game.engine;

public class MantaDevice implements SoundDevice {

    @Override
    public void playSound(String sound) {
        System.out.println(sound);
    }
}