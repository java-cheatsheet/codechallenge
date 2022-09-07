package hackerrank.FlatlandSpaceStations;

import org.junit.Test;
import org.junit.Assert;

public class FlatlandSpaceStationsTest {
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

        Assert.assertEquals(expectedMaxDistance, maxDistance);
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

        Assert.assertEquals(expectedMaxDistance, maxDistance);
    }

    @Test
    void given10Cities1StationsAtFour() {
        int numberOfCities = 10;
        int[] spaceStations = {4};
        int expectedMaxDistance = 5;

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numberOfCities, spaceStations);

        Assert.assertEquals(expectedMaxDistance, maxDistance);
    }

    @Test
    void given10Cities3StationsAtFirstSecondLast() {
        int numberOfCities = 10;
        int[] spaceStations = {0, 1, 3};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numberOfCities, spaceStations);

        Assert.assertEquals(6, maxDistance);
    }

    @Test
    void givenFourCitiesThreeStationsAtFirstSecondLast() {
        int numOfCities = 4;
        int[] spaceStations ={0, 1, 3};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenFourCitiesOneStationAtLast() {
        int numOfCities = 4;
        int[] spaceStations = {3};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(3, maxDistance);
    }

    @Test
    void givenFourCitiesOneStationAtFirst() {
        int numOfCities = 4;
        int[] spaceStations = {0};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(3, maxDistance);
    }
    @Test
    void givenFourCitiesOneStationsAtSecond() {
        int numOfCities = 4;
        int[] spaceStations = {1};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(2, maxDistance);
    }

    @Test
    void givenFourCitiesThreeStationsAtSecondThirdAndFourth() {
        int numOfCities = 4;
        int[] spaceStations = {1, 2, 3};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenFourCitiesTwoStationsAtThirdAndFourth() {
        int numOfCities = 4;
        int[] spaceStations = {2,3};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(2, maxDistance);
    }

    @Test
    void givenFourCitiesTwoStationsAtSecondAndThird() {
        int numOfCities = 4;
        int[] spaceStations = {1, 2};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenFourCitiesTwoStationsAtFirstAndLast() {
        int numOfCities = 4;
        int[] spaceStations = {3, 0};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenFourCitiesTwoStationsAtFirstAndThird() {
        int numOfCities = 4;
        int[] spaceStations = {2, 0};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenFourCitiesTwoStationsAtFirstAndSecond() {
        int numOfCities = 4;
        int[] spaceStations = {1, 0};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(2, maxDistance);
    }

    @Test
    void givenThreeCityTwoStationsAtFirstAndThird() {
        int numOfCities = 3;
        int[] spaceStations = {0,2};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenThreeCityFirstAndSecond() {
        int numOfCities = 3;
        int[] spaceStations = {0,1};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenTwoCityTwoStations() {
        int numOfCities = 2;
        int[] spaceStations = {0,1};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(0, maxDistance);

    }

    @Test
    void givenFourCitiesAndOneStationAtFirst() {
        int numOfCities = 4;
        int[] spaceStations={0};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(3, maxDistance);
    }

    @Test
    void givenFourCitiesAndOneStationAtThird() {
        int numOfCities = 4;
        int[] spaceStations={2};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(2, maxDistance);
    }

    @Test
    void givenThreeCitiesAndOneStationAtThird() {
        int numOfCities = 3;
        int[] spaceStations={3};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(3, maxDistance);
    }

    @Test
    void givenThreeCitiesAndOneStationAtSecond() {
        int numOfCities = 3;
        int[] spaceStations={1};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenThreeCitiesAndOneStationAtFirst() {
        int numOfCities = 3;
        int[] spaceStations={0};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(2, maxDistance);
    }

    @Test
    void givenTwoCity() {
        int numOfCities = 2;
        int[] spaceStations={0};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(1, maxDistance);
    }

    @Test
    void givenOneCity() {
        int numOfCities = 1;
        int[] spaceStations={0};

        int maxDistance = FlatlandSpaceStations.flatlandSpaceStations(
                numOfCities, spaceStations);

        Assert.assertEquals(0, maxDistance);
    }

}

class ConsecutiveLastSpaceStationTest {
    @Test
    void givenFiveCities3SpaceStationSecondThirdAndFourth() {
        int[] spaceStations = {2, 3, 4};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities = 5;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                        spaceStations,
                        numberOfSpaceStations,
                        numberOfCities);

        Assert.assertTrue(isConsecutive);
    }

    @Test
    void givenFiveCities3SpaceStationFirstThirdAndFourth() {
        int[] spaceStations = {0, 2, 3};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities = 5;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                        spaceStations,
                        numberOfSpaceStations,
                        numberOfCities);

        Assert.assertFalse(isConsecutive);
    }

    @Test
    void givenFourCities2SpaceStationThirdAndFourth() {
        int[] spaceStations = {2, 3};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities = 4;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                        spaceStations,
                        numberOfSpaceStations,
                        numberOfCities);

        Assert.assertTrue(isConsecutive);
    }

    @Test
    void givenFourCities2SpaceStationFirstAndSecond() {
        int[] spaceStations = {0,1};
        int numberOfSpaceStations = spaceStations.length;
        int numberOfCities =  4;

        boolean isConsecutive = FlatlandSpaceStations.
                areSpaceStationsConsecutiveLast(
                        spaceStations,
                        numberOfSpaceStations,
                        numberOfCities);

        Assert.assertFalse(isConsecutive);
    }

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

        Assert.assertTrue(isConsecutive);
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

        Assert.assertTrue(isConsecutive);
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

        Assert.assertTrue(isConsecutive);
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

        Assert.assertFalse(isConsecutive);
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

        Assert.assertTrue(isConsecutive);
    }

}
