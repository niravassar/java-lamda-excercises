package hacker.rank;

@FunctionalInterface
public interface SwissKnife {
    default int compare(int i1, int i2) {
        return i1 - i2;
    }

    static void run() {
        System.out.println("Running !");
    }

    String welcomify(String name);
}
