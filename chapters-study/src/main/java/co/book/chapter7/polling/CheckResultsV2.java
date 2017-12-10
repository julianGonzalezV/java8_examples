package co.book.chapter7.polling;

public class CheckResultsV2 {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
       /*
       Cuantas veces imprime Not reached yet?
       R  Tampoco se sabe :) peero sabemos que va ser menos intensivo que la V1
       note como el while imprime muuucho menos que el de la V1*/

        new Thread(() -> {
            for(int i=0; i<5000; i++) CheckResultsV2.counter++;
        }).start();
        while(CheckResultsV2.counter<1000) {
            System.out.println("Not reached yet");
            Thread.sleep(100); // 1 SECOND
        }
        System.out.println("Reached!");
    }
}
