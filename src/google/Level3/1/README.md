# Problem 

Bomb, Baby!
===========

You're so close to destroying the LAMBCHOP doomsday device you can taste it! But in order to do so, you need to deploy special 
**self-replicating** bombs designed for you by the brightest scientists on Bunny Planet. 

There are two types: Mach bombs (M) and Facula bombs (F). 

The bombs, once released into the LAMBCHOP's inner workings,
will automatically deploy to all the strategic points you've
identified and destroy them at the same time. 

But there's a few catches. 

### First, the bombs self-replicate via one of two distinct processes:

Every Mach bomb retrieves a sync unit from a Facula bomb; **for every Mach bomb, a Facula bomb is created**;

**Every Facula bomb spontaneously creates a Mach bomb.**

For example, if you had 3 Mach bombs and 2 Facula bombs, 
they could either produce 3 Mach bombs and 5 Facula bombs, 
or 5 Mach bombs and 2 Facula bombs. 

The replication process can be changed each cycle. 

### Second, you need to ensure that you have **exactly the right number of Mach and Facula bombs** to destroy the LAMBCHOP device.
Too few, and the device might survive.

Too many, and you might overload the mass capacitors and create a singularity at the heart of the space station - not good! 

And finally, you were only able to smuggle
**one of each type of bomb - one Mach, one Facula**
- aboard the ship when you arrived, so 
that's all you have to start with. 
(Thus it may be impossible to deploy the bombs to destroy the LAMBCHOP, but that's not going to stop you from trying!) 

You need to know **how many replication cycles (generations)** 
it will take to generate the correct amount of bombs to destroy the LAMBCHOP.

Write a function solution(M, F) where M and F are the number of Mach and Facula bombs needed. 

Return the fewest number of generations (as a string) that need to pass before you'll have the exact number of bombs necessary to destroy the LAMBCHOP, or the string "impossible" if this can't be done! 

M and F will be string representations of positive integers no larger than 10^50. 

For example, if M = "2" and F = "1", one generation would need to pass, so the solution would be "1". 
However, if M = "2" and F = "4", it would not be possible.

-- Java cases -- 
Input:
Solution.solution('2', '1')
Output: 1

Input:
Solution.solution('4', '7'): (4, 7-4) => (4-3, 3) => (1, 3-1) => (1, 2-1) => (1,1)
Output: 4


# Solution

At first could not understand the problem quiet clearly.

After doing some search, it made some sense.

('4', '7'): (4, 7-4) => (4-3, 3) => (1, 3-1) => (1, 2-1) => (1,1)
Steps       1           2           3           4

(2,4): (2,4-2) => (2,2) impossible


Found a great solution which passed Google tests.
```python
def answer(M, F):
    x, y = int(M), int(F)
    count = 0
    while y >= 1:
        if x < y:
            x, y = y, x
        x, y, q = y, x % y, x // y
        count += q
    print(x)
    return str(count - 1) if x == 1 else "impossible"
    
# https://github.com/oneshan/foobar/blob/master/bomb_baby/solution.py
```

Some other solutions:
https://github.com/oneshan/foobar/blob/master/bomb_baby/solution.py

https://sskaje.me/2017/05/googles-foo-bar-doomsday-fuel/

https://stackoverflow.com/questions/307291/how-does-the-google-did-you-mean-algorithm-work?rq=1


### After a day.
```python
def solution(M, F):
    # Your code here
    x, y = int(M), int(F)
    count = 1
    while y >= 1:
        if x < y:
            x, y = y, x
        x, y = y, x % y
        count += 1
    return str(count) if x == 1 else "impossible"
```
The above changes fails:
Test 1 passed!
Test 2 failed 
Test 3 failed  [Hidden]
Test 4 passed! [Hidden]
Test 5 failed  [Hidden

Some more analysis:
(6,2): (6-2, 2) : (4-2, 2) : (0:2)  impossible
(2,8): (8-2, 2) : (6-2, 2) impossible
(2,10): (10-2, 2) : (8-2, 2) impossible
(3,12): (3, 12-3) : (3, 9-3) impossible

From these analysis, we can see that if the higher 
number divided by smaller, remainder = 0, then 
the we will not be able to reduce 1,1.


The solution fails a test when the condition below
is enabled. Need to find a test case where it fails.

``` python
   if x > y and x % y == 0:
        return "impossible"
```
