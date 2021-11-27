package main.engine.players;

import main.Main;
import main.engine.Constants;
import main.engine.Game;
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
            } while (chosenCard != null);
        }
        //TODO: gui mode

        return chosenCard;
    }


}
