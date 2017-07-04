package pl.com.bottega.game.engine;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private String hand;

    private static final String PAPER = "papier";
    private static final String ROCK = "kamien";
    private static final String SCISSORS = "nozyce";

    private int allAttempts;    // zmienna zliczająca wszystkie błędne próby człowieka w całej grze

    public HumanPlayer(String name) {
        this.name = name;
    }

    public String giveHand() {
        int attempt = 0;
        Scanner scanner = new Scanner(System.in);
        while (attempt < 4) {
            say(name + " wpisz: kamien, nozyce lub papier"); // dodałem wyświetlanie imienia humanPlayer
            hand = scanner.nextLine();
            if (!(hand.equals(PAPER) || hand.equals(ROCK) || hand.equals(SCISSORS))) {
                say("input error, try again!");
                attempt++;
            } else {
                return hand;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    private void say(String s) {
        System.out.println(s);
    }
}
