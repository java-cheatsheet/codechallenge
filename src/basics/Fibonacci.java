package basics;

/**
 * https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
 */
public class Fibonacci {

    public static void main(String[] args)
    {

    }

    public static void callFibonacciTabulated()
    {
        FibonacciTabulated f = new FibonacciTabulated();
        int n = 9;
        System.out.println("Fibonacci number is" + " " + f.fib(n));
    }

    public static void callFibonacciMemoized()
    {
        FibonacciMemoized f = new FibonacciMemoized();
        int n = 40;
        f._initialize();
        System.out.println("Fibonacci number is" + " " + f.fib(n));
    }
}


class FibonacciTabulated {

    int fib(int n)
    {
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i-1] + f[i-2];
        return f[n];
    }
}


class FibonacciMemoized
{
    final int MAX = 100;
    final int NIL = -1;

    int lookup[] = new int[MAX];

    /* Function to initialize NIL values in lookup table */
    void _initialize()
    {
        for (int i = 0; i < MAX; i++)
            lookup[i] = NIL;
    }

    /* function for nth Fibonacci number */
    int fib(int n)
    {
        if (lookup[n] == NIL)
        {
            if (n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fib(n-1) + fib(n-2);
        }
        return lookup[n];
    }

}

class FibonacciRecursive {
    public int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}