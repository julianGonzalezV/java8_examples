package co.book.chapter6;

public class Turkey {

    public static void main(String[] args) {
        //no compila porque debe ser hija de extends AutoCloseable
        //No sabe como cerrarlo!!!
        /*
        try (Turkey t = new Turkey()) { // DOES NOT COMPILE
            System.out.println(t);
        }*/

    }
}
