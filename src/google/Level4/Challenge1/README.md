# Problem:

Running with Bunnies
====================

You and your rescued bunny prisoners need to get out of this collapsing death trap of a space station - and **fast**! Unfortunately, some of the bunnies have been weakened by their long imprisonment and can't run very fast. Their friends are trying to help them, but this escape would go a lot faster if you also pitched in. The defensive bulkhead doors have begun to close, and if you don't make it through in time, you'll be trapped! You need to grab as many bunnies as you can and get through the bulkheads before they close. 

The **time it takes to move** from your starting point to all of the bunnies and to the bulkhead will be given to you in a square matrix of integers. **Each row will tell you the time it takes to get to the start, first bunny, second bunny, ..., last bunny, and the bulkhead in that order**. The order of the rows follows the same pattern (start, each bunny, bulkhead). The bunnies can jump into your arms, so picking them up is instantaneous, and arriving at the bulkhead at the same time as it seals still allows for a successful, if dramatic, escape. (Don't worry, any bunnies you don't pick up will be able to escape with you since they no longer have to carry the ones you did pick up.) You can revisit different spots if you wish, and moving to the bulkhead doesn't mean you have to immediately leave - **you can move to and from the bulkhead to pick up additional bunnies if time permits**.

In addition to spending time traveling between bunnies, some paths interact with the space station's security checkpoints and add time back to the clock. Adding time to the clock will delay the closing of the bulkhead doors, and if the time goes back up to 0 or a positive number after the doors have already closed, it triggers the bulkhead to reopen. Therefore, it might be possible to walk in a circle and keep gaining time: that is **each time a path is traversed, the same amount of time is used or added**.

Write a function of the form solution(times, time_limit) to calculate the most bunnies you can pick up and which bunnies they are, while still escaping through the bulkhead before the doors close for good. If there are multiple sets of bunnies of the same size, **return the set of bunnies with the lowest prisoner IDs (as indexes) in sorted order**. The bunnies are represented as a sorted list by prisoner ID, with the **first bunny being 0**.There are at most **5 bunnies**, and time_limit is a non-negative integer that is at most ***999**.

For instance, in the case of
[
  [0, 2, 2, 2, -1],  # 0 = Start
  [9, 0, 2, 2, -1],  # 1 = Bunny 0
  [9, 3, 0, 2, -1],  # 2 = Bunny 1
  [9, 3, 2, 0, -1],  # 3 = Bunny 2
  [9, 3, 2, 2,  0],  # 4 = Bulkhead
]
and a time limit of 1, the five inner array rows designate the starting point, bunny 0, bunny 1, bunny 2, and the bulkhead door exit respectively. You could take the path:

Start End Delta Time Status
    -   0     -    1 Bulkhead initially open
    0   4    -1    2
    4   2     2    0
    2   4    -1    1
    4   3     2   -1 Bulkhead closes
    3   4    -1    0 Bulkhead reopens; you and the bunnies exit

With this solution, you would pick up bunnies 1 and 2. This is the best combination for this space station hallway, so the answer is [1, 2].

Languages
=========

To provide a Java solution, edit Solution.java
To provide a Python solution, edit solution.py

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

-- Java cases --
Input:
Solution.solution({{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}}, 3)
Output:
    [0, 1]

Input:
Solution.solution({{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}}, 1)
Output:
    [1, 2]

-- Python cases --
Input:
solution.solution([[0, 2, 2, 2, -1], [9, 0, 2, 2, -1], [9, 3, 0, 2, -1], [9, 3, 2, 0, -1], [9, 3, 2, 2, 0]], 1)
Output:
    [1, 2]

Input:
solution.solution([[0, 1, 1, 1, 1], [1, 0, 1, 1, 1], [1, 1, 0, 1, 1], [1, 1, 1, 0, 1], [1, 1, 1, 1, 0]], 3)
Output:
    [0, 1]

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.

# Solution

## First Analysis

### Provided Case 1
Time Limit: 1
Answer: Bunnies 1, 2

     0  1  2  3   4
  0  0, 2, 2, 2, -1,   0 = Start
  1  9, 0, 2, 2, -1,   1 = Bunny 0
  2  9, 3, 0, 2, -1,   2 = Bunny 1
  3  9, 3, 2, 0, -1,   3 = Bunny 2
  4  9, 3, 2, 2,  0,   4 = Bulkhead

Start End Delta Time Status
    -   0     -    1 // Bulkhead initially open

    0   4    -1    2 // Add time. As the minimal time needed is 2 to rescuse any bunny, it is opted to add more time. And to add time we can jump to Bulkhead once.
    
    4   2     2    0 // Rescue a bunny. As there are bunnies those requires time which we have gathered, i.e. 2, it is opted to rescue Bunny 1.
    
    2   4    -1    1 // Add time. Now rescue more bunny we need to get more time so we need to go through bulkhead again.

    4   3     2   -1 // Go to second bunny as the time taken is 2, we will have to 1 time to give back. We can not go to first bunny as it takes 3 to carry bunny and we will not be able to reopen the bulkhead.
    
    3   4    -1    0 Open bulkhead. Exit. As reopening bulkhead add 1, we can return the time we lended, i.e. -1.

> What if I try to recuse all of the bunnies?



### Provided Case 2

Time Limit: 3
Answer: Bunnies 0, 1

    0  1  2  3  4
0   0, 1, 1, 1, 1 # Start
1   1, 0, 1, 1, 1 # Bunny 0  
2   1, 1, 0, 1, 1 # Bunny 1  
3   1, 1, 1, 0, 1 # Bunny 2  
4   1, 1, 1, 1, 0 # End  

Start End Delta Time Status
    -   0     -    3 Bulkhead is open
    0   1     2    2 Rescue bunny one
    1   2     1    1 Rescue bunny two
    2   4     0    0 Exit. We can go directly to 4 as it takes 1 time to open the bulkhead.
    
If we wanted to rescue third bunny then we needed to add more time, which is slows the process, so we skip them as the requirement to the problem was to be fast! But there could have been another solution to rescue 0,3 0r 1,3 bunny as well as every rescure needs exactly same time.


A greedy approach would do well as the process requires minimization of the resource usage to get maximum value.
Or some form of graph based dynamic programming will be needed.

As the weight can be negative, we may need to use Floyd Warshall/Bellman Ford or other algorithm. Incase of absense of negative cycle Dijkstras. Or find some other efficient algorithms.

Tutotial and code sample. This is a really good resource.
https://www.youtube.com/watch?v=09_LlHjoEiY
https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory 

Further foundatational Understanding:
https://en.wikipedia.org/wiki/Graph_traversal
https://en.wikipedia.org/wiki/Tree_traversal
https://www.geeksforgeeks.org/detecting-negative-cycle-using-floyd-warshall
https://www.geeksforgeeks.org/detect-negative-cycle-graph-bellman-ford
https://www.hackerearth.com/practice/algorithms/graphs/hamiltonian-path/tutorial
http://rosettacode.org

Implemented References:
https://cs.stackexchange.com/questions/129602/google-foobar-level-4-graph-problem
https://github.com/franklinvp/foobar/blob/master/foobar2020/solutionProblem4.py

