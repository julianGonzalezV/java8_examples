package co.book.chapter1.virtual_method_invocation;

public class Main {

    /**
     * Version 1 sin virtual method invocation
     * @param animal
     */
    /*
    public void feedAnimal(Animal animal) {
        if(animal instanceof Cow) {
            ((Cow)animal).addHay();
        } else if(animal instanceof Bird) {
            ((Bird)animal).addSeed();//note que El Pájaro se alimenta con semilla y no hay/heno
        } else if(animal instanceof Lion) {
            ((Lion)animal).addMeat();//note que El leon se alimenta con meat y no hay
        } else {
            throw new RuntimeException("Unsupported animal");//This is a good thing.
        }
    }*/

    public static void feedAnimal(Animal animal){
        animal.feed();
    }


    public static void main(String ... args){
        Animal lio = new Lion();
        /**
         * feed() es un clar ejemplo de virtual method invocation. porque
         * lo que hace java en tiempo de ejecución (RUNTIME) es verificar el tipo
         * de animal que en este caso en un Leon y llama ése método
         */
        lio.feed();

        /**
         * Ojo que cuando son variables el caso es diferente
         * Recuerda la famosa frase " el tal virtual variables invocation NO existe".
         */
        lio.printName(); //print ??? y no Leonidas :O  :O   :O   :O
    }
}
