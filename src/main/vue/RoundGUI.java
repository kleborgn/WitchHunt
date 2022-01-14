package main.vue;

import main.engine.cards.Identities;
import main.engine.cards.RumourCard;
import main.engine.players.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RoundGUI extends JFrame {
    private JPanel globalPanel;
    private Player chosenPlayer;
    private JPanel currentPlayerPanel;
    private JLabel currentPlayerNameLabel;
    private JPanel currentPlayerHand;
    private JPanel allPlayersInfosPanel;
    private JPanel player1Panel;
    private JPanel player2Panel;
    private JPanel player3Panel;
    private JPanel player4Panel;
    private JPanel player5Panel;
    private JPanel player6Panel;
    private JButton player1NameButton;
    private JButton player2NameButton;
    private JButton player3NameButton;
    private JButton player4NameButton;
    private JButton player5NameButton;
    private JButton player6NameButton;
    private JLabel player1ScoreLabel;
    private JLabel player2ScoreLabel;
    private JLabel player3ScoreLabel;
    private JLabel player4ScoreLabel;
    private JLabel player5ScoreLabel;
    private JLabel player6ScoreLabel;
    private JLabel player1RoleLabel;
    private JLabel player2RoleLabel;
    private JLabel player3RoleLabel;
    private JLabel player4RoleLabel;
    private JLabel player5RoleLabel;
    private JLabel player6RoleLabel;
    private JLabel currentPlayerActionLabel;
    private JButton currentPlayerCard1Button;
    private JButton currentPlayerCard2Button;
    private JButton currentPlayerCard3Button;
    private JButton currentPlayerCard4Button;
    private JButton currentPlayerAction1Button;
    private JButton currentPlayerAction2Button;
    private ImageIcon iconCurrentPlayerCard1;
    private ImageIcon iconCurrentPlayerCard2;
    private ImageIcon iconCurrentPlayerCard3;
    private ImageIcon iconCurrentPlayerCard4;
    private ArrayList<JButton> currentPlayerCardButtons = new ArrayList<>(Arrays.asList(currentPlayerCard1Button, currentPlayerCard2Button, currentPlayerCard3Button, currentPlayerCard4Button));
    private ArrayList<JButton> playerNameButtons = new ArrayList<>(Arrays.asList(player1NameButton, player2NameButton, player3NameButton, player4NameButton, player5NameButton, player6NameButton));
    private ArrayList<JLabel> playerScoreLabels = new ArrayList<>(Arrays.asList(player1ScoreLabel, player2ScoreLabel, player3ScoreLabel, player4ScoreLabel, player5ScoreLabel, player6ScoreLabel));
    private ArrayList<JLabel> playerRoleLabels = new ArrayList<>(Arrays.asList(player1RoleLabel, player2RoleLabel, player3RoleLabel, player4RoleLabel, player5RoleLabel, player6RoleLabel));


    public RoundGUI(){
        add(globalPanel);
        validate();
    }

    public void setCardList(Player currentPlayer, ArrayList<RumourCard> currentPlayerCardList, Player accuser, boolean chooseIdentity){
        System.out.println(currentPlayerCardList);
        for(int i = 0; i < currentPlayerCardButtons.size(); i++){
            currentPlayerCardButtons.get(i).setVisible(false);
        }
        currentPlayerAction2Button.setVisible(false);
        currentPlayerNameLabel.setText(currentPlayer.getName());
        if (chooseIdentity == true) {
            currentPlayerActionLabel.setText("Choose your identity");
            currentPlayerAction1Button.setText("Witch");
            if (currentPlayerAction1Button.getActionListeners().length > 0) {
                currentPlayerAction1Button.removeActionListener(currentPlayerAction1Button.getActionListeners()[0]);
            }
            currentPlayerAction1Button.addActionListener(e -> currentPlayer.pickIdentity(Identities.Witch));
            currentPlayerAction2Button.setVisible(true);
            currentPlayerAction2Button.setText("Villager");
            if (currentPlayerAction2Button.getActionListeners().length > 0) {
                currentPlayerAction2Button.removeActionListener(currentPlayerAction2Button.getActionListeners()[0]);
            }
            currentPlayerAction2Button.addActionListener(e -> currentPlayer.pickIdentity(Identities.Villager));
        } else if (accuser == null) {
            currentPlayerActionLabel.setText("Play an Hunt Effect or accuse a Player");
            currentPlayerAction1Button.setText("Accuse chosen Player");
            if (currentPlayerAction1Button.getActionListeners().length > 0) {
                currentPlayerAction1Button.removeActionListener(currentPlayerAction1Button.getActionListeners()[0]);
            }
            currentPlayerAction1Button.addActionListener(e -> currentPlayer.accuseSomeone());
        } else {
            currentPlayerActionLabel.setText("Play a Witch Effect or reveal your role");
            currentPlayerAction1Button.setText("Reveal your identity");
            if (currentPlayerAction1Button.getActionListeners().length > 0) {
                currentPlayerAction1Button.removeActionListener(currentPlayerAction1Button.getActionListeners()[0]);
            }
            currentPlayerAction1Button.addActionListener(e -> currentPlayer.revealIdentity(accuser));
        }
        if (currentPlayerCardList != null){
            for(int i = 0; i < currentPlayerCardList.size(); i++){
                currentPlayerCardButtons.get(i).setVisible(true);
                currentPlayerCardButtons.get(i).setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                if (currentPlayerCardButtons.get(i).getActionListeners().length > 0) {
                    currentPlayerCardButtons.get(i).removeActionListener(currentPlayerCardButtons.get(i).getActionListeners()[0]);
                }
                RumourCard currentCard = currentPlayerCardList.get(i);
                currentPlayerCardButtons.get(i).addActionListener(e -> {
                    if (accuser == null) {
                        currentCard.huntEffect(currentPlayer);
                    } else {
                        currentCard.witchEffect(currentPlayer, accuser);
                    }
                });
            }
        }
        this.revalidate();
        super.update(this.getGraphics());
    }

    public void setPlayersList(ArrayList<Player> currentPlayerList){
        for(int i = 0; i < playerNameButtons.size(); i++){
            playerNameButtons.get(i).setVisible(false);
            playerScoreLabels.get(i).setVisible(false);
            playerRoleLabels.get(i).setVisible(false);
        }

        for(int i = 0; i < currentPlayerList.size(); i++){
            playerNameButtons.get(i).setVisible(true);
            playerScoreLabels.get(i).setVisible(true);
            playerRoleLabels.get(i).setVisible(true);
            playerNameButtons.get(i).setText(currentPlayerList.get(i).getName());
            Player currentPlayer = currentPlayerList.get(i);
            playerNameButtons.get(i).addActionListener(e -> chosenPlayer = currentPlayer);
            if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                playerRoleLabels.get(i).setText("Role : " + currentPlayerList.get(i).getIdentityCard().toString());
            } else {
                playerRoleLabels.get(i).setText("Role : Unknown");
            }
            playerScoreLabels.get(i).setText("Score : " + currentPlayerList.get(i).getPoints());
        }
        this.revalidate();
        super.update(this.getGraphics());
    }

    public Player getChosenPlayer() {
        return chosenPlayer;
    }
}
