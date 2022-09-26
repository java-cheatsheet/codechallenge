package hackerrank.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CompareSubstrings {
    /**
     * Given String s, find the lexicographically
     * smallest and largest substrings of length k.
     *
     * Parameters:
     *     string s: a string
     *     int k: the length of the substrings to find
     *
     * Returns
     *     string: the string ' + "\n" + ' where and are the two substrings
     */

    public String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        ArrayList sortedSubString = getSortedSubString(s, k);
        smallest = sortedSubString.get(0).toString();
        largest = sortedSubString.get(
                sortedSubString.size() - 1).toString();

        return smallest+ " " + largest;
    }

    private ArrayList getSortedSubString(String s, int k) {
        String smallest = "", largest = "";

        int i, j;
        int stringLength = s.length();
        ArrayList<String> subStringList
                = new ArrayList<String>();

        for (i = 0; i < s.length()-k+1  ; i++) {
            subStringList.add(s.substring(i, k+i));
        }

        Collections.sort(subStringList);
        return subStringList;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        CompareSubstrings compareSubstrings =
                new CompareSubstrings();


        System.out.println(
                compareSubstrings.getSmallestAndLargest(
                        s, k));
    }
}


/**
 * Problem
 * https://www.hackerrank.com/challenges/java-string-compare
 */
