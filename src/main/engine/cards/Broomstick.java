package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class Broomstick extends RumourCard {

    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        this.setRevealed(true);
        Game.setNextPlayer(owner);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        this.setRevealed(true);
        Game.setNextPlayer(owner.choosePlayer());
        return true;
    }

    @Override
    public boolean isWitchEffectUsable() {
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
        return "While revealed, you cannot be chosen by the Angry Mob.";
    }

    @Override
    public String toString() {
        return "Broomstick";
    }
}
