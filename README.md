# java8_examples
selft study repo

vpcmobile
VPC#Guest2017

VPC-CODINGCLUB
VPC#coding2017

Aditions in Java8:
using lambdas for the Comparator implementation
Most of the changes in Java8 revolve around streams


Using Method References(JAVA8):::::::::::::::::::::::.

Hace que el código sea más corto, haciendo que java infiera lo que se está deseando llamar.
ejemplo:
Comparator<Duck> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);

llevarlo a 
d1 y d2 solo se pasaban al método compareByWeight de DuckHelper
Comparator<Duck> byWeight = DuckHelper::compareByWeight;


se pueden usar en(ver ejemplos del OCP line 153-155):
■ Static methods
■ Instance methods on a particular instance
■ Instance methods on an instance to be determined at runtime
■ Constructors

:::::::::::::::::::::::.

Removing Conditionally:::::::::::::::::::::::.
firma
boolean removeIf(Predicate<? super E> filter)
eg:list.removeIf(s -> s.startsWith("A"));
:::::::::::::::::::::::.:::::::::::::::::::::::.

go back to page 53: Defining a Functional Interface::::::::::::::::::::::::::::

We can use the @FunctionalInterface annotation: Para asegurar las reglas de functional Interface, y además para asegurar que otro developer no vaya a 
modificar la interface y agregar nuevos métodos, por que muy probablemente generería errores.

Java compiler implicitly assumes that any interface that contains exactly one abstract method is a functional interface


more examples:
a -> a.canHop() its ok 
 
(Animal a) -> { return a.canHop(); } itś OK 

Applying the Predicate Interface::::::::::::::::::::::::::

public interface Predicate<T> {
public boolean test(T t);
}



USO:

import java.util.function.Predicate;
 
public class FindMatchingAnimals {
private static void print(Animal animal, Predicate<Animal> trait) {
if(trait.test(animal))
System.out.println(animal);
}
 
public static void main(String[] args) {
print(new Animal("fish", false, true), a -> a.canHop());
print(new Animal("kangaroo", true, false), a -> a.canHop());
}
}


::::::::::::::..Updating All Elements(addition java8)::::::::::::::::::::::::
List<Integer> list = Arrays.asList(1, 2, 3);
list.replaceAll(x -> x*2);
System.out.println(list); // [2, 4, 6]


::::::::::::::::::::::::....Looping through a Collection::::::::::::::::::::::::..
cats.forEach(c -> System.out.println(c));



::::::::::::::...Using New Java 8 Map APIs::::::::::::::::::::::::


::::::::::::::INICIO :::CHAPTER 7 Concurrency::::::::::::::::::::::::::::::::::::::::::::::::
A thread is the smallest unit of execution that can be scheduled by the operating system

The Runnable interface is commonly used to define the work a thread will execute

Java8 strongly encourages developers to use the
Concurrency API to create and manage Thread objects for them

ExecutorService : performs
thread tasks without having to create Thread objects directly





::::::::::::::FIN :::CHAPTER 7 Concurrency::::::::::::::::::::::::::::::::::::::::::::::::
