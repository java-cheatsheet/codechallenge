package codesignal.tournaments.CommonPoints;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonPointsTest {
    CommonPoints commonPoints;
    int l1, l2, r1, r2, expected;

    @BeforeEach
    void setUp() {
        commonPoints = new CommonPoints();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void commonPoints() {
        l1 = 1;
        r1 = 5;
        l2 = 2;
        r2 = 10;
        expected = 2;

        assertEquals(expected, commonPoints.commonPoints(l1, r1, l2, r2));
    }
}