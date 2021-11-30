package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class Toad extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        Game.setNextPlayer(owner);
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        owner.getIdentityCard().revealIdentity();

        if (owner.getIdentityCard().getIdentity() == Identities.Witch) {
            Game.setNextPlayer(Game.getPlayers().get(Game.getPlayers().indexOf(owner) - 1));
            Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        } else {
            Game.setNextPlayer(owner.choosePlayer());
            Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        }
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
        return "Reveal your identity. Witch: Player to your left takes next turn.";
    }

    @Override
    public String toString() {
        return "Toad";
    }
}
