package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class HookedNose extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        RumourCard choice = owner.pickCard(accuser.getRumourCards());
        owner.getRumourCards().add(choice);
        accuser.getRumourCards().remove(choice);
        Game.setNextPlayer(owner);
        this.setRevealed(true);
        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        Player chosenPlayer = owner.choosePlayer();
        Game.setNextPlayer(chosenPlayer);
        RumourCard chosenCard = owner.pickCard(chosenPlayer.getRumourCards());
        owner.getRumourCards().add(chosenCard);
        chosenPlayer.getRumourCards().remove(chosenCard);
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
        return "Take one card from the hand of the player who accused you. Take next turn.";
    }

    @Override
    public String huntEffectToString() {
        return "Choose next player. Before their turn, take a random card from their hand and add it to your hand.";
    }
}
