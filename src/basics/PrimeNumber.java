package basics;

import java.util.Stack;

/**
 *
 * Problem:
 * https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/tutorial/
 *
 * Check whether the number is prime or not!
 *
 * Solutions:
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * http://www.voidcn.com/article/p-arewgswr-bpb.html
 * https://www.quora.com/What-is-an-easy-way-to-understand-the-coin-change-problem-in-dynamic-programming
 *
 *
 */
public class PrimeNumber {

    public static void main(String args[]) {
//        checkPrimeNaive(10);
//        checkPrimeSqrRoot(11);
//        checkPrimeSieveApporoach(11);

        factorizeSqrt(12);
    }

    /**
     * The time complexity of this function is O(N) because you traverse from 1 to N.
     * @param N
     */
    public static void checkPrimeNaive(int N){
        int count = 0;

        for( int i = 1; i <= N;++i )
            if( N % i == 0 )
                count++;

        if( count == 2 )
            System.out.println( N +"  is a prime number.");
        else
            System.out.println( N +"  is a not prime number.");
    }

    /**
     *
     * @param N
     */
    public static void checkPrimeSqrRoot(int N) {
        int count = 0;

        for( int i = 1; i * i <= N; ++i ) {
            if( N % i == 0) {
                if( i * i == N )
                    count++;
                else       // i < sqrt(N) and (N / i) > sqrt(N)
                    count += 2;
            }
        }

        if( count == 2 )
            System.out.println( N +"  is a prime number.");
        else
            System.out.println( N +"  is a not prime number.");
    }

    public static void checkPrimeSieveApporoach(int N) {
        boolean[] isPrime = new boolean[N+1];

        for(int i = 0; i <= N;++i) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= N; ++i) {

            if(isPrime[i] == true) {                    //Mark all the multiples of i as composite numbers
                for(int j = i * i; j <= N ;j += i)
                    isPrime[j] = false;
            }
        }

        for(int i = 0; i <= N;++i) {
            System.out.println(i +" : "+ isPrime[i]);
        }

    }

    public static Stack<Integer> factorizeSqrt(int n) {
        Stack<Integer> res = new Stack<>();

        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                res.push(i);
                n /= i;
            }
        }

        if ( n != 1 ) {
            res.push(n);
        }

        System.out.println(res);

        return res;
    }


}
