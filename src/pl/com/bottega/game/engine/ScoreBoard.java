package pl.com.bottega.game.engine;


public class ScoreBoard {

    private short points1;
    private short points2;

    private String name1;
    private String name2;

    private short maxRounds;

    private SoundDevice soundDev;
    private String soundOfVictory = "FANFARY!!";

    public ScoreBoard(String name1, String name2, short maxRounds, SoundDevice soundDevice) {
        this.name1 = name1;
        this.name2 = name2;
        this.maxRounds = maxRounds;
        this.soundDev = soundDevice;
    }

    public void refresh(byte result, int counter, String name1, String name2) {
        if (result == -1) {
            displaySummary(counter, name1, name2);
            return;
        }
        switch (result) {
            case 1:
                points1++;
                break;
            case 2:
                points2++;
        }
        displayCurrentState(counter);
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    private void displayCurrentState(int counter) {
        say("round " + (counter + 1) + ": " + name1 + ": " + points1 + " VS " + name2 + ": " + points2);
    }

    private void displaySummary(int counter, String name1, String name2) {  // dodałem wyświetlanie imienia gracza
        displayCurrentState(counter);
        if (points1 == points2)
            say("remis");
        else {
            String winner = points1 > points2 ? name1 : name2;
            say("mecz wygrał: " + winner);
            soundDev.playSound(soundOfVictory);
        }
    }

    private void say(String s) {
        System.out.println(s);
    }

}
