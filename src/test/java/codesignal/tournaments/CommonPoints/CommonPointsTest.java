package codesignal.tournaments.CommonPoints;

import org.junit.Test;
import org.junit.Assert;

public class CommonPointsTest {
    CommonPoints commonPoints;
    int l1, l2, r1, r2, expected;

    @Test
    void commonPoints() {
        l1 = 1;
        r1 = 5;
        l2 = 2;
        r2 = 10;
        expected = 2;

        Assert.assertEquals(expected, commonPoints.commonPoints(l1, r1, l2, r2));
    }
}