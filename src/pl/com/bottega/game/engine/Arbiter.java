package pl.com.bottega.game.engine;

public class Arbiter {

    private short courrentRound;
    private short maxRounds;

    private Player player1;
    private Player player2;

    public Arbiter(Player player1, Player player2, short maxRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.maxRounds = maxRounds;
    }

    public byte playRound() {
        if (courrentRound == maxRounds)
            return -1;
        courrentRound++;
        String hand1 = player1.giveHand();
        String hand2 = player2.giveHand();

        return calculateResult(hand1, hand2);
    }

    private static byte calculateResult(String hand1, String hand2) {
        if (hand1.equals(hand2))
            return 0;
        if ((hand1.equals("papier") && hand2.equals("kamien"))
                ||
                (hand1.equals("kamien") && hand2.equals("nozycze"))
                ||
                (hand1.equals("nozyce") && hand2.equals("papier"))) {
            return 1;
        } else {
            return 2;
        }
    }
}

