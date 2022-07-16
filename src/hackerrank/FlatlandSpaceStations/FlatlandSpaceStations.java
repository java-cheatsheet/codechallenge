package hackerrank.FlatlandSpaceStations;

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
    public static int flatlandSpaceStations(
            int noOfCities,
            int[] spaceStations) {
        int noOfSpaceStations = spaceStations.length;

        if (noOfCities == noOfSpaceStations)
            return 0;

        else if (noOfCities == 2 && noOfSpaceStations == 1)
            return 1;

        else if (noOfCities == 3 && noOfSpaceStations == 2)
            return 1;

        else if (noOfSpaceStations == 1) {

            // if the space station is at first or last
            if (spaceStations[0] == 0 ||
                    spaceStations[0] == noOfCities - 1)
                return noOfCities - 1;

            else {
                return Math.max(spaceStations[0],
                        noOfCities - 1 - spaceStations[0]);

            }
        }

        Arrays.sort(spaceStations);

        // First and last cities are the space station.
        if (spaceStations[0] == 0 &&
                spaceStations[1] == noOfCities - 1)
            return (spaceStations[1] - spaceStations[0]) / 2;

        if (areSpaceStationsConsecutiveLast(
                spaceStations,
                noOfSpaceStations,
                noOfCities))
            return spaceStations[0];

        int maxDistance = 0;

        // If first city is not a space station
        if (spaceStations[0] != 0) {
            maxDistance = spaceStations[0];
        } else if ( spaceStations[0] == 0 ) {
            maxDistance = (spaceStations[1]-spaceStations[0])/2;
        }

        for (int i = 1; i < noOfSpaceStations-1; i++)  {
            int distance = (spaceStations[i+1] - spaceStations[i])/2;

            if ( distance > maxDistance )
                maxDistance = distance;
        }

        // If last space station is not the last city
        if ( spaceStations[noOfSpaceStations-1] != noOfCities -1 ) {
            int lastSpaceStationDistance = noOfCities - 1 -
                    spaceStations[noOfSpaceStations-1] ;

            return maxDistance > lastSpaceStationDistance ?
                    maxDistance : lastSpaceStationDistance;
        }

        return maxDistance;
    }

    /**
     * The space stations are consecutive last,
     * i.e. They are the last ones.
     * Given 5 cities with 2 space stations that
     * are in the end. i.e. Cities 3 and 4 are
     * the space stations.
     *
     * Get the last station
     * Check if the last city is the last station,
     * spaceStations[noOfSpaceStations-1] == noOfCities-1
     *
     * Get the first station spaceStations[0]
     *
     * How to confirm that space stations are
     * consecutive last?
     *
     */
    public static boolean areSpaceStationsConsecutiveLast(
            int[] spaceStations,
            int numberOfSpaceStations,
            int numberOfCities) {

        int lastSpaceStation = spaceStations[numberOfSpaceStations - 1];

        if ( lastSpaceStation != numberOfCities-1 )
            return false;

        int firstSpaceStation =  spaceStations[0];
        int isLast = (lastSpaceStation - firstSpaceStation) -
                (numberOfSpaceStations - 1);

        return ( isLast == 0 ) ? true : false;
    }
}


