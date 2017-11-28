package co.book.chapter5;

public class Animal {
    private int age;
    private String name;
    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public Animal(int age) {
        this.age = age;
        this.name = null;
    }

}