package datastructures;

import java.util.Arrays;
import java.util.Collections;

public class ReverserArray {

    static void justPrintInReverse(int[] intArray) {
        //print array starting from last element
        System.out.println("Original Array printed in reverse order:");
        for(int i=intArray.length-1;i>=0;i--)
            System.out.print(intArray[i] + "  ");
    }

    static void useArrayList(Integer[] myArray)
    {
//        When int[] myArray is passed as parameter,
//        println prints pointer to object.
//        We have to call Arrays.toString(intArray)
//        exclusively.
//        Collections.reverse(Arrays.asList(myArray));
//        System.out.println("Reversed Array:" + Arrays.toString(intArray));

        Collections.reverse(Arrays.asList(myArray));
        System.out.println("Reversed Array:" + Arrays.asList(myArray));
    }

    static void usingExtraArray(char[] charArray)
    {
        int n = charArray.length;
        char[] destArray = new char[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            destArray[j - 1] = charArray[i];
            j = j - 1;
        }

        System.out.println("Reversed array: ");
        for (int k = 0; k < n; k++) {
            System.out.print(destArray[k] + " ");
        }
    }

    static void reverseStringAsList(String[] myArray)
    {
        Collections.reverse(Arrays.asList(myArray));
        System.out.println("Reversed Array:" + Arrays.asList(myArray));
    }

    static void inPlace(int[] intArray)
    {
        int i, k, temp;
        int size = intArray.length;
        for (i = 0; i < size / 2; i++) {
            temp = intArray[i];
            intArray[i] = intArray[size - i - 1];
            intArray[size - i - 1] = temp;
        }

        /*print the reversed array*/
        System.out.println("Reversed Array: \n" + Arrays.toString(intArray));
    }

    public static void main(String[] args) {
        Integer[] intArray = {10,20,30,40,50,60,70,80,90};
//        String [] myArray = {"one", "Two", "Three", "Four", "Five", "Six","Seven"};
//        char [] char_array = {'H','E','L','L','O'};

        useArrayList(intArray);
    }
}

/**
 How to Reverse a List in Java?
 Use the reverse method provided by the Collections interface of Java.
 */