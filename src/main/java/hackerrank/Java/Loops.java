package hackerrank.Java;

import java.util.*;
import java.io.*;

/**
 * Problem:
 * Series: (a + 2^0 * b), (a + 2^0 * b + 2^1 * b ), ..., (a + 2^0 * b + ... + 2^n-1 * b )
 *
 * Print each element of the series as a single line of space-separated values.
 *
 * Link: https://www.hackerrank.com/challenges/java-loops
 */
public class Loops {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt(); // 0
            int b = in.nextInt(); // 2
            int n = in.nextInt(); // 10
            int sum = 0;

            for (int j = 0; j < n; j++) {
                sum += Math.pow(2, j) * b;

                System.out.print( a + sum + " ");
            }

            System.out.println();
        }
        in.close();
    }
}
