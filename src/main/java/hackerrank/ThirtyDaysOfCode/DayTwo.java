package hackerrank.ThirtyDaysOfCode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/30-data-types/problem
 *
 * Input Format:
 *  The first line contains an integer that you must sum with .
 *  The second line contains a double that you must sum with .
 *  The third line contains a string that you must concatenate with .
 *
 * Read different dataypes and print them.
 */
public class DayTwo {

    public static void main(String[] args) {
        solution();
    }

    /**
     * This is the solution.
     */
    private static void solution() {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int nextInt = scan.nextInt();
        double nextDouble = scan.nextDouble();

        // Escape epmty line.
        scan.nextLine();
        s += scan.nextLine();

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + nextInt);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d + nextDouble);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */

        // this is functional but is inefficient
        // because we do not need to loop
        //while (scan.hasNext()) s += scan.next() + " ";
        System.out.println(s);
        scan.close();
    }
}