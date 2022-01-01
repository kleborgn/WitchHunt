package main.engine.players;

import main.Main;
import main.engine.Constants;
import main.engine.Game;
import main.engine.cards.*;

import java.util.ArrayList;
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

    /**
     * Set identity
     * @param identity
     */
    public void pickIdentity(Identities identity) {
        this.identityCard = new IdentityCard(identity);
    }

    /**
     * Choose identity
     */
    public abstract void chooseIdentity();

    /**
     * Discard a card
     * @param card card to discard
     */
    public void discardCard(RumourCard card) {
        this.rumourCards.remove(card);
        Game.addDiscardedCard(card);
    }

    /**
     * Discard all cards
     */
    public void discardAllCards() {
        for (RumourCard card:rumourCards) {
            this.rumourCards.remove(card);
            Game.addDiscardedCard(card);
        }
    }

    /**
     * Add points
     * @param points points to add
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Sub points
     * @param points points to sub
     */
    public void subPoints(int points) { this.points -= points; }

    /**
     * Get the identity card
     * @return identityCard
     */
    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    /**
     * Get points
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get all caller's cards
     * @return cards
     */
    public ArrayList<RumourCard> getRumourCards() {
        return rumourCards;
    }

    /**
     * Add a card
     * @param card card
     */
    public void addCard(RumourCard card) {
        this.rumourCards.add(card);
    }

    /**
     * Check if a Broomstick card has been revealed
     * @return true if true, false if false
     */
    public boolean isBroomstickRevealed() {
        for (RumourCard card:rumourCards) {
            if (card instanceof Broomstick) {
                return card.isRevealed();
            }
        }
        return false;
    }

    /**
     * Check if a Wart card has been revealed
     * @return true if true, false if false
     */
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

    /**
     * Check if the player can play
     * @return boolean
     */
    public boolean isCanPlay() {
        return canPlay;
    }

    /**
     * Set if the player can play
     * @param canPlay boolean
     */
    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public abstract void displayIdentity(Player who);

    /**
     * Get all caller's revealed cards
     * @return cards
     */
    public ArrayList<RumourCard> getRevealedCards() {
        ArrayList<RumourCard> revealedCards = new ArrayList<RumourCard>();
        for (RumourCard card:rumourCards) {
            if (card.isRevealed())
                revealedCards.add(card);
        }
        return revealedCards;
    }

    public abstract void displayMessage(String message);

    /**
     * Display a message to all players
     * @param message string
     */
    public void messageAll(String message) {
        if (Main.getMode() == Constants.MODE_CMD)
            System.out.println(this.getName() + " said: " + message);
    }

    /**
     * Get all caller's non-revealed cards
     * @return cards
     */
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

    /**
     * Reveal player's identity
     * @param accuser The player who accused the caller
     */
    public void revealIdentity(Player accuser) {
        this.getIdentityCard().revealIdentity(this);

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

    public abstract void accused(Player accuser);
}
