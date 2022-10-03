package hackerrank.java;

import java.util.Arrays;
import java.util.Locale;

/**
 * Check if two strings are anagram (case insensitive)
 *
 */
public class Anagrams {

    /**
     * First String
     */
    private final String first;

    /**
     * Second String
     */
    private final String second;

    /**
     * Instantiate first and second strings.
     *
     * @param first String
     * @param second String
     */
    public Anagrams(final String first, final String second) {
        this.first =  first;
        this.second =  second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    /**
     * Return true if two strings are anagram.
     *
     * @return Boolean
     */
    public boolean isAnagram() {
        int count = 0;
        final int firstLen = first.length();

        if ( equal(firstLen, second.length()) ) {

            final char[] firstCharArr = sort(first);
            final char[] secondCharArr = sort(second);

            while (count < firstLen) {

                if ( !equal(firstCharArr[count],
                        secondCharArr[count]) ) {
                    break;
                }
                count++;
            }
        }

        return count == firstLen;
    }

    private char[] sort(final String randomStr) {
        final Locale locale = Locale.ENGLISH;

        final char[] upperChar = randomStr.toUpperCase(locale)
                .toCharArray();
        Arrays.sort(upperChar);

        return upperChar;
    }

    private boolean equal(final int first,
                          final int second) {
        return first == second;
    }
}
