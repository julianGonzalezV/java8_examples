package co.book.chapter6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CatchExceptionExamples {

    public static void main(String ... args){


    }

    public static void multiCatch() {
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);// y así no tiene que duplica esta linea o la anterior en cada catch que realice
        }
    }


}
