package leetcode.datastructure.containsduplicate.three;

import java.util.Arrays;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if ( nums.length == 0 || nums.length == 1 || k ==0 ) return false;

        if ( nums.length == 2 ) {
            long first = nums[0];
            long second = nums[1];
            long diff = Math.abs(first - second);
            if ( diff <= t )
                return true;
        }

        int initialRange = k>nums.length?nums.length:k+1;
        int loops = nums.length>=k?nums.length-k:nums.length;
        int count = 0;

        for (; count < loops; count++) {
            int[] window = Arrays.copyOfRange(nums, count, initialRange + count);
            Arrays.sort(window);

            for (int i = 0; i < window.length-1; i++) {
                long first = window[i];
                long second = window[i+1];
                long diff = Math.abs(first - second);

                if ( diff <= t )
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
}
