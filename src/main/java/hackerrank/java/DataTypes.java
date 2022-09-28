package hackerrank.java;

/**
 * Problem:
 * Out of data types: byte, short, int, and long, check in which the input can be stored in.
 *
 * Print as below if the data type fits in anyone of them
 *  `n can be fitted in:`
 *  `* dataType`
 *
 * If the number cannot be stored in one of the four aforementioned primitives, print the line:
 *  `n can't be fitted anywhere.`
 *
 * Example:
 * Sample Input:
 * 5 // 5 integer inputs
 * -150
 * 150000
 * 1500000000
 * 213333333333333333333333333333333333
 * -100000000000000
 *
 * Sample Output
 * -150 can be fitted in:
 * * short
 * * int
 * * long
 * 150000 can be fitted in:
 * * int
 * * long
 * 1500000000 can be fitted in:
 * * int
 * * long
 * 213333333333333333333333333333333333 can't be fitted anywhere.
 * -100000000000000 can be fitted in:
 * * long
 *
 * Link: https://www.hackerrank.com/challenges/java-datatypes
 */

import java.util.*;

public class DataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            try {
                long n = sc.nextLong();
                System.out.println(n + " can be fitted in:");

                if (( n >= Byte.MIN_VALUE ) && ( n <= Byte.MAX_VALUE ))
                    System.out.println("* byte\n* short\n* int\n* long");

                else if (( n >= Short.MIN_VALUE ) && ( n <= Short.MAX_VALUE ))
                    System.out.println("* short\n* int\n* long");

                else if (( n >= Integer.MIN_VALUE ) && ( n <= Integer.MAX_VALUE ))
                    System.out.println("* int\n* long");

                else
                    System.out.println("* long");
            }
            catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }

        sc.close();

    }
}