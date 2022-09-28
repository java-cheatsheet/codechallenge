package main;

import hackerrank.java.CompareSubstrings;
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

        try (Scanner scan = new Scanner(System.in)) {
            final String randomString = scan.next();
            final int substringLength = scan.nextInt();

            final CompareSubstrings compareSubstrings =
                    new CompareSubstrings(randomString, substringLength);

            compareSubstrings.createSubstrings();

        }
    }
}
