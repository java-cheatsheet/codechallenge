# Problem
Given an integer array nums and an integer k,
return true if there are two `distinct indices` 
i and j in the array such that nums[i] == nums[j] 
and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
- 0 <= k <= 10^5


# Solution
## First

Key points:
nums[i] == nums[j] : Equal Numbers.
abs(i - j) <= k : Difference of Indices < k.

So we cannot sort as index needs to be preserved.

### Pseudocode

for (i=0; i < nums.len; i++) // loop all nums
for (j=i+1; j < nums.len; j++) // loop all nums except i  

if nums[i]=nums[j] and abs(i-j)<=k, return true

return false.

### Data structure
Max numeric length is  10^5
Max value is 10^9.

`int` would suffice.

```
4 bytes. 
Stores whole numbers from -2,147,483,648 to 2,147,483,647.
```

### Understanding Case 1
Initial logic below was failing test case 1
```
for (int i = 0; i < nums.length - 1; i++) {
    for ( int j = i+1; j < nums.length-1; j++ ) {

    if ( nums[i] == nums[j] && abs(i-j) <= k )
        return true;
    }
}
```
nums = [1,2,3,1], k = 3
There are two equal numbers `1` at nums[0] and nums[3].
Their index abs difference 0-3 = 3.
This case returns true.

The loop was not reaching all the numbers. Minor change
was made.
```
for ( int j = i+1; j < nums.length; j++ )
```


## Failed To Run 
The given test case failed to run with exception:
**Time Limit Exceeded**

Data stored in testcase-48.txt

The first O(n^2) solution does not work for 
large input size.

Other algorithm:
Search with other efficient algorithm.
Check the condition.

### Pseudo code
for loop to iterate all
binary search 
if binary search finds, 
    check condition, return true
return false

Well for binary search to work, we need sorted array.
While doing this we loose original index. 
Either we store the original indexes and then apply
binary search or look for other algorithms.


Store values and their indexes in a key-value pair
in a map.
key = the number
value = indexes of the number separated by comma ','.
Example: 1111=>1,2,3

Loop through this key. We only want to loop through 
those keys that have duplicate values.

Store only those values which has duplicate values.


OR

Sort 
Loop through sorted
If current == next, 
    Find the index current.
    Find the index of next.
    Check condition.
    
Let's say we have 3 same numbers at different indexes. 
When we sort the array, 3 of them will appear one after 
another. And the value of k might be just less than the 
first index and the last. So we might have to check the 
current and the last.

## Solution Accepted
Runtime: 30 ms, faster than 37.52% of Java online 
submissions for Contains Duplicate II.

Memory Usage: 49.3 MB, less than 54.65% of Java 
online submissions for Contains Duplicate II.

## Refactor
The current solution is not efficient - time 
and space constraints are high.

Another solution would be using `Sliding Window`
technique.

https://sdever.medium.com/sliding-window-algorithm-approach-go-example-9df848c76077
https://leetcode.com/discuss/general-discussion/657507/Sliding-Window-for-Beginners-Problems-or-Template-or-Sample-Solutions
https://newbedev.com/what-is-sliding-window-algorithm-examples
https://redquark.org/cotd/sliding_window
https://quanticdev.com/algorithms/dynamic-programming/sliding-window
https://redquark.org/cotd/sliding_window
https://www.geeksforgeeks.org/window-sliding-technique

The constraint k defines the difference and 
this also means the distance between the two 
equal numbers.

### Pseudocode
Iterate through array
Create a new array of size of the window.
Sort it.
Check if two numbers are equal.

Two implementations are applied based on the technique.
And both of them fails when large volume of data is 
processed.

## Second Refactoring
### Pseudocode
1. Create a hashmap (nmap) of all the keys of duplicate values
2. Iterate through nmap
3. If nmap.value > 1
4. Iterate through nmap.value
5. If the keys satisfies condition, return true
6. return false

Runtime: 44 ms, faster than 21.07% of Java online submissions for Contains Duplicate II.
Memory Usage: 61.3 MB, less than 26.38% of Java online submissions for Contains Duplicate II.
https://leetcode.com/submissions/detail/602549296

