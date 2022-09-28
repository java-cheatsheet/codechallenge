package hackerrank.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Definition:
 *
 * https://www.hackerrank.com/challenges/anagram/problem
 *
 * Two words are anagrams of one another if their letters can be rearranged to form the other word.
 * In this challenge, you will be given a string. You must split it into two contiguous substrings,
 * then determine the minimum number of characters to change to make the two substrings into anagrams of one another.
 * For example, given the string 'abccde', you would break it into two parts: 'abc' and 'cde'.
 * Note that all letters have been used, the substrings are contiguous and their lengths are equal.
 * Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde'
 * which are anagrams. Two changes were necessary.
 *
 * Function Description:
 * Complete the anagram function in the editor below. It should return
 * the minimum number of characters to change to make the words anagrams,
 * or if it's not possible.
 *
 */
public class Anagram {

    public static void main(String[] args) {
        strShouldBeAnagram();
        threeStrNeededToMakeAnagram();
        fiveStrNeededToMakeAnagram();
    }

    static void strShouldBeAnagram() {
        int result = anagram("xaxbbbxx");
        int expected = 1;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static void threeStrNeededToMakeAnagram() {
        int result = anagram("asdfjoieufoa");
        int expected = 3;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static void fiveStrNeededToMakeAnagram() {
        int result = anagram("fdhlvosfpafhalll");
        /**
         * fdhlvosf
         *
         * pafhalll
         *
         */
        int expected = 5; //r=4
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static int anagram(String s) {
        int sLen =  s.length();
        char[] charStr = s.toCharArray();

        if ( sLen % 2 != 0 ) return -1;

        if ( sLen == 2 && charStr[0] == charStr[1]) return 0;
        if ( sLen == 2 && charStr[0] != charStr[1]) return 1;

        int halfSArr = ( sLen / 2 );
        char[] firstSubStr = s.substring(0, halfSArr).toCharArray();
        char[] secondSubStr = s.substring(halfSArr, sLen).toCharArray();

        Map<Character, Integer> firstSubstringMap = getFrequencyMapFromArray(firstSubStr);

        for (int j = 0; j < secondSubStr.length; j++) {
            char t = secondSubStr[j];

            if ( firstSubstringMap.get(t) != null ) {

                if ( firstSubstringMap.get(t) != 0 )
                    firstSubstringMap.put(t, firstSubstringMap.get(t) - 1);
            }
        }

        int charToMakeAnagram = 0;
        for (Character c : firstSubstringMap.keySet()) {
            charToMakeAnagram += firstSubstringMap.get(c);
        }

        return charToMakeAnagram;

    }

    private static Map<Character, Integer> getFrequencyMapFromArray(char[] arr) {

        Map<Character, Integer> map = new HashMap<>();

        for(char key : arr){

            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key, 1);


        }
        return map;
    }

}
