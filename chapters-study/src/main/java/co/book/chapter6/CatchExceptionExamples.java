package co.book.chapter6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CatchExceptionExamples {

    public static void main(String ... args){

        multiCatch();
    }

    public static void multiCatch() {
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException | IOException e) {
            //note como en el catch solo hay una variable "e",que puede ser de tipo  DateTimeParseException o IOException
            //Note como el pipe es uno solo
            System.out.println("Generó error");
            e.printStackTrace();
            throw new RuntimeException(e);// y así no tiene que duplica esta linea o la anterior en cada catch que realice
        }
    }

    public static void multiCatchEsInmutable() {
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException | IOException e) {
            //e = new IOException(); //inmutable porque esta reasignacion no es permitida
            //porque no sabems la excepcion especifica que sucedió, miesntras que son sngleCatch logicao sabemos cual es
            System.out.println("Generó error");
            e.printStackTrace();
            throw new RuntimeException(e);// y así no tiene que duplica esta linea o la anterior en cada catch que realice
        }
    }


    public static void singleCatchEsmutable() {
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (IOException e) {
            e = new IOException(); //mutable porque esta reasignacion SI es permitida Pero se debe hacer
            //catch solo de una sola excepcion
            System.out.println("Generó error");
            e.printStackTrace();
            throw new RuntimeException(e);// y así no tiene que duplica esta linea o la anterior en cada catch que realice
        }
    }


    /**
     * :::::::::::::.automatic resource management:::::::::::::::::::::
     *
     * La nueva version de una cierra las conexiones establecdas en el constructor
     * @param path1
     * @param path2
     * @throws IOException
     */
    public static void tryWithResources(Path path1, Path path2) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(path1);
             BufferedWriter out = Files.newBufferedWriter(path2)) {
            out.write(in.readLine());
        }
    }


    /**
     * More Verbose
     * @param path1
     * @param path2
     * @throws IOException
     */
    public static void oldTryResourceManager(Path path1, Path path2) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader(path1);
            out = Files.newBufferedWriter(path2);
            out.write(in.readLine());
        }finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }




}
