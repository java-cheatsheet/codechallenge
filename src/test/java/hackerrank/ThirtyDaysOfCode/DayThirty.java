package hackerrank.ThirtyDaysOfCode;

import org.junit.Test;

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

