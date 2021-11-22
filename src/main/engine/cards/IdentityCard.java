package main.engine.cards;

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

    public Identities getIdentity() {
        return identity;
    }
}
