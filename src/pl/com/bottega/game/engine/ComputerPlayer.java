package pl.com.bottega.game.engine;

import java.util.Random;

public class ComputerPlayer implements Player {

    private String name = "HAL";
    private Random random = new Random();

    public String giveHand() {
        int randomChoice = random.nextInt(3);
        String computerHand = null;
        switch (randomChoice) {
            case 0:
                computerHand = "kamien";
                break;
            case 1:
                computerHand = "papier";
                break;
            case 2:
                computerHand = "nozyce";
                break;
        }

        return computerHand;
    }

    public String getName() {
        return name;
    }
}
