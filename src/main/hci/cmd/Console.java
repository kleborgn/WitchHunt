package main.hci.cmd;

import main.engine.Game;
import main.engine.cards.RumourCard;
import main.engine.players.Player;

import java.util.Scanner;

public class Console {
    public static Scanner sc = new Scanner(System.in);

    public static void initGame() {
        int nbPlayers, nbHumans, nbAI = 0;
        do {
            System.out.println("Total number of players (3-6):");
            nbPlayers = sc.nextInt();
            sc.nextLine();
        } while (nbPlayers >6 || nbPlayers<3);

        do {
            System.out.println("Number of human players :");
            nbHumans = sc.nextInt();
            sc.nextLine();
        } while (nbHumans > nbPlayers || nbHumans<=0);

        nbAI = nbPlayers - nbHumans;

        Game.createGame(nbPlayers, nbHumans, nbAI);
        Game.startGame();
        Debug.warning("END");
        sc.close();
    }

    // https://stackoverflow.com/a/32295974
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu(Player caller) {
        String input;
        caller.displayMessage("It's your turn");
        System.out.println("MENU:");
        System.out.println("1: Look at my hand");
        System.out.println("2: Look at my revealed cards");
        System.out.println("3: Look at my identity");
        System.out.println("4: Accuse someone");
        System.out.println("5: Reveal a rumour card (Hunt effect)");
        System.out.println("Type a card name to get more info");

        input = sc.nextLine();

        switch (input) {
            case "1" -> {
                for (RumourCard card: caller.getNonRevealedCards()) {
                    System.out.println(card.toString());
                }
                System.out.println("Press enter to continue...");
                sc.nextLine();
                menu(caller);
            }

            case "2" -> {
                for (RumourCard card : caller.getRevealedCards()) {
                    System.out.println(card.toString());
                }
                System.out.println("Press enter to continue...");
                sc.nextLine();
                menu(caller);
            }

            case "3" -> {
                System.out.println(caller.getIdentityCard().toString());
                System.out.println("Press enter to continue...");
                sc.nextLine();
                menu(caller);
            }

            case "4" -> {
                caller.accuseSomeone();
            }

            case "5" -> {
                caller.revealCardHunt();
            }

            default -> {
                for (RumourCard card : Game.getAllCards()) {
                    if (card.toString().equals(input)) {
                        System.out.println("Witch effect: " + card.witchEffectToString());
                        System.out.println("Hunt effect: " + card.huntEffectToString());
                        System.out.println("Side effect: " + card.sideEffectToString());
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        menu(caller);
                        break;
                    }
                }
                System.out.println("Unknown command.");
                System.out.println("Press enter to continue...");
                sc.nextLine();
                menu(caller);
            }
        }
    }

    public static void menuAccused(Player caller, Player accuser) {
        String input;
        caller.displayMessage("It's your turn. " + accuser.getName() + " accused you.");
        System.out.println("MENU:");
        System.out.println("1: Look at my hand");
        System.out.println("2: Look at my revealed cards");
        System.out.println("3: Look at my identity");
        System.out.println("4: Reveal my identity");
        System.out.println("5: Reveal a rumour card (Witch effect)");
        System.out.println("Type a card name to get more info");

        input = sc.nextLine();

        switch (input) {
            case "1" -> {
                for (RumourCard card: caller.getNonRevealedCards()) {
                    System.out.println(card.toString());
                }
                System.out.println("Press enter to continue...");
                sc.nextLine();
                menu(caller);
            }

            case "2" -> {
                for (RumourCard card : caller.getRevealedCards()) {
                    System.out.println(card.toString());
                }
                System.out.println("Press enter to continue...");
                sc.nextLine();
                menu(caller);
            }

            case "3" -> {
                System.out.println(caller.getIdentityCard().toString());
                System.out.println("Press enter to continue...");
                sc.nextLine();
                menu(caller);
            }

            case "4" -> {
                caller.revealIdentity(accuser);
            }

            case "5" -> {
                caller.revealCardWitch(accuser);
            }

            default -> {
                for (RumourCard card : Game.getAllCards()) {
                    if (card.toString().equals(input)) {
                        System.out.println("Witch effect: " + card.witchEffectToString());
                        System.out.println("Hunt effect: " + card.huntEffectToString());
                        System.out.println("Side effect: " + card.sideEffectToString());
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        menu(caller);
                        break;
                    }
                }
                System.out.println("Unknown command.");
                System.out.println("Press enter to continue...");
                sc.nextLine();
                menu(caller);
            }
        }
    }
}
