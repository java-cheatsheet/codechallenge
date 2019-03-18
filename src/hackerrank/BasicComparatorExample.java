package hackerrank;


import java.util.*;

/**
 * https://docs.oracle.com/javase/6/docs/api/java/lang/Comparable.html
 * https://docs.oracle.com/javase/6/docs/api/java/util/Comparator.html
 *
 * http://www.javagf.com/comparator-interface-java
 * http://www.javagf.com/java-comparable-interface
 *
 * https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
 *
 */

public class BasicComparatorExample
{
    public static void main(String[] args) {
        callComparator();
        callComparable();
    }

    private static void callComparator() {
        //Comparable
        TreeSet<Student> ts = new TreeSet<>( new ComparatorImpl() );
        ts.add(new Student(104,"vikash"));
        ts.add(new Student(101,"vicky"));
        ts.add(new Student(103,"santosh"));
        ts.add(new Student(102,"kapil"));
        System.out.println(ts);

    }

    private static void callComparable() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Vikas", "Hyderabad"));
        list.add(new Employee(105, "Sanjit", "Banglore"));
        list.add(new Employee(103, "Yogesh", "Pune"));
        Collections.sort(list);
        System.out.println(list);
    }
}


class ComparatorImpl implements Comparator
{
    public int compare(Object o1, Object o2) {
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;

        if(s2.roll > s1.roll)
            return 1;
        else if(s2.roll < s1.roll)
            return -1;

        return 0;
    }
}

class Student
{
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll=roll;
        this.name=name;
    }

    public String toString(){
        return roll + "  "+name;
    }

}


/**
 * Comparable Impl
 */
class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String address;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override public int compareTo(Employee o) {
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override public String toString() { return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]"; }
}
