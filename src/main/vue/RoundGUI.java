package main.vue;

import main.engine.cards.RumourCard;
import main.engine.players.Player;

import javax.swing.*;
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

//
//        iconCurrentPlayerCard1 = new ImageIcon(getClass().getResource("assets/Angry Mob.png"));
//
//        currentPlayerCard1Label.setIcon(iconCurrentPlayerCard1);
//
//        currentPlayerHand.add(currentPlayerCard1, new GridConstraints());
//
//        iconCurrentPlayerCard2 = new ImageIcon(getClass().getResource("assets/Black Cat.png"));
//
//        currentPlayerCard2.setIcon(iconCurrentPlayerCard2);
//        currentPlayerHand.add(currentPlayerCard2, new GridConstraints());
//
//        iconCurrentPlayerCard3 = new ImageIcon(getClass().getResource("assets/Broomstick.png"));
//
//        currentPlayerCard3.setIcon(iconCurrentPlayerCard3);
//        currentPlayerHand.add(currentPlayerCard3, new GridConstraints());
//
//        iconCurrentPlayerCard4 = new ImageIcon(getClass().getResource("assets/Cauldron.png"));
//
//        currentPlayerCard4.setIcon(iconCurrentPlayerCard4);
//        currentPlayerHand.add(currentPlayerCard4, new GridConstraints());

//        ArrayList<JLabel> cardsToAdd = new ArrayList<JLabel>();
//        cardsToAdd.add(currentPlayerCard1);
//        cardsToAdd.add(currentPlayerCard2);
//        cardsToAdd.add(currentPlayerCard3);
//        cardsToAdd.add(currentPlayerCard4);
//        currentPlayerPanel.add(currentPlayerHand, new GridConstraints());
//        globalPanel.add(currentPlayerHand, new GridConstraints());
        add(globalPanel);
        validate();
    }

    public void setCardList(ArrayList<RumourCard> currentPlayerCardList){
        for(int i = 0; i < currentPlayerCardList.size(); i++){
            switch (i){
                case 0:
                    currentPlayerCard1Label.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                case 1:
                    currentPlayerCard2Label.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                case 2:
                    currentPlayerCard3Label.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                case 3:
                    currentPlayerCard4Label.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                default:
                    System.out.println(i);
                    System.out.println("Euh y'a trop de cartes là");
                    System.out.println(currentPlayerCardList.get(i).toString());
            }
        }
    }

    public void setPlayersList(ArrayList<Player> currentPlayerList){
        System.out.println(currentPlayerList.size());
        for(int i = 0; i < currentPlayerList.size(); i++){
            switch (i){
                case 0:
                    System.out.println("On arrive là ?");
                    player1NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true){
                        player1RoleLabel.setText("Role :" + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player1RoleLabel.setText("Role : Unknown");
                    }
                    player1ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                case 1:
                    System.out.println("On arrive là ?");
                    player2NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true){
                        player2RoleLabel.setText("Role :" + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player2RoleLabel.setText("Role : Unknown");
                    }
                    player2ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());//currentPlayerCard2Label.setIcon(new ImageIcon(getClass().getResource("/main/assets/" + currentPlayerCardList.get(i).toString() + ".png")));
                case 2:
                    System.out.println("On arrive là ?");
                    player3NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true){
                        player3RoleLabel.setText("Role :" + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player3RoleLabel.setText("Role : Unknown");
                    }
                    player3ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                case 3:
                    System.out.println("On arrive là ?");
                    player4NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true){
                        player4RoleLabel.setText("Role :" + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player4RoleLabel.setText("Role : Unknown");
                    }
                    player4ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                case 4:
                    System.out.println("On arrive là ?");
                    player5NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true){
                        player5RoleLabel.setText("Role :" + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player5RoleLabel.setText("Role : Unknown");
                    }
                    player5ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
                case 5:
                    System.out.println("On arrive là ?");
                    player6NameLabel.setText(currentPlayerList.get(i).getName());
                    if (currentPlayerList.get(i).getIdentityCard().getIsRevealed() == true){
                        player6RoleLabel.setText("Role :" + currentPlayerList.get(i).getIdentityCard().getIdentity().toString());
                    } else {
                        player6RoleLabel.setText("Role : Unknown");
                    }
                    player6ScoreLabel.setText("Score : " + currentPlayerList.get(i).getPoints());
            }
        }
    }
}
