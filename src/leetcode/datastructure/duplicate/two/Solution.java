package leetcode.datastructure.duplicate.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import static java.lang.Math.abs;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int[] numsClone = nums.clone();
        Arrays.sort(numsClone);
        int parent = 0;
        int count = 0;

        for (; count < nums.length-1; count++) {

            if (numsClone[count] == numsClone[count + 1]) {
                    parent++;
            } else {

                if ( parent > 0 ) {
                    int num = numsClone[count];

                    ArrayList<Integer> indexes = new ArrayList<Integer>();
                    int index = 0;

                    for (int j=0; j <= parent ;j++) {

                        index = IntStream.range(index, nums.length).
                                filter(a -> num == nums[a]).
                                findFirst().orElse(Integer.MIN_VALUE);

                        if ( index > Integer.MIN_VALUE )
                            indexes.add(index);

                        index++;
                    }

                    for (int xk=0; xk < indexes.size(); xk++){

                        for (int l=xk+1; l < indexes.size(); l++){

                            if( abs(indexes.get(xk) - indexes.get(l)) <= k )
                                return  true;
                        }
                    }
                }

                parent = 0;
            }
        }

        if ( parent > 0 ) {
            int num = numsClone[count];

            ArrayList<Integer> indexes = new ArrayList<Integer>();
            int index = 0;

            for (int j=0; j <= parent ;j++) {

                index = IntStream.range(index, nums.length).
                        filter(a -> num == nums[a]).
                        findFirst().orElse(Integer.MIN_VALUE);

                if ( index > Integer.MIN_VALUE )
                    indexes.add(index);

                index++;
            }

            for (int xk=0; xk < indexes.size(); xk++){

                for (int l=xk+1; l < indexes.size(); l++){

                    if( abs(indexes.get(xk) - indexes.get(l)) <= k )
                        return  true;
                }
            }
        }

        return false;
    }

//    Fails test case with exception : Time Limit Exceeded
//    20 / 51 test cases passed.
    public boolean containsNearbyDuplicateInputStream(int[] nums, int k) {

        for (int count = 0; count < nums.length-1; count++) {
            int numToFind = nums[count];
            int indexOfElement = IntStream.range( count + 1, nums.length).
                    filter( j -> numToFind == nums[j]).
                    findFirst().orElse(Integer.MIN_VALUE);

            if ( indexOfElement != Integer.MIN_VALUE && abs(count - indexOfElement) <= k) {
                return true;
            }
        }

        return false;
    }

    //    48 / 51 test cases passed.
    //    Fails test case with exception : Time Limit Exceeded
    public boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
           for ( int j = i+1; j < nums.length; j++ ) {

                if ( nums[i] == nums[j] && abs(i-j) <= k )
                    return true;
            }
        }

        return false;
    }

}
