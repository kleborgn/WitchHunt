package main.engine.cards;

import main.engine.Game;
import main.engine.players.Player;

public class AngryMob extends RumourCard {
    @Override
    public boolean witchEffect(Player accused, Player accuser) {
        Game.setNextPlayer(accused);
        return true;
    }

    @Override
    public boolean huntEffect(Player accused) {
        // Usability check
        if(!accused.getIdentityCard().getIsRevealed() || accused.getIdentityCard().getIdentity() != Identities.Villager)
            return false;

        //TODO: implements effect
        return true;
    }
}
