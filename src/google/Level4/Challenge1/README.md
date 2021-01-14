# Problem:

Running with Bunnies
====================

You and your rescued bunny prisoners need to get out of this collapsing death trap of a space station - and **fast**! Unfortunately, some of the bunnies have been weakened by their long imprisonment and can't run very fast. Their friends are trying to help them, but this escape would go a lot faster if you also pitched in. The defensive bulkhead doors have begun to close, and if you don't make it through in time, you'll be trapped! You need to grab as many bunnies as you can and get through the bulkheads before they close. 

The **time it takes to move** from your starting point to all of the bunnies and to the bulkhead will be given to you in a square matrix of integers. **Each row will tell you the time it takes to get to the start, first bunny, second bunny, ..., last bunny, and the bulkhead in that order**. The order of the rows follows the same pattern (start, each bunny, bulkhead). The bunnies can jump into your arms, so picking them up is instantaneous, and arriving at the bulkhead at the same time as it seals still allows for a successful, if dramatic, escape. (Don't worry, any bunnies you don't pick up will be able to escape with you since they no longer have to carry the ones you did pick up.) You can revisit different spots if you wish, and moving to the bulkhead doesn't mean you have to immediately leave - **you can move to and from the bulkhead to pick up additional bunnies if time permits**.

In addition to spending time traveling between bunnies, some paths interact with the space station's security checkpoints and **add time back to the clock**. Adding time to the clock will delay the closing of the bulkhead doors, and if the time goes back up to 0 or a positive number after the doors have already closed, it **triggers the bulkhead to reopen**. Therefore, it might be possible to walk in a circle and keep gaining time: that is **each time a path is traversed, the same amount of time is used or added**.

Write a function of the form solution(times, time_limit) to calculate the most bunnies you can pick up and which bunnies they are, while still escaping through the bulkhead before the doors close for good. If there are multiple sets of bunnies of the same size, **return the set of bunnies with the lowest prisoner IDs (as indexes) in sorted order**. The bunnies are represented as a sorted list by prisoner ID, with the **first bunny being 0**.There are at most **5 bunnies**, and time_limit is a **non-negative** integer that is at most ***999**.

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

### Primary Resources
- https://algs4.cs.princeton.edu/44sp
- https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pdf/06DynamicProgrammingII.pdf


## First Analysis

### Provided Case 1: Time Added Back
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

    0   4    -1    2 // Add time. As the minimal time needed is 2 to rescuse any bunny, we need to add 1 more time which can be gained by opening Bulkhead as 0 to 4 is -1.
    
    4   2     2    0 // Rescue a bunny. As there are bunnies those requires time which we have gathered, i.e. 2, it is opted to rescue Bunny 1. 
    
    2   4    -1    1 // Add time. Although we can exit at this point but going to Bulhead add time back so we go through it. 

    4   3     2   -1 // Future calculation. Rescue Second bunny as the time taken is 2, and from there is path to Bulkhead which adds back time while going through.
    
    3   4    -1    0 // Exit. The last Third bunny is left to rescue but as the time is 0 we will not be able to rescue it.


> What if I try to recuse all of the bunnies?



### Provided Case 2: No Time Added Back

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
    0   1     2    2 Rescue First Bunny.
    1   2     1    1 Rescue Second Bunny.
    2   4     0    0 Exit.
    
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


## Second Analysis

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


## Third Analysis
Went back to the problem and update the description to the given examples above.

#### Some Theory

> Graph representations 
Adjacency Matrix is a n-by-n matrix with A uv = 1 if (u, v) is an edge.
- Two representations of each edge.
- Space proportional to n 2 .
- Checking if (u, v) is an edge takes Θ(1) time.
- Identifying all edges takes Θ(n 2 ) time.

Adjacency Lists is a node-indexed array of lists.
- Two representations of each edge.
- Space is Θ(m + n).
- Checking if (u, v) is an edge takes O(degree(u)) time. degree = number of neighbors of u.
- Identifying all edges takes Θ(m + n) time.


Cycles: A cycle is a path v 1 , v 2 , ..., v k in which v 1 = v k and k ≥ 2.
Trees: An undirected graph is a tree if it is connected and does not contain a cycle.

Shortest path problem. Given two nodes s and t, what is the length of a shortest path between s and t?

**In our problem we intend to return the nodes which can be reached with the time we have.**

Breadth-first search: Explore outward from s in all possible directions, adding nodes one “layer” L at a time.
BFS algorithm.
- L0 = {s}
- L1 = all neighbors of L0
- L2 = all nodes that do not belong to L0 or L1 , and that have an edge to a node in L1
- Li+1 = all nodes that do not belong to an earlier layer, and that have an edge to a node in Li

BFS runs in O(m + n) time if the graph is given by an adjacency representation.

Connected component. Find all nodes reachable from a point.

**This kind of represents our problem** - Which nodes can can we reach from start with the limited time constraints.

> Graph search
- Directed reachability. Given a node s, find all nodes reachable from s.
- Directed s↝t shortest path problem. Given two nodes s and t, what is the length of a shortest path from s to t?
- Graph search. BFS extends naturally to directed graphs.

> Strong connectivity
- Def. Nodes u and v are mutually reachable if there is both a path from u to v and also a path from v to u.
- Def. A graph is strongly connected if every pair of nodes is mutually reachable.

> Directed acyclic graphs
- Def. A DAG is a directed graph that contains no directed cycles.
- Def. A topological order of a directed graph G = (V, E) is an ordering of its nodes as v 1 , v 2 , ..., v n so that for every edge (v i , v j ) we have i < j.

> Cycles
Def. A path is a sequence of edges which connects a sequence of nodes.
Def. A cycle is a path with no repeated nodes or edges other than the starting and ending nodes.

> Minimum spanning tree (MST)
Def. Given a connected, undirected graph G = (V, E) with edge costs ce, a minimum spanning tree (V, T ) is a spanning tree of G such that the sum of the edge costs in T is minimized.

> Arborescence
In graph theory, an arborescence is a directed graph in which, for a vertex u called the root and any other vertex v, there is exactly one directed path from u to v. An arborescence is thus the directed-graph form of a rooted tree, understood here as an undirected graph. Equivalently, an arborescence is a directed, rooted tree in which all edges point away from the root; a number of other equivalent characterizations exist. Every arborescence is a directed acyclic graph, but not every DAG is an arborescence. An arborescence can equivalently be defined as a rooted digraph in which the path from the root to any other vertex is unique.

> Algorithmic Paradigms:
- Greed: Process the input in some order, myopically making irrevocable decisions.
- Divide-and-conquer: Break up a problem into independent subproblems; Solve each subproblem; Combine solutions to subproblems to form solutionto original problem.
- Dynamic programming: Break up a problem into a series of overlapping subproblems; Combine solutions to smaller subproblems to form solution to large subproblem.Dynamic programming is a fancy name for caching intermediate results in a table for later reuse.


## Fourth Analysis
From the last analysis and some theory, I believe that some modification of Bellman-Ford would be enough to get the answer while checking for a negative cycle.

And I need to answer a question on negative cycle - 
- [ ]  Why do return all the bunnies when there is a negative cycle? 
This question is based on the solution that passed the tests.

A simple algorithm that I came up in last analysis:

2. Check if the time we have would be enough save a bunny that requires the same amount of time.
3. If No, Check if there is a way to increase/add more time to save a bunny.
4. 3. If Yes, add time, and save the bunny.
5. 3. If No, return the number of bunnies saved.
6. If Yes, Check if by saving that bunny we would still have more time to keep the Bulkhead.

Well this thought can be done with an updated BFS or DFS but those would not work with a grapth that might have a negative cycle. So a modified Belmanford suits best.

Looked into A* algorithm. This could be an alternative to finding short path but this does not detect neg cycle.
- http://theory.stanford.edu/~amitp/GameProgramming
- https://www.edureka.co/blog/a-search-algorithm
- https://rosettacode.org/wiki/A*_search_algorithm
- https://www.redblobgames.com/pathfinding/a-star/introduction.html
- https://www.ics.uci.edu/~welling/teaching/ICS175winter12/A-starSearch.pdf
- https://stackoverflow.com/questions/5197523/does-a-work-with-negative-weights-as-long-that-the-heuristic-is-admissible


- [ ] So I am curious to know how the algorithms behave after we remove try to remove the negative cycle by augmenting the time provided at first in the auxilliary matrix.

**Well this does not work!**

```
        # Matrix with negative cycle.
        # [
        #     [
        #         [0, 3, 1, 8, 1],
        #         [2, 0, 9, 4, 2],
        #         [-5, 1, 0, 3, -2],
        #         [3, 2, 1, 0, 1],
        #         [1, 3, 2, 0, 0]
        #     ], [10], [[0,1,2]]
        # ],
        
        # Removed neg cycle by adding 10 to check how the solution behaves.
        [
            [
                [0, 13, 11, 18, 11],
                [12, 0, 19, 14, 12],
                [5, 11, 0, 13, 8],
                [13, 12, 11, 0, 11],
                [11, 13, 12, 10, 0]
            ], [0], [[0,1,2]]
        ]

        # Adding 10 was wrong because by adding we increased the time it takes to resuce each bunny.
        # Instead we needed to substract the value or put some other/more logic that could realte in a better way.
        
```

Code coverage with Python.
I wanted to understand how much code was being covered by the tests cases.
https://developer.ibm.com/recipes/tutorials/testing-and-code-coverage-with-python


- [ ] Does first iteration from source node determines/finds out the shortest path and also if there exists any negative cycle in the graph? If so then there will be no need to iterate through all the rows as done in the solutions or default Belman-Ford does. [[0,1,2]]


https://www.geeksforgeeks.org/graph-and-its-representations


Abdul Bari:
Graph Traversals - BFS & DFS -Breadth First Search and Depth First Search
https://www.youtube.com/watch?v=pcKY4hjDrxk
Visit And Explore - There are two fundamental activites in graph traversal.

4.1 MultiStage Graph - Dynamic Programming
https://www.youtube.com/watch?v=9iE9Mj4m8jk

4.1.1 MultiStage Graph (Program) - Dynamic Programming
https://www.youtube.com/watch?v=FcScLYJI42E

Dijkstra Algorithm - Single Source Shortest Path - Greedy Method
https://www.youtube.com/watch?v=XB4MIexjvY0

All Pairs Shortest Path (Floyd-Warshall) - Dynamic Programming
https://www.youtube.com/watch?v=oNI0rf2P9gE

Bellman Ford Algorithm - Single Source Shortest Path - Dynamic Programming
https://www.youtube.com/watch?v=FtN3BYH2Zes


Dijkstra's Algorithm - Computerphile
https://www.youtube.com/watch?v=GazC3A4OQTE
A* (A Star) Search Algorithm - Computerphile
https://www.youtube.com/watch?v=ySN5Wnu88nE


https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue


Note that if a graph contains a “negative cycle” (i.e. a cycle whose edges sum to a negative value) that is reachable from the source, then there is no shortest path. Any path that has a point on the negative cycle can be made cheaper by one more walk around the negative cycle. Bellman–Ford algorithm can easily detect any negative cycles in the graph.

https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-1-introduction/
Minimax is a kind of backtracking algorithm that is used in decision making and game theory to find the optimal move for a player, assuming that your opponent also plays optimally. It is widely used in two player turn-based games such as Tic-Tac-Toe, Backgammon, Mancala, Chess, etc.

In Minimax the two players are called maximizer and minimizer. The maximizer tries to get the highest score possible while the minimizer tries to do the opposite and get the lowest score possible.

Every board state has a value associated with it. In a given state if the maximizer has upper hand then, the score of the board will tend to be some positive value. If the minimizer has the upper hand in that board state then it will tend to be some negative value. The values of the board are calculated by some heuristics which are unique for every type of game.



Time Amendment and use Dijkstras
Lets say we have the below input:
[
        [[0, 2, 2, 2, -1], Adjacency Matrix
        [9, 0, 2, 2, -1],
        [9, 3, 0, 2, -1],
        [9, 3, 2, 0, -1],
        [9, 3, 2, 2, 0]],
    [1], Time 
    [[1,2]] Answer
],

Convert -ve time to 0, the largest negative number is -1, 
so add 1 to it and substract 1 from others, and add 1 to
time each time one is added.
[[0, 1, 1, 1, 0], Time = 1 + time = 2
[8, 0, 1, 1, 0], Time = 1 + time = 3
[8, 2, 0, 1, 0], Time = 1 + time = 4
[8, 2, 2, 0, 0],
[8, 2, 1, 1, 0]],

- [X] Need to check with this theory.
This theory also does not work as from theory - 
https://algs4.cs.princeton.edu/44sp/
https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pdf/06DynamicProgrammingII.pdf:
`Reweighting. Adding a constant to every edge length does not necessarily make Dijkstra’s algorithm produce shortest paths.`


#### More Theory
So when to use DFS over A*, when to use Dijkstra over A* to find the shortest paths?

Summary:

1) One source and One Destination-
→ Use A* Search Algorithm (For Unweighted as well as Weighted Graphs)

2) One Source, All Destination –
→ Use BFS (For Unweighted Graphs)
→ Use Dijkstra (For Weighted Graphs without negative weights)
→ Use Bellman Ford (For Weighted Graphs with negative weights)

3) Between every pair of nodes-
→ Floyd-Warshall
→ Johnson’s Algorithm


https://medium.com/cantors-paradise/dijkstras-shortest-path-algorithm-in-python-d955744c7064
http://theory.stanford.edu/~amitp/GameProgramming/
https://www.geeksforgeeks.org/a-search-algorithm
https://medium.com/@nicholas.w.swift/easy-dijkstras-pathfinding-324a51eeb0f
https://gist.github.com/codeanit/63846b7c07ba2731b5541820306f0efb
https://www.redblobgames.com/pathfinding/a-star/implementation.html
https://gist.github.com/jamiees2/5531924
https://www.freecodecamp.org/news/dijkstras-shortest-path-algorithm-visual-introduction/
https://www.geeksforgeeks.org/python-program-for-dijkstras-shortest-path-algorithm-greedy-algo-7/
https://www.youtube.com/watch?v=XB4MIexjvY0&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=45 3.6 Dijkstra Algorithm - Single Source Shortest Path - Greedy Method
https://www.geeksforgeeks.org/comparison-dijkstras-floyd-warshall-algorithms/
https://github.com/vkasojhaa/Comparison-of-Shortest-Path-Searching-Algorithms
https://www.geeksforgeeks.org/detect-cycle-in-the-graph-using-degrees-of-nodes-of-graph/?ref=rp
https://konaeakira.github.io/posts/using-the-shortest-path-faster-algorithm-to-find-negative-cycles.html
https://iq.opengenus.org/shortest-path-faster-algorithm/

https://en.wikipedia.org/wiki/Paging
https://www.geeksforgeeks.org/paging-in-operating-system/
https://dengking.github.io/Linux-OS/Kernel/Guide/Memory-management/Virtual-memory/Paging/
https://www.geeksforgeeks.org/program-for-least-recently-used-lru-page-replacement-algorithm/
https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/?ref=lbp



#### Analysis with Bellman-Ford

Time: [[0, 2, 2, 2, -1], [9, 0, 2, 2, -1], [9, 3, 0, 2, -1], [9, 3, 2, 0, -1], [9, 3, 2, 2, 0]]

Shortest distance from 0
Parent: [-1, 0, 4, 4, 0]
From  0  to  0  distance is  0. It's path is [ 0 ]
From  0  to  1  distance is  2. It's path is [ 0 1 ]
From  0  to  2  distance is  1. It's path is [ 0 4 2 ]
From  0  to  3  distance is  1. It's path is [ 0 4 3 ]
From  0  to  4  distance is  -1. It's path is [ 0 4 ]
Here the shortest distance from 0 is 1 that leads to 2.


`And from here we can see that the another shortest distance from 0 is 1, 0 to 2.
As there is a possibility to add time back -1 so we can precalculate that
we can rescue third bunny from this initial stage.`

That though would be invalid as there might not be a path from 2-3 with a cost of 1. 

But as 4 is an intermediary route to which both path has a cost of 1, 
the above logic is valid for such case, i.e. The route will be: 
    0->4, 4->2, 2->4, 4->3, 3->4


Shortest distance from 2
Parent: [4, 4, -1, 4, 2]
From  2  to  0  distance is  8. It's path is [ 2 4 0 ]
From  2  to  1  distance is  2. It's path is [ 2 4 1 ]
From  2  to  2  distance is  0. It's path is [ 2 ]
From  2  to  3  distance is  1. It's path is [ 2 4 3 ]
From  2  to  4  distance is  -1. It's path is [ 2 4 ]

The shortest distance from 2 is 1 that leads to 3.

There is a pattern here that can help to find the distances from the
first loop with the origin 0.


#### Python Theory

**Python Collections (Arrays)**

There are four collection data types in the Python programming language:

    List is a collection which is ordered and changeable. Allows duplicate members.
    Tuple is a collection which is ordered and unchangeable. Allows duplicate members.
    Set is a collection which is unordered and unindexed. No duplicate members.
    Dictionary is a collection which is unordered and changeable. No duplicate members.

When choosing a collection type, it is useful to understand the properties of that type. Choosing the right type for a particular data set could mean retention of meaning, and, it could mean an increase in efficiency or security.

#### Analysis with Bellman-Ford (contd..)
Bellman ford gives the shortest path from one vertex to other. 
So with this in mind, and as I've seen some other implementations,
I wanted to find the shortest next path with in the Bellman-Ford.

The first rough idea was to use a recursion that would fetch the
next shortest path. This idea worked for the provided case with
negative weight but failed for the positive weights.

```python
def BellmanFord(edges, source, time, N, last):
    
    if source > 0 and source < N-1 :
        bunny.add(source) 
        # print(bunny)

    # cost stores shortest-path information
    cost = [INF] * N
 
    # Initially all vertices except source vertex have a weight of infinity
    cost[source] = 0
    
    parent = [-1] * N

    # Relaxation step (run V-1 times)
    for i in range(N):
        # consider all edges from u to v having weight w
        for (u, v, w) in edges:
            # if the cost to the destination u can be
            # shortened by taking the edge u -> v
            if cost[u] <= INF and cost[u] + w < cost[v]:

                # print("cost[v] ", cost[v], ' cost[u] ', cost[u], ' + w ', w )

                # update cost to the lower value
                cost[v] = cost[u] + w

                # set v's parent as u
                parent[v] = u
    
            # print("cost[v]:v ", cost[v],":", v )
                # print()


    # Run relaxation step once more for N'th time to
    # check for negative-weight cycles
    for (u, v, w) in edges:
        # if the cost to the destination u can be
        # shortened by taking the edge u -> v
        if cost[u] <= INF and cost[u] + w < cost[v]:
            return True

    print(parent)
    
    for i in range(N):
        print("From ", source, " to ", i , " distance is ", cost[i], end='.')
        print(" It's path is [ ", end='')
        printPath(parent, i)
        print("]")


    # Find the cheapest distance
    minCost = INF
    next = INF
    
    for i in range(1, N):

        if cost[i] < minCost \
        and i != source \
        and not i in bunny :
            next = i
            minCost = cost[i]
            
    if not last:         
        if ( minCost < 0 ):
            time = time + -1*minCost

        elif ( minCost > 0 ):
            time = time - minCost

        # This is for negative costs involved.
        # For the first solution.
        if time < 0 and source == N-1 and len(bunny)+1 == N-2: 
            return 

        # if time < 0 and source == N-1 and len(bunny)+1 == N-2: 
        #     return 

        # check if this is the last stage and door is yet not open
        if time < 0 and source == N-2:
            # go back and check if there is a way from the previous source to door.
            time = time + minCost
            bunny.pop()
            last = bunny.pop()

            # This was the previous logic but as we already have 
            # the shortest path so we can use that data but the data 
            # is not stored yet.
            # BellmanFord(edges, last, time, N, 1)    
    else:
        next = N-1
        time = time + minCost

    # BellmanFord(edges, next, time, N, False)
    
    # else:
    #     # Check if there is a path from the next to bulhead
    #     BellmanFord(edges, next, time, N )
    #     # print source in asecending order
    #     False

    return False

```

Then the next idea was to use all the computed
paths by completed Bellman-Ford.

```python
    
    # Store computed data bunnies in the Bellman-Ford
    bunny = []

    for i in range(len(bunny)-4):
        minDist = INF
        for j in range(len(bunny)-1):
            print("From ", i, " to ", j , " distance is ", bunny[i]['cost'][j], end='.')
            print(" It's path is [ ", end='')
            printPath(bunny[i]['parent'], j)
            print("]")
            print('Cost', bunny[i]['cost'][j])

            if bunny[i]['cost'][j] < minDist and i!=j:
                minDist = bunny[i]['cost'][j]
                print(bunny[i]['cost'][j]) 
```

Both ideas are not yet fully relaized as the remaninig time was minimal.
So I choose to use existing solution for submission.

I choose Python as the programming language as the solutions and examples 
were better and more, and I use it as tooling language to validate ideas.

### Further analysis after submission
The submitted solution was third-party and I wanted to find better
optimium solution.

##### First Example:
``` python
adjacencyMatrix = [
            [0, 2, 2, 2, -1],  # 0 = Start
            [9, 0, 2, 2, -1],  # 1 = Bunny 0
            [9, 3, 0, 2, -1],  # 2 = Bunny 1
            [9, 3, 2, 0, -1],  # 3 = Bunny 2
            [9, 3, 2, 2,  0],  # 4 = Bulkhead
        ]
time = 1
```

The shortest paths are from 0, 1, 2 and 3 are:
[0, 2, 1, 1, -1], [8, 0, 1, 1, -1], [8, 2, 0, 1, -1], [8, 2, 1, 0, -1]

Rough algorithm could be:

Find the miminum value. 
If there are more than one, put them in a queue, i.e. Here there is two 1's,
Select the minimum value.
Reduce the total time provided.

Move to next stage who's minimum value was selected.
Select the next minimum value excluding the previous stage.

Check if the available time is enough to reach next stage.
The remaining time must be greater than or equal to shortest time it takes to reach next level.

Steps taken based on the algorithm based on the shortest path:

Previous vertices pv = null
Remaining time rt =  2

Step 1 [0, 2, 1, 1, -1]
Remove first and last index from the list, say AL, = [2, 1, 1]
Sort = [1,1,2]
Add sorted list to queue
Dequeue: Choose the first number from the sorted list 
    The next path np = Select the first index in AL = 2
rt = 2 - 1 = 1
Is rt - np > 0, go to next step.


Step 2 [8, 2, 0, 1, -1]
Previous vertices:0
Remove first, last index, self, and previous vertices index AL = [2, 1]
    This filtration might cause issue while selecting as the index are removed
    But we need it for sorting
Sort = [1, 2]
Add sorted list to queue
Choose the first number from the sorted list
    The next path = Select the index in the shortest path whose value is dequeued
        [x, x, x, 1, x] = 3, the only option remaining  
    Probable problem:
rt = 1 - 1 = 0
Is rt - np > 0, go to next step. No


##### Second Example:
Adjacency Matrix = [[0, 1, 1, 1, 1], [1, 0, 1, 1, 1], [1, 1, 0, 1, 1], [1, 1, 1, 0, 1], [1, 1, 1, 1, 0]]
Time = 3
Shortest Path sp = [[0, 1, 1, 1, 1], [1, 0, 1, 1, 1], [1, 1, 0, 1, 1], [1, 1, 1, 0, 1]]


Previous vertices pv = null
Remaining time rt =  3
list = sp[0] = [0, 1, 1, 1, 1] 

while i > 0:

Step 1 [0, 1, 1, 1, 1]
pv = null
Remove first and last index from the list, say AL, = [1, 1, 1]
Sort = [1,1,1]
Add sorted list to queue
Dequeue: Choose the first number from the sorted list = 1
    Choose the first index whose value is 1.
    nextIndex = sp[1]
rt = 3 - 1 = 2
Is rt - np > 0, 
    Go to next step: nextIndex


Step 2 [1, 0, 1, 1, 1]
pv = 0
Remove first and last index from the list, say AL, = [1, 1, 1]
Sort = [1,1,1]
Add sorted list to queue
Dequeue: Choose the first number from the sorted list = 1
    Choose the first index whose value is 1
    nextIndex = sp[1]
rt = 2 - 1 = 1
Is rt - np > 0, 
    Go to next step: nextIndex

Step 3 [1, 1, 0, 1, 1]
pv = 1
Remove first, last and previous index from the list, say AL, = [1]
Sort = [1] // No need to sort if there's one one item
Add sorted list to queue // No need
Dequeue: Choose the first number from the sorted list = 1
    Choose the first index whose value is 1
    nextIndex = sp[1]
rt = 2 - 1 = 1
Is rt - np > 0, 
    Go to next step: nextIndex




###### Tabs On Brower
- [ ] https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/tutorial/
- [ ] https://docs.ioin.in/writeup/www.auxy.xyz/_tutorial_Webkit_Exp_Tutorial_/index.html
- [ ] https://tech.ebayinc.com/engineering/ou-online-analytical-processing/
- [ ] https://www.linkedin.com/pulse/dos-donts-while-preparing-amazon-machine-learning-specialty-semaan/
- [ ] https://www.infoq.com/podcasts/software-architecture-team-topologies
- [ ] https://medium.com/awsblogs/ci-cd-with-kubernetes-3c29e8073c38
- [ ] https://www.infoq.com/presentations/hotspot-graalvm-code-execution
- [ ] https://medium.com/better-programming/modern-day-architecture-design-patterns-for-software-professionals-9056ee1ed977 
- [ ] https://www.linkedin.com/learning/cobol-essential-training/cobol-is-alive-and-well
- [ ] https://mailchi.mp/5125b7b5305e/18-dear-architects
- [ ] https://advocacy.vmware.com/member/post/1d9aff34-0610-42ed-9b90-21233cabc9ae?uc=113877&g=df4af070-be59-44be-b7f0-ea2387c55f98&f=2433965
- [ ] https://minimatech.org/from-postgresql-to-neo4j
- [ ] https://www.siddharthsarda.com/p/developer-progression-as-a-function
- [ ] https://www.infoworld.com/article/3563829/jamstack-the-static-website-revolution-upending-web-development.html
- [ ] https://apenwarr.ca/log/20201227 System design
- [ ] https://www.infoq.com/articles/database-audit-system-kafka
- [ ] https://increment.com/remote/committing-to-collaboration-version-control | https://increment.com/remote
- [ ] https://medium.com/neotiv-gmbh/5-design-patterns-every-software-engineer-should-know-470c8b6c0b54
- [ ] https://chromeisbad.com
