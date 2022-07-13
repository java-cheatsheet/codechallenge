package datastructures;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

class Printer <T> {
    /**
     *    Method Name: printArray
     *    Print each element of the generic array on a new line. Do not return anything.
     *    @param A generic array
     **/

    // Write your code here
    public void printArray(T[] t) {
        for(int i=0; i<t.length; i++) {
            System.out.println(t[i]);
        }
    }
}

public class GenericExample {

    public static void main(String args[]){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        Integer[] intArray = {1,2,3,4};
//        for (int i = 0; i < n; i++) {
//            intArray[i] = scanner.nextInt();
//        }

//        n = scanner.nextInt();
        String[] stringArray = {"a","b","c","d"};
//        for (int i = 0; i < n; i++) {
//            stringArray[i] = scanner.next();
//        }

        Printer<Integer> intPrinter = new Printer<Integer>();
        intPrinter.printArray( intArray  );

        Printer<String> stringPrinter = new Printer<String>();
        stringPrinter.printArray( stringArray );
        Method[] methods = Printer.class.getDeclaredMethods();

        for (Method method: methods) {
          System.out.println(method.getName());
        }

        if(Printer.class.getDeclaredMethods().length > 1){
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
    }
}
