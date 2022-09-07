package hackerrank.BackTracking;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/
 *
 * Davis has a number of staircases in his house and he likes
 * to climb each staircase or steps at a time. Being a very
 * precocious child, he wonders how many ways there are to
 * reach the top of the staircase.
 *
 * Given the respective heights for each of the staircases in
 * his house, find and print the number of ways he can climb
 * each staircase, module 10^9+7 on a new line.
 *
 * For example, there is s = 1 staircase in the house that is n=5
 * steps high. Davis can step on the following sequences of steps.
 * There are 13 possible ways he can take these 5 steps.
 * 13 % 10^9 + 7 = 13.
 *
 * Solution:
 * The solution was visualized from the discussion section.
 * Both solutions provided are functional.
 *
 * Articles to read:
 * http://fusharblog.com/solving-linear-recurrence-for-programming-contest/
 * http://fusharblog.com/solving-linear-recurrence-for-programming-contest-part-2/
 *
 */
public class DavisStaircase {

    public static void main(String args[]) {
        validGMSol3Ways();
    }

    static void validGMSol3Ways () {
        int n = 7;

        RecursiveSolutionWithHashMap obj = new RecursiveSolutionWithHashMap();
        int result = obj.stepPerms(n);
//
//        RecursiveSolutionWithArray obj = new RecursiveSolutionWithArray();
//        int result = obj.stepPerms(n);

        int expected = 44;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

}


class RecursiveSolutionWithHashMap {

    private Map<Integer, Integer> map = new HashMap<>();

    public int stepPerms(int n) {
        if(n < 0)
            return 0;

        if(n == 0)
            return 1;

        if( !map.containsKey(n) ) {
            int count = stepPerms(n-1) + stepPerms(n - 2 ) + stepPerms(n - 3 );
            map.put(n, count);
        }
        return map.get(n);
    }
}


class IterativeSolutionWithArray {
    public static int stepPerms(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        int[] ways = new int[] {1,2,4};

        for ( int i = 4; i < n; i++) {
            int idx = (i - 1) % 3;
            ways[idx] = ways[0] + ways[1] + ways[2];
        }
        return ways[0] + ways[1] + ways[2];
    }
}