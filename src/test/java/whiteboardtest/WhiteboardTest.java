package whiteboardtest;

//import whiteboard.Whiteboard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WhiteboardTest {

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    public void shouldReturnTrueForOddNumbers(int number) {
        Assertions.assertTrue(isOdd(number));
    }

    /**
     * Given String s, find the lexicographically
     * smallest and largest substrings of length k.
     *
     * Parameters:
     *     string s: a string
     *     int k: the length of the substrings to find
     *
     * Returns
     *     string: the string ' + "\n" + ' where and are the two substrings
     */
    public String[] getSmallestAndLargestArray(String s, int k) {
        String smallest = "", largest = "";

//        Make a substring of lenght k.
//        Sort the String array
//        smallest = array[0]
//        largest = array[len-1]

        int i, j;
        int stringLength = s.length();
        ArrayList<String> subStringList
                = new ArrayList<String>();

        for (i = 0; i < s.length()-2  ; i++) {
            subStringList.add(s.substring(i, k+i));
        }

        Collections.sort(subStringList);
        smallest = subStringList.get(0);
        largest = subStringList.get(subStringList.size()-1);

        return new String[]{smallest, largest};
    }

    @Test
    public void shouldReturnSmallestAndLargestSubstring() {
        String s  =  "welcometojava";

        int k =  3;
        String[] actual = getSmallestAndLargestArray(s, k);
        String [] expected = new String[]{"ava", "wel"};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void main() {
        int N = 5;

        if (N%2 == 0) {
            if (N>1 && N<6)
                System.out.println("Not Weird");
            else if (N>5 && N <21)
                    System.out.println("Weird");
            else if (N>20) {
                System.out.println("Not Weird");
            }
        } else {
            System.out.println("Weird");
        }
    }


    /**
     * Break a string into two according to it's index value.
     * Print even first and odd second separated by a space.
     * Input = Hello
     * Output = "Hlo el"
     * S[0] = H
     * S[1] = e
     * S[2] = l
     * S[3] = l
     * S[4] = o
     *
     * Solution
     * Data structures
     * Use two Strings to store even and odd characters
     *
     * Algorithm
     * Read all Characters from the String
     * Starting from 0, add to even String
     * Next, add to odd.
     * And repeat.
     *
     * Concat the two Strings.
     *
     */
//    @Test
//    public void breakString() {
//        Scanner sc = new Scanner(System.in);
//        int wordsCount = sc.nextInt();
//
//        for (int j=0; j < wordsCount; j++) {
//            String s = sc.nextLine();
////        String s = "Hello";
//            StringBuilder oddS = new StringBuilder();
//            StringBuilder evenS = new StringBuilder();
//            evenS.append(s.charAt(0));
//
//            for(int i=1; i< s.length(); i++) {
//
//                if (i%2 == 0) evenS.append(s.charAt(i));
//                else oddS.append(s.charAt(i));
//            }
//
//            System.out.println(evenS.toString() + " " + oddS.toString());
//        }
//    }

    
    /**
     * A = [1,2,3,4,5]
     * Print 4 3 2 1. Each integer is separated by one space.
     */
    
    public void reversePrintWithSpace() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4);

        for(int a=arr.size()-1; a >-1; a--) {
            System.out.print(arr.get(a)+" ");
        }

//        int[] A = {1,2,3,4};
//        for(int a=A.length-1; a >-1; a--) {
//            System.out.print(A[a]+" ");
//        }
    }

//    @Test
//    public void checkFactorial(){
//        Whiteboard whiteboardObj = new Whiteboard();
//
//        Assertions.assertNotEquals(-1, whiteboardObj.factorialRecursive(3));
//        Assertions.assertEquals(6, whiteboardObj.factorialRecursive(3));
//        Assertions.assertEquals(24, whiteboardObj.factorialRecursive(4));
//        Assertions.assertEquals(0, whiteboardObj.factorialRecursive(0));
//        Assertions.assertEquals(0, whiteboardObj.factorialRecursive(-3));
//    }
//
//    @Test
//    public void checkConsecutiveOnes(){
//        Whiteboard whiteboardObj = new Whiteboard();
//
//        Assertions.assertEquals(0, whiteboardObj.findConsecutiveOnes(1));
//        Assertions.assertEquals(1, whiteboardObj.findConsecutiveOnes(5));
//        Assertions.assertEquals(2, whiteboardObj.findConsecutiveOnes(13));
//        Assertions.assertEquals(1, whiteboardObj.findConsecutiveOnes(2));
//        Assertions.assertEquals(5, whiteboardObj.findConsecutiveOnes(125));
//        Assertions.assertEquals(3, whiteboardObj.findConsecutiveOnes(7));
//    }
//
//    @Test
//    public void checkTestScores(){
//        Whiteboard whiteboardObj = new Whiteboard();
//
//        Assertions.assertEquals( 'D',
//                whiteboardObj.calculateAvg(
//                        new int[]{41, 42, 43, 44, 45,
//                                46, 48}));
//    }

    @Test
    public void divisorSum() {
        int num = 6;
        int sum = 0;

        for (int i=1; i<=num; i++){
            if(num%i == 0) sum+=i;
        }

        Assertions.assertEquals(12, sum);
    }
}