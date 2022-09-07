

# Problem

You need to pass a message to the bunny prisoners, 
but to avoid detection, the code you agreed to use
is obscure, to say the least.

The bunnies are given food on standard-issue prison
plates that are stamped with the numbers 0-9 for 
easier sorting, and you need to **combine sets of plates
to create the numbers in the code**. The signal that
a number is part of the code is that it is 
**divisible by 3**. You can do smaller numbers like 15
and 45 easily, but bigger numbers like 144 and 414
are a little trickier. 

Write a program to help yourself quickly 
**create large numbers** for use in the code, 
given a limited number of plates to work with.

You have L, a list containing some digits (0 to 9).

Write a function solution(L) which 
**finds the largest number that can be made
 from some or all of these digits and is divisible by 3**. 

If it is not possible to make such a number, return 0
as the solution. 

**L will contain anywhere from 1 to 9 digits.**  
The same digit may appear multiple times in the list,
but each element in the list may only be used once.

#### Examples:
Input: Solution.solution({3, 1, 4, 1})
Output: 4311

Input: Solution.solution({3, 1, 4, 1, 5, 9})
Output: 94311

## Solution
**The largest number that can be made from
some or all of these digits and is divisible by 3**

#### Pseudocode
For: A[3, 1, 4, 1, 5, 9]

Sort reversed A 9 5 4 3 1 1
 
Store A in a string

Two for loops
    Outer for iterating through the length
        Inner to get total integers from end
        
            Loop to sum from i to j
                condition num%3==0
                
                OR 
                        
            Get substring and check

9 5 4 3 1 1
i->     <-j

i=0
9 5 4 3 1 1
9 5 4 3 1 -
9 5 4 3 - 1
9 5 4 - 1 1
9 5 - 3 1 1
9 - 4 3 1 1

i=1
5 4 3 1 1
5 4 3 1 -
5 4 3 - 1
5 4 - 1 1
5 - 3 1 1



for i=0; i < lenA ; i++
    
    // This skips numbers behind    
    // for j = lenA-1; j >= i; j--    
    
   // loop through all except one, 
   // skip one from end    
   int skip = lenA-1
    
   for int j=i; j < lenA-1; j++ 
        if( j != skip )
            string += A[i]
            mod check            
        skip--
        
        
       

        
Get string segment from i, j.
Convert into number.
Then check A%3 == 0
    T return A

        
## New Thought, Second solution

Previous idea fails because, the numbers
can be combined!

The numbers could also be exchanged.
A 9 5 4 3 1 1
Skipping does not find divisible by 3.

Instead of sipping one number, the place
can be interchanged, like 1 and 2 values.
A 9 4 5 3 1 1 

We do 1 and 2 values because we want to
the largest. 


## New Thought

No need to take permutation as -

**An integer is divisible by 3 if and only if the
 sum of its digits is divisible by 3.**
 
> https://www.apronus.com/math/threediv.htm
 
 So the previous thought was valid and continued. 
 But fails the one of the hidden test.
 
 
 ## New Thought
 
**Reduce from max sum**

    9 5 4 3 1 1
i->             <-j
sum             reduce 
remove,sum      reduce


If a sum of digits is not divisible by 3
then the remainder will be either 1 or 2. 

We have to remove maximum two digits to 
make a number that is divisible by 3: 

- If remainder is ‘1’, 
    Try to remove one 1,4,7 first.
    We have to remove single digit that have remainder ‘1’.
    Or we have to remove two digit that have remainder ‘2’.
    ( 2 + 2 => 4 % 3 => ‘1’)
    1111%3 = 1
    11111%3 = 2. Here are no 2mod, so remove two 1.


- If remainder is ‘2’,
    Try to remove one 2,5,8 first.
    We have to remove single digit that have remainder ‘2’.
    Or we have to remove two digit that have remainder ‘1’.
    ( 1 + 1 => 2 % 3 => 2 )


##### Logic
check
    Array len > 10, return 0.
    Array len = 1, mod3 == 0, return num; else 0.    

count
    while counting, do sum.

mod = 0; return string.

remove
    Skip 0, as it's irrelevant.
    Try to remove one small number first.
        mod=1, 1,4,7
        mod=2, 2,5,8
    Minimize the numbers removed.
    Why, We want the largest number.    

make
    Create string from end of count array.
  
  
Case: 1,2,3,4,5,6,7,8,8
count: 0:0 1:1 2:1 3:1 4:1 5:1 6:1 7:1 8:2 9:0
mod: 123456788 % 3 = 2
remove: 
    Check if 2,5,8 exists.  
    In this case, there is one 2. So we remove 2.
make.


Case: 9,9,9,9,9,9,9,9,9
check:
sum: 
count: 9:9
mod: 123456788 % 3 = 2
remove: 
    Check if 2,5,8 exists.  
    In this case, there is one 2. So we remove 2.
    

    

