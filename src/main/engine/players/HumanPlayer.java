package main.engine.players;

import main.Main;
import main.engine.Constants;
import main.engine.Game;
import main.engine.cards.Identities;
import main.engine.cards.RumourCard;
import main.hci.cmd.Console;

import java.util.ArrayList;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Player choosePlayer() {
        String name;
        if (Main.getMode() == Constants.MODE_CMD) {
            for (Player p: Game.getPlayers()) {
                if(!p.equals(this) && p.isCanPlay()) {
                    System.out.println(p.getName());
                }
            }
            do {
                System.out.println("Player name :");
                name = Console.sc.nextLine();
            } while (!Game.isPlayerExisting(name));
            return Game.getPlayerByName(name);
        }
        //TODO: gui mode

        return null;
    }

    @Override
    public RumourCard pickCard(ArrayList<RumourCard> cards) {
        RumourCard chosenCard = null;

        if (Main.getMode() == Constants.MODE_CMD) {
            String choice;

            for (RumourCard card:cards) {
                System.out.println(card.toString());
            }
            do {
                System.out.println("Enter the name of a card to pick :");
                choice = Console.sc.nextLine();
                chosenCard = Game.getCardByName(choice, cards);
            } while (chosenCard == null);
        }
        //TODO: gui mode

        return chosenCard;
    }

    @Override
    public void displayIdentity(Player who) {
        if(Main.getMode() == Constants.MODE_CMD) {
            System.out.println(who.getIdentityCard().getIdentity().toString());
        }
    }

    @Override
    public void displayMessage(String message) {
        if (Main.getMode() == Constants.MODE_CMD) {
            System.out.println(this.getName() + " : " + message);
        }
        //TODO: add gui mode
    }

    @Override
    public void chooseIdentity() {
        if(Main.getMode() == Constants.MODE_CMD) {
            int input;
            System.out.println(this.getName() + " choose your identity:");
            System.out.println("1: Witch");
            System.out.println("2: Villager");
            input = Console.sc.nextInt();
            Console.sc.nextLine();

            switch (input) {
                case 1 -> {
                    this.pickIdentity(Identities.Witch);
                }
                case 2 -> {
                    this.pickIdentity(Identities.Villager);
                }
                default -> {
                    System.out.println("Unknown command.");
                    this.chooseIdentity();
                }
            }
        }
    }

    @Override
    public void accuseSomeone() {
        Player chosenPlayer = this.choosePlayer();
        if (chosenPlayer.getIdentityCard().getIsRevealed()) {
            this.displayMessage("This player has already revealed their identity. They are " + chosenPlayer.getIdentityCard().toString());
            Console.menu(this);
            return;
        }

        if (chosenPlayer instanceof AIPlayer) {
            ((AIPlayer) chosenPlayer).aiPlayerChoice();
            return;
        }

        if (Main.getMode() == Constants.MODE_CMD) {
            Console.menuAccused(chosenPlayer, this);
        }
    }

    @Override
    public void revealCardHunt() {
        RumourCard card;

        do {
            card = this.pickCard(this.getNonRevealedCards());
        } while (!card.isHuntEffectUsable(this));

        while (!card.huntEffect(this));
    }

    @Override
    public void revealCardWitch(Player accuser) {
        RumourCard card;
        do {
            card = this.pickCard(this.getNonRevealedCards());
        } while (!card.isWitchEffectUsable(this));

        while(!card.witchEffect(this, accuser));
    }
}
