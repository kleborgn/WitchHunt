package main.vue;

import main.engine.cards.RumourCard;
import main.engine.players.Player;

import java.util.ArrayList;

public class GUI {
    static SetupGUI setupGui;
    static RoundGUI roundGui;
    public static void initGame() {
        setupGui = new SetupGUI();
        setupGui.setVisible(true);
        setupGui.pack();
        setupGui.setTitle("Witch Hunt");
        setupGui.setSize(640, 480);
    }

    public static void initMainPanel() {
        roundGui = new RoundGUI();
        roundGui.setVisible(true);
        roundGui.pack();
        roundGui.setTitle("Witch Hunt");
        roundGui.setSize(1280,720);
    }

    public static void setPlayersList(ArrayList<Player> currentPlayers) {
        roundGui.setPlayersList(currentPlayers);
    }

    public static void setCardList(Player currentPlayer, ArrayList<RumourCard> currentPlayerCards, Player accuser, boolean chooseIdentity) {
        roundGui.setCardList(currentPlayer, currentPlayerCards, accuser, chooseIdentity);
    }
    public static Player getChosenPlayer() {
        return roundGui.getChosenPlayer();
    }
}
