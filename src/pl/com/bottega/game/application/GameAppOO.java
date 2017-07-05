package pl.com.bottega.game.application;

import pl.com.bottega.game.engine.*;

public class GameAppOO {

    public static void main(String[] args) {

        Arbiter arbiter;
        short gamesCount;

        GameCount gc = new GameCount();
        gamesCount = gc.readGamesCount();

        ArbiterFactory af = new ArbiterFactory();
        arbiter = af.initializePlayers(gamesCount);

        DeviceFactory device = new DeviceFactory();
        ScoreBoard primaryScore = new ScoreBoard(af.getPlayer1().getName(), af.getPlayer2().getName(), gamesCount, device.initializeDevice());

        for (int counter = 0; counter <= gamesCount; counter++) {
            byte result = arbiter.playRound();
            //primaryScore.refresh(result, counter, af.getPlayer1().getName(), af.getPlayer2().getName());
            primaryScore.refresh(result, counter, primaryScore.getName1(), primaryScore.getName2());    // getName z innego miejsca
        }
    }
}
