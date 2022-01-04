package main.vue;

import main.engine.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        createGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createGame();
            }
        });
        add(globalPanel);
        validate();
    }

    public void createGame() {
        ArrayList<String> playerNames = new ArrayList<String>();
        if (player1NameTextField.getText().equals("") == false){
            playerNames.add(player1NameTextField.getText());
        }
        System.out.println(playerNames);
        if (player2NameTextField.getText().equals("") == false){
            playerNames.add(player2NameTextField.getText());
        }
        System.out.println(playerNames);
        if (player3NameTextField.getText().equals("") == false){
            playerNames.add(player3NameTextField.getText());
        }
        System.out.println(playerNames);
        if (player4NameTextField.getText().equals("") == false){
            playerNames.add(player4NameTextField.getText());
        }
        System.out.println(playerNames);
        if (player5NameTextField.getText().equals("") == false){
            playerNames.add(player5NameTextField.getText());
        }
        System.out.println(playerNames);
        if (player6NameTextField.getText().equals("") == false){
            playerNames.add(player6NameTextField.getText());
        }
        System.out.println(playerNames);
        Game.createGame(3,3, 0, playerNames);
        Game.startGame();
    }
}
