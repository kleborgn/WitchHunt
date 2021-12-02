package main.engine.players;

import main.Main;
import main.engine.Constants;
import main.engine.Game;
import main.engine.cards.*;
import main.hci.cmd.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Player {

    private String name;
    private int points;
    private IdentityCard identityCard;
    private boolean canPlay = true;

    private ArrayList<RumourCard> rumourCards;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.rumourCards = new ArrayList<RumourCard>();
    }

    public void pickIdentity(Identities identity) {
        this.identityCard = new IdentityCard(identity);
    }

    public abstract void chooseIdentity();

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

    public void subPoints(int points) { this.points -= points; }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public ArrayList<RumourCard> getRumourCards() {
        return rumourCards;
    }

    public void addCard(RumourCard card) {
        this.rumourCards.add(card);
    }

    public boolean isBroomstickRevealed() {
        for (RumourCard card:rumourCards) {
            if (card instanceof Broomstick) {
                return card.isRevealed();
            }
        }
        return false;
    }

    public boolean isWartRevealed() {
        for (RumourCard card:this.getRevealedCards()) {
            if (card instanceof Wart) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public abstract Player choosePlayer();
    public abstract RumourCard pickCard(ArrayList<RumourCard> cards);

    public boolean isCanPlay() {
        return canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public abstract void displayIdentity(Player who);

    public ArrayList<RumourCard> getRevealedCards() {
        ArrayList<RumourCard> revealedCards = new ArrayList<RumourCard>();
        for (RumourCard card:rumourCards) {
            if (card.isRevealed())
                revealedCards.add(card);
        }
        return revealedCards;
    }

    public abstract void displayMessage(String message);

    public ArrayList<RumourCard> getNonRevealedCards() {
        ArrayList<RumourCard> nonRevealedCards = new ArrayList<RumourCard>();
        for (RumourCard card:rumourCards) {
            if (!card.isRevealed())
                nonRevealedCards.add(card);
        }
        return nonRevealedCards;
    }

    public abstract void accuseSomeone();

    public abstract void revealCardHunt();

    public abstract void revealCardWitch(Player accuser);

    public void revealIdentity(Player accuser) {
        this.getIdentityCard().revealIdentity();

        if (this.getIdentityCard().getIdentity() == Identities.Villager) {
            Game.getCurrentRound().setNextPlayer(this);
            Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        } else {
            accuser.addPoints(1);
            Game.getCurrentRound().setNextPlayer(accuser);
            Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
            Game.getCurrentRound().getCurrentPlayers().remove(this);
        }
    }
}
