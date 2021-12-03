package main.engine;

import main.engine.cards.*;
import main.engine.players.AIPlayer;
import main.engine.players.Player;
import main.hci.cmd.Console;

import java.util.ArrayList;

public class Round {

    private Player nextPlayer;
    private boolean isNeededToIncrementNextPlayer = true;
    private ArrayList<Player> currentPlayers;

    private ArrayList<RumourCard> discardedCards;

    Round(ArrayList<Player> players) {
        this.currentPlayers = players;
    }

    public void startRound(ArrayList<Player> players) {
        for (Player p:currentPlayers) {
            p.chooseIdentity();
            Console.clearScreen();
        }
        discardedCards = new ArrayList<RumourCard>();
        dealCards();

        setNextPlayer(currentPlayers.get(Game.rand.nextInt(currentPlayers.size())));
        while (!isRoundEnd(currentPlayers)) {
            if (!(nextPlayer instanceof AIPlayer))
                Console.menu(nextPlayer);
            else
                ((AIPlayer) nextPlayer).aiPlayerChoice();
            if (isNeededToIncrementNextPlayer)
                setNextPlayer(currentPlayers.get(currentPlayers.indexOf(nextPlayer) + 1));
            isNeededToIncrementNextPlayer = true;
            Console.clearScreen();
        }
        dealPoints();
    }

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
    }

    public ArrayList<RumourCard> getAllRevealedRumourCards() {
        ArrayList<RumourCard> result = new ArrayList<RumourCard>();
        for (Player p:currentPlayers) {
            result.addAll(p.getRevealedCards());
        }
        return result;
    }

    public void dealCards() {
        ArrayList<RumourCard> cards = new ArrayList<RumourCard>();
        cards.addAll(Game.getAllCards());
        int randomN;

        switch (currentPlayers.size()) {
            case 3 -> {
                for (Player p:currentPlayers) {
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
