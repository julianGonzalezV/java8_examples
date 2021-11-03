package co.book.chapter2_design_patterns.Composing;

/**
 * Penguin es la composición de la unión de instancia de Flippers y WebbedFeet.
 * Es decir para armar un penguin necesito esa composición (ingredientes)
 *
 * UNA DE LAS VENTAJAS DE COMPOSITION sobre inheritance es que compositions promueve mas
 * reutilización de código, ejemplo Flippers puede ser reutilizado en muchas partes mas
 * donde aplique
 */
public class Penguin {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin() {
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }
    public void flap() {
        this.flippers.flap();
    }
    public void kick() {
        this.webbedFeet.kick();
    }
}
