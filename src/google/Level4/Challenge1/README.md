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

As the weight can be negative, we may need to use Floyd Warshall/Bellman Ford algorithm. Incase of absense of negative cycle Dijkstras. Or find some other efficient algorithms.

Tutotial and code sample. This is a really good resource.
https://www.youtube.com/watch?v=09_LlHjoEiY
https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory 
https://www.youtube.com/watch?v=4NQ3HnhyNfQ&list=PLDV1Zeh2NRsAsbafOroUBnNV8fhZa7P4u&index=8

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


### Second Analysis

https://www.cs.princeton.edu/~wayne/kleinberg-tardos
https://en.wikipedia.org/wiki/Path_%28graph_theory%29#Different_types_of_paths
https://cstheory.stackexchange.com/questions/17462/finding-the-shortest-path-in-the-presence-of-negative-cycles


```python
# https://github.com/franklinvp/foobar/blob/master/foobar2020/solutionProblem4.py

import copy

def BellmanFord(times, time_limit):
    """
    Bellman-Ford algorithm using all vertices as source.
    We pass in the time_limit to check, when there is a negative cycle,
    if it it reachable from the start.
    """
    # Initialization
    n = len(times)
    d = [n*[float("inf")] for _ in range(n)]
    for s in range(n):
        d[s][s] = 0
        # Relaxation
        for i in range(n-1):
            updated = False
            for u in range(n):
                for v in range(n):
                    distReach = d[s][u] + times[u][v]
                    if d[s][v] > d[s][u] + times[u][v]:
                        updated = True
                        d[s][v] = distReach
            # An optimization. It doesn't change the worst case, but well ...
            if not updated:
                break 
        # Negative cycle detection
        for u in range(n):
            for v in range(n):
                if d[s][v] > d[s][u] + times[u][v] and d[0][u] < time_limit:
                    return True, d # Negative cycle
    return False, d # no negative cycles


def solution(times, time_limit):
    n = len(times)
    if n <=2 :
        return []
    nc, d = BellmanFord(times, time_limit)
    
    if nc:
        return [x for x in range(len(times)-2)]
    else:
        # BFS for paths that collect max bunnies.
        stack = [[0,[0],time_limit,[[i] for i in range(n)]]]
        vertices = set([i for i in range(n)])
        maxBunnies = set()
        maxNumberBunnies = 0
        while stack:
            [u,path,timeleft, voidvertices] = stack.pop()
            for v in vertices - set(voidvertices[u]):
                timeuv = d[u][v]
                timeub = d[v][n-1]
                timevu = d[v][u]
                nextVoidVertices = copy.deepcopy(voidvertices)
                if timeuv+timevu == 0:
                    nextVoidVertices[u].append(v)
                    nextVoidVertices[v].append(u)
                if timeleft-timeuv-timeub >= 0:
                    nextPath = path+[v]
                    nextTimeLeft=timeleft-timeuv
                    stack.append([v,nextPath,nextTimeLeft,nextVoidVertices])
                    if v == n-1: 
                        setNextPath = set(nextPath)
                        lengthNextPath = len(setNextPath)
                        if lengthNextPath == n: # We got all bunnies
                            return [x for x in range(len(times)-2)]
                        if maxNumberBunnies < lengthNextPath or (maxNumberBunnies == lengthNextPath and sum(maxBunnies) > sum(setNextPath)):
                            maxBunnies = setNextPath
                            maxNumberBunnies = lengthNextPath
        return sorted([x-1 for x in (maxBunnies - set([0,n-1]))])
```

#### Some Python Tutorial
```python
LIST vs TUPLE
Lists are mutable
Tuple are immutable

Implication of iterations is Time-consuming 	
Implication of iterations is comparatively Faster
 	    
The list is better for performing operations, such as insertion and deletion. 	
Tuple data type is appropriate for accessing the elements

Lists consume more memory
Tuple consume less memory as compared to the list

Lists have several built-in methods
Tuple does no have must built-in methods.

The unexpected changes and errors are more likely to occur
In tuple, it is hard to take place

List Example
listWeekDays = ['mon', 'tue', 'wed', 2]
You can check the type of object created using type() function in Python.	
type(listWeekDays)
#<class 'list'>

Tuple Example:
tupWeekDays = ('mon', 'tue', 'wed', 2)
Using type() function to check the tupWeekDays type.	
type(tupWeekDays)
#<class 'tuple'>

Here tuple is created without ( and )
tupWeekDays = 'mon', 'tue', 'wed', 2 


Dictionary
A dictionary in python is a collections of key-value pairs of item. For each entry, there are two items: a key and a value. Note the following about Python dictionaries
    keys in a dictionary must be unique (no two same keys)
    keys are immutable
    keys and values can be of any data types
    the keys() function returns list of keys in a dictionary
    the values() function returns list of values in dictionary

>>> months = {
    "Jan": "January",
    "Feb": "Febraury",
}
>>> weekdays = {
    1: "Monday",
    2: "Tuesday",
}


Set
A set in python is a collection of items just like Lists and Tuples.  Note the following about sets:
    A set is created using the set keyword
    A set cannot be an element of a set (but a list can be an element of a list)
>>> things = set(["chair", 45, 'A', "house"])
```

#### Bellman-Ford algorithm example
```python
# https://www.techiedelight.com/determine-negative-weight-cycle-graph/

# define infinity as maximum value of the integer
INF = float('inf')
 
 
# Function to run Bellman-Ford algorithm from given source
def BellmanFord(edges, source):
 
    # cost stores shortest-path information
    cost = [INF] * N
 
    # Initially all vertices except source vertex have a weight of infinity
    cost[source] = 0
 
    # Relaxation step (run V-1 times)
    for _ in range(N-1):
        # consider all edges from u to v having weight w
        for (u, v, w) in edges:
            # if the cost to the destination u can be
            # shortened by taking the edge u -> v
            if cost[u] != INF and cost[u] + w < cost[v]:
                # update cost to the lower value
                cost[v] = cost[u] + w
 
    # Run relaxation step once more for N'th time to
    # check for negative-weight cycles
    for (u, v, w) in edges:
        # if the cost to the destination u can be
        # shortened by taking the edge u -> v
        if cost[u] != INF and cost[u] + w < cost[v]:
            return True
 
    return False
 
 
if __name__ == '__main__':
 
    # given adjacency representation of matrix
    adjMatrix = [
        [0, INF, -2, INF],
        [4, 0, -3, INF],
        [INF, INF, 0, 2],
        [INF, -1, INF, 0]
    ]
 
    # N is number of vertices in the graph
    N = 4
 
    # create a List to store graph edges
    edges = []
 
    for v in range(N):
        for u in range(N):
            if adjMatrix[v][u] and adjMatrix[v][u] != INF:
                # edge from source v to dest u having specified weight
                edges.append((v, u, adjMatrix[v][u]))
 
    # run Bellman-Ford algorithm from each vertex as source
    # and check for any Negative Weight Cycle
    for i in range(N):
        if BellmanFord(edges, i):
            print("Negative Weight Cycle Found!!")
            break
 
```

#### Another neat solution:
``` python

# https://github.com/n3a9/google-foobar/blob/master/Level%204/running_with_bunnies/solution.py

import itertools

def convert_to_path(perm):
    perm = list(perm)
    perm = [0] + perm + [-1]
    path = list()
    for i in range(1, len(perm)):
        path.append((perm[i - 1], perm[i]))
    return path

def solution(time, time_limit):
    rows = len(time)
    bunnies = rows - 2

    for k in range(rows):
        for i in range(rows):
            for j in range(rows):
                if time[i][j] > time[i][k] + time[k][j]:
                    time[i][j] = time[i][k] + time[k][j]

    for r in range(rows):
        if time[r][r] < 0:
            return [i for i in range(bunnies)]

    for i in reversed(range(bunnies + 1)):
        for perm in itertools.permutations(range(1, bunnies + 1), i):
            total_time = 0
            path = convert_to_path(perm)
            for start, end in path:
                total_time += time[start][end]

            if total_time <= time_limit:
                return sorted(list(i - 1 for i in perm))

    return None
'''
Itertool is a module provided by Python for creating iterators for efficient looping. It also provides various features or functions that work with iterators to produce complex iterators and help us to solve problems easily and efficiently in terms of time as well as memory. Itertools module provides us various ways to manipulate the sequence that we are traversing through.
Itertools.permutation() function falls under the Combinatoric Generators. The recursive generators that are used to simplify combinatorial constructs such as permutations, combinations, and Cartesian products are called combinatoric iterators.

As understood by the word “Permutation” it refers to all the possible combinations in which a set or string can be ordered or arranged. Similarly here itertool.permutations() method provides us with all the possible arrangements that can be there for an iterator and all elements are assumed to be unique on the basis of there position and not by there value or category. All these permutations are provided in lexicographical order. The function itertool.permutations() takes an iterator and ‘r’ (length of permutation needed) as input and assumes ‘r’ as default length of iterator if not mentioned and returns all possible permutations of length ‘r’ each.

    a = "GeEK"
    p = permutations(a)      
    for j in list(p):  
        print(j)  

'''
```

#### Findings
From the research solution could be found in the following steps:
1. Check if negative cycle exists using Bellman Ford algoritm.
2. If true, return the total number of bunnies.
3. Now we need to find the total number of bunnies that can be carried with the allowed time. This can be done with BFS or DFS. The latest solution provides good reference.


#### TODO 
- [ ] Understand and implement the finding number 3. 
- [ ] Review https://iq.opengenus.org/blossom-maximum-matching-algorithm
- [ ] Review https://www.informit.com/articles/article.aspx?p=169575&seqNum=8
