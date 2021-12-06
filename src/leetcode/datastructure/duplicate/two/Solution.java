package leetcode.datastructure.duplicate.two;

import static java.lang.Math.abs;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length - 1; i++) {
            for ( int j = i+1; j < nums.length; j++ ) {

                if ( nums[i] == nums[j] && abs(i-j) <= k )
                    return true;
            }
        }

        return false;
    }
}
