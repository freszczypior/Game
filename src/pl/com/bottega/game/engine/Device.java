package pl.com.bottega.game.engine;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Device {

    public SoundDevice selectDevice() {
        boolean ifCorrect = false;
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
            SoundDevice sony = new SonyDevice();
            return sony;
        } else if (choice == 2) {
            SoundDevice bosse = new BosseDevice();
            return bosse;
        } else {
            SoundDevice manta = new MantaDevice();
            return manta;
        }
    }

    private void say(String s) {
        System.out.println(s);
    }
}
