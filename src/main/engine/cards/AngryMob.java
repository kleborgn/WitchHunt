package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class AngryMob extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        Game.setNextPlayer(owner);
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        Player selected = owner.choosePlayer();

        if (selected.isBroomstickRevealed()) {
            owner.displayMessage("This player has revealed a Broomstick card.");
            return false;
        }

        if(selected.getIdentityCard().getIsRevealed()) {
            owner.displayMessage("This player has already revealed his identity.");
            return false;
        }

        selected.getIdentityCard().revealIdentity(selected);
        if (selected.getIdentityCard().getIdentity() == Identities.Witch)
            owner.addPoints(2);
        if (selected.getIdentityCard().getIdentity() == Identities.Villager)
            owner.subPoints(2);

        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean isWitchEffectUsable(Player owner) {
        return true;
    }

    public boolean isHuntEffectUsable(Player owner) {
        if(owner.getIdentityCard().getIsRevealed() && owner.getIdentityCard().getIdentity() == Identities.Villager) {
            return true;
        }
        return false;
    }

    @Override
    public String witchEffectToString() {
        return "Take next turn.";
    }

    @Override
    public String huntEffectToString() {
        return "Reveal another player's identity.";
    }

    @Override
    public String toString() {
        return "Angry Mob";
    }

}
