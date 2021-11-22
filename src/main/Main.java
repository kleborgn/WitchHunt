package main;

import main.engine.Constants;
import main.hci.cmd.Console;
import main.hci.cmd.Debug;

import java.util.Objects;

public class Main {
    private static boolean isCmdMode = false;
    private static boolean isGUIMode = false;

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: java WitchHunt (--cmdline | --gui) [--debug]");
        } else {
            if(args.length == 2) {
                if(Objects.equals(args[1], "--debug"))
                    Debug.showDebugMessage = true;
            }
            switch (args[0]) {
                case "--cmdline" -> {
                    isCmdMode = true;
                    Console.initGame();
                }
                case "--gui" -> {
                    isGUIMode = true;
                    //TODO: call main window
                    System.out.println("Not implemented yet");
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
}
