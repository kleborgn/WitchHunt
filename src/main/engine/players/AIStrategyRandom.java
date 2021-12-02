package main.engine.players;

import main.engine.Game;
import main.engine.cards.Identities;
import main.engine.cards.RumourCard;

import java.util.ArrayList;

public class AIStrategyRandom implements AIStrategy {
    public RumourCard pickCard(ArrayList<RumourCard> cards) {
        return cards.get(Game.rand.nextInt(cards.size()));
    }

    @Override
    public Player choosePlayer(Player caller) {
        Player chosenPlayer = Game.getPlayers().get(Game.rand.nextInt(Game.getPlayers().size()));
        if (chosenPlayer.equals(caller))
            chosenPlayer = choosePlayer(caller);
        return chosenPlayer;
    }

    @Override
    public void chooseIdentity(Player caller) {
        int randomN = Game.rand.nextInt(2);

        if(randomN == 0) {
            caller.pickIdentity(Identities.Villager);
        } else {
            caller.pickIdentity(Identities.Witch);
        }
    }

    @Override
    public boolean useHuntEffect(Player caller) {
        return pickCard(caller.getNonRevealedCards()).huntEffect(caller);
    }

    @Override
    public boolean useWitchEffect(Player caller, Player accuser) {
        return pickCard(caller.getNonRevealedCards()).witchEffect(caller, accuser);
    }

    @Override
    public boolean accuseSomeone(Player caller) {
        Player chosenPlayer = choosePlayer(caller);
        if (chosenPlayer.getIdentityCard().getIsRevealed())
            return false;
        accused(chosenPlayer, caller);
        return true;
    }

    @Override
    public void accused(Player caller, Player accuser) {
        int randomN = Game.rand.nextInt(2);

        if (randomN == 0) {
            while(!useWitchEffect(caller, accuser));
        } else {
            caller.revealIdentity(accuser);
        }
    }

    @Override
    public void choice(Player caller) {
        int randomN = Game.rand.nextInt(2);

        if (randomN == 0) {
            while(!useHuntEffect(caller));
        } else {
            while(!accuseSomeone(caller));
        }
    }

    @Override
    public void duckingStoolChoice(Player caller) {

    }
}
