package hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Probelem:
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 *
 * Watson gives Sherlock an array of integers. His challenge is to
 * find an element of the array such that the sum of all elements
 * to the left is equal to the sum of all elements to the right.
 *
 * For each test case print YES if there exists an element in the
 * array, such that the sum of the elements on its left is equal
 * to the sum of the elements on its right; otherwise print NO.
 *
 */
public class SherlockAndArray {

    public static void main(String args[]) {
//        elementDoesNotExist();
        shouldBeYEST3();
    }

    /**
     * The data is very confusing.
     */
    public static void shouldBeYEST3() {
        List<Integer> arr = Arrays.asList(2, 0, 0, 0);
        String result = balancedSums( arr );
        String expected = "YES";
        assert ( result.equals(expected) ) : "Result:" + result +" | Expected:" + expected;
    }

    public static void shouldBeYEST2() {
        List<Integer> arr = Arrays.asList(1, 1, 4, 1, 1);
        String result = balancedSums( arr );
        String expected = "YES";
        assert ( result.equals(expected) ) : "Result:" + result +" | Expected:" + expected;
    }

    public static void elementDoesNotExist() {
        List<Integer> arr = Arrays.asList(1, 2, 3);
        String result = balancedSums( arr );
        String expected = "NO";
        assert ( result.equals(expected) ) : "Result:" + result +" | Expected:" + expected;
    }

    public static void shouldBeYEST1() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 3);
        String result = balancedSums( arr );
        String expected = "YES";
        assert ( result.equals(expected) ) : "Result:" + result +" | Expected:" + expected;
    }
    // Complete the balancedSums function below.
    public static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        int i = 0;
        int j = n - 1;
        int left = 0;
        int right = 0;

        while (i < n && j >= 0) {

            if (left == right && i == j) {
                return "YES";
            }

            if (left > right) {
                right += arr.get(j);
                j--;
            } else {
                left += arr.get(i);
                i++;
            }
        }

        if (left == right ) return "YES";

        return "NO";
    }

    // Complete the balancedSums function below.
    public static String balancedSumsX(List<Integer> arr) {
        int arrSize =  arr.size();

        if ( arrSize == 1 ) { return "YES";}

        for (int i = 1; i < arrSize; i++ ) {
            //get left sum
            int leftSum = getSum( arr, 0, i );

            //get right sum
            int rightSum = getSum( arr, i, arrSize );

            if ( leftSum == rightSum ) {
                return "YES";
            }
        }

        return "NO";
    }

    public static int getSum(List<Integer> arr, int startIndex, int endIndex ) {
        int tempSum = 0;

        for ( int i = startIndex; i < endIndex; i++ ) {
            tempSum += arr.get(startIndex);
        }

        return tempSum;
    }


}
