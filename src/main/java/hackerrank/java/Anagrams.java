package hackerrank.java;

import java.util.Arrays;
import java.util.Locale;

public class Anagrams {
    String first;
    String second;

    public Anagrams(String first, String second) {
        this.first =  first;
        this.second =  second;
    }

    public boolean isAnagram() {

        if ( first.length() != second.length() ) {
            return false;
        }
        Locale locale = Locale.ENGLISH;
        String firstUpper = first.toUpperCase(locale);
        String secondUpper = second.toUpperCase(locale);
        char[] firstCharArr =  firstUpper.toCharArray();
        char[] secondCharArr =  secondUpper.toCharArray();
        Arrays.sort(firstCharArr);
        Arrays.sort(secondCharArr);

        for (int i=0; i < first.length(); i++) {

            if (  firstCharArr[i] != secondCharArr[i] ) {
                return false;
            }
        }

        return true;
    }
}
