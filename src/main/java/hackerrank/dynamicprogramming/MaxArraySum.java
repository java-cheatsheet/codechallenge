package hackerrank.dynamicprogramming;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/max-array-sum/problem
 *
 * Given an array of integers, find the subset of non-adjacent
 * elements with the maximum sum. Calculate the sum of that
 * subset.
 *
 * Example : 3 7 4 6 5, maximum subset sum is 13.
 */
public class MaxArraySum {

    public static void main(String[] args) {
        validTestCase2();
    }

    public static void validTestCase2() {
        int[] a = {3, 5, -7, 8, 10};
        long result = maxSubsetSum(a);
        long expected = 15;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    /**
     * Explanation of the solution by williamlemens at the forum - https://www.hackerrank.com/challenges/max-array-sum/forum
     " I can explain how it works.

     Firstly, my assumption that you won't use this array again is significant,
     as this solution overwrites the initial values. You can circumvent this by
     simply using a temporary array to store updated values.

     arr[0] = Math.max(0, arr[0]);

     This is where my assumption that the empty set is a valid subset comes into
     play. Were we to only consider subsets of size >= 1, we'd have to concern
     ourselves with finding the least negative number in an array of purely
     negative numbers. However, since we can use the empty set, 0 is a valid sum
     for an array of purely negative integers.

     arr[1] = Math.max(arr[0], arr[1]);

     Getting setup for the actual iteration.

     for (int i = 2; i < arr.length; i++) arr[i] = Math.max(arr[i-1], arr[i]+arr[i-2]);

     This is where the magic happens. Essentially, we sum from arr[0] up to arr[n-1].
     Since we're only concerned with non-sequential subsets, we must choose if we want
     the optimal sum of the previous index, arr[i-1], or to keep the current index's
     value and the optimal sum of non-sequential values before it, arr[i]+arr[i-2].
     Note that at this point, arr[i-1] and arr[i-2] store the optimal sums possible at
     those two locations, not their original values.

     return arr[arr.length-1];

     Finally, we return the maximum sum available at the last index of the array, which
     is simply the max non-sequential subset sum of the whole array. "

     * @param arr
     * @return
     */
    public static int maxSubsetSum(int[] arr) {

        if (arr.length == 0) return 0;
        arr[0] = Math.max(0, arr[0]);

        if (arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++)
            arr[i] = Math.max( arr[i - 1], arr[i] + arr[i - 2] );


        return arr[arr.length-1];
    }

}
