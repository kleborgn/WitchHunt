package main.vue;

import main.engine.cards.Identities;
import main.engine.cards.RumourCard;
import main.engine.players.Player;

import javax.swing.*;
import java.util.ArrayList;

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

    public RoundGUI(){
        add(globalPanel);
        validate();
    }

    public void setCardList(Player currentPlayer, ArrayList<RumourCard> currentPlayerCardList, Player accuser, boolean chooseIdentity){
        System.out.println(currentPlayerCardList);
        currentPlayerCard1Button.setVisible(false);
        currentPlayerCard2Button.setVisible(false);
        currentPlayerCard3Button.setVisible(false);
        currentPlayerCard4Button.setVisible(false);
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
                switch (i){
                    case 0:
                        RumourCard currentCard1 = currentPlayerCardList.get(i);
                        currentPlayerCard1Button.setVisible(true);
                        currentPlayerCard1Button.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentCard1.toString() + ".png")));
                        if (currentPlayerCard1Button.getActionListeners().length > 0) {
                            currentPlayerCard1Button.removeActionListener(currentPlayerCard1Button.getActionListeners()[0]);
                        }
                        currentPlayerCard1Button.addActionListener(e -> {
                            if (accuser == null) {
                                currentCard1.huntEffect(currentPlayer);
                            } else {
                                currentCard1.witchEffect(currentPlayer, accuser);
                            }
                        });
                        break;
                    case 1:
                        RumourCard currentCard2 = currentPlayerCardList.get(i);
                        currentPlayerCard2Button.setVisible(true);
                        currentPlayerCard2Button.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentCard2.toString() + ".png")));
                        if (currentPlayerCard2Button.getActionListeners().length > 0) {
                            currentPlayerCard2Button.removeActionListener(currentPlayerCard2Button.getActionListeners()[0]);
                        }
                        currentPlayerCard2Button.addActionListener(e -> {
                            if (accuser == null) {
                                currentCard2.huntEffect(currentPlayer);
                            } else {
                                currentCard2.witchEffect(currentPlayer, accuser);
                            }
                        });
                        break;
                    case 2:
                        RumourCard currentCard3 = currentPlayerCardList.get(i);
                        currentPlayerCard3Button.setVisible(true);
                        currentPlayerCard3Button.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentCard3.toString() + ".png")));
                        if (currentPlayerCard3Button.getActionListeners().length > 0) {
                            currentPlayerCard3Button.removeActionListener(currentPlayerCard3Button.getActionListeners()[0]);
                        }
                        currentPlayerCard3Button.addActionListener(e -> {
                            if (accuser == null) {
                                currentCard3.huntEffect(currentPlayer);
                            } else {
                                currentCard3.witchEffect(currentPlayer, accuser);
                            }
                        });
                        break;
                    case 3:
                        RumourCard currentCard4 = currentPlayerCardList.get(i);
                        currentPlayerCard4Button.setVisible(true);
                        currentPlayerCard4Button.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentCard4.toString() + ".png")));
                        if (currentPlayerCard4Button.getActionListeners().length > 0) {
                            currentPlayerCard4Button.removeActionListener(currentPlayerCard4Button.getActionListeners()[0]);
                        }
                        currentPlayerCard4Button.addActionListener(e -> {
                            if (accuser == null) {
                                currentCard4.huntEffect(currentPlayer);
                            } else {
                                currentCard4.witchEffect(currentPlayer, accuser);
                            }
                        });
                        break;
                    default:
                }
            }
        }
        this.revalidate();
        super.update(this.getGraphics());
    }

    public void setPlayersList(ArrayList<Player> currentPlayerList){
        player1NameButton.setVisible(false);
        player1RoleLabel.setVisible(false);
        player1ScoreLabel.setVisible(false);
        player2NameButton.setVisible(false);
        player2RoleLabel.setVisible(false);
        player2ScoreLabel.setVisible(false);
        player3NameButton.setVisible(false);
        player3RoleLabel.setVisible(false);
        player3ScoreLabel.setVisible(false);
        player4NameButton.setVisible(false);
        player4RoleLabel.setVisible(false);
        player4ScoreLabel.setVisible(false);
        player5NameButton.setVisible(false);
        player5RoleLabel.setVisible(false);
        player5ScoreLabel.setVisible(false);
        player6NameButton.setVisible(false);
        player6RoleLabel.setVisible(false);
        player6ScoreLabel.setVisible(false);

        for(int i = 0; i < currentPlayerList.size(); i++){
            switch (i) {
                case 0:
                    Player currentPlayer1 = currentPlayerList.get(i);
                    player1NameButton.setVisible(true);
                    player1RoleLabel.setVisible(true);
                    player1ScoreLabel.setVisible(true);
                    player1NameButton.setText(currentPlayerList.get(i).getName());
                    player1NameButton.addActionListener(e -> chosenPlayer = currentPlayer1);
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player1RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().toString());
                    } else {
                        player1RoleLabel.setText("Role : Unknown");
                    }
                    player1ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 1:
                    Player currentPlayer2 = currentPlayerList.get(i);
                    player2NameButton.setVisible(true);
                    player2RoleLabel.setVisible(true);
                    player2ScoreLabel.setVisible(true);
                    player2NameButton.setText(currentPlayerList.get(i).getName());
                    player2NameButton.addActionListener(e -> chosenPlayer = currentPlayer2);
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player2RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().toString());
                    } else {
                        player2RoleLabel.setText("Role : Unknown");
                    }
                    player2ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 2:
                    Player currentPlayer3 = currentPlayerList.get(i);
                    player3NameButton.setVisible(true);
                    player3RoleLabel.setVisible(true);
                    player3ScoreLabel.setVisible(true);
                    player3NameButton.setText(currentPlayerList.get(i).getName());
                    player3NameButton.addActionListener(e -> chosenPlayer = currentPlayer3);
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player3RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player3RoleLabel.setText("Role : Unknown");
                    }
                    player3ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 3:
                    Player currentPlayer4 = currentPlayerList.get(i);
                    player4NameButton.setVisible(true);
                    player4RoleLabel.setVisible(true);
                    player4ScoreLabel.setVisible(true);
                    player4NameButton.setText(currentPlayerList.get(i).getName());
                    player4NameButton.addActionListener(e -> chosenPlayer = currentPlayer4);
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player4RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player4RoleLabel.setText("Role : Unknown");
                    }
                    player4ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 4:
                    Player currentPlayer5 = currentPlayerList.get(i);
                    player5NameButton.setVisible(true);
                    player5RoleLabel.setVisible(true);
                    player5ScoreLabel.setVisible(true);
                    player5NameButton.setText(currentPlayerList.get(i).getName());
                    player5NameButton.addActionListener(e -> chosenPlayer = currentPlayer5);
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player5RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player5RoleLabel.setText("Role : Unknown");
                    }
                    player5ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 5:
                    Player currentPlayer6 = currentPlayerList.get(i);
                    player6NameButton.setVisible(true);
                    player6RoleLabel.setVisible(true);
                    player6ScoreLabel.setVisible(true);
                    player6NameButton.setText(currentPlayerList.get(i).getName());
                    player6NameButton.addActionListener(e -> chosenPlayer = currentPlayer6);
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player6RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player6RoleLabel.setText("Role : Unknown");
                    }
                    player6ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
            }
        }
        this.revalidate();
        super.update(this.getGraphics());
    }

    public Player getChosenPlayer() {
        return chosenPlayer;
    }
}
