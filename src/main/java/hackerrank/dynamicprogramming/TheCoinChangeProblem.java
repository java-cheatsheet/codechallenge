package hackerrank.dynamicprogramming;

import java.util.HashMap;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/coin-change/problem
 *
 * You are working at the cash counter at a fun-fair, and you have
 * different types of coins available to you in infinite quantities.
 * The value of each coin is already given. Can you determine the
 * number of ways of making change for a particular number of units
 * using the given types of coins?
 *
 * For example, if you have 4 types of coins, and the value of each
 * type is given as 8, 3, 1, 2 respectively, you can make change for
 * 3 units in three ways: {1, 1, 1}, {1, 2} and {3}.
 *
 *
 * Solution:
 * The problem is resolved with the code from the video below:
 * https://www.youtube.com/watch?v=sn0DWI-JdNA
 *
 * The problem itself had another issue with output, "~ no response on stdout ~"
 * is because the problem required the solution to write with other modes. The
 * main method had provided hint at the tope with code:
 *
 * BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 *
 * So it required to use this method to print the answered returned to the main
 * method and resolved the issue with code:
 *
 * bufferedWriter.write(String.valueOf(ways));
 *
 * Still I am not very much comfortable with the implementation  of the
 * GayleMcDowellSolution recursion!
 *
 * Other Solutions:
 * https://www.techiedelight.com/coin-change-making-problem-unlimited-supply-coins/
 *
 * https://cs.stackexchange.com/questions/105313/dynamic-pseudo-code-for-simplified-coin-changing-algorithm
 *
 */
public class TheCoinChangeProblem {

    // Driver program to test above function
    public static void main(String[] args) {

//        RepresentingNCents objRNC = new RepresentingNCents();
//        objRNC.makeChange(10);
//        System.out.println( countTabulated(c, c.length, n) );

        validGMSol3Ways();
    }

    public static void validGMSol3Ways () {
        long[] c = {8, 3, 1, 2};
        long n = 3;

        GayleMcDowellSolution solution = new GayleMcDowellSolution();
        long result = solution.makeChange(n, c);
        long expected = 3;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

}


class GayleMcDowellSolution {

    public long makeChange(long n, long[] c) {
        return makeChange(c, n, 0, new HashMap<String, Long>());
    }

    public long makeChange(long[] coins, long money, int index, HashMap<String, Long> memo) {
//        System.out.println("Coin: " + coins[index]);
        System.out.println("Money: " + money);
        System.out.println("Index: " + index);

        if ( money == 0 ) return 1;

        if ( index >= coins.length ) return 0;

        String key =  money + "-" + index;
        if(memo.containsKey(key)) return memo.get(key);

        long amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money) {
            long remaining = money - amountWithCoin;
            ways += makeChange(coins, remaining, index + 1, memo);
            amountWithCoin += coins[index];
            System.out.println("AmountWithCoin: " + amountWithCoin);
        }

        memo.put(key, ways);
        return ways;
    }
}

class OtherWays {
//    static long getWaysA(long n, long[] c) {
//        int N = 255;
//        int m = c.length;
//        long dp[] = new long[N];
//        // Base case (If given value is 0)
//        dp[0] = 1L;
//
//        // Pick all coins one by one and update the table[] values
//        // after the index greater than or equal to the value of the
//        // picked coin
//        for( long i=0; i < m; i++) {
//
//            for (long j = c[i]; j <= n; j++) {
//                long interMSum = j - c[i];
//                //table[j] = table[ i - 1 ] + table[ interMSum ];
//                dp[j] += dp[interMSum];
//            }
//        }
//        return dp[n];
//
//    }

    public static long countTabulated(long[] c, int m, long n ) {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        long[] table = new long[(int) n + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int i = 0; i < m; i++) {
            System.out.println("i: " + i);

            for (long j = c[i]; j <= n; j++) {

                System.out.println("j: " + (int)j);
                long aa = j - c[i];
                table[(int) j] += table[(int) aa];

                System.out.println("table: " + table[(int) j]);
            }
        }


        return table[(int)n];
    }

    static int countX(long[] S, long m, long n )
    {
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions
        // (i) including S[m-1]
        // (ii) excluding S[m-1]

        System.out.println(m + " m:n " + n);
        return ( countX( S, m - 1, n ) + countX( S, m, n - S[(int)m - 1] ) );
    }

    // Returns the count of ways we can
    // sum S[0...m-1] coins to get sum n
    static int count(int[] S, int m, int n )
    {
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions
        // (i) including S[m-1]
        // (ii) excluding S[m-1]
        return count( S, m - 1, n ) + count( S, m, n - S[m-1] );
    }


}


class RepresentingNCents {

    int makeChange(int n) {
        int[] denoms =  {2, 5, 3, 6};//{25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length]; //precomputed vals
        return makeChange(n, denoms, 0, map);
    }

    int makeChange(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0) { //retrieve value
            return map[amount][index];
        }
        if (index >= denoms.length - 1) return 1; //one denom remaining

        int denomAmount = denoms[index];
        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            //go to next denom, assuming i coints of denomAmount
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }
}

