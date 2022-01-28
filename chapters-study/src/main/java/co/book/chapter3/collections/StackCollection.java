package co.book.chapter3.collections;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Subclass de vector(set con synchronization a la antigua) pero es una synchronize implementation , but
 * synchronization is not always needed
 * in that case use ArrayDeque
 */
public class StackCollection {

    public static Stack eg1(){
        System.out.println("ADDING AND SEARCH::::::::::::::");
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);// push returns the inserted element while add returns the result of the operation
        intStack.addAll(Arrays.asList( 6, 7)); // adding multiple records at once
        System.out.println(intStack.peek()); // obtener el ultimo registro insertado pero sin eliminaro
        System.out.println(intStack.pop()); // obtener el ultimo registro insertado Y LO ELIMINA
        return intStack;
    }

    public static Stack eg2(){
        System.out.println("REMOVING::::::::::::::");
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);// push retunrs the inserted element while add returns the result of the operation
        intStack.addAll(Arrays.asList( 6, 7, 8, 9)); // adding multiple records at once
        System.out.println(intStack.peek()); // obtener el ultimo registro insertado pero sin eliminaro
        System.out.println(intStack.pop()); // obtener el ultimo registro insertado Y LO ELIMINA
        System.out.println(intStack.removeElement(6));
        intStack.removeElementAt(2);

        // Remove multiple elements
        List<Integer> intListToRemove = Arrays.asList(11, 12, 13, 14);
        intStack.addAll(intListToRemove);
        System.out.println(intStack);
        intStack.removeAll(intListToRemove);
        System.out.println(intStack);
        return intStack;
    }


    public static Stack filterRemove(){
        System.out.println("filterRemove::::::::::::::");
        Stack<Integer> intStack = new Stack<>();
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        intStack.addAll(intList);

        intStack.removeIf(element -> element % 2 == 0);
        System.out.println(intStack);

        return intStack;
    }

    /**
     * sEARCH FOR AN ELEMENT
     * @return
     */
    public static Stack eg3(){
        System.out.println("SEARCH::::::::::::::");
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);// push retunrs the inserted element while add returns the result of the operation
        intStack.addAll(Arrays.asList( 6, 7)); // adding multiple records at once
        intStack.push(1);
        intStack.push(1);
        System.out.println( intStack.search(5)); // INDEX = -1 IF NOT PRESENT
        System.out.println( intStack.search(1));// iNDEX DEL ELEMENTO QUE SE BUSCA
        System.out.println( intStack.indexOf(1));// iNDEX DEL ELEMENTO QUE SE BUSCA
        System.out.println( intStack.lastIndexOf(1));// iNDEX DEL ELEMENTO QUE SE BUSCA
        return intStack;
    }

    public static Stack iterateEg(){
        System.out.println("iterateEg::::::::::::::");
        Stack<Integer> intStack = new Stack<>();
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        intStack.addAll(intList);

        ListIterator<Integer> it = intStack.listIterator();

        Stack<Integer> result = new Stack<>();
        while(it.hasNext()) {
            result.push(it.next());
        }
        System.out.println(result);
        return intStack;
    }

    public static Stack streamEg(){
        System.out.println("streamEg::::::::::::::");
        Stack<Integer> intStack = new Stack<>();
        List<Integer> inputIntList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10);
        intStack.addAll(inputIntList);

        List<Integer> filtered = intStack
                .stream()
                .filter(element -> element <= 3)
                .collect(Collectors.toList());
        System.out.println(filtered);
        return intStack;
    }

    public static void main(String... args){
        /*eg1();
        eg2();
        filterRemove();
        eg3();
        streamEg();*/
        iterateEg();


    }
}
