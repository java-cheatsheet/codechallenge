package hackerrank.Mathematics;

import geeksforgeeks.dynamicprogramming.UglyNumbers;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/summing-the-n-series/problem
 *
 * You are given a sequence whose n^{th} term is
 * T_n = n^2 - (n - 1)^2
 *
 * You have to evaluate the series
 * S_n = T_1 + T_2 + T_3 + ... + T_n
 *
 * Find S_n mod (10^9 7).
 *
 * We could try to just bruteforce a solution like this
 *
 * sum = 0
 * for i in range(1, n+1):
 *     sum += i*i - (i-1)*(i-1)
 *
 * return sum % 1000000007
 *
 * However, as n can go up to 10^16, that is not really a
 * viable solution and when I tried I got a timeout on
 * most of the problems evaluated. So lets look at the
 * series.
 *
 * Substituting the value of T_n in the sum of series S_n,
 *
 * S1 = t1 = 1^2 - (n-1)^2 =1
 * S2 = t1 + t2 = 1 + 2^2 -(2-1)^2 = 1+4-1 = 4 = 2^2
 * S3 = S2 + t3 = 4 + 3^2 - (3-1)^2 = 4 + 9 - 4 = 9 = 3^2
 *
 * Therefore we end up with:
 *
 * S_n = n^2
 *
 * and thus we can write the code as:
 *
 * return n*n % 1000000007
 *
 */
public class SumingTheNSeries {

    /**
     * Three variations of the solutions are presented
     * but I have not had tine to figure out which one
     * the best in terms of Time/Space.
     *
     * @param args
     */
    public static void main(String args[])
    {
        long n = 10;
        summingSeriesVar1(n);
    }

    /**
     * ACCEPTED
     *
     */
    static int summingSeriesVar1(long n) {
        long cc =  ( n % 1000000007 );
        int square = (int)(( cc * cc ) % 1000000007);

        return square;
    }

    /**
     * ACCEPTED
     *
     */
    static int summingSeriesVar2(long n) {
        return (int)((( n % 1000000007 ) * ( n % 1000000007 )) % 1000000007);

    }

    /**
     * UNACCEPTED
     * Failed TEST Cases 3 to 6 while submission.
     */
    static int summingSeriesVar33(long n) {
        int cc = (int)( n % 1000000007 ) ;
        return (int) Math.pow( cc, 2);

        // OR
        // return (int) Math.pow( (int)( n % 1000000007 ), 2);
    }

}
