package basics;


import java.util.*;

/**
 * https://docs.oracle.com/javase/6/docs/api/java/lang/Comparable.html
 * https://docs.oracle.com/javase/6/docs/api/java/util/Comparator.html
 *
 * http://www.javagf.com/comparator-interface-java
 * http://www.javagf.com/java-comparable-interface
 *
 * https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
 * https://stackoverflow.com/questions/1814095/sorting-an-arraylist-of-objects-using-a-custom-sorting-order
 * https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
 *
 * https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
 */

public class BasicComparatorExample
{
    public static void main(String[] args) {

        //COMPARATOR
        // Data printed in ascending order
//        separateComparatorImpl();

//        System.out.println();
        //COMPARABLE
        // Data printed in decending order
//        studentWithComparable();

        //COMPARABLE
        defaultEmployeeSort();

        callEmployeeSortedByName();
    }

    private static void separateComparatorImpl() {
        TreeSet<Student> ts = new TreeSet<>( new ComparatorImpl() );
        ts.add(new Student(104,"vikash"));
        ts.add(new Student(101,"vicky"));
        ts.add(new Student(103,"santosh"));
        ts.add(new Student(102,"kapil"));

        // Implementation below will throw exception if ComparableImpl
        // is not passed to the TreeSet instantiations, i.e.
        // " new TreeSet<>() "
        // as the Student Class has not implemented Comparable class
        // has been implemented inorder to sort the data and display
        // sorted data in TreeSet. Either the Class Student as data
        // MUST implement a Comparable or a separate Comparator
        // implementation must be passed as above.
        //
        // Exception thrown when ComparatorImpl is not passed -
        //  Exception in thread "main" java.lang.ClassCastException:
        //  basics.Student cannot be cast to java.base/java.lang.Comparable


        for ( Student s : ts )
            System.out.println( s.name + " : " + s.roll );

    }

    private static void studentWithComparable() {
        //Comparable
        TreeSet<StudentWithComparable> ts = new TreeSet<>();
        ts.add(new StudentWithComparable(104,"vikash"));
        ts.add(new StudentWithComparable(101,"vicky"));
        ts.add(new StudentWithComparable(103,"santosh"));
        ts.add(new StudentWithComparable(102,"kapil"));

        // Implementation below will throw exception as the Student
        // Class has not implemented Comparable, nor any Comparator
        // has been implemented inorder to sort the data and display
        // sorted data in TreeSet. Either the Class Student as data
        // MUST implement a c
        // Exception in thread "main" java.lang.ClassCastException: basics.Student cannot be cast to java.base/java.lang.Comparable

        // Implementation same as above for loop.
        Iterator<StudentWithComparable> itr = ts.iterator();
        while( itr.hasNext() ) {
            StudentWithComparable aStudent = itr.next();
            System.out.println( aStudent.name + " : " + aStudent.roll );
        }
    }

    private static void defaultEmployeeSort() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Roma", "Baglung"));
        list.add(new Employee(105, "Pinky", "Pokhara"));
        list.add(new Employee(107, "Anit", "Dharan"));
        list.add(new Employee(103, "Anit", "Kathmandu"));
        list.add(new Employee(104, "Zeena", "Zumla"));
        Collections.sort(list);
        System.out.println(list);
    }

    private static void callEmployeeSortedByName() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Roma", "Baglung"));
        list.add(new Employee(105, "Pinky", "Pokhara"));
        list.add(new Employee(107, "Anit", "Dharan"));
        list.add(new Employee(103, "Anit", "Kathmandu"));
        list.add(new Employee(104, "Zeena", "Zumla"));
        Collections.sort(list, Employee.COMPARE_BY_NAME);
        System.out.println(list);
    }
//    List<Employee> e = new ArrayList<Employee>(employees);

}


/**
 * This is a sample of the Student Class that
 * implements Comparable class.
 */
class StudentWithComparable implements Comparable<StudentWithComparable> {

    int roll;
    String name;

    StudentWithComparable(int roll, String name) {
        this.roll=roll;
        this.name=name;
    }

    /**
     * Decending Order!
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(StudentWithComparable o) {
        if ( roll < o.roll) {
            return 1;
        } else if (roll > o.roll) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString(){
        return roll + "  "+name;
    }

}


/**
 * A separate Comparator class passed with the
 * comparision logic implemented at function
 * compare().
 */
class ComparatorImpl implements Comparator {

    /**
     * Ascending Order
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;

        if(s2.roll < s1.roll)
            return 1;
        else if(s2.roll > s1.roll)
            return -1;

        return 0;
    }
}


/**
 * This is a simple Student Class without any
 * Comparable functionality. The comparing logic
 * is implemented separately.
 */
class Student {

    int roll;
    String name;

    Student(int roll, String name) {
        this.roll=roll;
        this.name=name;
    }

    @Override
    public String toString(){
        return roll + "  "+name;
    }
}


/**
 * Comparable implementation in separate class.
 *
 * The Employee as a new data structure must implement
 * the Comparable interface inorder to be sorted and
 * iterable.
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

    @Override
    public int compareTo(Employee o) {
        if ( id > o.id ) {
            return 1;
        } else if ( id < o.id ) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Sort by Employee's name in ascending order.
     * If the names are same then sort by id.
     *
     * @param o1
     * @param o2
     * @return
     */
    public static Comparator<Employee> COMPARE_BY_NAME = new Comparator<Employee>() {
        public int compare(Employee o1, Employee o2) {
            Employee e1 = (Employee)o1;
            Employee e2 = (Employee)o2;

            int nameCmp = e1.name.compareTo(e2.name);
            if ( nameCmp != 0 )
                return nameCmp;

            return (e1.id < e2.id ? -1 :
                    (e1.id == e2.id ? 0 : 1));
        }
    };


    @Override
    public String toString() { return " \n Employee [id=" + id + ", name=" + name + ", address=" + address + "]\n"; }
}
