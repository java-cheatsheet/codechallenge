package leetcode.datastructure.containsduplicate.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import static java.lang.Math.abs;

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if ( nums.length == 1 || k == 0 )
            return false;

        if ( nums.length <= k && nums[0] == nums[nums.length-1]) {
            return true;
        }

        Map<Integer, ArrayList<Integer>> nmap = new HashMap<Integer, ArrayList<Integer>>();
        int numsLen =  nums.length;

        for (int i = 0; i < numsLen; i++) {
            nmap.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
        }

        for(Map.Entry<Integer,ArrayList<Integer>> entry : nmap.entrySet()){
            ArrayList<Integer> dupIndex = entry.getValue();
            int dupIndexSize = dupIndex.size();
            int currIndex =  dupIndex.get(0);

            if( dupIndexSize > 1 ) {
                int i = 1;
                int nextIndex =  dupIndex.get(i);

                for(; i < dupIndex.size(); i++) {

                    if ( isLessThanOrEqualsK(currIndex, nextIndex, k) == true )
                            return true;

                    currIndex = nextIndex;
                    nextIndex = dupIndex.get(i);
                }


            }
        }

        return false;
    }

    public boolean isLessThanOrEqualsK(int current, int next, int k){
        if ( abs(current - next) <= k)
            return  true;

        return false;
    }
    // Fails with Time Limit Exceeded for test case 47
    public boolean containsNearbyDuplicateSlidingWindowFAILS(int[] nums, int k) {
        if ( nums.length == 1 )
            return false;

        if ( nums.length <= k && nums[0] == nums[nums.length-1]) {
            return true;
        }

        int initialRange =  nums.length-k == 1 ? k+1 : k;

        if ( k == 1 || k == 2 ||  k % 2 > 0 ) initialRange = k+1;

        int loops = nums.length-k;

        int count = 0;
        for (; count < loops; count++) {
            int[] window = Arrays.copyOfRange(nums, count, initialRange + count);
            Arrays.sort(window);

            for (int i = 0; i < window.length-1; i++) {
                    if (window[i] == window[i+1])
                        return true;
            }
        }

        // Last few values would not have been compared
        // beacuase of the size of sliding window above.
        for (; count < nums.length-1 && k > 2; count++, k--) {
            for (int l = count; l < nums.length-1; l++) {

                if (nums[count] == nums[l + 1])
                    return true;
            }
        }

        return false;
    }

    // Fails with Time Limit Exceeded for test case 47
    public boolean containsNearbyDuplicateFails(int[] nums, int k) {
        int i = 0;
        int window =  nums.length - k == 1 ? 2 : nums.length - k;

        for (; i < window; i++) {
            for (int j = i; j < i + k; j++) {

                if (nums[i] == nums[j+1])
                        return true;
            }
        }

        for (; i < nums.length-1 && window > 2; i++, k--) {
            for (int l = i; l < nums.length-1; l++) {

                if (nums[i] == nums[l + 1])
                    return true;
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicateSUCCESS(int[] nums, int k) {
        int[] numsClone = nums.clone();
        Arrays.sort(numsClone);
        int duplicateCount = 0;
        int count = 0;

        for (; count < nums.length-1; count++) {

            if (numsClone[count] == numsClone[count + 1]) {
                duplicateCount++;
            } else {

                if ( duplicateCount > 0 ) {

                    if ( this.isLessThanK(numsClone[count], duplicateCount, k, nums) == true )
                        return true;
                }

                duplicateCount = 0;
            }
        }

        if ( duplicateCount > 0 ) {
            return this.isLessThanK(numsClone[count], duplicateCount, k, nums);
        }

        return false;
    }

    public boolean isLessThanK(int num, int duplicateCount, int k, int[] nums){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int index = 0;

        for (int j = 0; j <= duplicateCount; j++) {

            index = IntStream.range(index, nums.length).
                    filter(a -> num == nums[a]).
                    findFirst().orElse(Integer.MIN_VALUE);

            if ( index > Integer.MIN_VALUE )
                indexes.add(index);

            index++;
        }

        for (int y=0; y < indexes.size(); y++) {
            for (int z = y + 1; z < indexes.size(); z++) {

                if ((abs(indexes.get(y) - indexes.get(z))) <= k)
                    return  true;
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicateAccepted(int[] nums, int k) {
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
