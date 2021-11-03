package com.concurrency;

public class AThread extends Thread {
    public void run(){
        System.out.println("Im the thread ".concat(this.getName()));
    }


    public static void main(String ... args){
        AThread th1 = new AThread();
        th1.setPriority(1);
        th1.setName("Pepito");
        th1.start();

        AThread th2 = new AThread();
        th2.setPriority(5);
        th2.setName("Juanito");
        th2.start();

        new AThread().start();

    }
}
