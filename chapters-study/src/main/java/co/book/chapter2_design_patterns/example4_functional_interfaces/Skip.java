package co.book.chapter2_design_patterns.example4_functional_interfaces;

import co.book.chapter2_design_patterns.example3.Animal;

@FunctionalInterface
public interface Skip extends Sprint {

    /**
     * El método se esta implementado(tiene body) en la interface por eso sigue siendo
     * una interface funcional (SAM)
     * @param kangaroo
     * @return
     */
    public default int getHopCount(Animal kangaroo) {return 10;}

    /**
     * Los métodos estaticos en interfaces siempre deben tener un body/implemantación por eso sigue siendo
     * una interface funcional (SAM)
     * en este caso el body es vacio "{}"
     * @param speed
     */
    public static void skip(int speed) {}
    //public void sprint2(Animal animal);
}
