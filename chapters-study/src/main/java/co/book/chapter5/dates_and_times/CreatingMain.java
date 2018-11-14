package co.book.chapter5.dates_and_times;

import java.time.*;

public class CreatingMain {

    public static void main(String ... args){
        System.out.println(LocalDate.now());//solo fecha sin timezone ni hora
        System.out.println(LocalTime.now());//solo la hora
        System.out.println(LocalDateTime.now());//fecha y hora pero no timezone
        System.out.println(ZonedDateTime.now());//Contains a date, time, and time zone.

        /**
         * Note que son dos métodos diferentes
         */
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);//se recomienda esta
        LocalDate date2 = LocalDate.of(2015, 1, 20);// con los nuevos metodos de j8 el mes inicia en 1, como el lenguaje humano :)
        System.out.println(date1);
        System.out.println(date2);

        /**
         * Se puede decidir la precisión
         */
        LocalTime time1 = LocalTime.of(6, 15);// hour and minute
        LocalTime time2 = LocalTime.of(6, 15, 30);// + seconds
        LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);


        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);
        System.out.println(dateTime1);
        System.out.println(dateTime2);


        /**
         * ZonedDateTime
         */
        System.out.println("ZonedDateTime");

        ZoneId zone = ZoneId.of("America/Bogota");
        ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20,
                6, 15, 30, 200, zone);
        ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);

        System.out.println(zoned1);
        System.out.println(zoned2);
        System.out.println(zoned3);


        /**
         * Finding a Time Zone
         */


        System.out.println(ZoneId.systemDefault());

        //Listando los zone ids
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("Bogota"))
                .sorted().forEach(System.out::println);

/**
 * Manipulating Dates and Times
 * Adding
 */

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
        System.out.println(date);// 2014–01–20
        date = date.plusDays(2);
        System.out.println(date);// 2014–01–22
        date = date.plusWeeks(1);
        System.out.println(date);// 2014–01–29
        date = date.plusMonths(1);
        System.out.println(date);// 2014–02–28
        date = date.plusYears(5);
        System.out.println(date);// 2019–02–28

        /**
         * backward in time :)
         */

        date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);// 2020–01–20T05:15
        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime);// 2020–01–19T05:15
        dateTime = dateTime.minusHours(10);
        System.out.println(dateTime);// 2020–01–18T19:15
        dateTime = dateTime.minusSeconds(30);
        System.out.println(dateTime);// 2020–01–18T19:14:30


    }

}
