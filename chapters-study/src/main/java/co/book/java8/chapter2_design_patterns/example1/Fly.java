package co.book.java8.chapter2_design_patterns.example1;

public interface Fly {

    public int getWingSpan() throws Exception;
    public static final int MAX_SPEED = 100;
    public default void land() {
        System.out.println("Animal is landing");
    }

    /**
     * Para IMPLEMENTAR MÉTODOS EN UNA INTERFAce, estos deben ser static or default
     * @param distance
     * @param time
     * @return
     */
    public static double calculateSpeed(float distance, double time) {
        return distance/time;
    }
}
