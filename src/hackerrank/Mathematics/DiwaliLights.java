import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DiwaliLights {

    /*
     * Complete the lights function below.
     */
    static long lights(int n) {
        long val = 1;

        for (int i = 0; i < n; i++) {
            val *= 2;
            val = val % 100000L;

            System.out.println(val);
        }


        return val - 1;
    }
}
