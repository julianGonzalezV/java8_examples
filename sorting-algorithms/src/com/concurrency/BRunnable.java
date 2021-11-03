package com.concurrency;

public class BRunnable implements Runnable{
    public void run(){
        System.out.println("Im the runnable Thread ".concat(Thread.currentThread().getName()));
    }

    public static void main(String ... args){
        System.out.println("Im the runnable Thread ".concat(Thread.currentThread().getName()));
        new Thread(new BRunnable()).start();
        new Thread(new BRunnable()).start();
    }
}
