package co.book.chapter2_design_patterns.creational_patterns.b_inmutable_objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Explicando 4. Don’t allow referenced mutable objects to be modified or accessed directly.
 */
public final  class Animal {

    private final List<String> favoriteFoods;

    public Animal(List<String> favoriteFoods) {
        if(favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    /**
     * mutable porque alguien puede llamar a getFavoriteFoods()
     * @return
     */
    public List<String> getFavoriteFoods() { // MAKES CLASS MUTABLE!,
        return favoriteFoods;
    }
}
