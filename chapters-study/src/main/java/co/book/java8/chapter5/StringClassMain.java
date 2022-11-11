package co.book.java8.chapter5;

public class StringClassMain {
    public static void main(String ... args){
        String s = "abcde ";
        System.out.println(s.trim().length());
        System.out.println(s.charAt(4));
        System.out.println(s.indexOf('e'));
        System.out.println(s.indexOf("de"));
        System.out.println(s.substring(2, 4).toUpperCase());
        System.out.println(s.replace('a', '1'));
        System.out.println(s.contains("DE"));
        System.out.println(s.startsWith("a"));


    }
}
