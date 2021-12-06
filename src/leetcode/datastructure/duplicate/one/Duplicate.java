package leetcode.datastructure.duplicate.one;

import java.util.Arrays;

public class Duplicate {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int count = 0; count < nums.length-1; count++) {

            if ( nums[count] == nums[count+1] )
                return true;
        }

        return false;
    }
}