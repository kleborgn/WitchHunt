package main.hci.cmd;

import main.engine.Game;

import java.util.Scanner;

public class Console {
    public static Scanner sc = new Scanner(System.in);
    public static void initGame() {
        int nbPlayers, nbHumans, nbAI = 0;
        do {
            System.out.println("Nombre de joueurs total (3-6):");
            nbPlayers = sc.nextInt();
        } while (nbPlayers >6 || nbPlayers<3);

        do {
            System.out.println("Nombre de joueurs humains :");
            nbHumans = sc.nextInt();
        } while (nbHumans > nbPlayers || nbHumans<=0);

        nbAI = nbPlayers - nbHumans;

        Game.createGame(nbPlayers, nbHumans, nbAI);
        Game.startGame();
        Debug.warning("END");
        sc.close();
    }
}
