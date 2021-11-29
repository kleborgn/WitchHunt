package main.engine.players;

import main.engine.Game;
import main.engine.cards.RumourCard;

import java.util.ArrayList;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public Player choosePlayer() {
        return Game.getPlayers().get(Game.rand.nextInt(Game.getPlayers().size() - 1));
    }

    @Override
    public RumourCard pickCard(ArrayList<RumourCard> cards) {
        return cards.get(Game.rand.nextInt(cards.size() - 1));
    }

    @Override
    public void displayIdentity(Player who) {

    }

    @Override
    public void displayMessage(String message) {

    }
}
