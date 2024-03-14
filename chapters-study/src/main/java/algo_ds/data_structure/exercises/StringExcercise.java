package algo_ds.data_structure.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringExcercise {

    public static String reverse(String input){
        StringBuilder result = new StringBuilder("");
        for (int i=input.length()-1; i>=0; i--) {
            result = result.append(input.substring(i, i+1 ));
        }
        return result.toString();
    }

    public static String reverseConcu(String input){
        return reverseConcuAux(input, new StringBuilder(), input.length()-1);
    }

    public static String reverseConcuAux(String input, StringBuilder result, int counter){
        if(counter < 0 )
            return result.toString();
        else
            return reverseConcuAux(input, result.append(input.substring(counter, counter+1)), --counter);
    }

    public static String reverseSbuilder(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseByBytes(String str){
        byte[] inputBytes = str.getBytes();
        byte[] outputBytes = new byte[inputBytes.length];
        for(int i=0, j =inputBytes.length-1; j>=0; j--, i++ ){
            outputBytes[i] = inputBytes[j];
        }
        return new String(outputBytes);
    }


     public static <T> T reverserAbstractDivConquer(T input){
        return null;
    }

    public static String half( String input, boolean up){
        if(up) return input.substring(0, input.length()/2);
        else return input.substring(input.length()/2);
    }

    public static String halfAndReverse( String input){
        String halfDown = half(input, false);
        String halfUp = half(input, true);
        return new StringBuilder(reverse(halfUp)).append(reverse(halfDown)).toString();
    }

    /**
     * "love you", "love to you"
     * @param inputStr
     * @param fullStr
     * @return
     */
    public static boolean isRansomWord(String inputStr, String fullStr){
        List<String> inputList = new ArrayList<>(Arrays.asList(inputStr.split(" ")));
        String[] fullStrs = fullStr.split(" ");
        for(int i = 0; i<fullStrs.length; i++){ // O(n)
            if(inputList.contains(fullStrs[i])){ // Contains is O(n) it is implemented on indexOf()
                inputList.remove(fullStrs[i]);
            }
        }//Then O(n exp 2)
        return inputList.isEmpty();
    }

    /*
    public static boolean isRansomWordV2(String inputStr, String fullStr){
        StringBuilder sb = new StringBuilder(inputStr);
        //sb.delete()
        String[] fullStrs = fullStr.split(" ");
        for(int i = 0; i<fullStrs.length; i++){ // O(n)
            if(inputStr.contains(fullStrs[i])){ // Contains is O(n) it is implemented on indesOf()
                inputStr.remove(fullStrs[i]);
            }
        }//Then O(n exp 2)
        return inputStr.isEmpty();
    }*/


    public static void stringBulderSample(){
        StringBuilder builder = new StringBuilder("abc");
        builder.append("def");
        builder.append("ghij");
        builder.insert(0, "xyz");
        builder.delete(3,6);
        System.out.println(builder.toString());
    }


    public static void main(String ... args){
        /*System.out.println(reverse("love"));
        System.out.println(reverse(""));
        System.out.println(reverse("Te amo mucho"));
        System.out.println(reverseConcu("Te amo concu"));
        System.out.println(reverseSbuilder("ucnoc oma eT"));
        System.out.println(half("microsoft", true));
        System.out.println(half("microsoft", false));
        System.out.println(halfAndReverse("microsoft"));
        System.out.println(reverseByBytes("loveyou"));*/
        //System.out.println(isRansomWord("love you", "love to you"));
        stringBulderSample();
    }
}
