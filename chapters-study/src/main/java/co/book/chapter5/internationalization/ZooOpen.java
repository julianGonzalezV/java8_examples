package co.book.chapter5.internationalization;

import java.util.*;

public class ZooOpen {
    public static void main(String ... args){
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        printProperties(us);
        System.out.println();
        printProperties(france);

    }

    /**
     * OJO los archivos dedenir  en la carpeta resources del proyecto actual
     * @param locale
     */
    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));

        //
        System.out.println("Recorrer las propiedades del archivo ");
        Set<String> keys = rb.keySet();
        keys.stream().map(k -> k + " " + rb.getString(k))
                .forEach(System.out::println);

        /**
         *
         * Converting from ResourceBundle to Properties
         *
         */

        Properties props = new Properties();
        rb.keySet().stream().forEach(k -> props.put(k, rb.getString(k)));
        System.out.println(props.getProperty("notReallyAProperty"));//null porque no existe
        System.out.println(props.getProperty("notReallyAProperty", "123"));//123
    }                                                                                                         }