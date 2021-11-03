package co.book.chapter2_design_patterns.example3;

import java.util.List;

/**
 * Imaginemos que necesitamos una implementación mas elaborada de RaceManager
 * Pero el Equipo de desarrollo encargado no ha terminado :0 :(
 * lo que podemos hacer es crear una implementación Dummy e ir adelantando
 * finalmente no puedes jugar con la papita diciendo que no pudiste avanzar por culpa del otro equipo ;)
 */
public class DummyRaceManager implements RaceManager {
    /**
     * Implementación pelle qpero puede adelantar algo :)
     * @param animals al fin y al cabo quién quita que la implementación
     *                de getWinner() sea un algoritmo muy perro que solo lo hacen los de NASA
     * @return
     */
    @Override
    public Animal getWinner(List<Animal> animals) {
        return animals==null || animals.size()==0 ? null: animals.get(0);
    }
}
