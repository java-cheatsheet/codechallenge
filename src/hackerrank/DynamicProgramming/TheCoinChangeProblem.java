package hackerrank.DynamicProgramming;

import java.util.Arrays;

public class TheCoinChangeProblem {

    // Driver program to test above function
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println( countTabulated(arr, m, 4) );

    }

    public static int countTabulated( int c[], int m, int n )
    {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int table[]=new int[n+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for( int i = 0; i<m; i++ )
            for( int j = c[i]; j <= n; j++)
                table[j] += table[j - c[i]];

        return table[n];
    }


    // Returns the count of ways we can
    // sum S[0...m-1] coins to get sum n
    static int count( int S[], int m, int n )
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

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) +
                count( S, m, n-S[m-1] );
    }


}
