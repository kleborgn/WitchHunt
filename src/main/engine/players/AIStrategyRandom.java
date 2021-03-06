package main.engine.players;

import main.engine.Game;
import main.engine.cards.Identities;
import main.engine.cards.RumourCard;

import java.util.ArrayList;

public class AIStrategyRandom implements AIStrategy {
    public RumourCard pickCard(ArrayList<RumourCard> cards) {
        if (cards.isEmpty())
            return null;
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
        RumourCard card = pickCard(caller.getNonRevealedCards());
        if (card == null)
            return false;
        caller.messageAll("I've played a " + card.toString() + " card (hunt effect).");
        return card.huntEffect(caller);
    }

    @Override
    public boolean useWitchEffect(Player caller, Player accuser) {
        RumourCard card = pickCard(caller.getNonRevealedCards());
        if (card == null)
            return false;
        caller.messageAll("I've played a " + card.toString() + " card (witch effect).");
        return card.witchEffect(caller, accuser);
    }

    @Override
    public boolean accuseSomeone(Player caller) {
        Player chosenPlayer = choosePlayer(caller);
        if (chosenPlayer.getIdentityCard().getIsRevealed())
            return false;
        caller.messageAll("I've accused " + chosenPlayer.getName());
        chosenPlayer.accused(caller);
        return true;
    }

    @Override
    public void accused(Player caller, Player accuser) {
        int randomN = Game.rand.nextInt(2);
        int count = 0;

        if (randomN == 0) {
            while(!useWitchEffect(caller, accuser)) {
                caller.messageAll("Failed.");
                if (count > 2) {
                    accused(caller, accuser);
                    break;
                }
                count++;
            }
        } else {
            caller.revealIdentity(accuser);
        }
    }

    @Override
    public void choice(Player caller) {
        int randomN = Game.rand.nextInt(2);
        int count = 0;

        if (randomN == 0) {
            while(!useHuntEffect(caller)) {
                caller.messageAll("Failed.");
                if (count > 2) {
                    choice(caller);
                    break;
                }
                count++;
            }
        } else {
            while(!accuseSomeone(caller));
        }
    }

    @Override
    public int duckingStoolChoice(Player caller) {
        return Game.rand.nextInt(2) + 1;
    }
}
