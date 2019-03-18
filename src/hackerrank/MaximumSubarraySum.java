package hackerrank;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
 *
 * Find the max m modulo of subarray a.
 *
 */
public class MaximumSubarraySum {

    public static void main(String args[]) {

        maxMod1();
    }

    public static void maxMod1() {
        long[] a = {1, 2, 3};
        long m = 2L;
        long result = maximumSum(a, m);
        long expected = 1;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    /**
     *
     * @param a
     * @param m
     * @return
     */
    static long maximumSum(long[] a, long m) {
        long maxSum=0;
        TreeSet<Long> prefix = new TreeSet<>();
        long currentSum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            currentSum = ( currentSum + a[i] % m ) %m;
            SortedSet<Long> set = prefix.tailSet(currentSum + 1 );
            Iterator<Long> itr = set.iterator();

            if( itr.hasNext() ) {
                maxSum= Math.max( maxSum, ( currentSum-itr.next() + m ) %m );
            }

            maxSum = Math.max( maxSum, currentSum );

            prefix.add(currentSum);
        }


        return maxSum;

    }

    /**
     * This was the first naive brut force approach with time complexity O(N^2)
     *
     * @param a
     * @param m
     * @return
     */
    static long maximumSumTrivial(long[] a, long m) {
        long maxMod = 0;
        int aLen = a.length;

        for ( int i = 0; i < aLen; i++ ) {
            long tempSum = a[i];
            long tempMod = tempSum % m;

            for ( int j = i + 1; j < aLen; j++ ) {
                tempSum += a[j];
                tempMod = tempSum % m;

                if ( tempMod > maxMod ) maxMod = tempMod;
            }
        }

        return maxMod;
    }

}
