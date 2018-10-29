package co.book.chapter2_design_patterns.example2;

public class Lion implements Run {

    /**
     * Note como acá si pide la impementacion de las funciones que pertenecen a la
     * Interface Run y Walk
     */

    @Override
    public boolean canHuntWhileRunning() {
        return true;
    }

    @Override
    public boolean isQuadruped() {
        return true;
    }

    @Override
    public double getMaxSpeed() {
        return 100;
    }
}
