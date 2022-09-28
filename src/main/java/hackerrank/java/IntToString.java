// https://www.hackerrank.com/challenges/java-int-to-string/

package hackerrank.java;

import java.util.Scanner;

public class IntToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if ( num < -100 || num > 100 ) {
            System.out.println("Wrong answer");
        } else {
            System.out.println("Good job");
        }
    }
}
