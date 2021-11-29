package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class Wart extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        Game.setNextPlayer(owner);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        Game.setNextPlayer(owner.choosePlayer());
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean isWitchEffectUsable(Player owner) {
        return true;
    }

    @Override
    public boolean isHuntEffectUsable(Player owner) {
        return true;
    }

    @Override
    public String witchEffectToString() {
        return "Take next turn.";
    }

    @Override
    public String huntEffectToString() {
        return "Choose next player.";
    }

    @Override
    public String sideEffectToString() {
        return "While revealed, you cannot be chosen by the Ducking Stool.";
    }

    @Override
    public String toString() {
        return "Wart";
    }
}
