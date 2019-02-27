package hackerrank.practice;
import java.util.ArrayList;
import java.util.Arrays;


public class SockMerchantWarmUpPractice {

    public static void main (String g[]) {
        findPairsOfNumber();
    }

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


