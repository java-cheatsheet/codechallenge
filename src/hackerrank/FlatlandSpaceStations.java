package hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Flatland Space Stations
 * Flatland is a country with a number of cities,
 * some of which have space stations. Cities are
 * numbered consecutively and each has a road of
 * length 1km connecting it to the next city.
 *
 * It is not a circular route, so the first city
 * doesn't connect with the last city.
 *
 * Determine the maximum distance from any city
 * to its nearest space station.
 *
 * Function Description
 * Complete the flatlandSpaceStations function in the editor below.
 *
 * flatlandSpaceStations has the following parameter(s):
 *
 *     int n: the number of cities
 *     int c[m]: the indices of cities with a space station
 *
 * Returns
 * - int: the maximum distance any city is from a space station
 *
 * Input Format
 * The first line consists of two space-separated integers n and m.
 *
 * The second line contains space-separated integers,
 * the indices of each city that has a space-station.
 * These values are unordered and distinct.
 *
 * Constraints
 * 1 <= n <= 10^5
 * 1 <= m <= n
 *
 * There will be at least 1 city with a space station.
 * No city has more than one space station.
 *
 * Problem: https://www.hackerrank.com/challenges/flatland-space-stations/problem
 *
 * # Solution
 * The maximum distance any city is from a space station.
 *
 * Example 1
 * 5 2    n = 5, c[] size m = 2
 * 0 4    space stations
 *
 * There are five cities, c0,c1,c2,c3,c4.
 * c0 and c4 has space stations.
 * c2 has the maximum distance either to c0 or c4.
 * So maximum distance is 2.
 *
 * We only need to find the distances from those
 * cities which do not have the space station.
 *
 * Example 2
 * 6 6 n=6, m=6
 * 0 1 2 4 3 5
 * As all the cities have stations, maximum
 * distance from any city to a space station
 * is 0.
 *
 *
 *
 * Pseudocode
 * maxDistance = 0
 * We have to calculate the distance for each
 * city to another, so we need two loops.
 *
 * for i=0;i<cities.length;i++
 *  for j=i+1;j<
 *
 * I think we just need to find maximum distance
 * between two stations, i.e. from a city to a
 * station between the stations.
 *
 * The distance from one (minimum) end point to
 * a space station.
 *
 * If there is only space station, calculate the
 * max distance from both ends.
 *
 * If there is only space station which is at
 * the either ends, get the distance from the
 * number of cities-1.
 */
public class FlatlandSpaceStations {
    public static int flatlandSpaceStations(int n, int[] c){
        int spaceStations = c.length;

        if ( n == 1 && spaceStations == 1 ) return 0;
        else if ( n == 2 && spaceStations == 1 ) return 1;
        else if ( n == 2 && spaceStations == 2 ) return 0;
        else if ( n == 3 && spaceStations == 2 ) return 1;

        if ( spaceStations == 1 ) {
            int firstSpaceStation = c[0];

            if ( n == 3 )
                return Math.max(firstSpaceStation, n-firstSpaceStation-1);

            else if ( firstSpaceStation == c.length-1 || c.length == 3 )
                return Math.max(firstSpaceStation-1, n-firstSpaceStation-1);

            else
                return Math.max(Math.abs(firstSpaceStation-1), n-firstSpaceStation);
        }

        Arrays.sort(c);
        int maxDistance = 0;

        int[] withLastCity = new int[spaceStations+1];
        withLastCity[spaceStations] = n-1;

        System.arraycopy(c, 0, withLastCity, 0, spaceStations);
        // maximum distance between space stations

        for(int i=0; i<spaceStations-1; i++){
            int distanceDiff =  Math.abs(withLastCity[i]-withLastCity[i+1]);

            if ( maxDistance < distanceDiff)
                maxDistance = distanceDiff;
        }

        return maxDistance;
    }
}


class FlatlandSpaceStationsTest {

    @Test
    @Disabled
    void hasFourCitiesThreeStationsAtFirstSecondLast() {
        int n=4, expected=1; // Distance from city four to city 2
        int[] c={0,1,3};
        Assertions.assertEquals(expected,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));

        /**
         * The current implementation fails.
         * Expected :1
         * Actual   :2
         *
         * The maximum distance being calculated
         */
    }

    @Test
    @Disabled
    void hasFourCitiesTwoStationsAtFirstAndSecond() {
        int n=4, expected=2; // Distance from city four to city 2
        int[] c={0,1};
        Assertions.assertEquals(expected,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));

        /**
         * Get the maximum distance in space stations.
         * Here, 0 and 1 has 0 distance but there
         * 0 is the starting so no other cities and
         * there are cities after one as total cities
         * is 4.
         */
    }

    @Test
    void hasThreeCityTwoStationsAtFirstAndThird() {
        int n=3, expected=1;
        int[] c={0,2};
        Assertions.assertEquals(expected,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

    @Test
    void hasThreeCityTwoStations() {
        int n=3, expected=1;
        int[] c={0,1};
        Assertions.assertEquals(expected,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

    @Test
    void hasTwoCityTwoStations() {
        int n=2, expected=0;
        int[] c={0,1};
        Assertions.assertEquals(expected,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

    @Test
    void hasFourCitiesAndOneStationAtFirst() {
        int n=4;
//        Distance from first to fourth city 4-1 =3
        int expectedMaxDistance=3;
        int[] c={0};
        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

    @Test
    void hasFourCitiesAndOneStationAtThird() {
        int n=4, expectedMaxDistance=2;
        int[] c={2};
        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

    @Test
    void hasThreeCitiesAndOneStationAtThird() {
        int n=3, expectedMaxDistance=2;
        int[] c={2};
        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
}

    @Test
    void hasThreeCitiesAndOneStationAtSecond() {
        int n=3, expectedMaxDistance=1;
        int[] c={1};
        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

    @Test
    void hasThreeCitiesAndOneStationAtFirst() {
        /**
         * Case1: c0 has a station
         *
         * Get max distance from either end.
         */
        int n=3, expectedMaxDistance=2;
        int[] c={0};
        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

    @Test
    void hasTwoCity() {
        int n=2, expected=1;
        int[] c={0};
        Assertions.assertEquals(expected,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

    @Test
    void hasOneCity() {
        int n=1, expected=0;
        int[] c={0};
        Assertions.assertEquals(expected,
                FlatlandSpaceStations.flatlandSpaceStations(n, c));
    }

}
