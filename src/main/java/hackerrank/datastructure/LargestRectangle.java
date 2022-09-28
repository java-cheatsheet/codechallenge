package hackerrank.datastructure;

import java.util.Stack;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 *
 * Solution:
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 *
 *
 * TODO:
 * I did not undestand the question much. So I
 * need to review the question again.
 *
 */
public class LargestRectangle {

    public static void main(String[] args) {
        validTestCase2();
    }

    static void validTestCase2() {
        int[] h = {11, 11, 10, 10, 10};
        long expected = 50;
        long result = GeeksForGeekSolution.largestRectangle(h);
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

    static void validTestCase0() {
        int[] h = {1, 2, 3, 4, 5};
        long expected = 9;
        long result = GeeksForGeekSolution.largestRectangle(h);
        assert (result == expected) : "Result:" + result +" | Expected:" + expected;
    }

}


/**
 * Solution from third party.
 */
class GeeksForGeekSolution {
    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    static long largestRectangle(int[] h) {
        int n = h.length;
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        long max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        long area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || h[s.peek()] <= h[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = (long) h[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.empty()) {
            tp = s.peek();
            s.pop();
            area_with_top = (long) h[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }
        return max_area;
    }
}