package co.book.chapter2_design_patterns.example4_functional_interfaces.Polymorphism;

public class Lemur extends Primate implements HasTail{

    public int age = 10;

    @Override
    public boolean isTailStriped() {
        return false;
    }

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


    }
}
