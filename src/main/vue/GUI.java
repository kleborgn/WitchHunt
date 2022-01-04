package main.vue;

public class GUI {

    public static void initGame() {

        SetupGUI setupGUI = new SetupGUI();
        setupGUI.setVisible(true);
        setupGUI.pack();
        setupGUI.setTitle("Witch Hunt");
        setupGUI.setSize(1280, 720);
    }
}
