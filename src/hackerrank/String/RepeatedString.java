package hackerrank.String;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&h_r=next-challenge&h_v=zen&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 *
 * Lilah has a string,
 *
 * , of lowercase English letters that she repeated infinitely many times.
 *
 * Given an integer, find and print the number of letter a's in the first letters of Lilah's infinite string.
 *
 * For example, if the string s='abcac' and n =10, the substring we consider is abaacabcac, the first 10
 * characters of her infinite string. There are 4 occurrences of a in the substring.
 *
 */
// Solution-

// Brutforce - Make the string, count the string

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * length of string
 * number of character in the string
 * position of the character in the string
 *
 * ie. s=abcacb; n=16
 * los = 6
 * noc = 2
 * positions = 1, 4
 *
 * 16 = 6 * 2 + 1
 */
public class RepeatedString {

    public static void main(String[] args) {
//        String s, long n
        System.out.println( solution() );
    }

    public static long solution () {
        String s = "cabga";
        long n = 10;


        long dividend = n;
        long divisor = s.length();
//        System.out.println("divisor : " + divisor);

        if( s.matches("[^a]+") || s.length() == 0 || s == "" )
            return 0;

        if( s.matches("[a]+") && s.length() > 99 ) {
            return dividend;
        }

        long quotient = dividend / divisor;
        long remainder = dividend % divisor;

        long timesRepeated = 0;

        HashSet<Integer> aPositions =  new HashSet<>();

        System.out.println("quo : " + quotient);
        System.out.println("rem : " + remainder);


        for( int i = 0; i < divisor; i++ ) {
            if( s.charAt(i) == 'a' ) aPositions.add(i);
        }
        aPositions.forEach((key) -> System.out.println(key));


        if ( remainder == 0 ) {
            timesRepeated = aPositions.size() * quotient;

        } else {
            timesRepeated = (aPositions.size() * quotient);

            for (int i = 0; i < remainder; i++ ) {
                if ( aPositions.contains(i) ) timesRepeated++;
            }
        }

        System.out.println("Repeated Chars : " + timesRepeated);

        return timesRepeated;
    }

}
