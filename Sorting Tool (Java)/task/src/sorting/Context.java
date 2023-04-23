package sorting;

public class Context {
    private Input input;

    public void setInput(Input input) {
        this.input = input;
    }

    public void printTotal() {
        this.input.printTotal();
    }

    public void printSorted() {
        this.input.printSorted();
    }

    public void printSortedByCount() {
        this.input.printSortedByCount();
    }
}
