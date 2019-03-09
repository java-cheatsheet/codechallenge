package hackerrank;

import java.util.Objects;

public class RansomeNote {

    public static void main(String args[]) {
        ransomeNoteTrue();
        maganizeDoesNotContainRepeatedWord();
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        int j = 0;
        int i = 0;

        while ( i < note.length ) {
            String ransomeWord = note[i];

            while( j < magazine.length ) {
                String magazineWord = magazine[j];

                if ( ransomeWord.equals(magazineWord) ) {
                    break;
                }
                j++;
            }

            if ( j == magazine.length && i != note.length ) {
                    System.out.print("No");
                    break;
            }
            i++;
        }

        if ( i == note.length ) System.out.print("Yes");

    }

    static void ransomeNoteTrue() {
        String[] magazine =  {"me", "one", "grand", "today", "night"};
        String[] note =  {"me", "one", "grand", "today"};
        checkMagazine(magazine, note);
//        assert( checkMagazine(magazine, note).equals("Yes") ) : "Error";
    }

    static void maganizeDoesNotContainRepeatedWord() {
        String[] magazine =  {"two", "times", "three", "is", "not", "four"};
        String[] note =  {"two", "times", "two", "is", "four"};
        checkMagazine(magazine, note);
//        assert( checkMagazine(magazine, note) == "No" ) : "Error";
    }

}
