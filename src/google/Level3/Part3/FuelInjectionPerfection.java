package google.Level3.Part3;

import java.util.*;

public class FuelInjectionPerfection {

    public static int solution(String s) {
        int n = Integer.valueOf(s);
        int count = 0;

        while (n > 1) {
            count++;

            if (n % 2 == 0)
                n /= 2;
            else if (n % 4 == 1)
                n -= 1;
            else
                n += 1;
        }

        return count;
    }
}


