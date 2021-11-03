package co.book.chapter2_design_patterns.example4_functional_interfaces;

import co.book.chapter2_design_patterns.example3.Animal;

public class MainFuncInterface {

    public static void main(String[] args) {
        //int a = 0; si colocamos esta emtpmces los labda expression van a fallar debido a no puede estar declarada
        FindMatchingAnimals.print(new Animal("fish", false, true), a -> a.canHop());
        //no imprime nada porque hopper es false
        FindMatchingAnimals.print(new Animal("kangaroo", true, false), a -> a.canHop());
        //imprime lo que se coloque en el toString() en esta caso el atributo speciesName kangaroo

        //llamado via method reference
        FindMatchingAnimals.print(new Animal("kangaroo", true, false), Animal::canHop);

        /**
         * Implementacion de print que usa predicate
         *
         */
        FindMatchingAnimals.print2(new Animal("kangaroo", true, false), Animal::canHop);



        /**
         * Spotting(Indentifying or recognizing) Invalid Lambdas
         */

        /*
        (int y, z) -> {int x=1; return y+10; }// DOES NOT COMPILE debido que que el primer parametro espcifica el tipo
        //entonces los demas parametros también deben o quitar el tipo del primero
        (String s, z) -> { return s.length()+z; }// DOES NOT COMPILE
        (a, Animal b, c) -> a.getName()// DOES NOT COMPILE

        (a, b) -> { int a = 0; return 5;}// DOES NOT COMPILE, ya que a es una variable de entrada y a del body es la
        //declaración de una nueva y no se puede
        */

    }
}
