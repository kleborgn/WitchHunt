package main.engine.cards;

import main.Main;
import main.engine.Constants;
import main.engine.players.Player;

public class IdentityCard {
    Identities identity;
    private boolean isRevealed;

    public IdentityCard(Identities identity) {
        this.identity = identity;
        this.isRevealed = false;
    }

    public boolean getIsRevealed() {
        return isRevealed;
    }

    public void revealIdentity(Player owner) {
        this.isRevealed = true;
        if(Main.getMode() == Constants.MODE_CMD)
            owner.messageAll("Im a " + this.toString());
        //TODO: gui mode
    }

    public void hideIdentity() {
        this.isRevealed = false;
    }

    public Identities getIdentity() {
        return identity;
    }

    @Override
    public String toString() {
        return identity.toString();
    }
}
