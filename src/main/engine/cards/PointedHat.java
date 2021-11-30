package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

import java.util.ArrayList;

public class PointedHat extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        RumourCard choice = owner.pickCard(owner.getRevealedCards());
        owner.getRumourCards().get(owner.getRumourCards().indexOf(choice)).setRevealed(false);
        Game.setNextPlayer(owner);
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        RumourCard choice = owner.pickCard(owner.getRevealedCards());
        owner.getRumourCards().get(owner.getRumourCards().indexOf(choice)).setRevealed(false);
        Game.setNextPlayer(owner.choosePlayer());
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean isWitchEffectUsable(Player owner) {
        return owner.getRevealedCards().size() > 0;
    }

    @Override
    public boolean isHuntEffectUsable(Player owner) {
        return owner.getRevealedCards().size() > 0;
    }

    @Override
    public String witchEffectToString() {
        return "Take one of your own revealed Rumour cards into your hand. Take next turn.";
    }

    @Override
    public String huntEffectToString() {
        return "Take one of your own revealed Rumour cards into your hand. Choose next player.";
    }

    @Override
    public String toString() {
        return "Pointed Hat";
    }
}
