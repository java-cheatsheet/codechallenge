package hackerrank.Mathematics;

import java.math.BigInteger;

public class Restaturant {

    public static void main(String args[]) {
        validMaxSquare();
        validMaxRestaurants();
        checkWithFailedTestCases();
    }

    //834 125
    public static void checkWithFailedTestCases() {
        int l = 310;
        int b = 620;
        int expected = 2;
        int result = restaurant( l, b );
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void validMaxRestaurants() {
        int l = 11;
        int b = 2;
        int expected = 22;
        int result = restaurant( l, b );
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void validMaxSquare() {
        int l = 10;
        int b = 6;
        int expected = 15;
        int result = getMaxSquare( l, b , 5);
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static int getMaxSquare(int len, int breadth, int divisor) {
        System.out.println(divisor);

        if (( len % divisor == 0 ) && ( breadth % divisor == 0 )) {
            int lRemainder = len / divisor;
            int bRemainder = breadth / divisor;

            return lRemainder * bRemainder;
        }

        if ( divisor == 1 ) return len * breadth;

        return getMaxSquare( len, breadth, divisor - 1);
    }

    static int restaurant(int l, int b) {

        if ( l == b ) return 1;

        int modV;

        if ( l > b ) {
            modV = l % b;
            if ( modV == 0 ) return l/b;

        } else {
            modV = b % l;
            if ( modV == 0 ) return b/l;
        }

        return getMaxSquare( l, b, modV );
    }
}

