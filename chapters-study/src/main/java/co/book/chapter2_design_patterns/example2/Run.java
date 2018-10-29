package co.book.chapter2_design_patterns.example2;

public interface Run extends Walk {
    /**
     * Note como no pide la implementación de boolean isQuadruped() de la interface Walk
     * Y por no ser una concrete class
     * @return
     */

    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}
