package google.Level2.Part2;

public class Solution {

    /**
     * Returns value of (x,y) coordinates.
     *
     * @param x long x-coordinate
     * @param y long y-coordinate
     *
     * @return string
     */
    public static String solution(long x, long y) {

        if (x == y) {
            return String.valueOf(x*x + y*y);
        }

        long xStartVal = getStartX(x);
        long yColSum = yColSum(x,y);
        return String.valueOf(xStartVal + yColSum);
    }

    /**
     * Returns (x,1) value.
     *
     * @param x long x-coordinate
     * @return long
     */
    public static long getStartX(long x){
        return x*(x+1)/2;
    }

    /**
     * Returns y-column sum from x-coordinate.
     *
     * @param x long x-coordinate
     * @param y long y-coodinate
     *
     * @return long
     */
    public static long yColSum(long x, long y){
        long n = y-1;
        return (n*( 2*x + (n - 1) ))/2;
    }

}