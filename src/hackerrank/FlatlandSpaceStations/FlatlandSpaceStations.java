package hackerrank.FlatlandSpaceStations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

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
 */
public class FlatlandSpaceStations {

    public static int flatlandSpaceStations(
            int numOfCities,
            int[] spaceStations) {
        int numOfSpaceStations = spaceStations.length;

        if ( isCitySpaceStation(numOfCities,
                numOfSpaceStations))
            return 0;

        if (isCitySpaceStation(numOfSpaceStations, 1)) {

            return getMaxDistanceWithOneSpaceStation(
                    numOfCities, spaceStations);
        }

        Arrays.sort(spaceStations);

        if ( areSpaceStationsConsecutiveLast(
                spaceStations,
                numOfSpaceStations,
                numOfCities))
            return spaceStations[0];

        int maxDistance = 0;

        maxDistance = setMaxDistanceBasedOnFirstSpaceStation(
                spaceStations);

        maxDistance = getMaxDistance(spaceStations,
                numOfSpaceStations, maxDistance);

        if ( lastCityIsNotLastSpaceStation(numOfCities,
                spaceStations, numOfSpaceStations)) {

            return distanceFromLastCityToLastStation(
                    numOfCities, spaceStations,
                    numOfSpaceStations, maxDistance);
        }

        return maxDistance;
    }

    private static boolean lastCityIsNotLastSpaceStation(
            int numOfCities, int[] spaceStations,
            int numOfSpaceStations) {

        return spaceStations[numOfSpaceStations - 1]
                != numOfCities - 1;
    }

    private static int setMaxDistanceBasedOnFirstSpaceStation(
            int[] spaceStations) {

        if (isCitySpaceStation(spaceStations[0], 0))
            return (spaceStations[1] - spaceStations[0])/2;

        return spaceStations[0];
    }

    private static boolean isCitySpaceStation(
            int spaceStation, int city) {

        return city == spaceStation;
    }


    private static int getMaxDistanceWithOneSpaceStation(
            int numOfCities, int[] spaceStations) {

        // The space station is at first or last
        if ( isCitySpaceStation(spaceStations[0], 0)
                || isCitySpaceStation( spaceStations[0],
                numOfCities - 1))
            return numOfCities - 1;

        // The space station is in the middle
        return Math.max(spaceStations[0],
                numOfCities - 1 - spaceStations[0]);
    }

    private static int getMaxDistance(
            int[] spaceStations,
            int numOfSpaceStations,
            int maxDistance) {

        for ( int i = 1; i < numOfSpaceStations -1; i++)  {
            int distance = ( spaceStations[i+1] -
                    spaceStations[i] ) / 2;

            if ( distance > maxDistance)
                maxDistance = distance;
        }

        return maxDistance;
    }

    private static int distanceFromLastCityToLastStation(int numOfCities, int[] spaceStations, int numOfSpaceStations, int maxDistance) {
        int lastSpaceStationDistance = numOfCities - 1 -
                spaceStations[numOfSpaceStations -1] ;

        return Math.max(maxDistance, lastSpaceStationDistance);
    }

    public static boolean areSpaceStationsConsecutiveLast(
            int[] spaceStations,
            int numberOfSpaceStations,
            int numberOfCities) {

        int lastSpaceStation = spaceStations[numberOfSpaceStations - 1];
        int lastCity = numberOfCities-1;

        if ( lastSpaceStation !=  lastCity)
            return false;

        int firstSpaceStation =  spaceStations[0];

        return numberOfSpaceStations >
                lastSpaceStation - firstSpaceStation;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
