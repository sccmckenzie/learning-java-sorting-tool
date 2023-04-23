package sorting;

import java.io.PrintStream;
import java.util.*;

abstract class Input <T extends Comparable<? super T>> {
    public ArrayList<T> elements;

    public String description;

    public String adjective = "longest";
    
    public PrintStream printStream;

    public int getLength() {
        return elements.size();
    }

    public Map<T, Integer> getCounts() {
        Map<T, Integer> counts = new HashMap<>();
        for (T element : elements) {
            counts.put(element, counts.getOrDefault(element, 0) + 1);
        }
        return counts;
    }

    public TreeMap<T, Integer> getSortedByCount() {
        Map<T, Integer> counts = this.getCounts();
        Comparator<T> countComparator = Comparator.comparing(counts::get);
        TreeMap<T, Integer> out = new TreeMap<>(countComparator.thenComparing(Comparator.naturalOrder()));
        out.putAll(counts);
        return out;
    }

    public int getPercentage(T element) {
        return (int) 100.0 * this.getCounts().get(element) / this.getLength();
    }

    public void printTotal() {
        printStream.println("Total " + this.description + "s: " + this.getLength() + ".");
    }

    public abstract void printSorted();

    public void printSortedByCount() {
        TreeMap<T, Integer> sortedByCount = this.getSortedByCount();

        for (Map.Entry<T, Integer> entry : sortedByCount.entrySet()) {
            printStream.println(entry.getKey() + ": " + entry.getValue() + " time(s), " +
                    this.getPercentage(entry.getKey()) + "%");
        }
    }

}

class LongInput extends Input <Long> {

    public LongInput(Scanner scanner, PrintStream printStream) {

        super.printStream = printStream;
        super.description = "number";
        super.adjective = "greatest";

        this.elements = new ArrayList<Long>();
        while (scanner.hasNext()) {
            this.elements.add(scanner.nextLong());
        }

        Comparator<Long> naturalOrder = Comparator.naturalOrder();
        elements.sort(naturalOrder);
    }

    public void printSorted() {
        printStream.print("Sorted data: ");
        for (int i = 0; i < elements.size(); i++) {
            printStream.print(elements.get(i));
            if (i != elements.size() - 1) {
                printStream.print(" ");
            }
        }
        printStream.println();
    }
}

class LineInput extends Input <String> {


    public LineInput(Scanner scanner, PrintStream printStream) {

        super.printStream = printStream;
        super.description = "line";

        this.elements = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            this.elements.add(scanner.nextLine());
        }

        Comparator<String> naturalOrder = Comparator.naturalOrder();
        elements.sort(naturalOrder);
    }

    public void printSorted() {
        printStream.println("Sorted data: ");
        for (int i = 0; i < elements.size(); i++) {
            printStream.print(elements.get(i));
            if (i != elements.size() - 1) {
                printStream.println();
            }
        }
        printStream.println();
    }
}

class WordInput extends Input <String> {


    public WordInput(Scanner scanner, PrintStream printStream) {

        super.printStream = printStream;
        super.description = "word";

        this.elements = new ArrayList<String>();
        while (scanner.hasNext()) {
            this.elements.add(scanner.next());
        }

        Comparator<String> naturalOrder = Comparator.naturalOrder();
        elements.sort(naturalOrder);
    }

    public void printSorted() {
        printStream.print("Sorted data: ");
        for (int i = 0; i < elements.size(); i++) {
            printStream.print(elements.get(i));
            if (i != elements.size() - 1) {
                printStream.print(" ");
            }
        }
        printStream.println();
    }

}