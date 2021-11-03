package co.book.exercises;

import java.util.*;

public class Palindrome {

    public  static boolean isPalindromeRecursive(String chain, int remainigItems) {
        if(chain.length() <= 1) return remainigItems <= 0;
        String firstI = chain.substring(0,1);
        String lastI = chain.substring(chain.length()-1);
        if(firstI.equals(lastI)){
            return isPalindromeRecursive(chain.substring(1,chain.length()-1), remainigItems);
        }else {
            return isPalindromeRecursive(chain.substring(1, chain.length() - 1), remainigItems + 1);
        }
    }


    public  static boolean isPalindrome(String chain){
        Stack<Character> setValues = new Stack();
        // O(n)
        int remainingItems = 0;
        for (Character s: chain.toCharArray()) {
            setValues.add(s);
        }
        return (setValues.size() == 1);
    }
    public static void main(String... args){
        //System.out.println(isPalindrome("ama"));
        System.out.println(isPalindromeRecursive("amoraroma",0));
        System.out.println(isPalindromeRecursive("aa",0));
        System.out.println(isPalindromeRecursive("m",0));
        System.out.println(isPalindromeRecursive("ama",0));
        System.out.println(isPalindromeRecursive("am",0));
    }
}
