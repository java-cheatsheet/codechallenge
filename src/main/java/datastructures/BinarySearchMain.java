package datastructures;

/**
 * Checking Binary Search
 *
 * https://www.geeksforgeeks.org/binary-search/
 */
public class BinarySearchMain {

    public static void main(String[] args)
    {
        mainIterative();

    }

    static void mainRecursive()
    {
        BinarySearchRecursive ob = new BinarySearchRecursive();
        int[] arr = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    static void mainIterative()
    {
        BinarySearchIterative ob = new BinarySearchIterative();
        int[] arr = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        boolean expected = true;

        assert(result != -1);

        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                    + "index " + result);
    }

}


/**
 * Recursive implementation of Binary Search
 */
class BinarySearchRecursive {
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int[] arr, int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    // Driver method to test above

}


/**
 * Iterative implementation of Binary Search
 */
class BinarySearchIterative {
    // Returns index of x if it is present in arr[],
    // else return -1
    int binarySearch(int[] arr, int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

}