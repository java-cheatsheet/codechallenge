package hackerrank.greedy;

import java.util.Arrays;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 *
 * Given an array of integers, find and print the minimum
 * absolute difference between any two elements in the array.
 *
 * Solution:
 * There was an issue with test case 2 which had 100000 data with
 * large numbers, ie: 636651840 845593958 514430275 950990774 89897149 679801372 575598744 260814438 500059913 881915491 591284043 454066471 611431220 826515366 49617511 336370744
 * And the answer was 0.
 *
 * I assumed the that this test case failed because of memory overflow
 * problem due to the big number additions but that was not the case.
 * I was confused that there would not be any duplicate values with the
 * statement in the question - " a[i] and a[j] (where i != j) ".
 */
public class MinimumAbsoluteDifferenceInArray {

    public static void main(String[] args) {
        validTestMinVal3();
    }

    public static void validTestMinVal3() {
        int[] arr = {3, -7, 0};
        int expected = 3;
        int result = minimumAbsoluteDifference(arr);
        assert (result == expected) : "testOddData - Result:" + result +" | Expected:" + expected;
    }

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int currentMin = Math.abs(arr[1] - arr[0]);

        if ( currentMin == 0 ) return currentMin;

        int arrLen = arr.length - 1;
        int tempMin;
        //int modVal = 1000000007;

        for (int j = 1; j < arrLen; j++) {

            tempMin = Math.abs(arr[j + 1] - arr[j]);

            if ( tempMin == 0 ) return tempMin;

            if (tempMin < currentMin) currentMin = tempMin;

        }

        return currentMin;
    }

    /**
     * Initial thought process with error in logic.
     */
    static int minimumAbsoluteDifferenceX(int[] arr) {
        // sort arr
        // take the absolute values of i and i+1
        // there may be other min values but we only
        // if the minimum val 1 is not found as i not equal to i+1

        Arrays.sort(arr);
        long currentMin = Math.abs( arr[1] - arr[0] );
        int arrLen = arr.length - 1;
        long tempMin;
        int modVal = 1000000007;

        for ( int j=1; j < arrLen; j++ ) {

            tempMin = Math.abs( arr[ j + 1 ]  - arr[j] % 10000007 );

            if ( tempMin == 1) return (int)tempMin % modVal;

            if ( tempMin < currentMin ) currentMin = tempMin;

        }

        return (int)currentMin % modVal;
    }

}
