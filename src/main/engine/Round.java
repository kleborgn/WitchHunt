package main.engine;

import main.Main;
import main.engine.cards.*;
import main.engine.players.AIPlayer;
import main.engine.players.Player;
import main.hci.cmd.Console;
import main.hci.cmd.Debug;
import main.vue.GUI;
import main.vue.RoundGUI;

import javax.swing.*;
import java.util.ArrayList;

public class Round {

    private Player nextPlayer;
    private boolean isNeededToIncrementNextPlayer = true;
    private ArrayList<Player> currentPlayers;

    private ArrayList<RumourCard> discardedCards;

    Round(ArrayList<Player> players) {
        this.currentPlayers = players;
    }

    /**
     * Start a round
     * @param players
     */
    public void startRound(ArrayList<Player> players) {
        if (Main.getMode() == Constants.MODE_CMD) {
            for (Player p:currentPlayers) {
                p.chooseIdentity();
                Console.clearScreen();
            }
        }
        if (Main.getMode() == Constants.MODE_GUI) {
            for (int i = 0; i < currentPlayers.size(); i++){
                int randomN = Game.rand.nextInt(2);
                if(randomN == 0) {
                    currentPlayers.get(i).pickIdentity(Identities.Villager);
                } else {
                    currentPlayers.get(i).pickIdentity(Identities.Witch);
                }
            }
        }
        discardedCards = new ArrayList<RumourCard>();
        dealCards();

        setNextPlayer(currentPlayers.get(Game.rand.nextInt(currentPlayers.size())));
        if (Main.getMode() == Constants.MODE_GUI) {
            GUI.setPlayersList(currentPlayers);
            GUI.setCardList(nextPlayer, nextPlayer.getNonRevealedCards(), null, false);
        }
        if (Main.getMode() == Constants.MODE_CMD) {
            while (!isRoundEnd(currentPlayers)) {
//            Debug.info(nextPlayer.getName());
                if (!(nextPlayer instanceof AIPlayer)) {
                    Console.menu(nextPlayer);
                } else {
                    ((AIPlayer) nextPlayer).aiPlayerChoice();
                }
                if (isNeededToIncrementNextPlayer) {
                    if (Game.getPlayers().indexOf(nextPlayer) == Game.getPlayers().size() - 1) {
                        setNextPlayer(currentPlayers.get(0));
                    } else {
                        setNextPlayer(currentPlayers.get(currentPlayers.indexOf(nextPlayer) + 1));
                    }
                }
                isNeededToIncrementNextPlayer = true;
                Console.clearScreen();
            }
            dealPoints();
        }
    }

    /**
     * Check if the round is over
     * @param players
     * @return
     */
    public boolean isRoundEnd(ArrayList<Player> players) {
        int nbUnrevealedPlayers = 0;
        for (Player player:players) {
            if (!player.getIdentityCard().getIsRevealed()) {
                nbUnrevealedPlayers++;
            }
            if (nbUnrevealedPlayers > 1)
                return false;
        }
        return true;
    }

    /**
     * Deal points to players
     */
    public void dealPoints() {
        Player winner = currentPlayers.get(0);
        if (winner.getIdentityCard().getIdentity() == Identities.Witch) {
            winner.displayMessage("is a witch ! They earned 2 points");
            winner.addPoints(2);
        } else {
            winner.displayMessage("is a villager ! They earned 1 point");
            winner.addPoints(1);
        }
    }

    public ArrayList<RumourCard> getDiscardedCards() {
        return discardedCards;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public ArrayList<Player> getCurrentPlayers() {
        return currentPlayers;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
        if (Main.getMode() == Constants.MODE_GUI) {
            GUI.setCardList(nextPlayer, nextPlayer.getNonRevealedCards(), null, false);
        }
    }

    public ArrayList<RumourCard> getAllRevealedRumourCards() {
        ArrayList<RumourCard> result = new ArrayList<RumourCard>();
        for (Player p:currentPlayers) {
            result.addAll(p.getRevealedCards());
        }
        return result;
    }

    /**
     * Deal cards to players
     */
    public void dealCards() {
        ArrayList<RumourCard> cards = new ArrayList<RumourCard>();
        cards.addAll(Game.getAllCards());
        int randomN;

        switch (currentPlayers.size()) {
            case 3 -> {
                for (Player p:currentPlayers) {
                    p.getRumourCards().clear();
                    for (int i = 0; i < 4; i++) {
                        randomN = Game.rand.nextInt(cards.size());
                        p.getRumourCards().add(cards.get(randomN));
                        cards.remove(randomN);
                    }
                }
            }
            case 4 -> {
                for (Player p:currentPlayers) {
                    for (int i = 0; i < 3; i++) {
                        randomN = Game.rand.nextInt(cards.size());
                        p.getRumourCards().add(cards.get(randomN));
                        cards.remove(randomN);
                    }
                }
            }
            case 5 -> {
                for (Player p:currentPlayers) {
                    for (int i = 0; i < 2; i++) {
                        randomN = Game.rand.nextInt(cards.size());
                        p.getRumourCards().add(cards.get(randomN));
                        cards.remove(randomN);
                    }
                }
                getDiscardedCards().addAll(cards);
            }
            case 6 -> {
                for (Player p:currentPlayers) {
                    for (int i = 0; i < 2; i++) {
                        randomN = Game.rand.nextInt(cards.size());
                        p.getRumourCards().add(cards.get(randomN));
                        cards.remove(randomN);
                    }
                }
            }
        }
    }

    public void setNeededToIncrementNextPlayer(boolean value) {
        this.isNeededToIncrementNextPlayer = value;
    }
}
