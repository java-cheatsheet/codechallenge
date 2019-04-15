package hackerrank.String;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 *
 * Alice is taking a cryptography class and finding anagrams
 * to be very useful. We consider two strings to be anagrams
 * of each other if the first string's letters can be rearranged
 * to form the second string. In other words, both strings must
 * contain the same exact letters in the same exact frequency
 * For example, bacdc and dcbac are anagrams, but bacdc and
 * dcbad are not.
 *
 * Alice decides on an encryption scheme involving two large
 * strings where encryption is dependent on the minimum number
 * of character deletions required to make the two strings anagrams.
 * Can you help her find this number?
 *
 * Given two strings, a and b, that may or may not be
 * of the same length, determine the minimum number of
 * character deletions required to make a and b anagrams.
 * Any characters can be deleted from either of the strings.
 *
 */
public class MakingAnagrams {

    public static void main(String args[]) {
        ransomeNoteTrue();
    }

    static void ransomeNoteTrue() {
        String a = "cde";
        String b = "abc";
        int result = makeAnagram(a, b);
        int expected = 4;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }


    /**
     *
     *
     *
     * @param a
     * @param b
     * @return
     */
    static int makeAnagram(String a, String b) {
        Character[] aArray = a.chars().mapToObj(x -> (char) x).toArray(Character[]::new);
        Character[] bArray = b.chars().mapToObj(x -> (char) x).toArray(Character[]::new);
        Map<Character, Long> aMap = getFrequencyMapFromArray(aArray);
        Map<Character, Long> bMap = getFrequencyMapFromArray(bArray);

        return countError(aMap, bMap);
    }

    private static int countError( Map<Character, Long> aMap, Map<Character, Long> bMap ) {
        long deletedChars = 0;

        for( char ch='a'; ch<='z'; ch++) {

            if ( aMap.containsKey(ch) && !bMap.containsKey(ch) )
                deletedChars += aMap.get(ch);

            else if( bMap.containsKey(ch) && !aMap.containsKey(ch) )
                deletedChars += bMap.get(ch);

            else if( bMap.containsKey(ch) && aMap.containsKey(ch) )
                deletedChars += Math.abs( aMap.get(ch) - bMap.get(ch));
        }

        return (int)deletedChars;
    }

    private static Map<Character, Long> getFrequencyMapFromArray(Character[] arr) {
        return Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


}