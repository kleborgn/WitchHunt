package main.engine.cards;

import main.engine.players.Player;

public abstract class RumourCard {
    private String name;

    /**
     * Use the witch effect
     * @param accused The accused player
     * @param accuser The accusing player
     * @return Return false if the effect isn't usable, otherwise true
     */
    public abstract boolean witchEffect(Player accused, Player accuser);

    /**
     * Use the hunt effect
     * @param accused The accused player
     * @return Return false if the effect isn't usable, otherwise true
     */
    public abstract boolean huntEffect(Player accused);

    public String getName() {
        return name;
    }
}
