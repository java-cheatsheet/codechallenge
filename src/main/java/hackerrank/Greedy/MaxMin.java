package hackerrank.Greedy;

import java.util.Arrays;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/angry-children/problem
 *
 * You will be given a list of integers, arr, and a single integer k.
 * You must create an array of length k from elements of arr such that
 * its unfairness is minimized. Call that array subarr. Unfairness of
 * an array is calculated as:
 * Max(subarr) - Min(subarr)
 *
 * Complete the maxMin function in the editor below. It must return
 * an integer that denotes the minimum possible value of unfairness.
 *
 */
public class MaxMin {

    public static void main(String args[]) {
        validTestCase2();
    }

    private static void validTestCase2() {
        int[] arr = { 10,100,300,200,1000,20,30 };
        int expected = 20;
        int result = maxMin(3, arr);
        assert (result == expected) : "testOddData - Result:" + result +" | Expected:" + expected;
    }

    /**
     * Valid Test Case
     */
    private static void validTestCase1() {
        int[] arr = { 1,2,3,4,10,20,30,40,100,200};
        int expected = 3;
        int result = maxMin(4, arr);
        assert (result == expected) : "testOddData - Result:" + result +" | Expected:" + expected;
    }


    static int maxMin(int k, int[] arr) {
        /**
         * Pseudo Code
         * - sort the arr
         * - create a sub array with k integers from arr
         * - get min and max
         * - get diff
         */
        int arrLen = arr.length;
        Arrays.sort(arr);
        int[] subArr = Arrays.copyOfRange(arr, 0, k);
        int minUnfairness = subArr[k - 1] - subArr[0];

        for ( int j = 1; j < arrLen - k + 1; j++ ) {

            subArr = Arrays.copyOfRange(arr, j, j+k);

            int tempMinUnfairness = subArr[ k - 1 ] - subArr[0];

            if ( tempMinUnfairness < minUnfairness ) {
                minUnfairness = tempMinUnfairness;
            }
        }

        return  minUnfairness;
    }


    /**
     * https://codereview.stackexchange.com/questions/217495/minmax-problem-implementation/217504#217504
     *
     * The maxMin() is reviewed at codereview and the below solution
     * was provided.
     *
     * @param k
     * @param arr
     * @return
     */
    static int maxMinReviewed(int k, int[] arr) {
        int arrLen = arr.length;
        //1)Make Sorted Local Copy to prevent Side Effects
        int[] localArr = Arrays.copyOf(arr, arrLen);
        Arrays.sort(localArr);

        int minUnfairness = Integer.MAX_VALUE;
        //2)Loop while maintaining two pointers
        // NOTE: we use J instead to prevent side effects on the int k
        int i = 0;
        int j = k - 1;
        while(j < arrLen){
            int tempMinUnfairness = localArr[j] - localArr[i];
            if ( tempMinUnfairness < minUnfairness ) {
                minUnfairness = tempMinUnfairness;
            }
            i++;
            j++;
        }
        return  minUnfairness;
    }
}
