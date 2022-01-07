package main.vue;

import main.engine.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class SetupGUI extends JFrame {
    private JPanel globalPanel;
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
    private JTextField player1NameTextField;
    private JTextField player2NameTextField;
    private JTextField player3NameTextField;
    private JTextField player4NameTextField;
    private JTextField player5NameTextField;
    private JTextField player6NameTextField;
    private JRadioButton player1AIButton;
    private JRadioButton player2AIButton;
    private JRadioButton player3AIButton;
    private JRadioButton player4AIButton;
    private JRadioButton player5AIButton;
    private JRadioButton player6AIButton;
    private JButton createGameButton;

    public SetupGUI() {
        createGameButton.addActionListener(e -> createGame());
        add(globalPanel);
        validate();
    }

    public void createGame() {
        ArrayList<String> playerNames = new ArrayList<String>();
        int humanCount = 0;
        int AICount = 0;
        if (player1NameTextField.getText().equals("") == false && player1AIButton.isSelected() == false){
            playerNames.add(player1NameTextField.getText());
            humanCount++;
        }
        if (player2NameTextField.getText().equals("") == false && player2AIButton.isSelected() == false){
            playerNames.add(player2NameTextField.getText());
            humanCount++;
        }
        if (player3NameTextField.getText().equals("") == false && player3AIButton.isSelected() == false){
            playerNames.add(player3NameTextField.getText());
            humanCount++;
        }
        if (player4NameTextField.getText().equals("") == false && player4AIButton.isSelected() == false){
            playerNames.add(player4NameTextField.getText());
            humanCount++;
        }
        if (player5NameTextField.getText().equals("") == false && player5AIButton.isSelected() == false){
            playerNames.add(player5NameTextField.getText());
            humanCount++;
        }
        if (player6NameTextField.getText().equals("") == false && player6AIButton.isSelected() == false){
            playerNames.add(player6NameTextField.getText());
            humanCount++;
        }
        if (player1AIButton.isSelected() == true){AICount++;}
        if (player2AIButton.isSelected() == true){AICount++;}
        if (player3AIButton.isSelected() == true){AICount++;}
        if (player4AIButton.isSelected() == true){AICount++;}
        if (player5AIButton.isSelected() == true){AICount++;}
        if (player6AIButton.isSelected() == true){AICount++;}
        Game.createGame(3,humanCount, AICount, playerNames);
        Game.startGame();
    }
}
