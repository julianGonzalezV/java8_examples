package co.book.chapter7.polling;

public class CheckResultsV1 {
    private static int counter = 0;
    public static void main(String[] args) {
       /*
       Cuantas veces imprime Not reached yet?
       R No se sabe porque depende de como la cpu le da acceso, si el programador de Threads es probre
       puede quedarse pegado
       El siguiente polling es muy intenso y consume recursos
        unica y exclusivamente para saber si un valor llega a su resultado deseado
        vaya a la V2 si quiere visualizar una mejor manera*/

        new Thread(() -> {
            for(int i=0; i<500; i++) CheckResultsV1.counter++;
        }).start();
        while(CheckResultsV1.counter<100) {
            System.out.println("Not reached yet");
        }
        System.out.println("Reached!");
    }
}
