package main.vue;

import javax.swing.*;

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

    public SetupGUI() {
        add(globalPanel);
        validate();
    }
}
