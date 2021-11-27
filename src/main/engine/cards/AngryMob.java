package main.engine.cards;

import main.Main;
import main.engine.Constants;
import main.engine.Game;
import main.engine.players.Player;

public class AngryMob extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        Game.setNextPlayer(owner);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        Player selected = owner.choosePlayer();

        if (selected.isBroomstickRevealed()) {
            if (Main.getMode() == Constants.MODE_CMD) {
                System.out.println("This player has revealed a Broomstick card.");
                //TODO: gui mode
            }
            return false;
        }

        if(selected.getIdentityCard().getIsRevealed()) {
            if (Main.getMode() == Constants.MODE_CMD) {
                System.out.println("This player has already revealed his identity.");
                //TODO: gui mode
            }
            return false;
        }

        selected.getIdentityCard().revealIdentity();
        if (selected.getIdentityCard().getIdentity() == Identities.Witch)
            owner.addPoints(2);
        if (selected.getIdentityCard().getIdentity() == Identities.Villager)
            owner.subPoints(2);

        return true;
    }

    @Override
    public boolean isWitchEffectUsable() {
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
