package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Probelem:
 * https://www.hackerrank.com/challenges/picking-numbers/
 * Another solution: https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Implementation/Picking%20Numbers/Solution.java#L26
 */
public class PickingNumbers {

    public static void main(String[] args) {

//        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 2));//5
        List<Integer> a = new ArrayList<>(Arrays.asList(4, 6, 5, 3, 3, 1, 4)); //3

        pickingNumbers(a);
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int mainCount = 0;

        // The numbers being compared are 2.
        // So if they are equal, the initial
        // value must be 2. Hence initially,
        // count is set to 1.
        int tempCount = 1;

        Collections.sort(a);
        int initialValue = a.get(0);

        a.forEach( (val)->System.out.print(" " + val));

        for ( int i = 0; i < a.size() - 1; i++ ) {

            if ( Math.abs( initialValue - a.get(i + 1) ) == 1
                 || Math.abs( initialValue - a.get(i + 1) ) == 0
                    ) {
                tempCount++;

                if (tempCount > mainCount) mainCount = tempCount;

            } else {
                initialValue = a.get(i + 1);
                tempCount = 1;
            }
        }

        System.out.println("  : " + mainCount);

        return mainCount;
    }


}
