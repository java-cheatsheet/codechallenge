package hackerrank.Greedy;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/two-arrays/problem
 *
 * The problem needed to be solved with Greedy method.
 */
public class PermutingTwoArrays {

    public static void main(String args[]) {
        validTestFor10();
        validTestFor5();
    }

    public static void validTestFor5() {
        int k = 5;
        int[] A = {1,2,2,1};
        int[] B = {3,3,3,4};
        String result = twoArrays(k, A, B);
        String expected = "NO";
        assert (result.equals(expected)) : "testOddData - Result:" + result +" | Expected:" + expected;
    }

    public static void validTestFor10() {
        int k = 10;
        int[] A = {7, 6, 8, 4, 2};
        int[] B = {5, 2, 6, 3, 1};
        String result = twoArrays(k, A, B);
        String expected = "NO";
        assert (result.equals(expected)) : "testOddData - Result:" + result +" | Expected:" + expected;
    }


    static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int lenA = A.length;

        for (int i = 0;  i < lenA; i++ ) {

            if ( A[i] + B[ (lenA - 1) - i ] < k ) return "NO";
        }

        return "YES";
    }


}
