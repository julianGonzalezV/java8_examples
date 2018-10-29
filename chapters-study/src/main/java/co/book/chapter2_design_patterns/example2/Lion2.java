package co.book.chapter2_design_patterns.example2;

/**
 * This is a wayf of multiple inheritance
 * Por ejemplo que la interface Run no tenga porque extender de Walk entonces la forma de que Lion2
 * tenga ambos rasgos es implemntar ambis traits
 */
public class Lion2 implements Run, Walk {
    @Override
    public boolean canHuntWhileRunning() {
        return false;
    }

    @Override
    public boolean isQuadruped() {
        return false;
    }

    @Override
    public double getMaxSpeed() {
        return 0;
    }
}
