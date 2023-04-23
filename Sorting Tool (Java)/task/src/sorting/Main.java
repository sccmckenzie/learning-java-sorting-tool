package sorting;

import java.io.File;
import java.io.PrintStream;
import java.util.*;
import com.beust.jcommander.JCommander;

public class Main {

    public static void main(final String[] args) throws Exception {

        AppConfig config = new AppConfig();
        JCommander jcmd = JCommander.newBuilder().addObject(config).build();

        // has user specified inputFile?
        // if not, use stdin
        Scanner scanner;
        if (config.inputFile == null) {
            scanner = new Scanner(System.in);
        } else {
            File inputFile = new File(config.inputFile);
            scanner = new Scanner(inputFile);
        }

        // has user specified outpufFile?
        // if now, use stdout
        PrintStream printStream;
        if (config.outputFile == null) {
            printStream = System.out;
        } else {
            File outputFile = new File(config.outputFile);
            printStream = new PrintStream(outputFile);
        }

        Context context = new Context();

        switch(config.dataType) {
            case "long":
                context.setInput(new LongInput(scanner, printStream));
                break;
            case "line":
                context.setInput(new LineInput(scanner, printStream));
                break;
            case "word":
                context.setInput(new WordInput(scanner, printStream));
                break;
            default:
                throw new Exception("Invalid dataType parameter");
        }

        context.printTotal();

        if (config.sortingType.equals("natural")) {
            context.printSorted();
        } else if (config.sortingType.equals("byCount")) {
            context.printSortedByCount();
        } else {
            throw new Exception("Invalid sortingType parameter");
        }
    }
}
