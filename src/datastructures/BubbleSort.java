package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class BubbleSort {
    private static void printArray(String s, int[] x) {
        System.out.print(s + " Array: ");
        for(int i : x){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] x) {
        printArray("Initial", x);

        int endPosition = x.length - 1;
        int swapPosition;

        while( endPosition > 0 ) {
            swapPosition = 0;

            for(int i = 0; i < endPosition; i++) {

                if( x[i] > x[i + 1] ){
                    // Swap elements 'i' and 'i + 1':
                    int tmp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = tmp;

                    swapPosition = i;
                } // end if

                printArray("Current", x);
            } // end for

            endPosition = swapPosition;
        } // end while

        printArray("Sorted", x);
    } // end bubbleSort

    public static void bubbleSortV2(int[] a) {
        int n = a.length;
        int numberOfSwaps = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.println("Array is sorted in "+numberOfSwaps+"swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
    }

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] unsorted = new int[n];
//        for (int i = 0; i < n; i++) {
//            unsorted[i] = scan.nextInt();
//        }
//        scan.close();
        int[] unsorted = {1,4,7,8,3,2,9};
        List<Integer> list = List.of(3, 2, 1);

//        Convert list to int[]
        int[] intArr = list.stream().mapToInt(i->i).toArray();
//        System.out.println(Arrays.toString(a));
////        bubbleSort(unsorted);
//        bubbleSortV2(a);
//        System.out.println(Arrays.toString(a));

        List<Integer> arrayList = new ArrayList<Integer>();;
        arrayList.addAll(list);
        arrayList.get(0);
        arrayList.add(0, 12);
        System.out.println(arrayList);

//        list is unchanged
        System.out.println(list);

    }
}
