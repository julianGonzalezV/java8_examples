package co.book.data_structure;

import java.util.Arrays;

public class MainDataStructure {

    public static void main(String... args){

        /**
         * Arrays:
         * Lista ordenada que puede contener duplicados
         */

        int[] numbers1 = new int[3];
        //todos los valores de las posiciones antes creadas las inicialoza en 0s
        System.out.println(numbers1[0]);


        /**
         * Cuando lo cree así no puede especificar el tamanio, genera error de sintaxis
         */
        int[] numbers2 = new int[] {99, 55, 42};
        Arrays.sort(numbers2);
        System.out.println(numbers2[2]);

        /**
         * This approach is called an anonymous array.It is anonymous because you don’t specify
         the type and size
         */
        int[] numbers3 = {42, 55, 99};
        System.out.println(numbers3[1]);

        /**
         * Se puede colocar el [] antes o después del nombre de la variable
         */


        String[] strings = { "stringValue" };
        Object[] objects = strings;
        String[] againStrings = (String[]) objects;
        //againStrings[0] = new StringBuilder(); // DOES NOT COMPILE, error de complación
        objects[0] = new StringBuilder();// careful!, genera error en tiempo de ejecución

    }


}
