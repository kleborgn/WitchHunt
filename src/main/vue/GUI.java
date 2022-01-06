package main.vue;

import main.engine.cards.RumourCard;
import main.engine.players.Player;

import java.util.ArrayList;

public class GUI {
    static RoundGUI roundGui;
    public static void initGame() {
        SetupGUI setupGUI = new SetupGUI();
        setupGUI.setVisible(true);
        setupGUI.pack();
        setupGUI.setTitle("Witch Hunt");
        setupGUI.setSize(640, 480);
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

    public static void setCardList(Player currentPlayer, ArrayList<RumourCard> currentPlayerCards, Player accuser) {
        roundGui.setCardList(currentPlayer, currentPlayerCards, accuser);
    }
}
