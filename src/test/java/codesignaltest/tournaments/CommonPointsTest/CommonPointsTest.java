package codesignaltest.tournaments.CommonPointsTest;

import codesignal.tournaments.CommonPointsTest.CommonPoints;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CommonPointsTest {
    CommonPoints commonPoints;
    int l1, l2, r1, r2, expected, outcome;

    @Test
    public void commonPoints() {
        l1 = 1;
        r1 = 5;
        l2 = 2;
        r2 = 10;
        expected = 2;
        commonPoints = new CommonPoints();
        outcome = commonPoints.commonPoints(l1, r1, l2, r2);

        Assertions.assertEquals(expected, outcome);
    }
}