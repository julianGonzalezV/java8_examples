package co.book.chapter6;

public class TurkeyCage implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("Close gate");
    }

    /**
     * Ahora si sabe como cerrarlo
     * @param args
     */
    public static void main(String[] args) {
        try (TurkeyCage t = new TurkeyCage()) {
            System.out.println("put turkeys in");
        }
    }

}
