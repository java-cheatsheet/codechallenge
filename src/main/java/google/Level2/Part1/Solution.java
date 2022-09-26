package google.Level2.Part1;


import java.util.Arrays;

public class Solution {

    /**
     * solution Build largest number that can be made from
     * some or all of these digits in array divisible by 3.
     *
     * @param arr int[]
     * @return int
     */
    public static int solution(int arr[]) {
        Arrays.sort(arr);

        int sum = getSum(arr);
        int remainder = sum % 3;

        if (remainder == 0) {
            return buildNum(arr, -1, -1);
        }

        return remainderNum(arr, remainder);
    }

    /**
     * getSum Sum of array
     *
     * @param arr int[]
     * @return int
     */
    static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * buildNum Create number from array.
     *
     * @param arr        int[]
     * @param skipFirst  Skip index of array arr
     * @param skipSecond Skip index of array arr
     * @return int Largest number divisible by 3.
     */
    public static int buildNum(int arr[], int skipFirst, int skipSecond) {
        StringBuilder strBuilder = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {

            strBuilder.append(String.valueOf(arr[i]));

            if (skipFirst == i) {
                strBuilder.setLength(strBuilder.length() - 1);
                skipFirst = -1;
            }

            if (skipSecond == i) {
                strBuilder.setLength(strBuilder.length() - 1);
                skipSecond = -1;
            }
        }
        String str = strBuilder.toString();

        if (str != null && !str.isEmpty())
            return Integer.parseInt(str);

        return 0;
    }

    /**
     * remainderNum Build number based on remainder.
     *
     * @param arr       int[] Sorted array.
     * @param remainder int
     * @return int Largest number divisible by 3.
     */
    static int remainderNum(int[] arr, int remainder) {
        int remOne = -1;
        int remTwo = -1;
        int skip;

        if (remainder == 1) skip = 2;
        else skip = 1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 3 == remainder) {
                return buildNum(arr, i, -1);
            }

            if (arr[i] % 3 == skip) {

                if (remOne == -1) {
                    remOne = i;

                } else if (remTwo == -1) {
                    remTwo = i;
                }
            }
        }

        if (remOne != -1 && remTwo != -1) {
            return buildNum(arr, remOne, remTwo);
        }

        return 0;
    }



}
