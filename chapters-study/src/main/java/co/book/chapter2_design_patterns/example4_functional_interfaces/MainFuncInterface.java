package co.book.chapter2_design_patterns.example4_functional_interfaces;

import co.book.chapter2_design_patterns.example3.Animal;

public class MainFuncInterface {

    public static void main(String[] args) {
        FindMatchingAnimals.print(new Animal("fish", false, true), a -> a.canHop());
        //no imprime nada porque hopper es false
        FindMatchingAnimals.print(new Animal("kangaroo", true, false), a -> a.canHop());
        //imprime lo que se coloque en el toString() en esta caso el atributo speciesName kangaroo

        //llamado vía method reference
        FindMatchingAnimals.print(new Animal("kangaroo", true, false), Animal::canHop);

    }
}
