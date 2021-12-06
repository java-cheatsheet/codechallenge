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
for (j=i+1; j < nums.len; j++) // loop all numbs except i  

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
Initial logic below was failing case 1
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


