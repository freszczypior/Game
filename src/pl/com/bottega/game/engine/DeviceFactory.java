package pl.com.bottega.game.engine;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DeviceFactory {

    public SoundDevice initializeDevice() {
        return selectDevice();
    }   // czy taki zabieg ma sens, w klasie jedna metoda(publiczna) wywołuję drugą(prywatną) ????????????????

    private SoundDevice selectDevice() {
        int choice;
        do {
            say("wybierz urządzenie do wyświetlania wyników:");
            say("1 - sony");
            say("2 - bosse");
            say("3 - manta");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        } while (!Pattern.matches("[1-3]", String.valueOf(choice)));
        if (choice == 1) {
            return new SonyDevice();
        } else if (choice == 2) {
            return new BosseDevice();
        } else {
            return new MantaDevice();
        }
    }
    private void say(String s) {
        System.out.println(s);
    }
}
