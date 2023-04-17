package sorting;

public class Context {
    private Input input;

    public void setInput(Input input) {
        this.input = input;
    }

    public void printStats() {
        this.input.printStats();
    }
}
