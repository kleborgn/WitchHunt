package main.engine.players;

import main.engine.cards.RumourCard;

import java.util.ArrayList;

public class AIStrategyAggresive implements AIStrategy {

    @Override
    public Player choosePlayer(Player caller) {
        return null;
    }

    @Override
    public RumourCard pickCard(ArrayList<RumourCard> cards) {
        return null;
    }

    @Override
    public void chooseIdentity(Player caller) {

    }

    @Override
    public boolean useHuntEffect(Player caller) {
        return false;
    }

    @Override
    public boolean useWitchEffect(Player caller, Player accuser) {
        return false;
    }

    @Override
    public boolean accuseSomeone(Player caller) {
        return false;
    }

    @Override
    public void accused(Player caller, Player accuser) {

    }

    @Override
    public void choice(Player caller) {

    }

    @Override
    public int duckingStoolChoice(Player caller) {

    }
}
