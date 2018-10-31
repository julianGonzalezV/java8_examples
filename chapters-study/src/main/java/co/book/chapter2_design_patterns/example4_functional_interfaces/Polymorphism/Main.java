package co.book.chapter2_design_patterns.example4_functional_interfaces.Polymorphism;

public class Main {
    public static void main(String[] args) {
        /**
         * acá es puro polimorfismo
         * solo se crea un objeto y se pasa a una vriable hasTail y primate, ambas
         * se conocen como referecias o reference y a que hace referencia? pues a un objeto en memoria en este caso
         * a lemur
         */

        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());

        Primate primate = lemur;
        System.out.println(primate.hasHair());


        /**
         * Note como  cada referencia hasTail2  y primate2 no pueden acceder sino a lo que se encuentre declarado
         * en ellas, a pesar de que lemur tiene el atributo age hasTail2 no lo ve
         */

        HasTail hasTail2 = lemur;
        //System.out.println(hasTail.age); // No compila

        Primate primate2 = lemur;
        //System.out.println(primate.isTailStriped()); // no compila
        //System.out.println(primate2.age); // No compila

        /**
         * Distinguishing between an Object
         and a Reference

         En java los objetos se acceden mediante referencia, como desarollado r no tenemos acceso directo
         a la ubicación en memoria del objeto como tal
         */

        //
        Lemur lemur2 = new Lemur();
        int v1 = lemur2.age;
        //el objeto Lemur se asignada a una referencia de tipo diferente
        //acá por ejemplo paorvechamos la caracteristica de que todos los objetos
        //heredan de java.lang.Object
        Object lemurAsObject = lemur2;
        //lemurAsObject.age;

        /**
         * De lo anterior se determina que
         * 1. The type of the object determines which properties exist within the object in memory.Ejemplo
         * so podemos hacer  lemur2.age;
         *
         2. The type of the reference to the object determines which methods and variables are
         accessible to the Java program. Ejemplo del   lemurAsObject.age; no es accesible desde Object
         */

        /**
         *Casting Object References, reglas:
         *
         *  1. Casting an object from a subclass to a superclass doesn’t require an explicit cast.
            2. Casting an object from a superclass to a subclass requires an explicit cast.
            3. The compiler will not allow casts to unrelated types. IMPORTANTE!!
                - Esto es que si no hay relación mediante algún mecanismo de herencia entonces fallará
                - Además de que también puede existir error en tiempo de ejecución, use instanceof para evitar ESTO;

         public class Rodent {
         }
         public class Capybara extends Rodent {
             public static void main(String[] args) {
             Rodent rodent = new Rodent();  Rodent no tiene nada que ver con Capybara, mientras Capybara
         si tiene que ver porque Capybara extends Rodent y se puede aplica r downcasting
             Capybara capybara = (Capybara)rodent; // Throws ClassCastException at
             // runtime
             }
         }
            4. Even when the code compiles without issue, an exception may be thrown at runtime if
                the object being cast is not actually an instance of that class.
         */

        Object lemurAsObject2 = lemur2;
        //Lemur lemur3 = lemurAsObject2;//no compila
        Lemur lemur3 = (Lemur) lemurAsObject2;//no compila
        System.out.println("lemur3.age  es => "+lemur3.age);

    }
}
