package co.book.chapter3.generics;

/**
 * Clase jaula
 */
public class Crate<T> {

    private T contents;
    public T emptyCrate() {
        return contents;
    }
    public void packCrate(T contents) {
        this.contents = contents;
    }


    /**
     *:::::::::::::::: Generic Methods::::::::::::::::
     */


    public static <T> Crate<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new Crate<T>();
    }

    public static <T> void sink(T t) { }
    public static <T> T identity(T t) { return t; }
    public static <T> int returnInt(T t) { return 0; }
    //public static T noGood(T t) { return t; } // DOES NOT COMPILE, ya que omite el parameter type <T>

}
