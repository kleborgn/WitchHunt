package main.vue;

import javax.swing.*;

public class PopupGUI extends JFrame {
    private JPanel globalPanel;
    private JLabel popupMessageLabel;

    public PopupGUI() {
        add(globalPanel);
        this.validate();
    }

    public void setPopupMessageLabel(String message) {
        popupMessageLabel.setText(message);
    }
}
