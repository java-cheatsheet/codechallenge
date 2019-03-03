package hackerrank.practice;
import java.util.ArrayList;
import java.util.Arrays;


public class WarmUpPractice {


    public static void main (String g[]) {
//        findPairsOfNumber();
//        countHighestNumber();
//        jumpingOnClouds();
        timeConversion();
    }

    /**
     * https://www.hackerrank.com/challenges/time-conversion/problem
     * It should return a new string representing the input time in 24 hour format.
     */
    public static String timeConversion(){
        String s = "12:45:54PM";
        String hour = s.substring(0,2);
        String dayOrNight = s.substring(8,10);
        String minSec = s.substring(2, 8);

        if(  dayOrNight.equals("AM") ) {

            if ( hour.equals("12") ) s = "00" + minSec;
            else s = hour + minSec;

        } else  {
                if ( !hour.equals("12") ) {
                    hour = Integer.toString(Integer.parseInt(hour) + 12);
                }

            s = hour + minSec;
        }

        System.out.println(s);

        return s;
    }

    //https://www.hackerrank.com/challenges/jumping-on-the-clouds/
    public static int jumpingOnClouds() {
        int[] c = {0, 0, 0, 0, 1, 0};//{0, 0, 1, 0, 0, 1, 0}; //{0, 0, 1, 0};

        if( c.length == 3 ) return 1;

        int count = 0;
        // As there is always a possible way out,
        // Below statements
        int jump = 1;
        int lenghtOfc =  c.length - 4; // Skip last 3 check

        while ( count <= lenghtOfc ) {

            if (c[count + 2] == 0) count +=2;
            else count++;

            ++jump;
        }

        System.out.println(count);

        return  jump;
    }

    //https://www.hackerrank.com/challenges/counting-valleys/
    public static int countHighestNumber() {
        int[] ar = {111, 2, 44, 2, 5, 44, 44, 111};
        int lengthOfAr = ar.length;
        Arrays.sort(ar);
        int countHighest = 1;
        int heighersNo = ar[--lengthOfAr];

        while (lengthOfAr > 0){
            if ( heighersNo == ar[--lengthOfAr] ) countHighest++;
        }

        System.out.println(countHighest);

        return countHighest;
    }

    //https://www.hackerrank.com/challenges/sock-merchant/
    public static int findPairsOfNumber() {
//        int n = 9;
        int[] ar = {10, 10};//, 20, 10, 10, 30, 50, 10, 20};
        int lenghtOfAr = ar.length;
        int index = 0;
        int pairsCounter = 0;

        if(lenghtOfAr == 1) return 0;

        Arrays.sort(ar);

        while( index + 1 <  lenghtOfAr ) {

            if( ar[index] == ar[index+1] ) {
                pairsCounter++;
                index++;
            }

            index++;
        }

        System.out.println(pairsCounter);

        return pairsCounter;
    }




}


