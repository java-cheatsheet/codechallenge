package codility.prefixsum;

/**
 * Problem:
 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 *
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * Array A contains only 0s and/or 1s:
 *
 *         0 represents a car traveling east,
 *         1 represents a car traveling west.
 *
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 *
 * For example, consider array A such that:
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 *
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 */

public class PassingCars {

    public static void main(String args[]) {
//        pairs7();
        pairs5();
    }

    static void pairs5() {
        int[] A = {0, 1, 0, 1, 1};
        Object solution = new SolutionOne();
        int result = ((SolutionOne) solution).solution(A);
        int expected = 5;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static void pairs7() {
        int[] A = {0, 1, 0, 0, 1, 1};
        Object solution = new SolutionOne();
        int result = ((SolutionOne) solution).solution(A);
        int expected = 7;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }


}


/**
 * Solution:
 * https://www.martinkysel.com/codility-passingcars-solution/
 *
 * This solution is in the comment by Naoufal Berouain
 */
class SolutionOne {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int count = 0;
        int pairs = 0;

        for (int a : A) {
            if (a == 0) {
                count++;
            } else {
                pairs += count;
            }

            if (pairs > Math.pow(10, 9)) return - 1;
        }

        return pairs;

    }
}

/**
 * Solution:
 * https://bogdankotzev.com/codility-passing-cars-java-solution/
 *
 */
class SolutionTwo {
    public int solution(int[] A) {

        // limit on number of passing cars (given in problem description) (1,000,000,000)
        final int CAR_LIMIT = 1000000000;
        // counter for number of passing cars
        int passingCars = 0;
        // number of zeroes OR cars traveling east
        int carsTravelingEast = 0;
        // number of elements in A
        int N = A.length;

        // iterate through A
        for (int i = 0; i < N; i++) {
            // increment number of cars traveling east
            if (A[i] == 0) {
                carsTravelingEast++;
            }
            //If you have at least 1 car traveling East and you encounter a car traveling west
            if (A[i] == 1 && carsTravelingEast > 0) {
                passingCars += carsTravelingEast;
                // if passing cars exceeds limit set by problem description
                if (passingCars > CAR_LIMIT)
                    return -1;
            }
        }
        return passingCars;
    }
}
