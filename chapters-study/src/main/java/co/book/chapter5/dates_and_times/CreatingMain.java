package co.book.chapter5.dates_and_times;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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


        /**
         * Working with Periods
         */
        //1) Not using period
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        performAnimalEnrichment(start, end);

        /**
         * Using Periods
         */
        System.out.println(" Using Periods::");
        LocalDate startP = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate endP = LocalDate.of(2015, Month.MARCH, 30);
        Period period = Period.ofMonths(1);// create a period
        performAnimalEnrichmentPeriod(startP, endP, period);// aumentando cada mes

        Period wrong = Period.ofMonths(1).ofWeeks(1);// EL tal encademaniendo en Period NO EXISTE
        //lo anterior es comi lo que sigue
        Period wrong2 = Period.ofYears(1);
        wrong2 = Period.ofWeeks(1);//esta reasignando

        Period wrongOK = Period.of(0, 1, 7); // 1  mes y una semana

        performAnimalEnrichmentPeriod(startP, endP, wrongOK);


        System.out.println(Period.ofWeeks(5));//P35D period of 35 days

        /**
         * Working with Durations
         * Ya que period  llega hasta dias entonces se cuenta con durations que permite
         * unidad mas detallada number of days, hours, minutes, seconds, or nanosecond
         */

        Duration         daily = Duration.ofDays(1);//PT24H PT = Period of Time

        Duration         everyMinute = Duration.ofMinutes(1); //PT1H

        Duration         hourly = Duration.ofHours(1); // PT1M

        Duration         everyTenSeconds = Duration.ofSeconds(10);// PT10S

        Duration         everyMilli = Duration.ofMillis(1); // PT0.001S

        Duration         everyNano = Duration.ofNanos(1); // PT0.000000001S

        /**
         * TAMBIEN BRINDA EL METODO OF()
         */
        Duration         daily2 = Duration.of(1, ChronoUnit.DAYS);

        Duration         hourly2 = Duration.of(1, ChronoUnit.HOURS);

        Duration         everyMinute2 = Duration.of(1, ChronoUnit.MINUTES);

        Duration         everyTenSeconds2 = Duration.of(10, ChronoUnit.SECONDS);

        Duration         everyMilli2 = Duration.of(1, ChronoUnit.MILLIS);

        Duration         everyNano2 = Duration.of(1, ChronoUnit.NANOS);


        /**
         * Working with Instants
         * represents a specific moment in time in the GMT time zone.
         */

        Instant now = Instant.now();//UTIL  PARA VER POR EJEMPLO CUANTO SE DEMORA UNA TAREA
        // do something time consuming LLAME UN MÉTDODO X, EJEMPLO EXECUTOR
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant later = Instant.now();

        Duration duration = Duration.between(now, later);
        System.out.println("la tarea se tardó =>  "+duration.toMillis());


        /**
         * Accounting for Daylight Savings Time
         */

        LocalDate date3 = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time4 = LocalTime.of(1, 30);
        ZoneId zone3 = ZoneId.of("US/Eastern"); // confuguracion del este de estados unidos
        ZonedDateTime dateTime3 = ZonedDateTime.of(date3, time4, zone3);

        System.out.println(dateTime3); // 2016–03–13T01:30–05:00[US/Eastern]

        dateTime3 = dateTime3.plusHours(1);// al sumarle una hora pesariamos que quedaria la nueva hora a la 02:30

        System.out.println(dateTime3); // 2016–03–13T03:30–04:00[US/Eastern] ups son las 03:30
        //el valor anterior es por que en horario de verano los relojes se deben ajustar y Java8 ya lo tiene en cuenta
        // :o :o :o :o y también para esa hora el UTC cambia ohhh


    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {// check if still before end
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1);// add a month
        }
    }

    /**
     * Este código es mas geberico que el anterior dado que recibe comoparametro un Period
     * asi cuando no deseemmo que sea cada mes sino cada mes y 1 semana se enviaria dicha configuración
     * en el period
     * @param start
     * @param end
     * @param period
     */
    private static void performAnimalEnrichmentPeriod(LocalDate start, LocalDate end,
                                                      Period period) {// uses the generic period
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period);// adds the period
        }
    }

}
