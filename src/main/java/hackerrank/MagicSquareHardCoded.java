package hackerrank;

import java.io.*;
import java.util.*;

/**
 * Solution is taken from:
 * https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Implementation/Forming%20a%20Magic%20Square/Solution.java#L18
 *
 */
public class MagicSquareHardCoded {

    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
        int[][][] possiblePermutations = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},// 1

                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},// 2

                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},// 3

                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},// 4

                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},// 5

                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},// 6

                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},// 7

                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},// 8
        };

//        int[][] given = new int[3][3];
//        for (int i = 0; i < 3; i++)
//        {
//            for (int j = 0; j < 3; j++)
//                given[i][j] = input.nextInt();
//        }
        int[][] given = new int[][]{
                { 4, 9, 2},
                { 3, 5, 7},
                { 8, 1, 6}
        };

        int minCost = Integer.MAX_VALUE;
        for (int permutation = 0; permutation < 8; permutation++)
        {
            int permutationCost = 0;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                    permutationCost += Math.abs(given[i][j] - possiblePermutations[permutation][i][j]);
            }
            minCost = Math.min(minCost, permutationCost);
        }
        System.out.println(minCost);
    }
}