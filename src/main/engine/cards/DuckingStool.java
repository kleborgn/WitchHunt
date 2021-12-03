package main.engine.cards;

import main.Main;
import main.engine.Constants;
import main.engine.Game;
import main.engine.players.AIPlayer;
import main.engine.players.Player;
import main.hci.cmd.Console;

public class DuckingStool extends RumourCard {
    @Override
    public boolean witchEffect(Player owner, Player accuser) {
        Player chosenPlayer = owner.choosePlayer();
        if (chosenPlayer.isWartRevealed()) {
            owner.displayMessage("This player has revealed a Wart card.");
            return false;
        }

        Game.setNextPlayer(chosenPlayer);
        Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
        this.setRevealed(true);

        return true;
    }

    @Override
    public boolean huntEffect(Player owner) {
        Player chosenPlayer = owner.choosePlayer();
        RumourCard card;

        if (chosenPlayer.isWartRevealed()) {
            owner.displayMessage("This player has revealed a Wart card.");
            return false;
        }

        int choice = 0;
        do {
            if(Main.getMode() == Constants.MODE_CMD) {
                if (chosenPlayer instanceof AIPlayer) {
                    choice = ((AIPlayer) chosenPlayer).duckingStoolChoice();
                } else {
                    chosenPlayer.displayMessage("Reveal your identity (1) or discard a card (2).");
                    choice = Console.sc.nextInt();
                    Console.sc.nextLine();
                }
            }
        } while (choice < 1 || choice > 2);

        switch (choice) {
            case 1-> {
                chosenPlayer.revealIdentity(chosenPlayer);
                if (chosenPlayer.getIdentityCard().getIdentity() == Identities.Witch) {
                    owner.addPoints(1);
                    Game.setNextPlayer(owner);
                    Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
                }
                if (chosenPlayer.getIdentityCard().getIdentity() == Identities.Villager) {
                    owner.subPoints(1);
                    Game.setNextPlayer(chosenPlayer);
                    Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
                }
            }
            case 2 -> {
                card = chosenPlayer.pickCard(chosenPlayer.getNonRevealedCards());
                chosenPlayer.discardCard(card);
                Game.setNextPlayer(chosenPlayer);
                Game.getCurrentRound().setNeededToIncrementNextPlayer(false);
            }
        }

        this.setRevealed(true);

        return true;
    }

    @Override
    public boolean isWitchEffectUsable(Player owner) {
        return true;
    }

    @Override
    public boolean isHuntEffectUsable(Player owner) {
        return true;
    }

    @Override
    public String witchEffectToString() {
        return "Choose next player.";
    }

    @Override
    public String huntEffectToString() {
        return "Choose a player. They must reveal their identity or discard a card from their hand.";
    }

    @Override
    public String toString() {
        return "Ducking Stool";
    }
}
