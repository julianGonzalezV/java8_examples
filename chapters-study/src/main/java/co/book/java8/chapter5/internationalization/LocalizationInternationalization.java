package co.book.java8.chapter5.internationalization;

import java.util.Locale;

public class LocalizationInternationalization {
    public static void main(String ... args){

        Locale locale = Locale.getDefault();
        System.out.println(locale);//en_US, configuraciupon actual de mi pc, donde eng es ellenguaje y US es el pais

        System.out.println(Locale.GERMAN); // de  the language
        System.out.println(Locale.GERMANY); // de_DE is Germany the country


        /**
         * Set a different one
         */
        System.out.println(Locale.getDefault()); // en_US
        Locale locale2 = new Locale("fr");
        Locale.setDefault(locale2);// change the default PERO SOLO LO CAMBIA PARA EL PROGRAMA JAVAQUE CORRE NO PARA EL PC :)
        System.out.println(Locale.getDefault()); // fr

        /**
         * Using a Resource Bundle
        */
         Locale us = new Locale("en", "US");

         Locale france = new Locale("fr", "FR");

         Locale englishCanada = new Locale("en", "CA");

         Locale frenchCanada = new Locale("fr", "CA");

    }
}
