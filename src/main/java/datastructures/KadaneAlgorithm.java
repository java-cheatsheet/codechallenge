package datastructures;

public class KadaneAlgorithm {

    public static void main(String args[]) {
        int[] arr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
        int expected = 17;

        int result = Solution.getMaximumSumOfAllSubarraysFromArray(arr);
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

}


class Solution {

    static int getMaximumSumOfAllSubarraysFromArray(final int[] array) {
        int currentMaximum = 0;
        int overallMaximum = 0;
        for (final int arrayItem : array) {
            currentMaximum = currentMaximum + arrayItem;

            if (currentMaximum > 0)
                overallMaximum = Math.max(overallMaximum, currentMaximum);
            else
                currentMaximum = 0;
        }

        return overallMaximum;
    }


}