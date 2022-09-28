package hackerrank.java;

import java.util.Scanner;

/**
 * Problem:
 * Input Format
 * There are three lines of input:
 *     The first line contains an integer.
 *     The second line contains a double.
 *     The third line contains a String.
 *
 * Output Format
 * There are three lines of output:
 * On the first line, print String: followed by the unaltered String read from stdin.
 * On the second line, print Double: followed by the unaltered double read from stdin.
 * On the third line, print Int: followed by the unaltered integer read from stdin.
 *
 * Note: If you use the nextLine() method immediately following the nextInt() method,
 * recall that nextInt() reads integer tokens; because of this, the last newline
 * character for that line of integer input is still queued in the input buffer and
 * the next nextLine() will be reading the remainder of the integer line (which is empty).
 *
 * Sample Input
 * 42
 * 3.1415
 * Welcome to HackerRank's Java tutorials!
 *
 * Sample Output
 * String: Welcome to HackerRank's Java tutorials
 * Double: 3.1415
 * Int: 42
 *
 * Link: https://www.hackerrank.com/challenges/java-stdin-stdout/problem?h_r=next-challenge&h_v=zen
 */
public class StdInOutTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        // Throw away the remaining line
        // left after double token is read
        scan.nextLine();
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}



/**
 * Note
 * Also tried with next()
 * ```
 * double d = scan.nextDouble();
 * String s = scan.next();
 * s += scan.nextLine();
 * ```
 * But this only worked with the sample input of String
 * passing 0 and 1 test cases and failed to others.
 */
