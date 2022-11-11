package co.book.java8.chapter2_design_patterns.creational_patterns.c_builder_pattern;

import co.book.java8.chapter2_design_patterns.creational_patterns.b_inmutable_objects.Animal;

import java.util.Arrays;
import java.util.List;

/**
 * Note el parecido a la Clase inmutable Animal en
 * import co.book.chapter2_design_patterns.creational_patterns.b_inmutable_objects.Animal;
 *
 * Peeero si hay diferencias
 * 1) AnimalBuilder es mutable!
 *
 * But there are some important differences. First,
 this class is mutable, whereas the Animal class is immutable.
 Porque es mutable? R/ Note como tenemos puros métodos sets que retornan la instancia actual con el cambio
 y al final existe buil() para que devuelva una instancia inmutable VAYA AL MAIN DE ESTA CLASE


 La principal ventaja es que es muy mantenible y no hace que por un cambio en el constructor, todo el mundo
 se tenga que actualizar


 THERE IS ANY DOWNSIDES?? Obviously!!
 es altamente acoplado a la clase Animal, si cambia el constructor entonces esta clase se ve afectada
bajo acoplamiento es lo mejor pero para este caso no se puede porque sino entonces el patron no funciona
 */
public class AnimalBuilder {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    /**
     * using the immutable Animal class:
     * @return
     */
    public Animal build() {
        return new Animal(species,age,favoriteFoods);
    }



    public static void main(String ... args){
        AnimalBuilder duckBuilder = new AnimalBuilder();
        duckBuilder
                .setAge(4)
                .setFavoriteFoods(Arrays.asList("grass","fish")).setSpecies("duck");
        Animal duck = duckBuilder.build();
        System.out.println("duck es => "+duck);


        /**
         * No es necesario almacekar la instancia de builder como en el anterior AnimalBuilder duckBuilder = ...
         * sino que de una vamos y obtenemos el imutable Animal
         */
        Animal flamingo = new AnimalBuilder()
                .setFavoriteFoods(Arrays.asList("algae","insects"))
                .setSpecies("flamingo").build();
        System.out.println("flamingo es => "+flamingo);
    }
}
