package hackerrank.java;

import hackerrank.java.Anagrams;

import java.util.Arrays;

public class Anagrams {
    String first;
    String second;

    public Anagrams(String first, String second) {
        this.first =  first;
        this.second =  second;
    }

    public boolean isAnagram() {

        if (first.length() != second.length())
            return false;

        // sort
        char[] firstCharArr =  first.toUpperCase().toCharArray();
        char[] secondCharArr =  second.toUpperCase().toCharArray();
        Arrays.sort(firstCharArr);
        Arrays.sort(secondCharArr);

        // compare all the characters
        for (int i=0; i<first.length(); i++){

            if (  firstCharArr[i] != secondCharArr[i])
                return false;
        }

        return true;
    }
}
