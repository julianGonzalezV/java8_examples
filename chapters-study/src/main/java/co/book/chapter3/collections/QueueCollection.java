package co.book.chapter3.collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ::::::::::Queue Interface ::::::::::::::::::::
 * Use a queue when elements are added and removed in a specific order
 * Unless stated otherwise, a queue is assumed to be FIFO (first-in, first-out).The other common format is LIFO (last-in, first-out.)
 *add, and remove from the beginning and end of the list in constant time.
 * The tradeoff is that dealing with an arbitrary index takes linear time.
 *
 *
 *
 * ::::::::: Queue Implementations :::::::::::::
 * ArrayDeque: Pure Queue (see code below), more performance than LinkedList
 *
 * LinkedList: Works as a List or Queue (implements both List and Queue)
 *
 *
 */
public class QueueCollection {
/**  ------------ Queue Methods------------
    boolean add(E e) :::: Adds an element to the back of the queue and returns true or throws an exception
    E element() ::::Returns next element or throws an exception if empty queue
    boolean offer(E e) ::::Adds an element to the back of the queue and returns whether successful
    E remove() ::::Removes and returns next element or throws an exception if empty queue
    void push(E e) ::::Adds an element to the front of the queue Yes Yes
    E poll() ::::Removes and returns next element or returns null if empty queue
    E peek() ::::Returns next element (the head of the queue) or returns null if empty queue
    E pop() ::::Removes and returns next element or throws an exception if empty queue
*/

    /**
     * Use offer/poll/peek When talking about FIFO
     * @return
     */
    private static Queue numbersArrayDequeFifo(){
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.add(20)); //true
        //queue.push(30) /Does not compile because this is a FIFO queue
        System.out.println("La va n cola es => "+queue); // 10
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null
        return queue;
    }


    /**
     * Use push/poll/peek When talking about LIFO or Stack
     * @return
     */
    private static Queue numbersArrayDequeLifo(){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.add(20)); //true
        queue.push(30);
        System.out.println("La va n cola es => "+queue); // 10
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null
        return queue;
    }



    /**
     * Use offer/poll/peek When talking about FIFO
     * @return
     */
    private static Queue numbersLinkedListFifo(){
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.add(20)); //true
        //queue.push(30) /Does not compile because this is a FIFO queue
        System.out.println("La va n cola es => "+queue); // 10
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null
        return queue;
    }


    /**
     * Use push/poll/peek When talking about LIFO or Stack
     * @return
     */
    private static Queue numbersLinkedListLifo(){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.add(20)); //true
        queue.push(30);
        System.out.println("La va n cola es => "+queue); // 10
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null
        return queue;
    }


    public static void main(String ... args){
        System.out.println(":::::::::::::::ArrayDeque => ");
        System.out.println(numbersArrayDequeFifo());
        System.out.println(numbersArrayDequeLifo());

        /**LinkeList funciona exactamente igual que ArrayDeque, pero recuerde que a nivel
        de performance la teoría recoienda ArrayDeque*/
        System.out.println(":::::::::::::::LinkedList => ");
        System.out.println(numbersLinkedListFifo());
        System.out.println(numbersLinkedListLifo());
    }
}
