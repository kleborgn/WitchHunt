import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: java WitchHunt (--cmdline | --gui) [--debug]");
        } else {
            if(args.length == 2) {
                if(Objects.equals(args[1], "--debug"))
                    Debug.showDebugMessage = true;
            }
            switch (args[0]) {
                case "--cmdline" -> Console.initGame();
                case "--gui" ->
                        //TODO: call main window
                        System.out.println("Not implemented yet");
                default -> System.out.println("Unrecognized argument");
            }
        }
    }
}
