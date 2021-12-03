package main.engine.players;

import main.engine.Game;
import main.engine.cards.Identities;
import main.engine.cards.RumourCard;

import java.util.ArrayList;

public class AIPlayer extends Player {

    private AIStrategy strat = new AIStrategyRandom();

    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public void displayIdentity(Player who) {
        //null
    }

    @Override
    public void displayMessage(String message) {
        //null
    }

    @Override
    public void accuseSomeone() {
        strat.accuseSomeone(this);
    }

    @Override
    public void revealCardHunt() {
        strat.useHuntEffect(this);
    }

    @Override
    public void revealCardWitch(Player accuser) {
        strat.useWitchEffect(this, accuser);
    }

    @Override
    public void accused(Player accuser) {
        strat.accused(this, accuser);
    }

    @Override
    public void chooseIdentity() {
        strat.chooseIdentity(this);
    }

    @Override
    public Player choosePlayer() {
        return strat.choosePlayer(this);
    }

    @Override
    public RumourCard pickCard(ArrayList<RumourCard> cards) {
        return strat.pickCard(cards);
    }

    public void aiPlayerChoice() {
        strat.choice(this);
    }

    public int duckingStoolChoice() {
        return strat.duckingStoolChoice(this);
    }
}
