package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class Cauldron extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        RumourCard randomCard = accuser.getNonRevealedCards().get(Game.rand.nextInt(accuser.getNonRevealedCards().size()));
        accuser.discardCard(randomCard);
        accuser.displayMessage("You have discarded a random card : " + randomCard.toString());
        Game.setNextPlayer(owner);
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        owner.revealIdentity(owner);

        if (owner.getIdentityCard().getIdentity() == Identities.Witch) {
            if (Game.getPlayers().indexOf(owner) == 0)
                Game.setNextPlayer(Game.getPlayers().get(Game.getPlayers().size() - 1));
            else
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
        return "The player who accused you discards a random card from their hand. Take next turn.";
    }

    @Override
    public String huntEffectToString() {
        return "Reveal your identity. Witch: Player to your left takes next turn. Villager: Choose next player.";
    }

    @Override
    public String toString() {
        return "Cauldron";
    }
}
