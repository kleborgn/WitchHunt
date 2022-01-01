package main.engine.cards;

import main.engine.players.Player;

public abstract class RumourCard {
    private boolean isRevealed;

    RumourCard() {
        this.isRevealed = false;
    }

    /**
     * Use the witch effect
     * @param owner The player owning the card
     * @param accuser The accusing player
     * @return Return false if the effect isn't usable, otherwise true
     */
    public abstract boolean witchEffect(Player owner, Player accuser);

    /**
     * Use the hunt effect
     * @param owner The player owning the card
     * @return Return false if the effect isn't usable, otherwise true
     */
    public abstract boolean huntEffect(Player owner);

    /**
     * Check if the effect is usable
     * @param owner The player owning the card
     * @return True if the effect is usable otherwise false
     */
    public abstract boolean isWitchEffectUsable(Player owner);

    /**
     * Check if the effect is usable
     * @param owner The player owning the card
     * @return True if the effect is usable otherwise false
     */
    public abstract boolean isHuntEffectUsable(Player owner);


    /**
     * Check if a card is revealed
     * @return True if the card is revealed
     */
    public boolean isRevealed() {
        return isRevealed;
    }

    /**
     * Set the revealed state of a card
     * @param revealed revealed state
     */
    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    /**
     * Get the effect description in a string
     * @return string
     */
    public abstract String witchEffectToString();

    /**
     * Get the effect description in a string
     * @return string
     */
    public abstract String huntEffectToString();

    /**
     * Get the effect description in a string, by default return "None."
     * @return string
     */
    public String sideEffectToString() {
        return "None.";
    }
}
