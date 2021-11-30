package main.engine.players;

import main.engine.Game;
import main.engine.cards.Identities;
import main.engine.cards.RumourCard;

import java.util.ArrayList;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public Player choosePlayer() {
        return Game.getPlayers().get(Game.rand.nextInt(Game.getPlayers().size()));
    }

    @Override
    public RumourCard pickCard(ArrayList<RumourCard> cards) {
        return cards.get(Game.rand.nextInt(cards.size()));
    }

    @Override
    public void displayIdentity(Player who) {

    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void chooseIdentity() {
        int randomN = Game.rand.nextInt(2);

        if(randomN == 0) {
            this.pickIdentity(Identities.Villager);
        } else {
            this.pickIdentity(Identities.Witch);
        }
    }
}
