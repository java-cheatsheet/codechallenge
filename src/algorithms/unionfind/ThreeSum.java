package algorithms.unionfind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *  3-SUM. Given N distinct integers, how many triples sum to exactly zero?
 */
public class ThreeSum {
    public static void main(String[] args)
    {
        int[] a = In.readInts(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(ThreeSumBruteForce.count(a));
        double time = stopwatch.elapsedTime();
    }
}

class ThreeSumBruteForce {
    public static int count(int[] a)
    {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++) // check each triple
                    if (a[i] + a[j] + a[k] == 0) //for simplicity, ignore integer overflow
                        count++;
        return count;
    }
}