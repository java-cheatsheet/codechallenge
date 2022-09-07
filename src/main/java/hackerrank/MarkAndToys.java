package hackerrank;

import java.util.Arrays;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/mark-and-toys
 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some.
 * There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.
 * Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy?
 *
 */
public class MarkAndToys {

    public static void main(String args[]) {
        toyCount4();
    }

    public static void toyCount4() {
        int[] prices = {1, 12, 5, 111, 200, 1000, 10, 10};
        int amountToSpend = 50;
        int result = maximumToys( prices, amountToSpend );
        int expected = 5;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    /**
     * This is the solution tha passed time constraints in hackerrank.
     * It uses two pointers scanning from front.
     *
     * T = O(N)
     *
     * @param k
     * @param prices
     * @return
     */
    public static int maximumToys( int[] prices, int k ) {
        Arrays.sort(prices);
        int arrLen = prices.length - 1;
        int i=0;
        int j=1;
        int maxToys =0;
        int sum = prices[i];
        int toysCount = 1;

        while( j < arrLen )  {
            sum +=prices[j];

            if ( sum <= k ) {
                toysCount++;
                j++;

                // Assumption: There is no point to look forward to
                // when the maximum length is covered already.
                if ( j > arrLen - i+1 ) break;

            } else if ( sum > k ) {
                sum = prices[i++];
                toysCount = 1;
            }

            if ( toysCount > maxToys ) maxToys = toysCount;
            if ( i == arrLen ) break;

        }

        return  maxToys;
    }


}
