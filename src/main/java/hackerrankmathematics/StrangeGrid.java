package hackerrankmathematics;

/**
 * Problem:
 *
 * https://www.hackerrank.com/challenges/strange-grid/problem
 *
 *  .............
 *  1  3  5  7  9
 *  0  2  4  6  8
 *
 * The grid grows upwards forever!
 *
 * Your task is to find the integer in cth column
 * in rth row of the grid.
 *
 */
public class StrangeGrid {

    public static void main(String[] args) {
        validTestFor5();
    }

    public static void validTestFor5() {
        int r = 6;
        int c = 3;
        int expected = 25;
        long result = strangeGrid(6, 3);

        assert ( result == expected ) : "testOddData - Result:" + result +" | Expected:" + expected;
    }


    /**
     * Had to change the input and return type to long
     * to pass all the test cases. Before test case 7
     * and 8 were not passing when the param and return
     * type were int. The value of r is
     * 1 <= r <= 2*10^9
     *
     * Original function definition:
     * static long strangeGrid(long r, long c)
     *
     * @param r
     * @param c
     * @return
     */
    static long strangeGrid(long r, long c) {

//        long rDividedBy2Remainder = Math.floorDiv(r, 2);
//        long rMod2 = r % 2;
//
//        if( rMod2 == 0 ) {
//            rDividedBy2Remainder = rDividedBy2Remainder - 1;
//            rMod2 = ( c * 2 ) - 1;
//        } else {
//            rMod2 =  ( c - 1 ) * 2;
//        }
//
//        return ( rDividedBy2Remainder * 10 ) + rMod2;

        //change the above code to 1 statement below
        return  r % 2 == 0 ? ( Math.floorDiv(r, 2) - 1 ) * 10 + ( c * 2 ) - 1
                : Math.floorDiv(r, 2) * 10 + ( c - 1 ) * 2;
    }

    /**
     * This is another working example with multiple
     * of 5 which is more elegant than mine.
     *
     * @param r
     * @param c
     * @return
     */
    static long strangeGrid5(long r, long c) {
         return r % 2 == 1 ? ( r - 1 ) * 5 + ( c - 1 ) * 2
             : ( r - 2 ) * 5 + 1 + ( c - 1 ) * 2 ;
    }

}
