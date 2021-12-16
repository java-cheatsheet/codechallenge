package talabat.route;

import java.util.HashMap;

class Solution {

    public String trackRoute(String[][] itineraries) {
        int startIndex = this.findStartingIndex(itineraries);
        return this.createPath(startIndex, itineraries);
    }

    public int findStartingIndex(String[][] itineraries) {
        String start = "";
        boolean startFound = false;
        int i = 0;

        for (; i < itineraries.length && startFound == false; i++) {
            start = itineraries[i][0];
            int j = 0;

            for (; j < itineraries.length; j++) {

                if (i != j && start == itineraries[j][1]) {
                    j = itineraries.length + 1;
                }
            }

            if (j == itineraries.length) {
                startFound =true;
            }
        }

        return i-1;
    }

    public String createPath(int startIndex, String[][] itineraries) {
        String route = itineraries[startIndex][0] + ", " + itineraries[startIndex][1];
        String nextStart = itineraries[startIndex][1];
        HashMap<Integer, Boolean> traversedIndex = new HashMap<Integer, Boolean>();
        traversedIndex.put(startIndex, true);

        for (int l = 0; l < itineraries.length+1; l++) {

            if ( traversedIndex.containsKey(l) == false ) {
                int m = 0;
                for (; m < itineraries.length; m++) {

                    if ( traversedIndex.containsKey(m) == false
                            && nextStart == itineraries[m][0]) {
                        nextStart = itineraries[m][1];
                        route += ", " + itineraries[m][1];
                        traversedIndex.put(m, true);
                    }
                }
            }
        }

        return route;
    }

}
