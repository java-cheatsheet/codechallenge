// https://www.hackerrank.com/challenges/java-static-initializer-block

package hackerrank.Java;

import java.util.*;

public class StaticInitializerBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int B = sc.nextInt();
        int H = sc.nextInt();

        if ( B < 1 || B > 100 || H < 1 || H > 100 ) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            System.out.println(B * H);
        }
    }
}
