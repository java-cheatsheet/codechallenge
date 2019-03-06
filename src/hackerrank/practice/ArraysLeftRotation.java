package hackerrank.practice;

import java.util.HashMap;
import java.util.HashSet;

public class ArraysLeftRotation {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };

//        leftRotateArrayShift(arr, 4, 5);
        arr  = rotateLeftConditionalAlgorithm(arr, 3);
//        leftRotateWithGCD(arr, 4, 8);
        printArray(arr, arr.length);
    }

    //https://codingin.wordpress.com/2017/01/22/solution-array-left-rotation/
    // Complete the rotLeft function below.
    static int[] rotateLeftConditionalAlgorithm(int[] a, int d) {
        int aLen = a.length;

        if ( aLen == d ) return a;

        int rotatedA[] = new int[aLen];

        for(int i = 0; i < aLen; i++){

            if (i-d >= 0){
                rotatedA[i-d] = a[i];

            } else {
                int index = i-d + aLen;
                rotatedA[index] = a[i];
            }
        }

        return rotatedA;
    }

    /**
     * https://www.geeksforgeeks.org/array-rotation/
     *
     * @param arr
     * @param d
     * @param n
     */
    static void leftRotateWithGCD(int arr[], int d, int n)
    {
        int i, j, k, temp;
        for (i = 0; i < gcd(d, n); i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;

            while (true) {
                k = j + d;

                if (k >= n)
                    k = k - n;

                if (k == i)
                    break;

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /*UTILITY FUNCTIONS*/

    /* function to print an array */
    static void printArray(int arr[], int size)
    {
//        int i;
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    /*Fuction to get gcd of a and b*/
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }


    /*Function to left rotate arr[] of size n by d*/
    static void leftRotateArrayShift(int arr[], int d, int n)
    {
        for (int i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    static void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

}

/**
 * Previous logic
 if ( d > 0) {
 b[i] = a[aLen - d];

 } else if ( i == initialD ){
 b[i] = a[0];

 } else {
 b[i] = a[aLen - afterCounter];

 afterCounter--;
 }

 */
