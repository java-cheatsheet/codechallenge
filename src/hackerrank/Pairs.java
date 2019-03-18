package hackerrank;

import java.util.Arrays;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/pairs/problem
 * You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value.
 *
 * Function Description
 * Complete the pairs function below. It must return an integer representing the number of element pairs having the required difference.
 *
 */

public class Pairs {

    public static void main(String args[]) {
        validSwapCountEquals5();
        validSwapCountEquals3();
    }

    public static void validSwapCountEquals5() {
        int[] arr = {1, 2, 3, 4, 5, 6, 8}; //1,3; 2,4; 3,5; 4,6, 6,8
        int k = 2;
        int result = pairs(k, arr);
        int expected = 5;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void validSwapCountEquals3() {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;
        int result = pairs(k, arr);
        int expected = 3;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    /**
     * This is the solution tha passed time constraints in hackerrank.
     * It uses two pointers scanning from front.
     *
     * T = O(N)
     *
     * @param k
     * @param arr
     * @return
     */
    public static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int arrLen = arr.length;
        int i=0;
        int j=1;
        int count=0;

        while( j < arrLen )  {
            int diff = arr[j] - arr[i];

            if (diff == k) {
                count++;
                j++;
            } else if (diff > k) {
                i++;
            } else if (diff < k) {
                j++;
            }
        }

        return  count;
    }

    /**
     *  The solution is not optimum and fails due to time out.
     *  T = O(N^2)
     *
     * @param k
     * @param arr
     * @return
     */
    public static int pairsONSquare(int k, int[] arr) {
        Arrays.sort(arr);

        // first forloop to loop over all
        // second forloop to check for pair
        int arrLen = arr.length;
        int pairCount = 0;

        for ( int i = 0; i < arrLen; i++ ) {

            for (int j = i+1; j < arrLen; j++ ) {
                int sum = arr[j] - arr[i];

                if ( sum == k ) pairCount++;
            }
        }

        return pairCount;
    }

    /**
     * This solution does not work.
     *
     * This was the first thought process for the solution with 4 pointers.
     * The idea basically was to explore the array from both ways, i.e.
     * from the front and as well as the back. This got complicated but
     * I believe the solution is near to be found if more time given.
     *
     * @param k
     * @param arr
     * @return
     */
    public static int pairsX(int k, int[] arr) {
        Arrays.sort(arr);

        int arrLen = arr.length - 1;
        int arrBack = arrLen;
        int arrFront = 0;
        int pairsCount = 0;
        int fi = 1;
        int bj = arrBack - 1;

        //fi != arrFront && bj != arrBack
        while ( arrBack > arrFront ) {

            if ( bj < 0 ) {
                arrBack--;
                bj = arrBack - 1;
            }

            if ( fi > arrLen + 1 ) {
                arrFront++;
                fi = arrFront + 1;
            }

            int frontSum = arr[fi] - arr[arrFront];

            if ( frontSum > k ) {
                arrFront++;
                fi = arrFront + 1;

            } else if ( frontSum == 2 ) {
                pairsCount++;

                if ( arr[arrFront] == arr[arrFront + 1] ) {
                    arrFront = arrFront + 2;
                    pairsCount++;
                }

                fi++;
            } else {
                fi++;
            }

            int backSum = arr[arrBack] - arr[bj];

            if ( backSum > k ) {
                arrBack--;
                bj = arrBack - 1;

            } else if ( backSum == 2 && fi < arrBack ) {

                if ( arr[arrBack] == arr[arrBack - 1] ) {
                    arrBack = arrBack - 2;
                    pairsCount++;
                }
                pairsCount++;

            } else {
                bj--;
            }
        }

        return pairsCount;
    }
}
