package co.book.chapter2_design_patterns.example4_functional_interfaces.Polymorphism;

public class Oceanographer {

    /**
     * Recibe cualquier objeto cuya clase implemente LivesInOcean
     * @param animal
     */
    public void checkSound(LivesInOcean animal) {
        animal.makeSound();
    }


    public static void main(String[] args) {
        /**
         * Note el uso de polimorfismo a nivel de clase
         */
        Oceanographer o = new Oceanographer();
        o.checkSound(new Dolphin());
        o.checkSound(new Whale());
    }
}
