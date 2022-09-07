package hackerrank.DynamicProgramming;

/**
 * https://cs.stackexchange.com/questions/105313/dynamic-pseudo-code-for-simplified-coin-changing-algorithm
 *
 * TODO
 */
public class ArithmeticExpressions {

    public static void main(String args[]) {
        failedTestCase13WhenJLessThan2();
    }

    public static void failedTestCase13WhenJLessThan2() {
        int[] arr = {22, 79, 21};
        String expected = "22*79-21";
        String result = arithmeticExpressions(arr);

        assert (result.equals(expected)) : "testOddData - Result:" + result + " | Expected:" + expected;
    }

    static String arithmeticExpressions(int[] arr) {
        return "";
    }

    static String arithmeticExpressionsRecur(int[] arr, int index, int sum, String expression) {

        // Check if the next number is greater than previous, we cannot subtract
        // Check which arithmetic operation gives is equal to 101
        // If true,
        //      Add the operator to the string
        //      Add * to remaining numbers

        /**
         Steps:
         1. index =
            calculation = sum - arr[i]
         */
        int i = 0;
        while ( i < 3 ) {
            //addition
            //substraction
            //multiplication


        }
        return "";
    }

    /**
     * https://codereview.stackexchange.com/questions/178933/hackerrank-arithmetic-expressions
     *
     * @return
     */
    static String arithmeticExpressionsX(int[] arr) {
        boolean[][] remainders = new boolean[10000][101];
        Character[][] operators = new Character[10000][101];
        int[][] previousRemainder = new int[10000][101];

        remainders[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];

            if (remainders[i - 1][0]) {
                remainders[i][0] = true;
                operators[i][0] = Character.MIN_VALUE;
                previousRemainder[i][0] = 0;

            } else {
                for (int j = 0; j < 101; j++) {

                    if (remainders[i - 1][j]) {
                        remainders[i][Math.floorMod(j + num, 101)] = true;
                        operators[i][Math.floorMod(j + num, 101)] = '+';
                        previousRemainder[i][Math.floorMod(j + num, 101)] = j;

                        remainders[i][Math.floorMod(j - num, 101)] = true;
                        operators[i][Math.floorMod(j - num, 101)] = '-';
                        previousRemainder[i][Math.floorMod(j - num, 101)] = j;

                        remainders[i][Math.floorMod(j * num, 101)] = true;
                        operators[i][Math.floorMod(j * num, 101)] = '*';
                        previousRemainder[i][Math.floorMod(j * num, 101)] = j;
                    }
                }
            }

        }

        String result = Integer.toString(arr[0]);
        Integer currentRemainder = 0;
        String[] operatorsResult = new String[10000];

        for (int i = arr.length - 1; i >= 1; i--) {
            operatorsResult[i] = Character.toString(operators[i][currentRemainder]);
            currentRemainder = previousRemainder[i][currentRemainder];
        }

        for (int i = 1; i < arr.length; i++) {
            result += operatorsResult[i] + Integer.toString(arr[i]);
        }

        return result;

    }

}
