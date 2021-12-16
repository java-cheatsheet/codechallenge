# Problem
Given an integer array nums and two integers k and t, 
return true if there are two distinct indices i and j 
in the array such that abs(nums[i] - nums[j]) <= t and 
abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

### Constraints:
1 <= nums.length <= 2 * 10^4
-2^31 <= nums[i] <= 2^(31 - 1)
0 <= k <= 10^4
0 <= t <= 2^31 - 1

### Hints
Time complexity O(n logk) - This will give an indication 
that sorting is involved for k elements.

Use already existing state to evaluate next state - 
Like, a set of k sorted numbers are only needed to be 
tracked. When we are processing the next number in array, 
then we can utilize the existing sorted state and it is 
not necessary to sort next overlapping set of k numbers 
again.

# Solution
Conditions:
1. i != j
2. abs(nums[i] - nums[j]) <= t
3. abs(i - j) <= k

## Brute force
The window size is defined by k.

1. Calculate number of loops
2. Iterate through number of loops
3. Get the subarray with the size of k
4. Sort the number
5. Check condition 2
We dont need to check condition 3 because
we are taking an indexes values which are
in ascending order and therefore should be
less than the size of k

This solution fails for large dataset with
exception Time Limit Exceeded. An example
test case is testcase50.txt.




