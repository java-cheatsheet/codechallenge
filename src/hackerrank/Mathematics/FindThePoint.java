package hackerrank.Mathematics;

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

    }

    public static void maxMod1() {
        long[] a = {1, 2, 3};
        long m = 2L;
        long result = maximumSum(a, m);
        long expected = 1;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }


    static int[] findPoint(int px, int py, int qx, int qy) {
        int[] reflectedPoints =  new int[2];

        for (int i = 1; i <= n; i++){
            reflectedPoints[0] = 2 * qx - px;
            reflectedPoints[1] = 2 * qy - py;
        }

        return reflectedPoints;
    }


}
