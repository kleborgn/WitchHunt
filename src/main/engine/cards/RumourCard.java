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

    public abstract boolean isWitchEffectUsable(Player owner);

    public abstract boolean isHuntEffectUsable(Player owner);

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public abstract String witchEffectToString();
    public abstract String huntEffectToString();
    public String sideEffectToString() {
        return "None.";
    }
}
