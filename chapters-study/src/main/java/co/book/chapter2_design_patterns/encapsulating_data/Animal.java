package co.book.chapter2_design_patterns.encapsulating_data;

/**
 * Encapsulado nos sirve para hacer cumplir INVARIANTS
 */
public class Animal {

    /**
     * haciendo cumplir la invariante, deben ser private los atributos
     */
    private String species;
    private int age;


    public Animal(String species) {
        this.setSpecies(species);
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        if(species == null || species.trim().length()==0) {
            throw new IllegalArgumentException("Species is required");
        }
        this.species = species;
    }
    public int getAge() {
        return age;
    }

    /**
     * haciendo cumplir la invariante
     * un set solo quizás no tenga sentido pero cuando se colocan reglas como estas ya empieza a
     * tomar forma
     * @param age
     */
    public void setAge(int age) {
        if(age<0) {
            throw new IllegalArgumentException("Age cannot be a negative number");
        }
        this.age = age;
    }
}
