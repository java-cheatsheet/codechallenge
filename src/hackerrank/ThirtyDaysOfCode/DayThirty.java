package hackerrank.ThirtyDaysOfCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Given the expected and actual return dates
 * for a library book, create a program that
 * calculates the fine (if any).
 *
 * The fee structure is as follows:
 *
 * If the book is returned on or before the
 * expected return date, no fine will be charged.
 * fine = 0
 *
 * If the book is returned after the expected
 * return day but still within the same calendar
 * month and year as the expected return date,
 * fine = 15 * the number of days late.
 *
 * If the book is returned after the expected
 * return month but still within the same
 * calendar year as the expected return date,
 * the fine = 500 * the numbers of months late.
 *
 * If the book is returned after the calendar
 * year in which it was expected, there is a
 * fixed fine of 10000.
 *
 * Input Format
 * The first line contains 3 space-separated
 * integers denoting the respective month, day
 * and year on which the book was actually
 * returned.
 *
 * The second line contains 3 space-separated
 * integers denoting the respective month, day
 * and year on which the book was expected to
 * be returned (due date).
 *
 * Output Format
 * Print a single integer denoting the library
 * fine for the book received as input.
 */
public class DayThirty {
    public static void main(String[] args) {
        ArrayList<String> input = input();

        ArrayList<Date> dateList = new ArrayList<>();
        dateList = getDateList(input);

        Date returnedDate = dateList.get(0);
        Date dueDate = dateList.get(1);

        System.out.println(fine(returnedDate, dueDate));
    }

    /**
     * Read return and due date.
     *
     * return int[][] Date
     * int[][0], int[][0], int[][0] Day, Month, Year,
     * respectively.
     * int[0][] return date, int[1][] due date
     */
    public static ArrayList<String> input() {
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String returnDate = bufferedReader.readLine().trim();
            String dueDate = bufferedReader.readLine().trim();
            arrayList.add(returnDate);
            arrayList.add(dueDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public static ArrayList<Date> getDateList(ArrayList<String> strList){
        ArrayList<Date> dateList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

        try {
            dateList.add(sdf.parse(strList.get(0)));
            dateList.add(sdf.parse(strList.get(1)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return dateList;
    }

    public static int fine(Date returned, Date due) {
        if (returned.before(due) || returned.equals(due)) return 0;

        else if (Integer.parseInt(returned.toString().substring(24)) >
                Integer.parseInt(due.toString().substring(24))) {
            return 10000;

        } else {
            long days = TimeUnit.MILLISECONDS.toDays(
                    (long) Math.abs(returned.getTime() - due.getTime()));
            if(days > 31) {
                   long months = days/31;
                   return (int)months * 500;

            } else return (int) days * 15;
        }
    }
}


class FineTest {
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


class InputTest {
    @Test
    void validDateList() throws Exception {
        ArrayList<String> input = new ArrayList<>();
        input.add("20 7 2020");
        input.add("16 6 2020");

        ArrayList<Date> actualDate = DayThirty.getDateList(input);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyy");
        Date expectedReturnDate = sdf.parse("20 07 2020");
        Date expectedDueDate = sdf.parse("16 06 2020 ");

        Assertions.assertNotNull(DayThirty.getDateList(input));
        Assertions.assertTrue(expectedReturnDate.compareTo(actualDate.get(0)) == 0);
        Assertions.assertTrue(expectedDueDate.compareTo(actualDate.get(1)) == 0);

        System.out.println(expectedReturnDate);
    }

}

//    @Test
//    void testInput(){
//        int[][] expected =  {{01,02,2022}, {02,02,2022}};
//        Assertions.assertArrayEquals(expected, DayThirty.input());
//    }

//    @Test
//    @ParameterizedTest
//    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
//    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
//        Assertions.assertTrue(DayThirty.isOdd(number));
//    }

