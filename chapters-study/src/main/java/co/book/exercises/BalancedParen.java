package co.book.exercises;

import java.util.*;

public class BalancedParen {
    static Map<Character,Character> ClosedSymbols = new HashMap<>();


    public static boolean isBalancedParentheses(String chain){
        Stack<Character> queue = new Stack<>();
        // O(n)
        for (Character ch: chain.toCharArray()) {

            if(queue.isEmpty()){
                queue.add(ch);
                continue;
            }
            //System.out.println(queue.peek());

            if(ClosedSymbols.get(ch)!= null && ClosedSymbols.get(ch).equals(queue.peek())){
                queue.pop();
                continue;
            }
            queue.add(ch);

        }
        return queue.isEmpty();
    }

    /**
     * Map is selected to better performance
     */
    private static void loadSymbolMap(){
        ClosedSymbols.put('}','{');
        ClosedSymbols.put(']','[');
        ClosedSymbols.put(')','(');
    }



    public static void main(String... args){
        loadSymbolMap();
        System.out.println(isBalancedParentheses("{[()]}"));
        System.out.println(isBalancedParentheses("}"));
        System.out.println(isBalancedParentheses("(){[()]}"));
        System.out.println(isBalancedParentheses("{[()]}[]"));
        System.out.println(isBalancedParentheses("{[()]}["));
        System.out.println(isBalancedParentheses("){[()]}"));
    }
}
