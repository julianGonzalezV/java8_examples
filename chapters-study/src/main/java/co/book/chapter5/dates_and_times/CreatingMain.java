package co.book.chapter5.dates_and_times;

import java.time.*;

public class CreatingMain {

    public static void main(String ... args){
        System.out.println(LocalDate.now());//solo fecha sin timezone ni hora
        System.out.println(LocalTime.now());//solo la hora
        System.out.println(LocalDateTime.now());//fecha y hora pero no timezone
        System.out.println(ZonedDateTime.now());//Contains a date, time, and time zone.

        /**
         * Note que son dos métodos difernetes
         */
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);//se recomienda esta
        LocalDate date2 = LocalDate.of(2015, 1, 20);// con los nuevos metodos de j8 el mes inicia en 1, como el lenguaje humano :)
        System.out.println(date1);
        System.out.println(date2);

    }

}
