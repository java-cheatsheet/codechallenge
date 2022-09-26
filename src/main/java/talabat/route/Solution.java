package talabat.route;

import java.util.HashMap;

public class Solution {

    public String trackRoute(String[][] itineraries) {
        String route = "";
        int itineraryLen = itineraries.length;

        if( itineraryLen == 1 ) {
            return itineraries[0][0] + ", " + itineraries[0][1];
        }

//        1. Transform to hashmap
//        2. Find starting point
//        3. Make route


//        Transform to hashmap
        HashMap<String, String> itinerariesMap = new HashMap<>();

        for (int i=0; i<itineraryLen; i++) {
            itinerariesMap.put(itineraries[i][0],itineraries[i][1]);
        }

//        Find starting point
        boolean foundStart = false;
        String start = "";
        for ( int i=0; i < itineraryLen && foundStart == false; i++ ) {
            start = itineraries[i][0];

            if ( !itinerariesMap.containsValue(start) )
                foundStart = true;
        }

//        Make route
        String end = itinerariesMap.get(start);
        route += start + ", " + end;

//        As we can take start and end at once,
//        find the number of iterations to make
        int loop = itineraryLen/2 + itineraryLen%2 - 1;

        for ( int i=0; i<loop; i++ ) {
            start = itinerariesMap.get(end);
            end = itinerariesMap.get(start);
            route += ", " + start + ", " + end;

        }

//        Last destination is missed when itineraries
//        length is even
        if ( itineraryLen % 2 == 0 )
            route += ", " + itinerariesMap.get(end);

        return route;
    }
}

class SolutionLegacy {

    public String trackRoute(String[][] itineraries) {
        int startIndex = this.findStartingIndex(itineraries);
        return this.createPath(startIndex, itineraries);
    }

    public int findStartingIndex(String[][] itineraries) {
        int itineraryLen = itineraries.length;
        String start = "";
        boolean startFound = false;
        int i = 0;

        for (; i < itineraryLen && startFound == false; i++) {
            start = itineraries[i][0];
            int j = 0;

            for (; j < itineraryLen; j++) {

                if (i != j && start == itineraries[j][1]) {
                    j = itineraryLen + 1;
                }
            }

            if (j == itineraryLen) {
                startFound =true;
            }
        }

        return i-1;
    }

    public String createPath(int startIndex, String[][] itineraries) {
        int itineraryLen = itineraries.length;
        String route = itineraries[startIndex][0] + ", " + itineraries[startIndex][1];
        String nextStart = itineraries[startIndex][1];
        HashMap<Integer, Boolean> traversedIndex = new HashMap<Integer, Boolean>();
        traversedIndex.put(startIndex, true);

        for (int l = 0; l < itineraryLen+1; l++) {

            if ( traversedIndex.containsKey(l) == false ) {
                int m = 0;
                for (; m < itineraryLen; m++) {

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
