package hackerrank.ThirtyDaysOfCode;

import org.junit.Test;
import org.junit.Assert;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class InputTest {
    @Test
    void validDateList() throws Exception {
        ArrayList<String> input = new ArrayList<>();
        input.add("20 7 2020");
        input.add("16 6 2020");

        ArrayList<Date> actualDate = DayThirty.getDateList(input);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyy");
        Date expectedReturnDate = sdf.parse("20 07 2020");
        Date expectedDueDate = sdf.parse("16 06 2020 ");

        Assert.assertNotNull(DayThirty.getDateList(input));
        Assert.assertTrue(expectedReturnDate.compareTo(actualDate.get(0)) == 0);
        Assert.assertTrue(expectedDueDate.compareTo(actualDate.get(1)) == 0);

        System.out.println(expectedReturnDate);
    }

}
