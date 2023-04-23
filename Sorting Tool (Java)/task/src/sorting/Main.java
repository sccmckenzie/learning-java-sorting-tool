package sorting;

import java.util.*;
import com.beust.jcommander.JCommander;


public class Main {

    public static void main(final String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Context context = new Context();


        AppConfig config = new AppConfig();
        JCommander jcmd = JCommander.newBuilder().addObject(config).build();
        jcmd.parse(args);

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
