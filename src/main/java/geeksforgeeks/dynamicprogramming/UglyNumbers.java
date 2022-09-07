package geeksforgeeks.dynamicprogramming;

/**
 * Problem:
 *
 * Ugly Numbers
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 * Given a number n, the task is to find n’th Ugly number.
 *
 * https://www.geeksforgeeks.org/ugly-numbers/
 *
 */
public class UglyNumbers {

    /* Function to get the nth ugly number*/
    int getNthUglyNo(int n)
    {
        int ugly[] = new int[n];  // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1;

        for(int i = 1; i < n; i++)
        {
            next_ugly_no = Math.min(next_multiple_of_2,
                    Math.min(next_multiple_of_3,
                            next_multiple_of_5));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2)
            {
                i2 = i2+1;
                next_multiple_of_2 = ugly[i2]*2;
            }
            if (next_ugly_no == next_multiple_of_3)
            {
                i3 = i3+1;
                next_multiple_of_3 = ugly[i3]*3;
            }
            if (next_ugly_no == next_multiple_of_5)
            {
                i5 = i5+1;
                next_multiple_of_5 = ugly[i5]*5;
            }
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int n = 10;
        UglyNumbers obj = new UglyNumbers();
        System.out.println(obj.getNthUglyNo(n));
    }
}