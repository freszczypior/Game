package pl.com.bottega.game.application;

import pl.com.bottega.game.engine.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GameAppOO {

    static Player player1;
    static Player player2;
    static Device device;
    static Arbiter arbiter;
    static Scanner scanner = new Scanner(System.in);
    static short gamesCount;

    public static void main(String[] args) {

        gamesCount = readGamesCount();
        initializePlayers();
        ScoreBoard primaryScore = new ScoreBoard(player1.getName(), player2.getName(), gamesCount, initializeDevice());

        for (int counter = 0; counter <= gamesCount; counter++) {
            byte result = arbiter.playRound();
            primaryScore.refresh(result);
        }
    }
    private static SoundDevice initializeDevice(){
        device = new Device();
        return device.selectDevice();
    }

    private static void initializePlayers() {
        int choice;
        do {
            say("wybierz graczy:");
            say("1. computer vs computer");
            say("2. human vs human");
            say("3. human vs computer");
            choice = scanner.nextInt();
            clearScanner();
        } while (!Pattern.matches("[1-3]", String.valueOf(choice)));
        switch (choice) {
            case 1:
                player1 = createComputerPlayer();
                player2 = createComputerPlayer();
                break;
            case 2:
                say("podaj imie gracza nr 1:");
                player1 = createHumanPlayer();
                say("podaj imie gracza nr 2");
                player2 = createHumanPlayer();

                break;
            case 3:
                say("podaj imie gracza:");
                player1 = createHumanPlayer();
                player2 = createComputerPlayer();
                break;
        }
        arbiter = createArbiter(player1, player2, gamesCount);
    }

    private static Player createHumanPlayer() {
        return new HumanPlayer(scanner.nextLine());
    }

    private static Player createComputerPlayer() {
        return new ComputerPlayer();
    }

    private static Arbiter createArbiter(Player player1, Player player2, short gamesCount) {
        return new Arbiter(player1, player2, gamesCount);
    }

    static void clearScanner() {
        scanner.nextLine();
    }

    private static short readGamesCount() {
        return 5;
    }

    private static void say(String s) {
        System.out.println(s);
    }
}
