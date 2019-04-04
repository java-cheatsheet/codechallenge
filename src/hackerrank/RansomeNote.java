package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem Definition:
 *
 * https://www.hackerrank.com/challenges/ctci-ransom-note/
 *
 * Harold is a kidnapper who wrote a ransom note,
 * but now he is worried it will be traced back
 * to him through his handwriting. He found a
 * magazine and wants to know if he can cut out
 * whole words from it and use them to create an
 * untraceable replica of his ransom note. The
 * words in his note are case-sensitive and he
 * must use only whole words available in the
 * magazine. He cannot use substrings or concatenation
 * to create the words he needs.
 *
 * Given the words in the magazine and the words
 * in the ransom note, print Yes if he can replicate
 * his ransom note exactly using whole words from
 * the magazine; otherwise, print No.
 *
 * For example, the note is "Attack at dawn".
 * The magazine contains only "attack at dawn".
 * The magazine has all the right words, but
 * there's a case mismatch. The answer is NO.
 *
 */
public class RansomeNote {

    public static void main(String args[]) {
        Ransome noteObj = new RansomeNotesJava7();
//        Ransome noteObj = new RansomeNoteWithStreams();

        ransomeNoteTrue(noteObj);
        maganizeDoesNotContainRepeatedWord(noteObj);
    }

    static void ransomeNoteTrue(Ransome ransome) {
        String[] magazine =  {"me", "one", "grand", "today", "night"};
        String[] note =  {"me", "one", "grand", "today"};
        ransome.checkMagazine(magazine, note);
//        assert( checkMagazine(magazine, note).equals("Yes") ) : "Error";
    }

    static void maganizeDoesNotContainRepeatedWord(Ransome ransome) {
        String[] magazine =  {"two", "times", "three", "is", "not", "four"};
        String[] note =  {"two", "times", "two", "is", "four"};
        ransome.checkMagazine(magazine, note);
//        assert( checkMagazine(magazine, note) == "No" ) : "Error";
    }

}


interface Ransome {
    // Any number of final, static fields
    // Any number of abstract method declarations
    void checkMagazine(String[] magazine, String[] ransom);
}

/**
 * Solutions source: https://codereview.stackexchange.com/questions/159872/hackerrank-hash-tables-ransom-note
 */

class RansomeNoteWithStreams implements Ransome {
    private boolean getRansom(String[] magazine, String[] ransom) {

        if (magazine.length < ransom.length)
            return false;

        Map<String, Long> magazineMap = getFrequencyMapFromArray(magazine);
        Map<String, Long> ransomMap = getFrequencyMapFromArray(ransom);
        System.out.println(magazineMap);
        System.out.println(ransomMap);

        return (ransomMap.entrySet().stream()
                .filter(i -> (!magazineMap.containsKey(i.getKey()) || magazineMap.get(i.getKey()) < i.getValue()))
                .count() == 0);

    }

    private Map<String, Long> getFrequencyMapFromArray(String[] arr) {

        return Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void checkMagazine(String[] magazine, String[] ransom) {
        if (getRansom(magazine, ransom))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}


class RansomeNotesJava7 implements Ransome {

    public void checkMagazine(String[] magazine, String[] ransom) {
        if (getRansom(magazine, ransom))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private boolean getRansom(String[] magazine, String[] ransom) {

        if( magazine.length >= ransom.length ) {

            Map<String, Integer> magazineMap = getFrequencyMapFromArray(magazine); //Arrays.stream(magazine).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<String, Integer> ransomMap = getFrequencyMapFromArray(ransom); //Arrays.stream(ransom).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            System.out.println(magazineMap);
            System.out.println(ransomMap);

            for (String key : ransomMap.keySet()) {

                if (!magazineMap.containsKey(key)) {
                    return false;
                }

                if (magazineMap.get(key) < ransomMap.get(key)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private  Map<String, Integer> getFrequencyMapFromArray(String[] arr) {

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


/**
 *
 *  This function was the original solution which did not meet the condition.
 *  But is nice to have as a reference.
 *

 static void checkMagazinePrevious(String[] magazine, String[] note) {

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

 *
 */