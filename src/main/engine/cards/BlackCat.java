package main.engine.cards;

import main.Main;
import main.engine.Constants;
import main.engine.Game;
import main.engine.players.Player;

import java.util.ArrayList;

public class BlackCat extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        Game.setNextPlayer(owner);
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        ArrayList<RumourCard> cards = Game.getDiscardedCards();

        owner.addCard(owner.pickCard(cards));
        owner.discardCard(this);

        return true;
    }

    @Override
    public boolean isWitchEffectUsable(Player owner) {
        return true;
    }

    @Override
    public boolean isHuntEffectUsable(Player owner) {
        return Game.getDiscardedCards().size() > 0;
    }

    @Override
    public String witchEffectToString() {
        return "Take next turn.";
    }

    @Override
    public String huntEffectToString() {
        return "Add one discarded card to your hand, and then discard this card. Take next turn.";
    }

    @Override
    public String toString() {
        return "Black Cat";
    }
}
