package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * We define a magic square to be an matrix of distinct positive
 * integers from to where the sum of any row, column, or diagonal
 * of length is always equal to the same number: the magic constant.
 *
 * You will be given a matrix of integers in the inclusive range.
 * We can convert any digit to any other digit in the range at
 * cost of . Given , convert it into a magic square at minimal cost.
 * Print this cost on a new line.
 *
 * Solution Resources:
 * https://www.mathblog.dk/hackerrank-forming-a-magic-square/
 * https://mindyourdecisions.com/blog/2015/11/08/how-many-3x3-magic-squares-are-there-sunday-puzzle/
 *
 * From the resources to finding the optimum solution, I have come to
 * this analysis:
 *
 * - Diagonal ends must be an EVEN number.
 * - Non-Diagonals ends must be an ODD number.
 * - Sum of Diagonals/Non-Diagonals must be 10.
 *
 * Solution Steps:
 *
 * The last solution steps are too long. So found out
 * hardcoded but easier solution to review.
 * The solution is from here:
 * https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Implementation/Forming%20a%20Magic%20Square/Solution.java
 *
 *
 * ------------------
 * New approach work in single dimension!
 *
 * Convert into a single dimension array
 *
 * Find the highest EVEN/ODD Number as needed in Diagonal/NonD position.
 *
 * If there are two higher numbers check if they are in different pairs.
 * Check if the SUM of it opposite end == 10
 *
 * Check if the SUM of it opposite end == 10
 *
 * If it does not, replace the existing value with 10 - found value.
 *
 * Check the highest value for the next Diagonal/NonD
 *
 *
 * --------------------------
 * This approach again is too complicated!
 *
 * CHECKS - (0,0),(0,2); (0,1),(1,0)
 *
 * Diagonal Check -
 *
 * Check If (0,0) is EVEN?
 *
 * T,
 *  Check If SUM with OPPOSITE end is 10?
 *   T,
 *      //Check if (0,2) is EVEN
 *      Move with (0,2)
 *   F,
 *      Check If other ADJACENT has higher number -
 *          T,
 *          REPLACE the that ADJACENT DIAGONAL end by 10 - ADJACENT
 *          MARKTHECHANGE()
 *          F,
 *          REPLACE the OPPOSITE by 10 - it
 *
 * F,
 *   Check If the the OPPOSITE is EVEN?
 *      T, REPLACE it by 10 - OPPOSITE, MARKTHECHANGE()
 *      F,
 *          Check If the ROW ADJACENT number is EVEN?
 *          T,
 *              Get any one EVEN number from it's pair and replace the existing,
 *              MARKTHECHANGE()
 *              Fill OPPOSITE END with other pair,
 *              MARKTHECHANGE()
 *          F,
 *              Check If the DIAGONAL of the ROW ADJACENT is EVEN?
 *              T,
 *                  Get any one EVEN number from other pair and replace the existing, MARKTHECHANGE()
 *                  Fill OPPOSITE END with other pair, MARKTHECHANGE()
 *                  Fill the DIAGONAL END with the other pair.
 *                  Mark
 *              F,
 *                  Fill both DIAGONAL WITH EVEN PAIRS [(00=2, 22=8), (02=4, 20=2)], MARKTHECHANGE()
 *
 * The Logic will be the same for NON-DIAGONAL.
 *
 * MARKTHECHANGE() Existing Value - Value Replacing
 *
 * --------------
 * Previous Thoughts
 *+
 * 1. LOOP (0,0),(0,2); (0,1),(1,0)
 * 2. CHECK
 *   - IF THE LOCATION IS ODD OR EVEN (* as needed in the location *)
 *
 *   -- IF MATCH, ie. location has CORRECT data
 *   --- IF THE SUM OF THE OPPOSITE END == 10 ; DO NOTHING
 *   --- ELSE CHECK VALUE FOR OTHER LOCATION
 *
 *   - - - IF the location CONTAIN required number
 *   - - - - C
 *
 *  if(  (((0,0) % 2 ) == 0) AND (((0,0) + (2,2)) == 10)  ) DO NOTHING
 *
 *
 * 3. Check IF THE SUM OF THE OPPOSITE IS 10 OR NOT.
 *
 * Diagonal Numbers = 2,4,6,8; pairs:(2, 8), (4,6)
 * Non-Diagonal Numbers = 1,3,7,9; pairs:(1, 9), (3,7)
 *------------------
 */

public class MagicSquare_UNRESOLVED
{
    static int[][] s = new int[][]{
            { 2, 4, 0},
            { 0, 5, 0},
            { 7, 6, 8}
    };
    static int[] intArr = new int[9];
    static HashMap<Integer, Integer> mapLineEnds = new HashMap<>();

    public static void main(String args[]) {
        mapLineEnds.put(0, 8);
        mapLineEnds.put(2, 6);
        mapLineEnds.put(1, 7);
        mapLineEnds.put(3, 5);

//        assert isEven(3):"NO";
        changeToSingleDArray(s);

        assert otherHighestEvenNum(4,6) == 8 : "Error";

//        magicFixDiagonal();

    }

    public static void magicFixDiagonal() {
        int highestEvenNum = 0;
        int duplicateNum = 0;

        for( int i = 0; i < 9; i+=2 ) {

            if( isEven( intArr[i] )) {

                if( intArr[i] > highestEvenNum )
                    highestEvenNum = intArr[i];

                if( intArr[i] == highestEvenNum )
                    duplicateNum = highestEvenNum;
            }
        }

        if( highestEvenNum == duplicateNum ) {

            if (intArr[0] == highestEvenNum
                    && intArr[8] == highestEvenNum
                    && intArr[2] == highestEvenNum
                    && intArr[6] == highestEvenNum ) {

                //Situation 1:
                // the highest no is 2

                intArr[0] = highestEvenNum; //2
                intArr[8] = 10 - highestEvenNum; //8

                intArr[2] = otherHighestEvenNum( intArr[0], intArr[8] );
                intArr[6] = 10 - intArr[2];

            } else if ( intArr[0] == highestEvenNum
                    && intArr[8] == highestEvenNum ) {
                intArr[8] = 10 - highestEvenNum;


                int otherHighestEvenNumber = otherHighestEvenNum( intArr[0], intArr[8] );
                // otherHighestEvenNumber = 6
                // arr6= 6, arr4 = 6

                if ( intArr[6] == otherHighestEvenNumber ) {

                    if ( intArr[2] != ( 10 - otherHighestEvenNumber ) )
                        intArr[2] = 10 - otherHighestEvenNumber;

                } else if ( intArr[2] == otherHighestEvenNumber ) {

                    if ( intArr[6] != ( 10 - otherHighestEvenNumber ) )
                        intArr[6] = 10 - otherHighestEvenNumber;
                } else {
                    intArr[6] = otherHighestEvenNumber;
                    intArr[2] = 10 - otherHighestEvenNumber;
                }

            } else if ( intArr[4] == highestEvenNum
                    && intArr[6] == highestEvenNum ) {
                intArr[6] = 10 - highestEvenNum;

                int otherHighestEvenNumber = otherHighestEvenNum( intArr[4], intArr[6] );

                if ( intArr[8] == otherHighestEvenNumber ) {

                    if ( intArr[0] != ( 10 - otherHighestEvenNumber ) )
                        intArr[0] = 10 - otherHighestEvenNumber;

                } else if ( intArr[0] == otherHighestEvenNumber ) {

                    if ( intArr[8] != ( 10 - otherHighestEvenNumber ) )
                        intArr[8] = 10 - otherHighestEvenNumber;
                } else {
                    intArr[8] = otherHighestEvenNumber;
                    intArr[0] = 10 - otherHighestEvenNumber;
                }

            } else if ( intArr[0] == highestEvenNum
                    && intArr[2] == highestEvenNum ) {

                // highest val is 2
                //check if other ends has a pair number
                int otherPairVal = 10 - intArr[0];

                if ( otherPairVal == intArr[8] ){
                    if ( intArr[6] != otherHighestEvenNum( intArr[0], otherPairVal ) ) {
                        intArr[6] = otherHighestEvenNum( intArr[0], otherPairVal );
                    }

                    intArr[2] = 10 - intArr[6];

                } else if ( otherPairVal == intArr[6] ) {
                    if( intArr[8] != otherHighestEvenNum( intArr[0], otherPairVal ) )
                        intArr[8] = otherHighestEvenNum( intArr[0], otherPairVal );

                    intArr[0] = 10 - intArr[8];
                }

            } else if ( intArr[6] == highestEvenNum
                    && intArr[8] == highestEvenNum ) {

                // highest val is 8
                //check if other ends has a pair number
                int otherPairVal = 10 - highestEvenNum;

                if ( otherPairVal == intArr[0] ) {

                    if ( intArr[2] != otherHighestEvenNum( highestEvenNum, otherPairVal ) ) {
                        intArr[2] = otherHighestEvenNum( highestEvenNum, otherPairVal );
                    }
                    intArr[6] = 10 - intArr[2];

                } else if ( otherPairVal == intArr[2] ) {

                    if ( intArr[0] != otherHighestEvenNum( highestEvenNum, otherPairVal ) ) {
                        intArr[0] = otherHighestEvenNum( highestEvenNum, otherPairVal );
                    }
                    intArr[8] = 10 - intArr[0];
                }

            }
        } else {
            // Now set to individual positive values.

            if ( intArr[0] == highestEvenNum ) {
//                intArr[8] = 10 - highestEvenNum;
//                int otherHighestEvenNumber = otherHighestEvenNum( intArr[0], intArr[8] );

            } else if ( intArr[2] == highestEvenNum ) {

            } else if ( intArr[4] == highestEvenNum ) {

            } else if ( intArr[8] == highestEvenNum ) {

            }
        }
    }

    /**
     *
     * @param first
     * @param second
     * @return
     */
    public static int otherHighestEvenNum(int firstPairNum, int secondPairNum) {
        return firstPairNum == 6 || secondPairNum == 6 ? 8 : 6;
    }

    public static void changeToSingleDArray(int[][] nonMagicMatrix) {
        int count =  0;

        for( int i = 0; i < 3; i++ ) {
            int j = 0;

            while ( j < 3 ){
               intArr[count] = nonMagicMatrix[i][j];
               count++;
               j++;
            }
        }
    }

    public static boolean isEven(int numToCheck) {
        return ( (numToCheck % 2) == 0 );
    }

}
