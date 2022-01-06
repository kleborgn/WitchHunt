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
    private JLabel currentPlayerCard1Label;
    private JLabel currentPlayerCard2Label;
    private JLabel currentPlayerCard3Label;
    private JLabel currentPlayerCard4Label;
    private JLabel currentPlayerActionLabel;
    private JButton currentPlayerCard1Button;
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
        currentPlayerCard1Label.setVisible(false);
        currentPlayerCard2Label.setVisible(false);
        currentPlayerCard3Label.setVisible(false);
        currentPlayerCard4Label.setVisible(false);
        currentPlayerCard1Button.setVisible(false);
        for(int i = 0; i < currentPlayerCardList.size(); i++){
            switch (i){
                case 0:
                    RumourCard currentCard = currentPlayerCardList.get(i);
                    currentPlayerCard1Button.setVisible(true);
                    currentPlayerCard1Button.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentCard.toString() + ".png")));
                    currentPlayerCard1Button.addActionListener(e -> {
                        System.out.println("Ca clique ou quoi");
//                        if (accuser == null) {
//                            currentCard.huntEffect(currentPlayer);
//                        } else {
//                            currentCard.witchEffect(currentPlayer, accuser);
//                        }
                    });
                    this.revalidate();
                    break;
                case 1:
                    currentPlayerCard2Label.setVisible(true);
                    currentPlayerCard2Label.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                    break;
                case 2:
                    currentPlayerCard3Label.setVisible(true);
                    currentPlayerCard3Label.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                    break;
                case 3:
                    currentPlayerCard4Label.setVisible(true);
                    currentPlayerCard4Label.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                    break;
                default:
            }
        }
        this.revalidate();
        super.update(this.getGraphics());
    }

    public void setPlayersList(ArrayList<Player> currentPlayerList){
        player1NameLabel.setText(null);
        player1RoleLabel.setText(null);
        player1ScoreLabel.setText(null);
        player2NameLabel.setText(null);
        player2RoleLabel.setText(null);
        player2ScoreLabel.setText(null);
        player3NameLabel.setText(null);
        player3RoleLabel.setText(null);
        player3ScoreLabel.setText(null);
        player4NameLabel.setText(null);
        player4RoleLabel.setText(null);
        player4ScoreLabel.setText(null);
        player5NameLabel.setText(null);
        player5RoleLabel.setText(null);
        player5ScoreLabel.setText(null);
        player6NameLabel.setText(null);
        player6RoleLabel.setText(null);
        player6ScoreLabel.setText(null);

        for(int i = 0; i < currentPlayerList.size(); i++){
            switch (i) {
                case 0:
                    player1NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player1RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().toString());
                    } else {
                        player1RoleLabel.setText("Role : Unknown");
                    }
                    player1ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 1:
                    player2NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player2RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().toString());
                    } else {
                        player2RoleLabel.setText("Role : Unknown");
                    }
                    player2ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 2:
                    player3NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player3RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player3RoleLabel.setText("Role : Unknown");
                    }
                    player3ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 3:
                    player4NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player4RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player4RoleLabel.setText("Role : Unknown");
                    }
                    player4ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 4:
                    player5NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true) {
                        player5RoleLabel.setText("Role : " + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player5RoleLabel.setText("Role : Unknown");
                    }
                    player5ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                    break;
                case 5:
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
