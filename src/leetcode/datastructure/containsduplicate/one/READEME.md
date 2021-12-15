# Problem
Given an integer array nums, return 
true if any value appears at least 
twice in the array, and return false 
if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
    
# Solution
## First - Brute force
Compare every element one after another.
It will take a long time.

## Second - Sort it
First sort, then compare to the next proceeding 
number.

### Data type
Our required range: -1000000000 to 1000000000, 
therefore, `int` would be sufficient.
```
4 bytes. 
Stores whole numbers from -2,147,483,648 to 2,147,483,647.
```

### Pseudocode
1. Sort array.
   1. Loop the sorted array.
2. Compare the current value with the next.
3. If next is greater, make next current, and compare.
4. Return true if current and next are equal.
5. Return false.
