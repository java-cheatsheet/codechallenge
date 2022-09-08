package hackerrank.Mathematics;

import java.util.Arrays;

/***
 * Problem:
 * https://www.hackerrank.com/challenges/find-point/
 * Find the reflection when a point and the mid points are given.
 *
 * Solutiion:
 * The solution was preety straight forward, we have to use mid point formula:
 * Mid Point = ( Original Point + Reflected Point ) / 2
 *
 */
public class FindThePoint {

    public static void main(String args[]) {

        minHeight12();
//        reflectionCoordiantes33();
    }

    public static void minHeight12() {
        int expected = 12;
        int result = lowestTriangle(17, 100);
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    /**
     * https://www.hackerrank.com/challenges/lowest-triangle/problem
     *
     * @param base
     * @param area
     * @return
     */
    static int lowestTriangle(int base, int area){
        /*
         This is interesting.
         If you the number is 2, then the ouput is floor of the remainder as the number after dot are ignored.

         If the number is 2.0 , then the output is the complete remainder with decimal
         */
        double xx = ( 2.0 * area ) / base;
        return (int)Math.ceil( xx );
    }

    public static void reflectionCoordiantes33() {

        int[] originalCoordinates = {1, 1};
        int[] middleCoordinates = {2, 2};
        int[] result = findPoint(originalCoordinates[0], originalCoordinates[1], middleCoordinates[0], middleCoordinates[1]);
        int[] expected = {3, 3};

        assert (Arrays.equals(result, expected)) : "Result:" + result +" | Expected:" + expected;
    }

    static int[] findPoint(int px, int py, int qx, int qy) {
        int[] reflectedPoints =  new int[2];

        for (int i = 1; i <= 2; i++){
            reflectedPoints[0] = 2 * qx - px;
            reflectedPoints[1] = 2 * qy - py;
        }

        return reflectedPoints;
    }


}
