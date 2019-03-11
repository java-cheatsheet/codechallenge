package hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Definition:
 *
 * https://www.hackerrank.com/challenges/two-strings/
 *
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 * For example, the words "a", "and", "art" share the common substring a.
 * The words "be" and "cat" do not share a substring.
 *
 */
public class TwoString {

    public static void main(String args[]) {
        exampleWithRetainAll();
//        substringExists();
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s1Len; i++) {
            set.add(s1.charAt(i));
        }

        for (int i = 0; i < s2Len; i++) {

            if (set.contains(s2.charAt(i))) return "YES";
        }

        return "NO";
    }

    static void substringExists() {
        String s1 = "hello";
        String s2 = "world";

        assert (twoStrings(s1,s2) == "YES") : "Must be YES";
    }

    static void exampleWithRetainAll() throws NullPointerException {
        try {

            // Creating object of HashSet<Integer>
            HashSet<Integer>
                    arrset1 = new HashSet<Integer>();

            // Populating arrset1
            arrset1.add(1);
            arrset1.add(2);
            arrset1.add(3);
            arrset1.add(4);
            arrset1.add(5);

            // print arrset1
            System.out.println("HashSet before "
                    + "retainAll() operation : "
                    + arrset1);

            // Creating another object of  HashSet<Integer>
            HashSet<Integer>
                    arrset2 = new HashSet<Integer>();
            arrset2.add(6);
            arrset2.add(7);
            arrset2.add(8);

            // Will throw null pointer exception.
            //arrset2 = null;

            // print arrset2
            System.out.println("Collection Elements"
                    + " to be retained : "
                    + arrset2);

            // Removing elements from arrset
            // specified in arrset2
            // using retainAll() method
            arrset1.retainAll(arrset2);

            // print arrset1
            System.out.println("HashSet after "
                    + "retainAll() operation : "
                    + arrset1);
        }

        catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}
