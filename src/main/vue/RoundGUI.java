package main.vue;

import main.engine.cards.RumourCard;
import main.engine.players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RoundGUI extends JFrame {
    private JPanel globalPanel;
    private JPanel currentPlayerPanel;
    private JLabel currentPlayerName;
    private JPanel currentPlayerHand;
    private JPanel allPlayersInfosPanel;
    private JPanel player1Panel;
    private JPanel player2Panel;
    private JPanel player3Panel;
    private JPanel player4Panel;
    private JPanel player5Panel;
    private JPanel player6Panel;
    private JLabel player1NameLabel;
    private JLabel player2NameLabel;
    private JLabel player3NameLabel;
    private JLabel player4NameLabel;
    private JLabel player5NameLabel;
    private JLabel player6NameLabel;
    private JLabel currentPlayerRole;
    private JPanel player1CardsPanel;
    private JPanel player2CardsPanel;
    private JPanel player3CardsPanel;
    private JPanel player4CardsPanel;
    private JPanel player5CardsPanel;
    private JPanel player6CardsPanel;
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
    private JButton accusePlayer1Button;
    private JButton accusePlayer2Button;
    private JButton accusePlayer3Button;
    private JButton accusePlayer4Button;
    private JButton accusePlayer5Button;
    private ImageIcon iconCurrentPlayerCard1;
    private ImageIcon iconCurrentPlayerCard2;
    private ImageIcon iconCurrentPlayerCard3;
    private ImageIcon iconCurrentPlayerCard4;

    public RoundGUI(){
        add(globalPanel);
        validate();
    }

    public void setCardList(Player currentPlayer, ArrayList<RumourCard> currentPlayerCardList, Player accuser){
        System.out.println(currentPlayerCardList);
        currentPlayerCard1Button.setVisible(false);
        currentPlayerCard2Button.setVisible(false);
        currentPlayerCard3Button.setVisible(false);
        currentPlayerCard4Button.setVisible(false);
        for(int i = 0; i < currentPlayerCardList.size(); i++){
            switch (i){
                case 0:
                    RumourCard currentCard1 = currentPlayerCardList.get(i);
                    currentPlayerCard1Button.setVisible(true);
                    currentPlayerCard1Button.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentCard1.toString() + ".png")));
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
        this.revalidate();
        super.update(this.getGraphics());
    }

    public void setPlayersList(ArrayList<Player> currentPlayerList){
        player1NameLabel.setVisible(false);
        player1RoleLabel.setVisible(false);
        player1ScoreLabel.setVisible(false);
        player2NameLabel.setVisible(false);
        player2RoleLabel.setVisible(false);
        player2ScoreLabel.setVisible(false);
        player3NameLabel.setVisible(false);
        player3RoleLabel.setVisible(false);
        player3ScoreLabel.setVisible(false);
        player4NameLabel.setVisible(false);
        player4RoleLabel.setVisible(false);
        player4ScoreLabel.setVisible(false);
        player5NameLabel.setVisible(false);
        player5RoleLabel.setVisible(false);
        player5ScoreLabel.setVisible(false);
        player6NameLabel.setVisible(false);
        player6RoleLabel.setVisible(false);
        player6ScoreLabel.setVisible(false);

        for(int i = 0; i < currentPlayerList.size(); i++){
            switch (i) {
                case 0:
                    player1NameLabel.setVisible(true);
                    player1RoleLabel.setVisible(true);
                    player1ScoreLabel.setVisible(true);
                    player1NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player1RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().toString());
                    } else {
                        player1RoleLabel.setText("Role : Unknown");
                    }
                    player1ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 1:
                    player2NameLabel.setVisible(true);
                    player2RoleLabel.setVisible(true);
                    player2ScoreLabel.setVisible(true);
                    player2NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player2RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().toString());
                    } else {
                        player2RoleLabel.setText("Role : Unknown");
                    }
                    player2ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 2:
                    player3NameLabel.setVisible(true);
                    player3RoleLabel.setVisible(true);
                    player3ScoreLabel.setVisible(true);
                    player3NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player3RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player3RoleLabel.setText("Role : Unknown");
                    }
                    player3ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 3:
                    player4NameLabel.setVisible(true);
                    player4RoleLabel.setVisible(true);
                    player4ScoreLabel.setVisible(true);
                    player4NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player4RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player4RoleLabel.setText("Role : Unknown");
                    }
                    player4ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 4:
                    player5NameLabel.setVisible(true);
                    player5RoleLabel.setVisible(true);
                    player5ScoreLabel.setVisible(true);
                    player5NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player5RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player5RoleLabel.setText("Role : Unknown");
                    }
                    player5ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 5:
                    player6NameLabel.setVisible(true);
                    player6RoleLabel.setVisible(true);
                    player6ScoreLabel.setVisible(true);
                    player6NameLabel.setText(currentPlayerList.get(i).getName());
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
}
