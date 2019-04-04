package hackerrank;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/string-reduction
 *
 * Solution:
 *
 * Asseted logic fot the solution is taken from the
 * discussion section of the problem:
 * If two of these counts are 0, then return string.length
 * Else if (all counts are even) or (all counts are odd), then return 2
 * Else, then return 1
 *
 * abcbcba      :   1   :   a=2, b=3, c=2
 * ababbac      :   2   :   a=3, b=3, c=1
 * abababaccc   :   1   :   a=4, b=3, c=3
 *
 * cab          :   2   :   a=1, b=1, c=1
 * bcab         :   1   :   a=1, b=2, c=1
 * ccccc        :   5   :   a=0, b=0, c=5
 *
 *
 * Algorithm:
 * 1. Count the numbers of a,b,c
 * 2. Validate with the asserted logic
 *
 * Other resources:
 * https://www.baeldung.com/java-count-chars
 * https://stackoverflow.com/questions/8033553/stumped-on-a-java-interview-need-some-hints/8715230#8715230
 *
 * Note:
 * Solution passed all the hackerrank tests.
 * Although the problem was listed in dynamic
 * programming section, the solution was derived
 * more in a mathematical sense. The stackoverflow
 * discussion by steveya who tries to present nice
 * overview from dynamic programming prespective
 * but I do not see a solution and also his
 * answer is not functional.
 *
 * Reached this problem while trying to resolve
 * Maximum Subarray Problem https://www.hackerrank.com/challenges/maxsubarray/problem
 * And found the resource for basic dynamic programming
 * https://www.hackerrank.com/challenges/maxsubarray/topics/dynamic-programming-basics
 */
public class StringReduction {

    public static void main(String args[]) {
        testOddData();
        testOddEvenData();
        testValidAllOdd();
        testValidAllEven();
        testWithAll5c();
        testOddData2();
        testWithabcbcba();
    }

    public static void testWithabcbcba() {
        String s = "abcbcba";
        long result = stringReduction(s);
        long expected = 1;
        assert (result == expected) : "testOddData - Result:" + result +" | Expected:" + expected;
    }

    public static void testWithAll5c() {
        String s = "ccccc";
        long result = stringReduction(s);
        long expected = 5;
        assert (result == expected) : "testOddData - Result:" + result +" | Expected:" + expected;
    }

    public static void testOddData2() {
        String s = "bcab";
        long result = stringReduction(s);
        long expected = 1;
        assert (result == expected) : "testOddData - Result:" + result +" | Expected:" + expected;
    }

    public static void testOddData() {
        String s = "cab";
        long result = stringReduction(s);
        long expected = 2;
        assert (result == expected) : "testOddData - Result:" + result +" | Expected:" + expected;
    }

    public static void testOddEvenData() {
        String s = "abababaccc";
        long result = stringReduction(s);
        long expected = 1;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void testValidAllOdd() {
        String s = "ababbac";
        long result = stringReduction(s);
        long expected = 2;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    public static void testValidAllEven() {
        String s = "bbcc";
        long result = stringReduction(s);
        long expected = 2;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static int stringReduction(String s) {
        int sLen = s.length();
        int lenA = 0;
        int lenB = 0;
        int lenC = 0;

        for ( int i = 0; i < sLen; i++ ) {
            switch (s.charAt(i)) {
                case 'a': lenA++; break;
                case 'b': lenB++; break;
                case 'c': lenC++; break;
            }
        }

        if ( checkOddOREven( lenA, lenB, lenC ) ) return 2;

        return checkAnyTwoCharCountIsZero(lenA, lenB, lenC, sLen);

    }

    static boolean checkOddOREven( int lenA, int lenB, int lenC ) {

        if ( lenA % 2 == 0 && lenB % 2 == 0 && lenC % 2 == 0 ) return true;
        else if ( lenA % 2 == 1 && lenB % 2 == 1 && lenC % 2 == 1 ) return true;
        else return false;
    }

    static int checkAnyTwoCharCountIsZero( int lenA, int lenB, int lenC, int sLen ) {

        if ( ( lenA == lenB && lenA == 0 && lenC > 1 )
                || ( lenB == lenC && lenB == 0 && lenA > 1 )
                || ( lenC == lenA && lenC == 0 && lenB > 1 ) ) return sLen;

        return 1;
    }

}
