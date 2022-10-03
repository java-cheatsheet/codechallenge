package main;

import hackerrank.java.Anagrams;
import hackerrank.java.CompareSubstrings;
import hackerrank.string.Anagram;

import java.util.Scanner;

/**
 *
 * Main runner class for all Classes that needs
 * to be invoked from CLI.
 *
 */
public class main {
    /**
     * Reads String of single word and
     * int to substring to break string.
     *
     * @param args
     */
    public static void main(final String[] args) {
//        twoStrings();
        oneStringOneInt();
    }

    public static void oneStringOneInt() {
        try (Scanner scan = new Scanner(System.in)) {
            final String randomString = scan.next();
            final int substringLength = scan.nextInt();

            final CompareSubstrings compareSubstrings =
                    new CompareSubstrings(randomString, substringLength);

            System.out.println( compareSubstrings.createSubstrings() );
        }
    }

    public static void twoStrings() {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        Anagrams obj = new Anagrams(a, b);

        boolean ret = obj.isAnagram();
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
