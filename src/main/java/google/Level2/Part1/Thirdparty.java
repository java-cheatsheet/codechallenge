package google.Level2.Part1;
import java.util.*;

// Java program to find the largest number
// that can be mode from elements of the
// array and is divisible by 3
//https://www.geeksforgeeks.org/find-largest-multiple-3-array-digits-set-2-time-o1-space/

class Thirdparty
{
//    // Number of digits
//    static int MAX_SIZE = 10;
//    static StringBuilder strBuilder = new StringBuilder();

//    static int accumulate(int[] arr, int start, int end) {
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++)
//        {
//            sum += arr[i];
//        }
//        return sum;
//    }
//
    static void sortArrayUsingCounts(int arr[], int n) {
        // Store count of all elements
        int[] count = new int[10];
        for (int i = 0; i < n; i++)
        {
            count[arr[i]]++;
        }

        // Store
        int index = 0;
        for (int i = 0; i < 10; i++)
        {
            while (count[i] > 0)
            {
                arr[index++] = i;
                count[i]--;
            }
        }
    }


    static int buildNum( int arr[], int ind1, int ind2 ) {
        StringBuilder strBuilder = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {

            if ( i != ind1 && i != ind2 ) {
                strBuilder.append(arr[i]);
            }
        }

        return Integer.parseInt(strBuilder.toString());
    }

    static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static int solution( int arr[] ) {
        int n = arr.length;
        Arrays.sort(arr);

        int sum = getSum(arr);
        int remainder = sum % 3;

        if ( remainder == 0 ) {
            return buildNum(arr,-1,-1);
        }

        if (remainder == 1)
        {
            int[] rem_2 = new int[2];
            rem_2[0] = -1;
            rem_2[1] = -1;


            for (int i = 0; i < n; i++) {

                if (arr[i] % 3 == 1) {
                    return buildNum(arr, i,-1);
                }

                if ( arr[i] % 3 == 2 ) {

                    if (rem_2[0] == -1) {
                        rem_2[0] = i;

                    } else if (rem_2[1] == -1) {
                        rem_2[1] = i;
                    }
                }
            }

            if ( rem_2[0] != -1 && rem_2[1] != -1 ) {
                return buildNum(arr,rem_2[0], rem_2[1]);
            }

        } else if (remainder == 2) {
            int[] rem_1 = new int[2];
            rem_1[0] = -1;
            rem_1[1] = -1;

            for (int i = 0; i < n; i++) {

                if (arr[i] % 3 == 2) {
                    return buildNum(arr, i,-1);
                }

                if (arr[i] % 3 == 1) {

                    if (rem_1[0] == -1) {
                        rem_1[0] = i;

                    } else if (rem_1[1] == -1) {
                        rem_1[1] = i;
                    }
                }
            }

            if ( rem_1[0] != -1 && rem_1[1] != -1 ) {
                return buildNum( arr, rem_1[0], rem_1[1]);
            }
        }

        return 0;
    }

//    public static int solution(int[] A) {
//        return largest3Multiple(A, A.length);
//    }


    // Driver code
//    public static void main(String[] args)
//    {
////        int arr[] = {4, 4, 1, 1, 1, 3};
////        int n = arr.length;
////        largest3Multiple(arr, n);
//
////        int[] arr = {9,9,9,9,9,9,9,9,9,9,9,9};
////        int n = arr.length;
////        largest3Multiple(arr, n);
//
//
//        int[] arr = {2,1,4,7,4,8,3,6,4,7};
//        int n = arr.length;
//        System.out.println(largest3Multiple(arr, n));
//
//    }
}