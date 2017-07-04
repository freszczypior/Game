package pl.com.bottega.game.engine;


public class ScoreBoard {

    private short points1;
    private short points2;

    private String name1;
    private String name2;

    private short maxRounds;

    private SoundDevice soundDev;
    private String soundOfVictory = "FANFARY!!";

    public ScoreBoard(String name1, String name2, short maxRounds, SoundDevice soundDev) {
        this.name1 = name1;
        this.name2 = name2;
        this.maxRounds = maxRounds;
        this.soundDev = soundDev;
    }

    public void refresh(byte result) {
        if (result == -1) {
            displaySummary();
            return;
        }
        switch (result) {
            case 1:
                points1++;
                break;
            case 2:
                points2++;
        }
        displayCurrentState();
    }

    private void displayCurrentState() {
        say(name1 + ": " + points1 + " VS " + name2 + ": " + points2);
    }

    private void displaySummary() {
        displayCurrentState();
        if (points1 == points2)
            say("remis");
        else {
            String nr = points1 > points2 ? "1" : "2";
            say("mecz wygrał: " + nr);
            say(soundDev.playSound(soundOfVictory));    // dzwiek przy wygranej jednej ze stron
        }
    }

    private void say(String s) {
        System.out.println(s);
    }

}
