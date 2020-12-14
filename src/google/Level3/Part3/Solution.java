package google.Level3.Part3;

import java.util.*;

public class Solution {

    public static int solution(String s) {
        int n = Integer.valueOf(s);

        if ( n == 0 )
            return 1;

        if ( n == 1 )
            return 0;

        int count = 0;
        while (n > 1) {
            count++;

            if (n % 10 == 1)
                n -= 1;
            else if ( n % 10 == 9)
                n += 1;
            else if (n % 2 == 0)
                n /= 2;
            else if (n % 2 == 1)
                if ( n == 15 )
                    n += 1;
                else
                    n -= 1;
            else
                n += 1;
        }

        return count;
    }
}


