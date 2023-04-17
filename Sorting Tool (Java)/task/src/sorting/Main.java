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

        String argName = args[0];
        if (config.sortIntegers) {
            context.setInput(new LongInput(scanner));
            context.printTotal();
            context.printSorted();
        } else {
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
            context.printStats();
        }


    }
}
