package co.book.java8.chapter1.overloading_and_overriding;

import java.io.IOException;

public class BobcatKitten extends Bobcat {
    /**
     * //Es un OVERRRIDING porque tiene la mista firma qu el padre (mismos parametros, en este caso cero parametros)
     *
     */
    public void findDen()  { }

    /**
     * OVERRRIDING que no funciona porque Throwable no es subclass de exception
     */
    //public void methodWithExc() throws Throwable{ }


    /**
     * OVERRRIDING que si funciona :) porque IOException extends Exception
     * @throws IOException
     */
    public void methodWithExc() throws IOException{ }

    /**
     * Es un OVERLOADING porque especifica mas parametros de entrada
     * @param b
     */
    public void findDen(boolean b) { }

    /**
     * Ni overloading ni overriden, es otro metodo con nombre distinto
     * @return
     * @throws Exception
     */
    public int findden() throws Exception { return 0; }
}
