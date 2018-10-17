package co.book.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[] vars4 [], space [][]; // a 2D AND a 3D array en una sola línea, confuso pero no enrredarse

        String [][] rectangle = new String[3][2];// es un array de 3 posiciones y cada posición contendrá
        //otro array de 2  posiciones


        /**
         * Uno de los defectos mas marcado arriba es que debemos saber el tamanio
         * por eso ArrayList
         *
         */

        /**
         * Creating an ArrayList:
         * java 5 y previas versiones
         */
        ArrayList list1 = new ArrayList(); // se crea con la cantidad de elementos que se assignapor defecto
        ArrayList list2 = new ArrayList(10);
        ArrayList list3 = new ArrayList(list2); //creando copia de otro array list

        /**
         * java 5 en adelante
         *
         */
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<>();

        /**
         * Java 7 en adelante
         * note como
         */

        List<String> list6 = new ArrayList<>();
        //ArrayList<String> list7 = new List<>(); // DOES NOT COMPILE, porque al lado izq debe ir la clase
        //general y al lado derecho la implementacion o deben ser ambos lados de tipo ArrayList Linea 99

        /**
         * ArrayList Methods
         * add:
         *
           boolean add(E element) //al parecer suiempre retorna true
           void add(int index, E element)
         */

        ArrayList list = new ArrayList();
        list.add("hawk");// [hawk]

        list.add(Boolean.TRUE);// [hawk, true] , permite el boolean porque como no le dijimos nada al lado izq acerca del tipo permitido
        //ArrayList<Strin> list = new ArrayList();
        System.out.println(list);  //[hawk, true]


        List<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add(1, "robin");
        birds.add(0, "blue jay");
        birds.add(1, "cardinal");
        birds.add("blue jay");//permite repetidos
        System.out.println(birds);
// [blue jay, cardinal, hawk, robin]

        /**
         * remove()
         */

        List<String> birds2 = new ArrayList<>();
        birds2.add("hawk");// [hawk]
        birds2.add("hawk");// [hawk, hawk]
        System.out.println(birds2.remove("cardinal")); // prints false porque no existe

        System.out.println(birds2.remove("hawk")); // prints true
        System.out.println("queda con lo elementos:"+birds2);

        System.out.println(birds2.remove(0)); // prints hawk
        System.out.println(birds2);


        /**
         * set(): Para cambiar una posicion del arrayList pero sin cambiar el tamanio
         */

        List<String> birds3 = new ArrayList<>();
        birds3.add("hawk");// [hawk]
        System.out.println(birds3.size());// 1
        birds3.set(0, "robin");// [robin]
        System.out.println(birds3.size());// 1
        //birds3.set(1, "robin");// IndexOutOfBoundsException, porque no tieoen la posicón 1 ,
        //las posiciones incian desde cero


        /**
         * isEmpty() and size()
         */
        System.out.println(birds.isEmpty());// true
        System.out.println(birds.size());// 0
        birds.add("hawk");// [hawk]
        birds.add("hawk");// [hawk, hawk]
        System.out.println(birds.isEmpty());// false
        System.out.println(birds.size());// 2

        /**
         * clear()
         */
        List<String> birds4 = new ArrayList<>();
        birds4.add("hawk");// [hawk]
        birds4.add("hawk");// [hawk, hawk]
        System.out.println(birds4.isEmpty());// false
        System.out.println(birds4.size());// 2
        birds4.clear();// []
        System.out.println(birds4.isEmpty());// true
        System.out.println(birds4.size());// 0


        /**
         * contains()
         */
        System.out.println(birds.contains("hawk")); // true
        System.out.println(birds.contains("robin")); // false


        /**
         * equals()
         * you can compare two lists
         to see if they contain the same elements in the same order.
         */

        /**
         * Autoboxing; convertir automáticamente deprimtivo a wrapper class
         */
        List<Double> weights = new ArrayList<>();
        weights.add(50.5);// [50.5]
        weights.add(new Double(60));// [50.5, 60.0]
        weights.remove(50.5);// [60.0]
        double first = weights.get(0);// 60.0

        /**
         * Removing
         * Be careful when autoboxing into Integer
         * //If you
         want to remove the 2, you can write numbers.remove(new Integer(2))
         */
        System.out.println("Removing + autoboxing");
        List<Integer> numbers31 = new ArrayList<>();
        numbers31.add(1);
        numbers31.add(2);
        numbers31.remove(1);// ṕor ser la lista de tipo wrapper class, remove(1) no quiere decir que
        //borre el elementyo cuyo valor sea 1 sino que borre la posición 1
        System.out.println(numbers31);




    }


}
