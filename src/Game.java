import java.util.ArrayList;

public final class Game {
    private static Game game;
    private static ArrayList<Player> players;

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
            System.out.println("Entrer le nom du joueur " + (i+1) + " :");
            players.add(new HumanPlayer(Console.sc.next()));
        }

        for (int i = 0; i < nbAI; i++) {
            players.add(new AIPlayer("BOT " + (i+1)));
        }
    }

    public static void startGame() {

    }

    public static Game getInstance() {
        return game;
    }
}
