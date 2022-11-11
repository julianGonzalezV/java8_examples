package co.book.java8.chapter2_design_patterns.creational_patterns.a_singleton;

public class LlamaTrainer {
    public boolean feedLlamas(int numberOfLlamas) {
        int amountNeeded = 5 * numberOfLlamas;
        HayStorage hayStorage = HayStorage.getInstance();
        if (hayStorage.getHayQuantity() < amountNeeded) {
            hayStorage.addHay(amountNeeded + 10);
        }
        boolean fed = hayStorage.removeHay(amountNeeded);

        /**
         * check the
         return type of removeHay()
         */
        if (fed) System.out.println("Llamas have been fed");
        return fed;
    }
}
