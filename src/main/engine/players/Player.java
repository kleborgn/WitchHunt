package main.engine.players;

import main.engine.Game;
import main.engine.cards.Identities;
import main.engine.cards.IdentityCard;
import main.engine.cards.RumourCard;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Player {

    private String name;
    private int points;
    private IdentityCard identityCard;

    private ArrayList<RumourCard> rumourCards;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public void pickIdentity(Identities identity) {
        this.identityCard = new IdentityCard(identity);
    }

    public void discardCard(RumourCard card) {
        this.rumourCards.remove(card);
        Game.addDiscardedCard(card);
    }

    public void discardAllCards() {
        for (RumourCard card:rumourCards) {
            this.rumourCards.remove(card);
            Game.addDiscardedCard(card);
        }
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
