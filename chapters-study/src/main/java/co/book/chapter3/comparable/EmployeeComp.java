package co.book.chapter3.comparable;


import java.util.*;
public class EmployeeComp {
    public static void main(String args[]) {
        int x=10;
        int y=25;
        int z=x+y;
        List<Employee> employees = new ArrayList();

        employees.add(new Employee("Juli", "Gonzo"));
        employees.add(new Employee("Juli", "Arango"));
        employees.add(new Employee("Ana", "Velez"));

        Set<Employee> employeesTs = new TreeSet<>();

        employeesTs.add(new Employee("Juli", "Gonzo"));
        employeesTs.add(new Employee("Juli", "Arango"));
        employeesTs.add(new Employee("juli", "arango"));
        employeesTs.add(new Employee("Ana", "Velez"));

        System.out.println("Sum of x+y = " + z);
        System.out.println(" Employees => "+ employees);
        System.out.println(" Employees TS => "+ employeesTs);
    }
}

class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public String toString(){
        return this.firstName+" - "+this.lastName;
    }


    public String getFullName(){
        return this.firstName+this.lastName;
    }

    public int compareTo(Employee other){
        return this.getFullName().compareTo(other.getFullName());
    }

}
