package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class EvilEye extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        Game.setNextPlayer(owner.choosePlayer());
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        Game.setNextPlayer(owner.choosePlayer());
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
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
        return "Choose next player. On their turn they must accuse a player other than you, if possible.";
    }

    @Override
    public String huntEffectToString() {
        return "Choose next player. On their turn they must accuse a player other than you, if possible.";
    }

    @Override
    public String toString() {
        return "Evil Eye";
    }
}
