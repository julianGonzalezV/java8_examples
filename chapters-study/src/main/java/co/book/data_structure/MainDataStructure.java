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
        //objects[0] = new StringBuilder();// sea cuidadoso!, genera error en tiempo de ejecución
        //porque objects es igual a un array de strings, si furea igual a un array de object no
        //generaría el error


        /**
         *Sorting
         */
        Arrays.sort(numbers2);
        System.out.println("Ordenado es "+numbers2[2]);


        /**
         *Searching
         * realiza un binary search que requiere un array ordenado ya que divide y luego mira por cual mitad
         * se va
         */
        int[] numbers = {2,4,6,8};
        System.out.println(Arrays.binarySearch(numbers,2));
        System.out.println(Arrays.binarySearch(numbers, 4));
        System.out.println(Arrays.binarySearch(numbers, 1));
        System.out.println(Arrays.binarySearch(numbers, 3));
        System.out.println(Arrays.binarySearch(numbers,9)); //-5 PORQUE EL 9 debería ir despues del 3 posicion del array (el 8)
        //osea en la posición 4 , lo que hace java es negarlo a -4y le resta -1 = -5

        /**
         * Multidimensional Arrays
         */
        int[][] vars1;// 2D array
        int vars2 [][];// 2D array
        int[] vars3[];// 2D array
        int[] vars4 [], space [][]; // a 2D AND a 3D array

        String [][] rectangle = new String[3][2];// es un array de 3 posiciones y cada posición contendrá
        //otro array de 2  posiciones


    }


}
