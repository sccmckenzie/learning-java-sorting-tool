package sorting;

import java.util.*;


public class Main {

    public static void main(final String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Input input = null;

        // duct-tape argument parsing bc internet connection isn't good enough to download jcommander
        if (args.length > 0) {
            switch(args[1]) {
                case "long":
                    input = new LongInput(scanner);
                    break;
                case "line":
                    input = new LineInput(scanner);
                    break;
                case "word":
                    input = new WordInput(scanner);
                    break;
                default:
                    throw new Exception("Invalid dataType parameter");
            }
            input.printStats();
        } else {
            input = new LongInput(scanner);
            input.printStats();
        }


    }
}
