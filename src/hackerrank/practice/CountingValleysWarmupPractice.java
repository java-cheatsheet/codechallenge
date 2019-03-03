package hackerrank.practice;

import java.util.Arrays;

public class CountingValleysWarmupPractice {

    static int countValleyWalk = 0;

    public static void main (String g[]) {
        findPairsOfNumber();
    }

    public static int findPairsOfNumber() {
//      int n, String s
        String str = "UUDDDD";//"UDDDUDUU";

//        str.chars().forEachOrdered(i -> System.out.print((char)i));
//        return 0;

//        String str = "....";
//        int offset = 0, strLen = str.length();
//        while (offset < strLen) {
//            int curChar = str.codePointAt(offset);
//            offset += Character.charCount(curChar);
//            // do something with curChar
//            System.out.println((char)curChar);
//        }
//        int[] ccc = str.codePoints().toArray();

        int seaLevel, countValleyWalked, counter;
        counter = seaLevel = countValleyWalked = 0;
        while (counter < str.length()) {

            if( str.charAt(counter) == 'U' ) {
                seaLevel++;

                if(seaLevel == 0) countValleyWalked++;

            } else {
                // OR the condition here
                //if(seaLevel == 0) countValleyWalked++;
                seaLevel--;
            }

            counter++;
        }

        System.out.println(countValleyWalked);
        return countValleyWalked;
    }
}
