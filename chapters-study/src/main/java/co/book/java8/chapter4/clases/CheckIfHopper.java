package co.book.java8.chapter4.clases;

public class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animal a) {
        return a.canHop();
    }
}
