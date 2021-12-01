package main.engine.players;

import main.engine.cards.RumourCard;

import java.util.ArrayList;

public interface AIStrategy {
    public Player choosePlayer(Player caller);
    public RumourCard pickCard(ArrayList<RumourCard> cards);
    public void chooseIdentity(Player caller);
    public boolean useHuntEffect(Player caller);
    public boolean useWitchEffect(Player caller, Player accuser);
    public boolean accuseSomeone(Player caller);
    public void accused(Player caller, Player accuser);

    public void choice(Player caller);
    public void duckingStoolChoice(Player caller);
}
