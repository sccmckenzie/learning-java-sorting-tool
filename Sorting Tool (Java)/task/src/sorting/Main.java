package sorting;

import java.util.*;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;


public class Main {

    public static void main(final String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Context context = new Context();


        for (String arg : args) {
            if (arg.contains("-") && !(arg.contains("dataType") || arg.contains("sortingType"))) {
                System.out.println("\"" + arg + "\" is not a valid parameter. It will be skipped.");
            }
        }

        AppConfig config = new AppConfig();
        JCommander jcmd = JCommander.newBuilder().addObject(config).build();

        try {
            jcmd.parse(args);
        } catch (ParameterException e) {
            if (e.getMessage().contains("dataType") || e.getMessage().contains("sortingType")) {
                return;
            }
        }

        switch(config.dataType) {
            case "long":
                context.setInput(new LongInput(scanner));
                break;
            case "line":
                context.setInput(new LineInput(scanner));
                break;
            case "word":
                context.setInput(new WordInput(scanner));
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
