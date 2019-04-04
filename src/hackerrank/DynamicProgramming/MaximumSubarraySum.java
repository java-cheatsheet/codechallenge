package hackerrank.DynamicProgramming;

import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Problem:
 * This topic, Prefix Sum, came to my attention when I was resolving a problem from
 * Maximum Subarray Sum in Hackerrank.com.
 *
 * Link: https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
 *
 * We define the following:
 * A subarray of array a of length n is a contiguous segment from a[i] through a[j] where 0 <= i < j < n.
 *
 * The sum of an array is the sum of its elements.
 * Given an n element array of integers, a, and
 * an integer, m, determine the maximum value of
 * the sum of any of its subarrays modulo m.
 *
 * Function Description:
 * Complete the maximumSum function in the editor below.
 * It should return a long integer that represents the
 * maximum value of subarray sum % m.
 *
 * maximumSum has the following parameter(s):
 *     a: an array of long integers, the array to analyze
 *     m: a long integer, the modulo divisor
 *
 * Solution:
 * 1. https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
 * 2. Another solution was found in hackerrank submission.
 *
 */
public class MaximumSubarraySum {

    public static void main(String args[]) {

        validMod7();
    }

    public static void validMod2() {
        long[] a = {1, 2, 3};
        long m = 2L;
        long result = maximumSum(a, m);
        long expected = 1;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void validMod7() {
        long[] a = {3, 3, 9, 9, 5};
        long m = 7L;
        long result = maximumSum(a, m);
        long expected = 6L;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    /**
     *
     * Time Complexity O(N)
     * Solution takes max approach.
     *
     * @param a
     * @param m
     * @return
     */
    static long maximumSum(long[] a, long m) {
        long maxSum=0;
        TreeSet<Long> prefixSet = new TreeSet<>();
        long currentSum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            currentSum = ( currentSum + a[i] % m ) %m;
            SortedSet<Long> set = prefixSet.tailSet(currentSum + 1 );
            Iterator<Long> itr = set.iterator();

            if( itr.hasNext() ) {
                maxSum = Math.max( maxSum, ( currentSum - itr.next() + m ) %m );
            }


            maxSum = Math.max( maxSum, currentSum );

            prefixSet.add(currentSum);
        }

        return maxSum;
    }

    /**
     * Found this another approach while analysing maximumSum.
     * Added this solution as a reference. This solution takes
     * Math.min() approach.
     *
     * Time Complexity O(N)
     *
     *
     * @param a
     * @param m
     * @return
     */
    public static long computeMaxModSum(long[] a, long m){
        int n = a.length;
        long cur = 0;
        TreeSet<Long> set = new TreeSet<>();
        long minValue = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            cur = ( cur + a[i] ) % m;
            minValue = Math.min( minValue, m - cur );

            if( (set != null) && (!set.tailSet(cur,false).isEmpty())){
                long temp = set.tailSet(cur,false).first();
                minValue = Math.min(minValue, temp - cur);
            }
            set.add(cur);

            if( minValue == 1 ){ return m - minValue; }
        }

        return m - minValue;
    }

    /**
     * DOES NOT PASS SUBMISSION yet!
     *
     * This soultion run first 3 tests but fails all the solution
     * when run.
     *
     * I was reviewing Kadane's algorithm, and as this problem was
     * also trying to subarray sum problem.
     * @param a
     * @param m
     * @return
     */
    static long getMaximumSumOfAllSubarraysFromArray( long[] a, long m) {
        long currentMaximum = 0;
        long overallMaximum = 0;

        for (final long arrayItem : a) {
            currentMaximum =  (( currentMaximum % m )  + ( arrayItem % m )) % m;

            if (currentMaximum > 0)
                overallMaximum = Math.max(overallMaximum, currentMaximum);
            else
                currentMaximum = 0;
        }

        if( overallMaximum == 1 ){ return m - overallMaximum; }

        return overallMaximum;
    }

    /**
     * This was the first naive brut force approach with time complexity O(N^2)
     * Time Complexity O(N^2)
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

/**
 * initialize a list S to contain one element 0.
 *  for each i from 1 to N do
 *    let T be a list consisting of xi + y, for all y in S
 *    let U be the union of T and S
 *    sort U
 *    make S empty
 *    let y be the smallest element of U
 *    add y to S
 *    for each element z of U in increasing order do
 *       //trim the list by eliminating numbers close to one another
 *       //and throw out elements greater than s
 *      if y + cs/N < z ≤ s, set y = z and add z to S
 *  if S contains a number between (1 − c)s and s, output yes, otherwise no
 */
