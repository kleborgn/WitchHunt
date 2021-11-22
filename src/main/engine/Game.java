package main.engine;

import main.engine.cards.RumourCard;
import main.engine.players.AIPlayer;
import main.engine.players.HumanPlayer;
import main.engine.players.Player;
import main.hci.cmd.Console;
import main.Main;

import java.util.ArrayList;

public final class Game {
    private static Game game;

    private static ArrayList<Player> players;
    private static Player nextPlayer;

    private static ArrayList<Round> rounds;
    private static ArrayList<Player> tiePlayers;

    private static ArrayList<RumourCard> discardedCards;

    int nbPlayers, nbHumans, nbAI;

    private Game(int nbPlayers, int nbHumans, int nbAI) {
        this.nbPlayers = nbPlayers;
        this.nbHumans = nbHumans;
        this.nbAI = nbAI;
    }

    public static void createGame(int nbPlayers, int nbHumans, int nbAI) {
        if(game == null) {
            game = new Game(nbPlayers, nbHumans, nbAI);
        }
    }

    private static void createPlayerList(int nbHumans, int nbAI) {
        if (players != null)
            return;
        players = new ArrayList<Player>();
        for (int i = 0; i < nbHumans; i++) {
            if (Main.getMode() == Constants.MODE_CMD) {
                System.out.println("Entrer le nom du joueur " + (i + 1) + " :");
                players.add(new HumanPlayer(Console.sc.next()));
            }
            //TODO: add GUI input
        }

        for (int i = 0; i < nbAI; i++) {
            players.add(new AIPlayer("BOT " + (i+1)));
        }
    }

    public static void startGame() {

    }

    public static boolean isLastRound() {
        int maxScore = 0;
        for (Player player:players) {
            if (player.getPoints() == 5)
                tiePlayers.add(player);

            if (tiePlayers.size() > 1)
                playTie();

            if (player.getPoints() > maxScore)
                maxScore = player.getPoints();
        }
        return maxScore >= 5;
    }

    public static void playTie() {

    }

    public static Player getWinner() {
        Player maxScorePlayer = players.get(0);
        if (tiePlayers.size() > 1) {
            for (Player player:tiePlayers) {
                if (player.getPoints() > maxScorePlayer.getPoints())
                    maxScorePlayer = player;
            }
        } else {
            for (Player player:players) {
                if (player.getPoints() > maxScorePlayer.getPoints())
                    maxScorePlayer = player;
            }
        }
        return maxScorePlayer;
    }

    public static void addDiscardedCard(RumourCard card) {
        discardedCards.add(card);
    }

    public static Game getInstance() {
        return game;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static Player getNextPlayer() {
        return nextPlayer;
    }

    public static void setNextPlayer(Player nextPlayer) {
        Game.nextPlayer = nextPlayer;
    }

    public static ArrayList<Round> getRounds() {
        return rounds;
    }

}
