package basics;

public class KadaneAlgorithm {

    public static void main(String args[]) {

    }



}


class Solution {

    public int getMaximumSumOfAllSubarraysFromArray(final int[] array) {
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