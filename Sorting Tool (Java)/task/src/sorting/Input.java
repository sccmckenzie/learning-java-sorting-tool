package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

abstract class Input <T> {
    public ArrayList<T> elements;

    public String description;

    public String adjective = "longest";

    public long getLength() {
        return elements.size();
    }

    public String getGreatestString(List<String> elements) {
        String greatestElement = new String();
        for (String element : elements) {
            if (element.length() > greatestElement.length()) {
                greatestElement = element;
            } else if (element.length() == greatestElement.length()) {
                List<String> compare = new ArrayList<>();
                compare.add(element);
                compare.add(greatestElement);
                Collections.sort(compare);
                greatestElement = compare.get(0);
            }
        }

        return greatestElement;
    }

    public abstract T getGreatest();

    public long getGreatestCount() {
        int out = 0;
        T greatest = this.getGreatest();
        for (T element : this.elements) {
            if (element.equals(greatest)) {
                out++;
            }
        }
        return out;
    }

    public long getGreatestPercentage() {
        return (long) 100.0 * this.getGreatestCount() / this.getLength();
    }

    public void printStats(boolean useNewLine) {
        String resultSep = " ";

        if (useNewLine) {
            resultSep = "\n";
        }

        System.out.println("Total " + this.description + "s: " + this.getLength() + ".");
        System.out.println("The " + this.adjective + " " + this.description + ":" +
                resultSep +
                this.getGreatest() +
                resultSep +
                "(" + this.getGreatestCount() + " time(s), " +
                this.getGreatestPercentage() + "%).");
    }

    public abstract void printStats();

}

class LongInput extends Input <Long> {

    public LongInput(Scanner scanner) {

        super.description = "number";
        super.adjective = "greatest";

        this.elements = new ArrayList<Long>();
        while (scanner.hasNext()) {
            this.elements.add(scanner.nextLong());
        }
    }

    public Long getGreatest() {

        Long greatestElement = Long.MIN_VALUE;
        for (Long element : elements) {
            if (element > greatestElement) {
                greatestElement = element;
            }
        }

        return greatestElement;
    }


    public void printStats() {
        super.printStats(false);
    }

}

class LineInput extends Input <String> {


    public LineInput(Scanner scanner) {

        super.description = "line";

        this.elements = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            this.elements.add(scanner.nextLine());
        }
    }

    public String getGreatest() {
        return getGreatestString(this.elements);
    }

    public void printStats() {
        super.printStats(true);
    }
}

class WordInput extends Input <String> {


    public WordInput(Scanner scanner) {

        super.description = "word";

        this.elements = new ArrayList<String>();
        while (scanner.hasNext()) {
            this.elements.add(scanner.next());
        }
    }

    public String getGreatest() {
        return getGreatestString(this.elements);
    }


    public void printStats() {
        super.printStats(false);
    }
}