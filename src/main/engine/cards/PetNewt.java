package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

import java.util.ArrayList;

public class PetNewt extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        Game.setNextPlayer(owner);
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        ArrayList<RumourCard> cards = Game.getCurrentRound().getAllRevealedRumourCards();
        if (cards.isEmpty())
            return false;
        RumourCard card = owner.pickCard(cards);
        card.setRevealed(false);
        for (Player p:Game.getPlayers()) {
            if (p.getRevealedCards().contains(card)) {
                p.getRumourCards().remove(card);
                break;
            }
        }
        owner.getRumourCards().add(card);
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
        return "Take a revealed rumour card from any other player to your hand. Choose next player.";
    }

    @Override
    public String toString() {
        return "Pet Newt";
    }
}
