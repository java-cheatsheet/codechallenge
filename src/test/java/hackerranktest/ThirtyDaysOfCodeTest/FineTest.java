package hackerranktest.ThirtyDaysOfCodeTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FineTest {
    @Test
    void failedTestCase4() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Date returnDate = sdf.parse("1 1 2010");
        Date dueDate = sdf.parse("31 12 2009");

        Assertions.assertEquals(10000, DayThirty.fine(returnDate, dueDate));
    }

    @Test
    void finedForADay() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Date returnDate = sdf.parse("7 6 2015");
        Date dueDate = sdf.parse("6 6 2015");

        Assertions.assertEquals(15, DayThirty.fine(returnDate, dueDate));
    }

    @Test
    void finedForThreeDays() throws Exception {
        /**
         * 9 6 2015    day = 9, month = 6, year = 2015 (date returned)
         * 6 6 2015    day = 6, month = 6, year = 2015 (date due)
         *
         * Fined for 3 days.
         * 15 * (returned - due) = 15 * (9-6) = 15 * 3 = 45
         */

        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Date returnDate = sdf.parse("9 6 2015");
        Date dueDate = sdf.parse("6 6 2015");

        Assertions.assertEquals(45, DayThirty.fine(returnDate, dueDate));
    }

    @Test
    void finedForTenDays() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Date returnDate = sdf.parse("20 7 2020");
        Date dueDate = sdf.parse("10 7 2020");

        Assertions.assertEquals(150, DayThirty.fine(returnDate, dueDate));
    }

    @Test
    void finedForTwoMonths() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Date returnDate = sdf.parse("20 07 2020");
        Date dueDate = sdf.parse("10 05 2020");

        Assertions.assertEquals(500 * 2, DayThirty.fine(returnDate, dueDate));
    }

    @Test
    void finedForMoreThanAYear() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Date returnDate = sdf.parse("20 7 2021");
        Date dueDate = sdf.parse("10 1 2020");

        Assertions.assertEquals(10000, DayThirty.fine(returnDate, dueDate));
    }

    @Test
    void returnedBeforeDueDate() throws Exception {
        /**
         * When dates are equal fine should be zero.
         * We need to calculate fine.
         */
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Date returnDate = sdf.parse("10 7 2020");
        Date dueDate = sdf.parse("20 7 2020");
        Assertions.assertEquals(0, DayThirty.fine(returnDate, dueDate));
    }

    @Test
    void returnedOnDueDate() throws Exception {
        /**
         * When dates are equal fine should be zero.
         * We need to calculate fine.
         */
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Date returnDate = sdf.parse("20 7 2020");
        Date dueDate = sdf.parse("20 7 2020");
        Assertions.assertEquals(0, DayThirty.fine(returnDate, dueDate));
    }

}
