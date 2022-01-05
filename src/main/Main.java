package main;

import main.engine.Constants;
import main.hci.cmd.Console;
import main.hci.cmd.Debug;
import main.vue.GUI;

import java.util.Objects;

public class Main {
    private static boolean isCmdMode = false;
    private static boolean isGUIMode = false;

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: java -jar WitchHunt.jar (--cmdline | --gui) [--debug]");
        } else {
            if(args.length == 2) {
                if(Objects.equals(args[1], "--debug"))
                    Debug.showDebugMessage = true;
            }
            switch (args[0]) {
                case "--cmdline" -> {
                    isCmdMode = true;
                    //hookShutdown();
                    Console.initGame();
                }
                case "--gui" -> {
                    isGUIMode = true;
                    GUI.initMainPanel();
                    GUI.initGame();
                }
                default -> System.out.println("Unrecognized argument");
            }
        }
    }

    public static int getMode() {
        if (isCmdMode) { return Constants.MODE_CMD; }
        if (isGUIMode) { return Constants.MODE_GUI; }
        return Constants.MODE_NULL;
    }

    // Hook VM shutdown to handle Ctrl+C
    private static void hookShutdown() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    System.out.println("Exited.");
                    Console.sc.close();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });
    }
}
