package co.book.java8.chapter2_design_patterns.example1;

public class Eagle implements Fly {
    @Override
    public int getWingSpan() throws Exception {
        return 15;
    }


    public void land() {
        System.out.println("Eagle is diving fast");
    }
}
