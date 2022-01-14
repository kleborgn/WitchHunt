package main.engine.cards;

import main.Main;
import main.engine.Constants;
import main.engine.Game;
import main.engine.Round;
import main.engine.players.Player;
import main.vue.GUI;

public class IdentityCard {
    Identities identity;
    private boolean isRevealed;

    public IdentityCard(Identities identity) {
        this.identity = identity;
        this.isRevealed = false;
    }

    /**
     * Get the revealed state of the card
     * @return revealed state
     */
    public boolean getIsRevealed() {
        return isRevealed;
    }

    /**
     * Reveal the card
     * @param owner owner
     */
    public void revealIdentity(Player owner) {
        this.isRevealed = true;
        if(Main.getMode() == Constants.MODE_CMD)
            owner.messageAll("Im a " + this.toString());
        else {
            if (Game.getCurrentRound().isRoundEnd(Game.getCurrentRound().getCurrentPlayers()) == true) {
                Game.getCurrentRound().dealPoints();
                Game.startGame();
            } else {
                GUI.setPlayersList(Game.getCurrentRound().getCurrentPlayers());
            }
        }
    }

    /**
     * Hide the card
     */
    public void hideIdentity() {
        this.isRevealed = false;
    }

    /**
     * Get the identity
     * @return identity
     */
    public Identities getIdentity() {
        return identity;
    }

    @Override
    public String toString() {
        return identity.toString();
    }
}
