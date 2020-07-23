package basics;

import java.util.Scanner;

/**
 * https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
 * https://www.geeksforgeeks.org/scanner-class-in-java/
 */
public class ScannerExamples {

    public static void main(String[] args) {
//        getINT();
//        getString();
        takeMixInputs();
    }

    private static void getINT() {
        // Declare an object and initialize with
        // predefined standard input object
        Scanner sc = new Scanner(System.in);

        // Initialize sum and count of input elements
        int sum = 0, count = 0;

        // Check if an int value is available
        while (sc.hasNextInt())
        {
            // Read an int value
            int num = sc.nextInt();
            sum += num;
            count++;
        }
        int mean = sum / count;
        System.out.println("Mean: " + mean);
    }

    private static void getString() {
        Scanner sc = new Scanner(System.in);

        // When the first input is INT, the below statements work.
        // But if the first input is STRING, it does not work and
        // throws exception java.util.InputMismatchException
//        int num = sc.nextInt();
//        String inputStr = sc.nextLine();
//        System.out.println( num + inputStr );

        //-----------------
        // On the other hand, the below statements works as we are
        // not specifying the type of input for the first input.
        // The second input is only been assigned INT.
        String inputStr2 = sc.nextLine();
        int num2 = sc.nextInt();
        System.out.println( num2 + inputStr2 );

    }

    public static void takeMixInputs() {
        // Declare the object and initialize with
        // predefined standard input object
        Scanner sc = new Scanner(System.in);

        // String input
        String name = sc.nextLine();

        // Character input
        char gender = sc.next().charAt(0);

        // Numerical data input
        // byte, short and float can be read
        // using similar-named functions.
        int age = sc.nextInt();
        long mobileNo = sc.nextLong();
        double cgpa = sc.nextDouble();

        // Print the values to check if input was correctly obtained.
        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Age: "+age);
        System.out.println("Mobile Number: "+mobileNo);
        System.out.println("CGPA: "+cgpa);
    }

    public void readContinously() {
        Scanner scanner = new Scanner(System.in);
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i = 1; scanner.hasNext() == true; i++) {
            System.out.println( i + " " + scanner.nextLine() );
        }

        scanner.close();
    }

}
