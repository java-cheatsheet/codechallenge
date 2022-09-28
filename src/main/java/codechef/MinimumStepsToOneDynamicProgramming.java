package codechef;

/**
 * Problem:
 *
 * https://www.codechef.com/wiki/tutorial-dynamic-programming
 *
 * On a positive integer, you can perform any one of the following 3 steps.
 * 1.) Subtract 1 from it. ( n = n - 1 )  ,
 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  ,
 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
 *
 * Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
 *
 * eg:
 * 1.) For n = 1 , output: 0
 * 2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )
 * 3.) For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
 *
 * Solution:
 *
 * Approach / Idea: One can think of greedily choosing the step,
 * which makes n as low as possible and continue the same, till
 * it reaches
 *
 * 1. If you observe carefully, the greedy strategy
 * doesn't work here. Eg: Given n = 10 ,
 * Greedy --> 10 /2 = 5  -1 = 4  /2 = 2  /2 = 1  ( 4 steps ).
 *
 * But the optimal way is --> 10  -1 = 9  /3 = 3  /3 = 1 ( 3 steps ).
 *
 * So, we need to try out all possible steps we can make for each
 * possible value of n we encounter and choose the minimum of these
 * possibilities.
 *
 * It all starts with recursion :).
 * F(n) =   1 + min{  F(n-1) ,  F(n/2)  ,  F(n/3)  }  if (n>1) ,
 * else 0  ( i.e., F(1) = 0 ) .
 *
 * Now that we have our recurrence equation, we can right way start
 * coding the recursion. Wait.., does it have over-lapping subproblems?
 * YES. Is the optimal solution to a given input depends on the optimal
 * solution of its subproblems? Yes... Bingo ! its DP :) So, we just
 * store the solutions  to the subproblems we solve and use them later
 * on, as in memoization.. or we start from bottom and move up till the
 * given n, as in dp. As its the very first problem we are looking at here,
 * lets see both the codes.
 *
 */
public class MinimumStepsToOneDynamicProgramming {

    public static void main(String[] args) {
        int positiveInt = 7;
        int expected = 3;

        int result = MemoizationTopDownSolution.getMinSteps(positiveInt);
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;

        result = BotomUpSolution.getMinSteps(positiveInt);
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }
}



class MemoizationTopDownSolution {

    static int getMinSteps(int n) {
        int[] memo = new int[n + 1]; // we will initialize the elements to -1 ( -1 means, not solved it yet )

        for ( int i = 0; i <= n; i++ )
            memo[i] = -1;


        return getMinStepsRec(n, memo);
    }

    static int getMinStepsRec( int n, int[] memo ) {

        if ( n == 1 )  return 0;  // base case

        if( memo[n] != -1 ) return memo[n];  // we have solved it already :)

        int r = 1 + getMinStepsRec( n - 1, memo );  // '-1' step .  'r' will contain the optimal answer finally

        if( n%2 == 0 )   r  =  Math.min( r , 1 + getMinStepsRec( n / 2, memo ) ) ;  //  '/2' step

        if( n%3 == 0 )   r  =  Math.min( r , 1 + getMinStepsRec( n / 3, memo ) ) ;  //  '/3' step

        memo[n] = r ;  // save the result. If you forget this step, then its same as plain recursion.

        return r;

    }


}


/**
 * Bottom-Up DP
 */
class BotomUpSolution {

    static int getMinSteps(int n) {
        int[] dp = new int[n + 1]; // we will initialize the elements to -1 ( -1 means, not solved it yet )

        for ( int i = 0; i <= n; i++ )
            dp[i] = -1;

        dp[1] = 0;  // trivial case

        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];

            if (i % 2 == 0) dp[i] = Math.min( dp[i], 1 + dp[i / 2]);

            if (i % 3 == 0) dp[i] = Math.min( dp[i], 1 + dp[i / 3]);
        }

        return dp[n];
    }


}