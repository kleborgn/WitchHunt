package main.engine.players;

import main.engine.cards.RumourCard;

import java.util.ArrayList;

public interface AIStrategy {
    /**
     * Strategy to choose a player
     * @param caller
     * @return player
     */
    public Player choosePlayer(Player caller);

    /**
     * Strategy to choose a card
     * @param cards
     * @return card
     */
    public RumourCard pickCard(ArrayList<RumourCard> cards);

    /**
     * Strategy to pick an identity
     * @param caller
     */
    public void chooseIdentity(Player caller);

    /**
     * Strategy to use the hunt effect of a card
     * @param caller
     * @return
     */
    public boolean useHuntEffect(Player caller);

    /**
     * Strategy to use the witch effect of a card
     * @param caller
     * @param accuser
     * @return
     */
    public boolean useWitchEffect(Player caller, Player accuser);

    /**
     * Strategy to accuse someone
     * @param caller
     * @return accused player
     */
    public boolean accuseSomeone(Player caller);

    /**
     * Strategy when the player has been accused
     * @param caller
     * @param accuser
     */
    public void accused(Player caller, Player accuser);

    /**
     * Strategy to choose an action to do
     * @param caller
     */
    public void choice(Player caller);

    /**
     * Strategy to choose an action (Ducking Stool card)
     * @param caller
     * @return
     */
    public int duckingStoolChoice(Player caller);
}
