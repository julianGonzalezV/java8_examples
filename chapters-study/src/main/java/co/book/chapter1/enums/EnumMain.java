package co.book.chapter1.enums;

public class EnumMain {

    public static  void main(String ... args){
        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER);// SUMMER
        System.out.println(s == Season.SUMMER);// true


        /**
         * Provee un array paa incluirlo enun loop por ejemplo
         */
        System.out.println("For throught an enum");
        for(Season season: Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }

        System.out.println("Creatign enums form the java old version");
        Season summer1 = Season.valueOf("SUMMER");// SUMMER
        System.out.println("summer1=> " + summer1);
        //Season summer2 = Season.valueOf("summer");// exception
        //System.out.println("summer2=> " + summer2);// no llega por la excepción anterior


        /**
         * Using Enums in Switch Statements
         */
        Season summer = Season.SUMMER;
        switch (summer) {
            case WINTER:
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
            default:
                System.out.println("Is it summer yet?");
        }

        System.out.println("More logic into a enum");
        Season2 s2 = Season2.SUMMER;
        s2.printHours();

        System.out.println("default\n" +
                "implementation and overriding method into a enum");
        Season3 s3 = Season3.FALL;
        s3.printHours();


    }
}
