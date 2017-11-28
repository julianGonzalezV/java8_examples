package co.book.chapter4.functional.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;


/**
 * No recibe parámetros y retorna un valor
 */
public class SupplierMain {

    //NOTA LLEVAR ESTOS CASOS QUE TEST DE PRUEBAS PARA EJEMPLIFICARLOS MEJOR

    public static void  main(String... args){
        // note como se pospone el computo, hasta que no se llama el método
        //de la interfaz funcional , no se ejecuta el computo

        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        System.out.println(d1);
        System.out.println(d2);




        Supplier<StringBuilder> s3 = StringBuilder::new;
        Supplier<StringBuilder> s4 = () -> new StringBuilder();
        System.out.println(s3.get());
        System.out.println(s4.get());


        Supplier<ArrayList<String>> s5 = ArrayList<String>::new;
        ArrayList<String> a1 = s5.get();
        System.out.println(a1);

    }

}
