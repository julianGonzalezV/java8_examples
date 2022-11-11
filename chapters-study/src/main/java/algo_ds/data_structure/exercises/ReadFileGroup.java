package algo_ds.data_structure.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileGroup {
    static private void readFile(String path) {
        try{
            Stream<String> st = Files.lines(Paths.get(path) ).flatMap(s -> Arrays.stream(s.split(" ")));
            Map<String, Long > mp = st.collect(Collectors.groupingBy(s ->s , Collectors.counting() ));
            System.out.println(mp);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    static private Map<String, Integer > getWordRepated(List<String> inL){
        Map<String, Integer > wordRm = new HashMap<>();
        for (String word : inL) {
            if(wordRm.containsKey(word)){
                wordRm.replace(word, wordRm.get(word)+1);
            }else{
                wordRm.put(word, 1);
            }

        }
        return wordRm;
    }

    /*static private Map<String, Integer > getWordRepatedV2(List<String> inL){
        Map<String, Integer > wordRm = new HashMap<>();
        return inL.stream().map(x -> {
            if(wordRm.containsKey(x)){
                wordRm.replace(x, wordRm.get(x)+1);
            }else{
                wordRm.put(x, 1);
            }
            return null;
        }).collect(Map.class);
    }*/

    public static void main(String ... args){
        System.out.println("-----");
        System.out.println(getWordRepated(Arrays.asList("java","oracle","c++","java")));
        readFile("C:\\examples\\resume.txt");

    }


}
