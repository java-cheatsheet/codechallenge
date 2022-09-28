package hackerrank.sort;


public class BubbleSort {

    public static void main(String[] args) {
        validSwapCountEquals5();
    }

    static void validSwapCountEquals5() {
        int[] a = {4, 2, 3, 1};
        int result = countSwaps(a);
        int expected = 5;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static void validSwapCountEquals3() {
        int[] a = {3,2,1};
        int result = countSwaps(a);
        int expected = 3;
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static int countSwaps(int[] a) {
        int swapCounts =  0;
        int lenOfa = a.length;

        for (int i = 0; i < lenOfa; i++) {
            for (int j = 0; j < lenOfa - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
//                    swap( a[j], a[j + 1]);
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] =  temp;

                    swapCounts++;
                }
            }

        }

        System.out.printf("Array is sorted in %d swaps.\n", + swapCounts);
        System.out.printf("First Element: %d \n",a[0]);
        System.out.printf("Last Element: %d \n", a[lenOfa  - 1]);

        return swapCounts;
    }


}
