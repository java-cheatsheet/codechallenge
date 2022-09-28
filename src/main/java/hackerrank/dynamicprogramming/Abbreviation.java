package hackerrank.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/abbr/problem
 *
 * TODO:
 * I may not have understood the problem so the current
 * solution failed test cases.
 *
 * The description provided in the discussion section is
 * great. I think I need to review the DP section videos
 *
 *
 */
public class Abbreviation {

    public static void main(String[] args) {
        validTest();
    }

    static void validTest() {
        String a = "daBcd";
        String b = "ABC";
        String result = abbreviation(a, b);
        String expected = "YES";
        assert (result.equals(expected)) : "Result:" + result +" | Expected:" + expected;
    }

    /**
     * Thought process:
     * Change all the characters to small letters
     * Keep the count of the characters in a hashmap
     * Get the lengths of both array
     *
     * If lengths are UNEQUAL-
     * Compare the array with smaller length to the longer one.
     * Longer one must have equal or more than the number
     *  of characters in the smaller one. If the longer string
     *  does not have equal or more or extra characters then
     *  it can not be converted, return NO.
     *
     * If lengths are EQUAL-
     * Both should have the same number of characters with same string.
     * Else return NO.
     *
     * @param a
     * @param b
     * @return
     */
    static String abbreviation(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        Map<Character, Integer> aMap = getFrequencyMapFromArray(a.toCharArray());
        Map<Character, Integer> bMap = getFrequencyMapFromArray(b.toCharArray());

        if( a.length() > b.length()) return compareTwoCharArrays(aMap, bMap);
        else return compareTwoCharArrays(bMap, aMap);
    }

    private static String compareTwoCharArrays( Map<Character, Integer> longerMap, Map<Character, Integer> shorterMap) {
        for(Map.Entry<Character, Integer> entry:shorterMap.entrySet()){
            if ( longerMap.get(entry.getKey()) < entry.getValue() )return "NO";
        }

        return "YES";
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
