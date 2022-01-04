package main.engine;

import main.engine.cards.*;
import main.engine.players.AIPlayer;
import main.engine.players.HumanPlayer;
import main.engine.players.Player;
import main.hci.cmd.Console;
import main.Main;
import main.vue.RoundGUI;

import java.util.ArrayList;
import java.util.Random;

public final class Game {
    private static Game game;

    private static ArrayList<RumourCard> allCards;

    private static ArrayList<Player> players;

    private static Round currentRound;
    private static ArrayList<Player> tiePlayers;

    public static Random rand = new Random();

    int nbPlayers, nbHumans, nbAI;

    private Game(int nbPlayers, int nbHumans, int nbAI) {
        this.nbPlayers = nbPlayers;
        this.nbHumans = nbHumans;
        this.nbAI = nbAI;
        initCards();
    }

    /**
     * Init the array with all cards
     */
    private static void initCards() {
        allCards = new ArrayList<RumourCard>();
        allCards.add(new AngryMob());
        allCards.add(new BlackCat());
        allCards.add(new Broomstick());
        allCards.add(new Cauldron());
        allCards.add(new DuckingStool());
        allCards.add(new EvilEye());
        allCards.add(new HookedNose());
        allCards.add(new PetNewt());
        allCards.add(new PointedHat());
        allCards.add(new TheInquisition());
        allCards.add(new Toad());
        allCards.add(new Wart());
    }

    /**
     * Create a new game
     * @param nbPlayers
     * @param nbHumans
     * @param nbAI
     */
    public static void createGame(int nbPlayers, int nbHumans, int nbAI, ArrayList<String> playerNames) {
        if(game == null) {
            game = new Game(nbPlayers, nbHumans, nbAI);
            createPlayerList(nbHumans, nbAI, playerNames);
            tiePlayers = new ArrayList<Player>();
        }
    }

    /**
     * Create the player list
     * @param nbHumans
     * @param nbAI
     */
    private static void createPlayerList(int nbHumans, int nbAI, ArrayList<String> playerNames) {
        String name;
        if (players != null)
            return;
        players = new ArrayList<Player>();
        for (int i = 0; i < nbHumans; i++) {
            if (Main.getMode() == Constants.MODE_CMD) {
                do {
                    System.out.println("Enter a name for player " + (i + 1) + " :");
                    name = Console.sc.next();
                } while(getPlayerByName(name) != null);
                players.add(new HumanPlayer(name));
            } else if (Main.getMode() == Constants.MODE_GUI){
                players.add(new HumanPlayer(playerNames.get(i)));
            }
        }

        for (int i = 0; i < nbAI; i++) {
            System.out.println("Cest les bots");
            players.add(new AIPlayer("BOT " + (i+1)));
        }
    }

    /**
     * Start the game
     */
    public static void startGame() {
        while(!isLastRound()) {
            currentRound = new Round(players);
            currentRound.startRound(players);
        }
        if (Main.getMode() == Constants.MODE_CMD)
            System.out.println(getWinner().getName() + " won!");
    }

    /**
     * @return Check if it's the last round
     */
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

    /**
     * Get the winner
     * @return winner
     */
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
        currentRound.getDiscardedCards().add(card);
    }

    public static Game getInstance() {
        return game;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static Player getNextPlayer() {
        return currentRound.getNextPlayer();
    }

    public static void setNextPlayer(Player nextPlayer) {
        currentRound.setNextPlayer(nextPlayer);
    }

    public static void setNextPlayer(String name) {
        setNextPlayer(getPlayerByName(name));
    }

    public static Player getPlayerByName(String name) {
        for (Player p:players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public static boolean isPlayerExisting(String name) {
        return (getPlayerByName(name) != null);
    }

    public static ArrayList<RumourCard> getDiscardedCards() {
        return currentRound.getDiscardedCards();
    }

    public static RumourCard getCardByName(String name, ArrayList<RumourCard> cards) {
        for (RumourCard card:cards) {
            if (card.toString().equals(name))
                return card;
        }
        return null;
    }

    public static Round getCurrentRound() {
        return currentRound;
    }

    public static ArrayList<RumourCard> getAllCards() {
        return allCards;
    }
}
