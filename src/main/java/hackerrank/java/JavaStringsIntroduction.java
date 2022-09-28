/**

 Given two strings of lowercase English letters,
 A and B, perform the following operations:
 1. Sum the lengths of A and B
 2. Determine if A is lexicographically larger
 than B (i.e.: does come before in the dictionary?).
 3. Capitalize the first letter in A and B
 and print them on a single line, separated by a space.

 */

package hackerrank.java;

import java.util.Scanner;

public class JavaStringsIntroduction {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        int aLen = A.length();
        int bLen = B.length();

        System.out.println(aLen + bLen);

        if ( A.compareTo(B) > 0 )
            System.out.println("Yes");
        else System.out.println("No");

        StringBuilder builder = new StringBuilder();
        String[] aStr = A.split("");
        String[] bStr = B.split("");

        for (int i = 0; i < aLen; i++) {

            if (i == 0)
                builder.append(aStr[i].toUpperCase());
            else builder.append(aStr[i]);
        }

        builder.append(" ");

        for (int ii = 0; ii < bLen; ii++) {

            if (ii == 0)
                builder.append(bStr[ii].toUpperCase());
            else builder.append(bStr[ii]);
        }

        System.out.println(builder);
    }

}
