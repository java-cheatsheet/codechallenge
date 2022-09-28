package hackerrankmathematics;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/restaurant/problem
 * Martha is interviewing at Subway. One of the rounds of the interview requires
 * her to cut a bread of size l * b into smaller identical pieces such that each piece
 * is a square having maximum possible side length with no left over piece of bread.
 *
 * Solution:
 *
 */
public class Restaturant {

    public static void main(String[] args) {
        validMaxSquare();
        validMaxRestaurants();
        checkWithFailedTestCases();

//        checkRestaurantEuclidGCD();
    }

    public static void checkRestaurantEuclidGCD() {
        int l = 5;
        int b = 10;
        int expected = 5;
        SolutionWithGCD obj = new SolutionWithGCD();
        int result = SolutionWithGCD.restaurant(l, b);
        assert (result == expected) : "Result:" + result + " | Expected:" + expected;
    }

    public static void checkWithFailedTestCases() {
        int l = 310;
        int b = 620;
        int expected = 2;
        SolutionWithGCD obj = new SolutionWithGCD();
        int result = SolutionWithGCD.restaurant(l, b);
        assert (result == expected) : "Result:" + result + " | Expected:" + expected;
    }

    public static void validMaxRestaurants() {
        int l = 11;
        int b = 11;
        int expected = 1;
        SolutionWithOutGCD sol = new SolutionWithOutGCD();
        int result = SolutionWithOutGCD.restaurant(l, b);
        assert (result == expected) : "Result:" + result + " | Expected:" + expected;
    }

    public static void validMaxSquare() {
        int l = 10;
        int b = 6;
        int expected = 15;
        SolutionWithOutGCD sol = new SolutionWithOutGCD();
        int result = SolutionWithOutGCD.getMaxSquare(l, b, 5);
        assert (result == expected) : "Result:" + result + " | Expected:" + expected;
    }

}

/**
 * This is the recent solution which was visualized after
 * revising the usage of Euclid algorithm. This solution
 * also has passed hackerrank tests.
 *
 * https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/
 */
class SolutionWithGCD {

    static int restaurant(int l, int b) {
        if ( l == b ) return 1;

        int divisor = getEuclidGCD( l, b );

        int lRemainder = l / divisor;
        int bRemainder = b / divisor;

        return lRemainder * bRemainder;
    }

    static int getEuclidGCD(int l, int b) {
//        System.out.println(l +" : "+ b );

        if( b == 0 )
            return l;
        else
            return getEuclidGCD(b, l % b);
    }

}


/**
 * This was the first custom solution which passed all the
 * Hackerrank tests.
 */
class SolutionWithOutGCD {

    static int getMaxSquare(int len, int breadth, int divisor) {
        System.out.println(divisor);

        if ((len % divisor == 0) && (breadth % divisor == 0)) {
            int lRemainder = len / divisor;
            int bRemainder = breadth / divisor;

            return lRemainder * bRemainder;
        }

        if (divisor == 1) return len * breadth;

        return getMaxSquare(len, breadth, divisor - 1);
    }

    static int restaurant(int l, int b) {

        if (l == b) return 1;

        int modV;

        if (l > b) {
            modV = l % b;
            if (modV == 0) return l / b;

        } else {
            modV = b % l;
            if (modV == 0) return b / l;
        }

        return getMaxSquare(l, b, modV);
    }

}