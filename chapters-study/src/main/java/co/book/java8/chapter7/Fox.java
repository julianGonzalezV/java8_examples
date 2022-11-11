package co.book.java8.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Food {}
 class Water {}

public class Fox {
    private String name;

    public Fox(String name){
        this.name = name;
    }


    public void eatAndDrink(Food food, Water water) {
        synchronized(food) {
            System.out.println("Got Food! "+name);
            move();
            synchronized(water) {
                System.out.println("Got Water! "+name);
            }
        }
    }


    public void drinkAndEat(Food food, Water water) {
        synchronized(water) {
            System.out.println("Got Water! "+name);
            move();
            synchronized(food) {
                System.out.println("Got Food! "+name);
            }
        }
    }


    public void move() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
// Handle exception
        }
    }


    public static void main(String[] args) {
// Create participants and resources
        Fox foxy = new Fox("FOXY");
        Fox tails = new Fox("TAIL");
        Food food = new Food();
        Water water = new Water();
// Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            //OJO note como, food and water con los mismo recursos para ambos Foxes

/*
            service.submit(() -> foxy.eatAndDrink(food,water));
            service.submit(() -> tails.drinkAndEat(food,water));
*/


            //UNA OPCION EASY DE RESOLVER DEADLOCK, que los dos a la vez taengan una regla
            //de que deben primero x y luego y eje eat and drink
            service.submit(() -> foxy.eatAndDrink(food,water));
            service.submit(() -> tails.eatAndDrink(food,water));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}