package sorting;

import java.util.*;

abstract class Input <T extends Comparable<? super T>> {
    public ArrayList<T> elements;

    public String description;

    public String adjective = "longest";

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
        System.out.println("Total " + this.description + "s: " + this.getLength() + ".");
    }

    public abstract void printSorted();

    public void printSortedByCount() {
        TreeMap<T, Integer> sortedByCount = this.getSortedByCount();

        for (Map.Entry<T, Integer> entry : sortedByCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " +
                    this.getPercentage(entry.getKey()) + "%");
        }
    }

}

class LongInput extends Input <Long> {

    public LongInput(Scanner scanner) {

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
        System.out.print("Sorted data: ");
        for (int i = 0; i < elements.size(); i++) {
            System.out.print(elements.get(i));
            if (i != elements.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

class LineInput extends Input <String> {


    public LineInput(Scanner scanner) {

        super.description = "line";

        this.elements = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            this.elements.add(scanner.nextLine());
        }

        Comparator<String> naturalOrder = Comparator.naturalOrder();
        elements.sort(naturalOrder);
    }

    public void printSorted() {
        System.out.println("Sorted data: ");
        for (int i = 0; i < elements.size(); i++) {
            System.out.print(elements.get(i));
            if (i != elements.size() - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

class WordInput extends Input <String> {


    public WordInput(Scanner scanner) {

        super.description = "word";

        this.elements = new ArrayList<String>();
        while (scanner.hasNext()) {
            this.elements.add(scanner.next());
        }

        Comparator<String> naturalOrder = Comparator.naturalOrder();
        elements.sort(naturalOrder);
    }

    public void printSorted() {
        System.out.print("Sorted data: ");
        for (int i = 0; i < elements.size(); i++) {
            System.out.print(elements.get(i));
            if (i != elements.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}