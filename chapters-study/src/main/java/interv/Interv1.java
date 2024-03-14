package interv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Interv1 {

    /**
     * – implement method that has as a parameter HashMap
     * of strings and return List of sorted values that contains char ‘A’
     * Eg:
     * {A:1,B,C}
     * out:
     *
     * @param args
     */

    private static List<String> getSortedList(HashMap<String, String> inputM){
        try {
            List<String>  outPutList = new ArrayList();
            inputM.forEach((k, v) -> {
                if(Objects.isNull(k)) try {
                    throw new Exception("Null value is not allowed");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if(k!= null &&  k.equals("A")){
                    outPutList.add(v);
                }
            });

            return  outPutList;
        }catch (Exception exception){
            exception.printStackTrace();
            return Collections.emptyList();
        }


    }
}
