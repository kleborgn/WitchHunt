package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class TheInquisition extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        owner.discardCard(owner.pickCard(owner.getNonRevealedCards()));
        Game.setNextPlayer(owner);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        Player choice = owner.choosePlayer();
        Game.setNextPlayer(choice);
        owner.displayIdentity(choice);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean isWitchEffectUsable(Player owner) {
        return true;
    }

    @Override
    public boolean isHuntEffectUsable(Player owner) {
        if(owner.getIdentityCard().getIsRevealed() && owner.getIdentityCard().getIdentity() == Identities.Villager) {
            return true;
        }
        return false;
    }

    @Override
    public String witchEffectToString() {
        return "Discard a card from your hand. Take next turn.";
    }

    @Override
    public String huntEffectToString() {
        return "Choose next player. Before their turn, secretly look at their identity.";
    }

    @Override
    public String toString() {
        return "The Inquisition";
    }
}
