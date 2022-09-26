package googletest.Level3.Part2;

import google.Level3.Part2.Solution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class SolutionTest {
    @Test
    public void cases() {
        HashMap<int[], int[][]> hm = new HashMap<int[], int[][]>();

//        hm.put(
//                new int[] {7, 6, 8, 21},
//                new int[][]{
//                        {0, 2, 1, 0, 0},
//                        {0, 0, 0, 3, 4},
//                        {0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0},
//                }
//            );
//        hm.put(
//                new int[] {0, 3, 2, 9, 14},
//                new int[][]{
//                    {0, 1, 0, 0, 0, 1},
//                    {4, 0, 0, 3, 2, 0},
//                    {0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0}
//                }
//        );
//        hm.put(
//            new int[] {1, 2, 3},
//            new int[][]{
//                    {1, 2, 3, 0, 0, 0},
//                    {4, 5, 6, 0, 0, 0},
//                    {7, 8, 9, 1, 0, 0},
//                    {0, 0, 0, 0, 1, 2},
//                    {0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0}
//            }
//         );
//
//        hm.put(
//                new int[] {1,1},
//                new int[][]{{0}}
//        );
////
//        hm.put(
//                new int[] {1, 2, 3, 4, 5, 15},
//                new int[][]{
//                    {0, 0, 12, 0, 15, 0, 0, 0, 1, 8},
//                    {0, 0, 60, 0, 0, 7, 13, 0, 0, 0},
//                    {0, 15, 0, 8, 7, 0, 0, 1, 9, 0},
//                    {23, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                    {37, 35, 0, 0, 0, 0, 3, 21, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                }
//        );
//
//        hm.put(
//                new int[] {4, 5, 5, 4, 2, 20},
//                new int[][]{
//                    {0, 7, 0, 17, 0, 1, 0, 5, 0, 2},
//                    {0, 0, 29, 0, 28, 0, 3, 0, 16, 0},
//                    {0, 3, 0, 0, 0, 1, 0, 0, 0, 0},
//                    {48, 0, 3, 0, 0, 0, 17, 0, 0, 0},
//                    {0, 6, 0, 0, 0, 1, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//                }
//        );
//        hm.put(
//                new int[] {1, 1, 1, 1, 1, 5},
//                new int[][]{
//                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//                }
//        );
//        hm.put(
//                new int[] {2, 1, 1, 1, 1, 6},
//                new int[][]{
////                   0  1  2  3  4  5  6  7  8  9
//                    {1, 1, 1, 0, 1, 0, 1, 0, 1, 0}, // 0
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 1
//                    {1, 0, 1, 1, 1, 0, 1, 0, 1, 0}, // 2
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 3
//                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0}, // 4
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 5
//                    {1, 0, 1, 0, 1, 0, 1, 1, 1, 0}, // 6
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 7
//                    {1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, // 8
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}  // 9
//                }
//        );

//        hm.put(
//                new int[] {6, 44, 4, 11, 22, 13, 100},
//                new int[][]{
//                    {0, 86, 61, 189, 0, 18, 12, 33, 66, 39},
//                    {0, 0, 2, 0, 0, 1, 0, 0, 0, 0},
//                    {15, 187, 0, 0, 18, 23, 0, 0, 0, 0},
//                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//                }
//        );
//
        hm.put(
                new int[] {1, 1, 1, 2, 5},
                new int[][]{
                    {0, 0, 0, 0, 3, 5, 0, 0, 0, 2},
                    {0, 0, 4, 0, 0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 4, 4, 0, 0, 0, 1, 1},
                    {13, 0, 0, 0, 0, 0, 2, 0, 0, 0},
                    {0, 1, 8, 7, 0, 0, 0, 1, 3, 0},
                    {1, 7, 0, 0, 0, 0, 0, 2, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                }
        );

//        hm.put(
//                new int[] {},
//                new int[][]{}
//        );


        Iterator<Map.Entry<int[], int[][]>> entrySet = hm.entrySet().iterator();

        while (entrySet.hasNext())
        {
            Map.Entry<int[], int[][]> entry = entrySet.next();
//            System.out.println(Arrays.toString(entry.getKey()));

            int[] got = Solution.solution(entry.getValue());
            System.out.println(Arrays.toString(got));

            Assertions.assertArrayEquals(entry.getKey(), got);
        }

//
//        for(int i =0; i < hm.size(); i++)
//        {
//            System.out.println(hm);
//        }
//
//        Iterator keySetIterator = hm.keySet().iterator();
//
//        while (keySetIterator.hasNext())
//        {
////            String key = keySetIterator.next();
//
//            System.out.println("Key : "+key+"   Value : "+hm.get(key));
//        }


//        System.out.println(hm);
//        int[] got = Solution.solution(a);
//        Assertions.assertArrayEquals(want, got);
    }
}


/**
 * Theories tests.
 */
class TheoriesTest {
    @Test
    public void threeD() {
        int[][][] arr = {
                {{1, 2}, {3, 4}},
                {{5, 6}, {7, 8}}
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    @Test
    public void twoD() {
        int[][] arr = {
                {1, 2, 1},
                {3, 4, 1},
                {1, 1, 2}
        };
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < 3; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                        + arr[i][j]);
    }

    @Test
    public void tcase() {

        int[] numbers = {2, -9, 0, 5, 12, -25, 22, 9, 8, 12};
        int sum = 0;
        Double average;

        // access all elements using for each loop
        // add each element in sum
        for (int number : numbers) {
            sum += number;
        }

        // get the total number of elements
        int arrayLength = numbers.length;

        // calculate the average
        // convert the average from int to double
        average = (double) (sum / arrayLength);

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}