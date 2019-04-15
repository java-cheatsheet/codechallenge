package hackerrank.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Problem Definition:
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/
 * Two strings are anagrams of each other if the letters of one string can
 * be rearranged to form the other string. Given a string, find the number
 * of pairs of substrings of the string that are anagrams of each other.
 *
 * Function Description
 * Complete the function sherlockAndAnagrams in the editor below.
 * It must return an integer that represents the number of anagrammatic pairs of substrings in s.
 *
 * Solutions:
 * The max len is 100. So the max strings to compare could be of len 10
 *
 * Test Case 2 That timed out;
 *
 * ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel
 * gffryqktmwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggjxbmxpnde
 * mqmtjwxaaaxklheghvqcyhaaegtlyntxmoluqlzvuzgkwhkkfpwarkckansgabfclzgnumdrojexnrdunivxqjzfbzsodycnsnmw
 * ofeqjnqnxwidhbuxxhfwargwkikjqwyghpsygjxyrarcoacwnhxyqlrviikfuiuotifznqmzpjrxycnqktkryutpqvbgbgthfges
 * zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw
 *
 * 399
 * 471
 * 370
 * 403
 * 428
 *
 */

public class SherlockAndAnagrams
{

    public static void main(String[] args) {


//        shouldCount10for4SameChars();
//        shouldCount3();

        testCase2TimedOut();
    }

    public static void testCase2TimedOut() {
        String s = "ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel";
        int result = sherlockAndAnagrams(s);

//        long startTime = System.nanoTime();
//        SolutionNotAccepted notAcceptedOnj =  new SolutionNotAccepted();
//        int result = notAcceptedOnj.sherlockAndAnagrams(s);
//        long endTime   = System.nanoTime();
//        long elapsedTime = endTime - startTime;
////        TimeUnit seconds = new TimeUnit();
//        System.out.println(TimeUnit.NANOSECONDS.toSeconds(elapsedTime));

//        startTime = System.nanoTime();
//        result = sherlockAndAnagrams(s);
//        endTime   = System.nanoTime();
//        elapsedTime = endTime - startTime;
//        TimeUnit seconds = new TimeUnit();
//        System.out.println(TimeUnit.NANOSECONDS.toSeconds(elapsedTime));


        int expected = 399;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void shouldCount10for4SameChars() {

        int result = sherlockAndAnagrams("kkkk");
        int expected = 10;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void shouldCount3() {
        int result = sherlockAndAnagrams("ifailuhkqq");
        int expected = 3;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static int sherlockAndAnagrams(String s) {
        int c = 0;
        char[] sa;
        sa = s.toCharArray();

        for (int index = 1; index < sa.length; index++) {
            for (int i = 0; i < sa.length - index + 1; i++) {
                String s1 = s.substring(i, index + i);
                for (int j = i + 1; j < sa.length - index + 1; j++) {
                    String s2 = s.substring(j, index + j);
//                     System.out.println(s1+"|"+s2);
                    if ( checkAnagram(s1, s2) == 1 )
                        c++;
                }
            }
        }

        return c;
    }


    public static int checkAnagram(String s1, String s2) {
        char a[] = s1.toCharArray();
        char b[] = s2.toCharArray();
        System.out.println(s1+" "+s2);

        int first[] = new int[26];
        int second[] = new int[26];
        Arrays.fill(first,0);
        Arrays.fill(second,0);

        int c=0;
        int sum = 0;
        while ( c < a.length) {
            sum = a[c] - 'a';
            first[ sum ]++;
            c++;
        }

        c = 0;
        while ( c < b.length) {
            sum = b[c] - 'a';
            second[ sum ]++;
            c++;
        }

        for (c = 0; c < 26; c++) {
            if ( first[c] != second[c] )
                return 0;
        }

        return 1;
    }

    /**
     * The sum of two different characters can be equal.
     * The problem does not work.
     */
    public static int checkAnagramWithSum(String s1, String s2) {
        char a[] = s1.toCharArray();
        char b[] = s2.toCharArray();

        int sumA = 0;
        int sumB = 0;
        int count = 0;
        int len = a.length;

        while ( count < len ) {
            sumA += a[count];
            sumB += b[count];
            count++;
        }

        return ( sumA == sumB ) ? 1 : 0;
    }

}


/**
 * This solution failed at run time.
 */
class SolutionNotAccepted
{
    public int sherlockAndAnagrams(String s) {
        int stringLength = s.length();
        int charToMakeAnagram = 0;

        for (int length = 1; length <= stringLength; length++) {

            for (int start1 = 0; start1 < stringLength; start1++) {

                for (int start2 = start1 + 1; start2 < stringLength; start2++) {
                    int end1 = start1 + length;
                    int end2 = start2 + length;

                    if( end1 <= stringLength && end2 <= stringLength ) {
                        String firstSubStr = s.substring(start1, end1);
                        String secondSubStr = s.substring(start2, end2);

                        if( checkAnagram(firstSubStr, secondSubStr) ) charToMakeAnagram++;
                    }
                }
            }
        }
//        System.out.println(charToMakeAnagram);

        return charToMakeAnagram;
    }

    private boolean checkAnagram(String firstSubStr, String secondSubStr) {

        Map<String, Integer> firstSubStrMap = getFrequencyMapFromArray(firstSubStr.split(""));
        Map<String, Integer> secondSubStrMap = getFrequencyMapFromArray(secondSubStr.split(""));
//        System.out.println(firstSubStrMap);
//        System.out.println(secondSubStrMap);

        for (String key : firstSubStrMap.keySet()) {

            if (!secondSubStrMap.containsKey(key)) {
                return false;
            }

            if (secondSubStrMap.get(key) < firstSubStrMap.get(key)) {
                return false;
            }
        }

        return true;

    }

    private Map<String, Integer> getFrequencyMapFromArray(String[] arr) {

        Map<String, Integer> map = new HashMap<>();

        for(String key : arr){
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key, 1);
        }
        return map;
    }

}