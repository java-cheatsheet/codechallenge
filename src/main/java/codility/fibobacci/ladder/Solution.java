package codility.fibobacci.ladder;

import java.lang.Math;

class Solution {
    public static int[] solution(int[] A, int[] B) {
        int[] fib = new int[A.length];
        int a = 0;
        int b = 1;
        int maxModulo = (int) Math.pow(2, 30);
        for (int i = 0; i < A.length; i++) {
            int x = (a + b) % maxModulo;
            fib[i] = x;
            a = b;
            b = x;
        }

        int[] result = new int[A.length];
        int[] modulo = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            modulo[i] = (int) Math.pow(2, B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            result[i] = fib[A[i] - 1] % modulo[i];
        }

        return result;
    }
}

