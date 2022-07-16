package hackerrank.FlatlandSpaceStations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlatlandSpaceStationsTest {
    @Test
    void given97Cities76SpaceStations(){
        int numberOfCities = 95;
        int[] spaceStations = {
                72, 0, 28, 79, 4, 73, 56,
                83, 95, 26, 49, 27, 91, 77,
                20, 87, 63, 33, 36, 7, 23,
                74, 80, 68, 57, 62, 52, 84,
                50, 13, 69, 39, 90, 55, 17,
                64, 81, 22, 88, 8, 46, 85,
                44, 96, 35, 47, 89, 93, 11,
                75, 38, 29, 86, 19, 70, 42,
                30, 58, 82, 76, 48, 54, 9,
                92, 71, 78, 16
        };
        int expectedMaxDistance = 2;

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numberOfCities, spaceStations);

        Assertions.assertEquals(expectedMaxDistance,
                maxDistance);
    }

    @Test
    void given95Cities19SpaceStations(){
        int numberOfCities = 95;
        int[] spaceStations = { 68, 81, 46,
                54, 30, 11, 19, 23, 22, 12,
                38, 91, 48, 75, 26, 86, 29,
                83, 62 };
        int expectedMaxDistance = 11;

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numberOfCities, spaceStations);

        Assertions.assertEquals(expectedMaxDistance,
                maxDistance);
    }

    @Test
    void given10Cities1StationsAtFour() {
        int numberOfCities = 10;
        int[] spaceStations = {4};
        int expectedMaxDistance = 5;

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numberOfCities, spaceStations);

        Assertions.assertEquals(expectedMaxDistance,
                maxDistance);
    }

    @Test
    void given10Cities3StationsAtFirstSecondLast() {
        int numberOfCities = 10;
        int[] spaceStations = {0, 1, 3};
        int expectedMaxDistance = 6;

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numberOfCities, spaceStations);

        Assertions.assertEquals(expectedMaxDistance,
            maxDistance);
    }

    @Test
    void hasFourCitiesThreeStationsAtFirstSecondLast() {
        int n=4, expected=1;
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
    void hasFourCitiesOneStationAtLast() {
        int noOfCities = 4, expectedMaxDistance=3; // Distance from city four to city 2
        int[] spaceStations = {3};

        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(
                        noOfCities, spaceStations));
    }

    @Test
    void hasFourCitiesOneStationAtFirst() {
        int noOfCities = 4, expectedMaxDistance=3; // Distance from city four to city 2
        int[] spaceStations = {0};

        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(
                        noOfCities, spaceStations));
    }
    @Test
    void hasFourCitiesOneStationsAtSecond() {
        int noOfCities = 4, expectedMaxDistance=2; // Distance from city four to city 2
        int[] spaceStations = {1};
        int spaceStationsLen = spaceStations.length;

        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(
                        noOfCities, spaceStations));
    }

    @Test
    void hasFourCitiesThreeStationsAtSecondThirdAndFourth() {
        int noOfCities = 4, expectedMaxDistance = 1;
        int[] spaceStations = {1, 2, 3};

        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(
                        noOfCities, spaceStations));
    }

    @Test
    void hasFourCitiesTwoStationsAtThirdAndFourth() {
        int noOfCities = 4, expectedMaxDistance = 2;
        int[] spaceStations = {2,3};

        int actualDistance = FlatlandSpaceStations.
                flatlandSpaceStations(noOfCities,
                        spaceStations);

        Assertions.assertEquals(expectedMaxDistance,
                actualDistance);

        /**
         * Assertion Fail.
         * Expected :2
         * Actual   :1
         *
         * The logic to get the maximum distance fails.
         * As the stations are in the end, we have to
         * get the distance from the first city to that
         * station.
         *
         */
    }

    @Test
    void givenFourCitiesTwoStationsAtSecondAndThird() {
        int noOfCities = 4, expectedMaxDistance = 1;
        int[] spaceStations = {1, 2};
        int spaceStationsLen = spaceStations.length;

        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(
                        noOfCities, spaceStations));
    }

    @Test
    void hasFourCitiesTwoStationsAtFirstAndLast() {
        int noOfCities = 4, expectedMaxDistance=1;
        int[] spaceStations = {3, 0};
        int spaceStationsLen = spaceStations.length;

        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(
                        noOfCities, spaceStations));

        /**
         * Test fails
         * Expected :1
         * Actual   :3
         *
         *         int maxDistance = 0;
         *         Arrays.sort(spaceStations);
         *         int i=0;
         *
         *         for(; i<noSpaceStations-1; i++){
         *             int distanceDiff =  Math.abs(spaceStations[i]-spaceStations[i+1]);
         *
         *             if ( maxDistance < distanceDiff)
         *                 maxDistance = distanceDiff;
         *         }
         *
         *         if (spaceStations[i] < noSpaceStations) {
         *             int distanceFromLast =  noOfCities-1-spaceStations[i];
         *
         *             if (maxDistance < distanceFromLast)
         *                 return distanceFromLast;
         *         }
         *
         *         return maxDistance;
         *
         * Logic fail
         *      int distanceDiff =  Math.abs(spaceStations[i]-spaceStations[i+1]);
         * distanceDiff is 3,  spaceStation[1](3) - spaceStation[0](3)
         *
         * We failed to consider the cities and distance
         * from space stations to cities.
         *
         * The distance between two space stations should
         * be (spaceStation[1](3) - spaceStation[0](3))/2
         *
         * Let's just consider first and last to be a
         * special case.
         *
         */


    }

    @Test
    void hasFourCitiesTwoStationsAtFirstAndThird() {
        int noOfCities = 4, expectedMaxDistance=1;
        int[] spaceStations = {2, 0};
        int spaceStationsLen = spaceStations.length;

        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(
                        noOfCities, spaceStations));
    }

    @Test
    void hasFourCitiesTwoStationsAtFirstAndSecond() {
        int noOfCities = 4, expectedMaxDistance=2;
        int[] spaceStations = {1, 0};
        int spaceStationsLen = spaceStations.length;

        Assertions.assertEquals(expectedMaxDistance,
                FlatlandSpaceStations.flatlandSpaceStations(
                        noOfCities, spaceStations));

//        int maxDistance = 0;
//        Arrays.sort(spaceStaions);
//
////        int[] withLastCity = new int[noOfCities+1];
////        withLastCity[noOfCities] = noOfCities-1;
////        System.arraycopy(spaceStaions, 0, withLastCity, 0, spaceStationsLen);
//
//        for(int i=0; i<spaceStationsLen-1; i++){
//            int distanceDiff =  Math.abs(spaceStaions[i]-spaceStaions[i+1]);
//
//            if ( maxDistance < distanceDiff)
//                maxDistance = distanceDiff;
//        }
//
//        maxDistance++;
//
//        Assertions.assertEquals(expectedMaxDistance, maxDistance);

        /**
         * Get the distance from the space station to city.
         *
         * 0 is a space station, check if the next city has
         * space station or not.
         *
         * If it has then start counting the cities from next.
         *
         * Pseudocode:
         * Sort space stations
         * Loop in cities
         * Check if space station or not
         * If not increase distance
         *
         *
         */
//        Arrays.sort(spaceStaions);
//        int maxDistance=0;
//        for (int city=0; city<noOfCities; city++) {
//            int distance=0;
//
//            for (int spaceStation=city+1; spaceStation < spaceStaions.length; spaceStation++){
//
//                if ( city != spaceStaions[spaceStation] )
//                    distance++;
//                else break;
//            }
//
//            if (distance > maxDistance) maxDistance = distance;
//
//        }
        /**
         * This above idea becomes complicated.
         * We are trying to keep track of distance from
         * city to space station.
         *
         * for (int spaceStation=city+1;
         *  if ( city != spaceStaions[spaceStation] )
         *
         * This logic fails.
         *
         * Loop space stations.
         * Get the distance from the last city.
         *
         * Original/First logic implemented which failed
         * for the test case.
         *
         * The idea is to get the distance from max index
         * to the space station. Looks a bit like Sub-Array
         * Sum kind of problem.
         *
         * Factored in last city which is not a space station.
         *
         * The solution should be straight forward.
         * Get the distance from city to space station or
         * space station to city. The only problem being
         * created is solving by considering which comes
         * first.
         *
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
    void hasThreeCityFirstAndSecond() {
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

class ConsecutiveLastSpaceStationTest {
    @Test
    void givenSpaceStations45() {
        int[] spaceStations = {4,5};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities = 6;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                        spaceStations,
                        numberOfSpaceStations,
                        numberOfCities);

        Assertions.assertTrue(isConsecutive);
    }

    @Test
    void givenSpaceStations23() {
        int[] spaceStations = {2,3};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities = 4;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                        spaceStations,
                        numberOfSpaceStations,
                        numberOfCities);

        Assertions.assertTrue(isConsecutive);
    }

    @Test
    void givenSpaceStations234() {
        int[] spaceStations = {2,3,4};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities =  5;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                        spaceStations,
                        numberOfSpaceStations,
                        numberOfCities);

        Assertions.assertTrue(isConsecutive);
    }

    @Test
    void givenSpaceStation2() {
        int[] spaceStations = {0,2};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities =  3;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                        spaceStations,
                        numberOfSpaceStations,
                        numberOfCities);

        Assertions.assertFalse(isConsecutive);
    }

    @Test
    void givenSpaceStation23() {
        int[] spaceStations = {2,3};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities = 4;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                spaceStations,
                numberOfSpaceStations,
                numberOfCities);

        Assertions.assertTrue(isConsecutive);
    }

}
