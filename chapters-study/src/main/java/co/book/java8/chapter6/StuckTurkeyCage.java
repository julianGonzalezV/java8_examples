package co.book.java8.chapter6;

public class StuckTurkeyCage implements AutoCloseable {

    /**
     * Que pasa si desde el try(ver main) creamos el recurso de tipo StuckTurkeyCage y este implementa
     * el método close que a diferencia de la clase TurkeyCage(ver clase) lanza una excepción?
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args)  {

        /**
         * si no se coloca throws Exception en el main o se hace un catch no
         * compilala siguiente linea
         */
        try (StuckTurkeyCage t = new StuckTurkeyCage()) { // DOES NOT COMPILE
            System.out.println("put turkeys in");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        suppressedException();
    }


    /**
     * Que pasa si ademas del exception que lanza el close() de StuckTurkeyCage dentro del
     * TRY tambien lanzara una? R/ Ahi es cuando aparece suppressedException
     * manera en que java sabe acerca de una excepcion principal(la del try) y la
     * excepciOn CONTENIDA
     */
    static void suppressedException(){
        System.out.println(":::::::::::::.suppressedException::::::::::::::");
        try (StuckTurkeyCage t = new StuckTurkeyCage()) { // DOES NOT COMPILE
            throw new IllegalStateException("turkeys ran off");
        }
        catch (Exception e){
            System.out.println("caught: " + e.getMessage());//IMPRIME LA PRINCIPAL
            for (Throwable t: e.getSuppressed())//RECORREMOS LAS CONTENIDAS
                System.out.println(t.getMessage());
        }
    }
}
