package hackerrank.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given String s, find the lexicographically
 * smallest and largest substrings of length k.
 *
 */
public final class CompareSubstrings {
    /**
     * string randomString: a string
     *
     */
    private final String randomString;

    /**
     * int substringLength: the length of the substrings to find
     *
     */
    private final int substringLength;

    public String getRandomString() {
        return randomString;
    }

    public int getSubstringLength() {
        return substringLength;
    }

    /**
     *
     * @param randomString String A string
     * @param substringLength int Substring length
     */
    public CompareSubstrings(final String randomString,
                             final int substringLength) {
        this.randomString = randomString;
        this.substringLength = substringLength;
    }



    /**
     * Create substring of the given length substringLength
     *
     * @return String
     */
    public String createSubstrings() {
        final List<String> subStringList
                = new ArrayList<>();

        final int subStringLen =  randomString.length()
                - substringLength + 1;

        for (int count = 0; count < subStringLen; count++) {
            subStringList.add(
                    randomString.substring( count,
                            substringLength + count));
        }

        Collections.sort(subStringList);
        final String smallestSubString = subStringList.get(0);
        final String largestSubString = subStringList.get(subStringList.size()-1);

        return  smallestSubString + " " + largestSubString;

    }
}


/**
 * Problem
 * https://www.hackerrank.com/challenges/java-string-compare
 */
