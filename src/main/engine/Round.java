package main.engine;

import main.engine.players.Player;

import java.util.ArrayList;

public class Round {
    public void startRound(ArrayList<Player> players) {

    }

    public boolean isRoundEnd(ArrayList<Player> players) {
        int nbUnrevealedPlayers = 0;
        for (Player player:players) {
            if (!player.getIdentityCard().getIsRevealed()) {
                nbUnrevealedPlayers++;
            }
            if (nbUnrevealedPlayers > 1)
                return false;
        }
        return true;
    }
}
