es# Problem

Escape Pods
===========

You've blown up the LAMBCHOP doomsday device and broken the bunnies out of Lambda's prison - and now you need to escape from the space station as quickly and as orderly as possible! The bunnies have all gathered in various locations throughout the station, and need to make their way towards the seemingly endless amount of escape pods positioned in other parts of the station. You need to get the numerous bunnies through the various rooms to the escape pods. Unfortunately, the corridors between the rooms can only fit so many bunnies at a time. What's more, many of the corridors were resized to accommodate the LAMBCHOP, so they vary in how many bunnies can move through them at a time.

Given the starting room numbers of the groups of bunnies, the room numbers of the escape pods, and how many bunnies can fit through at a time in each direction of every corridor in between, figure out how many bunnies can safely make it to the escape pods at a time at peak.

Write a function solution(entrances, exits, path) that takes an array of integers denoting where the groups of gathered bunnies are, an array of integers denoting where the escape pods are located, and an array of an array of integers of the corridors, returning the total number of bunnies that can get through at each time step as an int. The entrances and exits are disjoint and thus will never overlap. The path element path[A][B] = C describes that the corridor going from A to B can fit C bunnies at each time step.  There are at most 50 rooms connected by the corridors and at most 2000000 bunnies that will fit at a time.

For example, if you have:
entrances = [0, 1]
exits = [4, 5]
path = [
  [0, 0, 4, 6, 0, 0],  # Room 0: Bunnies
  [0, 0, 5, 2, 0, 0],  # Room 1: Bunnies
  [0, 0, 0, 0, 4, 4],  # Room 2: Intermediate room
  [0, 0, 0, 0, 6, 6],  # Room 3: Intermediate room
  [0, 0, 0, 0, 0, 0],  # Room 4: Escape pods
  [0, 0, 0, 0, 0, 0],  # Room 5: Escape pods
]

Then in each time step, the following might happen:
0 sends 4/4 bunnies to 2 and 6/6 bunnies to 3
1 sends 4/5 bunnies to 2 and 2/2 bunnies to 3
2 sends 4/4 bunnies to 4 and 4/4 bunnies to 5
3 sends 4/6 bunnies to 4 and 4/6 bunnies to 5

So, in total, 16 bunnies could make it to the escape pods at 4 and 5 at each time step.  (Note that in this example, room 3 could have sent any variation of 8 bunnies to 4 and 5, such as 2/6 and 6/6, but the final solution remains the same.)

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
Solution.solution({0, 1}, {4, 5}, {{0, 0, 4, 6, 0, 0}, {0, 0, 5, 2, 0, 0}, {0, 0, 0, 0, 4, 4}, {0, 0, 0, 0, 6, 6}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}})
Output:
    16

Input:
Solution.solution({0}, {3}, {{0, 7, 0, 0}, {0, 0, 6, 0}, {0, 0, 0, 8}, {9, 0, 0, 0}})
Output:
    6

-- Python cases --
Input:
solution.solution([0], [3], [[0, 7, 0, 0], [0, 0, 6, 0], [0, 0, 0, 8], [9, 0, 0, 0]])
Output:
    6

Input:
solution.solution([0, 1], [4, 5], [[0, 0, 4, 6, 0, 0], [0, 0, 5, 2, 0, 0], [0, 0, 0, 0, 4, 4], [0, 0, 0, 0, 6, 6], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]])
Output:
    16

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.


# Solution

## Analysis
For example, if you have:
Entrances = [0, 1]
Exits = [4, 5]
Path = [
     0  1  2  3  4  5
    [0, 0, 4, 6, 0, 0],  # Room 0: Bunnies
    [0, 0, 5, 2, 0, 0],  # Room 1: Bunnies

    [0, 0, 0, 0, 4, 4],  # Room 2: Intermediate room
    [0, 0, 0, 0, 6, 6],  # Room 3: Intermediate room
    
    [0, 0, 0, 0, 0, 0],  # Room 4: Escape pods
    [0, 0, 0, 0, 0, 0],  # Room 5: Escape pods
]

Output: 16

Then in each time step, the following might happen:
0 sends 4/4 bunnies to 2 
0 sends 6/6 bunnies to 3

1 sends 4/5 bunnies to 2 
1 sends 2/2 bunnies to 3

2 sends 4/4 bunnies to 4 
2 sends 4/4 bunnies to 5

3 sends 4/6 bunnies to 4 
3 sends 4/6 bunnies to 5

### Second Example
Entrances = [0]
Exists = [3]
Path = [[0, 7, 0, 0], [0, 0  , 6, 0], [0, 0, 0, 8], [9, 0, 0, 0]]
Output: 6

[0, 7, 0, 0] 0 # Room 0: Bunnies
[0, 0, 6, 0] 1 # Room 1: Intermediate room
[0, 0, 0, 8] 2 # Room 2: Intermediate room
[9, 0, 0, 0] 3 # Room 3: Escape pods

0 sends 7/6 bunnies to 1 
1 sends 6/8 bunnies to 2
2 sends 6/9 bunnies to 3

The problem is related to finding the network flow. 

### Theory
- https://algs4.cs.princeton.edu/40graphs
- [Network Flow Algorithms Starting Here](https://www.youtube.com/watch?v=LdOnanfc5TM&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=33)
- 13. Incremental Improvement: Max Flow, Min Cut](https://www.youtube.com/watch?v=VYZGlgzr_As)
- 14. https://www.youtube.com/watch?v=8C_T4iTzPCU
- https://www.youtube.com/watch?v=0CdxkgAjsDA
- https://en.wikipedia.org/wiki/Flow_network
- https://en.wikipedia.org/wiki/Max-flow_min-cut_theorem
- https://en.wikipedia.org/wiki/Maximum_flow_problem
- https://www.geeksforgeeks.org/cuts-and-network-flow
- https://www.sciencedirect.com/science/article/pii/002200008590039X
- https://stackoverflow.com/questions/36054690/how-to-use-dinics-algorithm-to-find-min-cut-edges-in-undireted-graph
- Actual Complexity of Max Flow Algorithms https://codeforces.com/blog/entry/52714


### First Example

```java

// Source:  https://vitaminac.github.io/Google-Foobar-Escape-Pods/

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Arrays;


public class EscapePods {
    private static final int INF = Integer.MAX_VALUE;

    private static int[][] transform(int[] sources, int[] sinks, int[][] network) {
        // transform to a equivalent single-source, single-sink flow network
        int length = network.length;
        int newLength = length + 2;
        int[][] newNetwork = new int[newLength][newLength];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newNetwork[i + 1][j + 1] = network[i][j];
            }
        }
        for (int entrance : sources) {
            newNetwork[0][entrance + 1] = INF;
        }
        for (int exit : sinks) {
            newNetwork[exit + 1][newLength - 1] = INF;
        }
        return newNetwork;
    }

    private static List<Integer> bfs(int[][] residual_network) {
        // find a path from s to t that every (u, v) in p satisfies c_f(u, v) > 0
        int[] parents = new int[residual_network.length];
        Arrays.fill(parents, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int u;
        for (; !queue.isEmpty() && parents[parents.length - 1] == -1; ) {
            u = queue.remove();
            for (int v = 0; v < parents.length; v++) {
                if (residual_network[u][v] > 0 && parents[v] == -1) {
                    queue.add(v);
                    parents[v] = u;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        u = parents[parents.length - 1];
        while (u != 0) {
            if (u == -1) return null;
            path.add(u);
            u = parents[u];
        }
        Collections.reverse(path);
        return path;
    }

    private static int solveWithFordFulkerson(int[][] residual_network) {
        // https://en.wikipedia.org/wiki/Ford%E2%80%93Fulkerson_algorithm
        int max_flow = 0;
        List<Integer> path;
        while ((path = bfs(residual_network)) != null) {
            // calculate residual capacity c_f(p)
            int residual_capacity = INF;
            int u = 0;
            for (int v : path) {
                residual_capacity = Math.min(residual_capacity, residual_network[u][v]);
                u = v;
            }
            // increment max flow
            max_flow += residual_capacity;
            u = 0;
            // update residual network
            for (int v : path) {
                residual_network[u][v] -= residual_capacity;
                residual_network[v][u] += residual_capacity;
                u = v;
            }
        }
        return max_flow;
    }

    public static int solution(int[] entrances, int[] exits, int[][] path) {
        return solveWithFordFulkerson(transform(entrances, exits, path));
    }
}
```                                                                                                                                                          
### Dinic's Algorithm
From further research, a more efficient algorithm - Dinic's algorithm selected.

##### Theory
- https://en.wikipedia.org/wiki/Dinic%27s_algorithm
- https://www.youtube.com/watch?v=M6cm8UeeziI&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=42
- https://github.com/ADJA/algos/blob/master/Graphs/Dinic.cpp
- https://www.geeksforgeeks.org/dinics-algorithm-maximum-flow
- https://www.hackerearth.com/practice/algorithms/graphs/maximum-flow/tutorial
- https://www.geeksforgeeks.org/dinics-algorithm-maximum-flow
- https://surajshetiya.github.io/Google-foobar/#round-4
- https://github.com/nkapliev/google-foo.bar/blob/master/problems/4.2_escape_pods.py
- http://www.cs.ust.hk/mjg_lib/Classes/COMP572_Fall07/Notes/index.htm

##### Example Implementation
```java
/**
 * Implementation of Dinic's network flow algorithm. The algorithm works by first constructing a
 * level graph using a BFS and then finding augmenting paths on the level graph using multiple DFSs.
 *
 * <p>Time Complexity: O(EV²)
 *
 * <p>Download the code: $ git clone https://github.com/williamfiset/Algorithms
 *
 * <p>Change directory to the root of the Algorithms directory: $ cd Algorithms
 *
 * <p>Build: $ javac -d src/main/java
 * src/main/java/com/williamfiset/algorithms/graphtheory/networkflow/examples/DinicsExample.java
 *
 * <p>Run: $ java -cp src/main/java
 * com/williamfiset/algorithms/graphtheory/networkflow/examples/DinicsExample
 */
package com.williamfiset.algorithms.graphtheory.networkflow.examples;

import static java.lang.Math.min;

import java.util.*;

public class DinicsExample {

  private static class Edge {
    public int from, to;
    public Edge residual;
    public long flow;
    public final long capacity;

    public Edge(int from, int to, long capacity) {
      this.from = from;
      this.to = to;
      this.capacity = capacity;
    }

    public boolean isResidual() {
      return capacity == 0;
    }

    public long remainingCapacity() {
      return capacity - flow;
    }

    public void augment(long bottleNeck) {
      flow += bottleNeck;
      residual.flow -= bottleNeck;
    }

    public String toString(int s, int t) {
      String u = (from == s) ? "s" : ((from == t) ? "t" : String.valueOf(from));
      String v = (to == s) ? "s" : ((to == t) ? "t" : String.valueOf(to));
      return String.format(
          "Edge %s -> %s | flow = %3d | capacity = %3d | is residual: %s",
          u, v, flow, capacity, isResidual());
    }
  }

  private abstract static class NetworkFlowSolverBase {

    // To avoid overflow, set infinity to a value less than Long.MAX_VALUE;
    static final long INF = Long.MAX_VALUE / 2;

    // Inputs: n = number of nodes, s = source, t = sink
    final int n, s, t;

    // Indicates whether the network flow algorithm has ran. The solver only
    // needs to run once because it always yields the same result.
    protected boolean solved;

    // The maximum flow. Calculated by calling the {@link #solve} method.
    protected long maxFlow;

    // The adjacency list representing the flow graph.
    protected List<Edge>[] graph;

    /**
     * Creates an instance of a flow network solver. Use the {@link #addEdge} method to add edges to
     * the graph.
     *
     * @param n - The number of nodes in the graph including s and t.
     * @param s - The index of the source node, 0 <= s < n
     * @param t - The index of the sink node, 0 <= t < n and t != s
     */
    public NetworkFlowSolverBase(int n, int s, int t) {
      this.n = n;
      this.s = s;
      this.t = t;
      initializeEmptyFlowGraph();
    }

    // Constructs an empty graph with n nodes including s and t.
    @SuppressWarnings("unchecked")
    private void initializeEmptyFlowGraph() {
      graph = new List[n];
      for (int i = 0; i < n; i++) graph[i] = new ArrayList<Edge>();
    }

    /**
     * Adds a directed edge (and its residual edge) to the flow graph.
     *
     * @param from - The index of the node the directed edge starts at.
     * @param to - The index of the node the directed edge ends at.
     * @param capacity - The capacity of the edge
     */
    public void addEdge(int from, int to, long capacity) {
      if (capacity <= 0) throw new IllegalArgumentException("Forward edge capacity <= 0");
      Edge e1 = new Edge(from, to, capacity);
      Edge e2 = new Edge(to, from, 0);
      e1.residual = e2;
      e2.residual = e1;
      graph[from].add(e1);
      graph[to].add(e2);
    }

    /**
     * Returns the residual graph after the solver has been executed. This allows you to inspect the
     * {@link Edge#flow} and {@link Edge#capacity} values of each edge. This is useful if you are
     * debugging or want to figure out which edges were used during the max flow.
     */
    public List<Edge>[] getGraph() {
      execute();
      return graph;
    }

    // Returns the maximum flow from the source to the sink.
    public long getMaxFlow() {
      execute();
      return maxFlow;
    }

    // Wrapper method that ensures we only call solve() once
    private void execute() {
      if (solved) return;
      solved = true;
      solve();
    }

    // Method to implement which solves the network flow problem.
    public abstract void solve();
  }

  private static class DinicsSolver extends NetworkFlowSolverBase {

    private int[] level;

    /**
     * Creates an instance of a flow network solver. Use the {@link #addEdge} method to add edges to
     * the graph.
     *
     * @param n - The number of nodes in the graph including source and sink nodes.
     * @param s - The index of the source node, 0 <= s < n
     * @param t - The index of the sink node, 0 <= t < n, t != s
     */
    public DinicsSolver(int n, int s, int t) {
      super(n, s, t);
      level = new int[n];
    }

    @Override
    public void solve() {
      // next[i] indicates the next edge index to take in the adjacency list for node i. This is
      // part
      // of the Shimon Even and Alon Itai optimization of pruning deads ends as part of the DFS
      // phase.
      int[] next = new int[n];

      while (bfs()) {
        Arrays.fill(next, 0);
        // Find max flow by adding all augmenting path flows.
        for (long f = dfs(s, next, INF); f != 0; f = dfs(s, next, INF)) {
          maxFlow += f;
        }
      }
    }

    // Do a BFS from source to sink and compute the depth/level of each node
    // which is the minimum number of edges from that node to the source.
    private boolean bfs() {
      Arrays.fill(level, -1);
      Deque<Integer> q = new ArrayDeque<>(n);
      q.offer(s);
      level[s] = 0;
      while (!q.isEmpty()) {
        int node = q.poll();
        for (Edge edge : graph[node]) {
          long cap = edge.remainingCapacity();
          if (cap > 0 && level[edge.to] == -1) {
            level[edge.to] = level[node] + 1;
            q.offer(edge.to);
          }
        }
      }
      // Return whether we were able to reach the sink node.
      return level[t] != -1;
    }

    private long dfs(int at, int[] next, long flow) {
      if (at == t) return flow;
      final int numEdges = graph[at].size();

      for (; next[at] < numEdges; next[at]++) {
        Edge edge = graph[at].get(next[at]);
        long cap = edge.remainingCapacity();
        if (cap > 0 && level[edge.to] == level[at] + 1) {

          long bottleNeck = dfs(edge.to, next, min(flow, cap));
          if (bottleNeck > 0) {
            edge.augment(bottleNeck);
            return bottleNeck;
          }
        }
      }
      return 0;
    }
  }

  public static void main(String[] args) {
    int n = 11;
    int s = n - 1;
    int t = n - 2;

    NetworkFlowSolverBase solver;
    solver = new DinicsSolver(n, s, t);

    // Source edges
    solver.addEdge(s, 0, 5);
    solver.addEdge(s, 1, 10);
    solver.addEdge(s, 2, 15);

    // Middle edges
    solver.addEdge(0, 3, 10);
    solver.addEdge(1, 0, 15);
    solver.addEdge(1, 4, 20);
    solver.addEdge(2, 5, 25);
    solver.addEdge(3, 4, 25);
    solver.addEdge(3, 6, 10);
    solver.addEdge(4, 2, 5);
    solver.addEdge(4, 7, 30);
    solver.addEdge(5, 7, 20);
    solver.addEdge(5, 8, 10);
    solver.addEdge(7, 8, 15);

    // Sink edges
    solver.addEdge(6, t, 5);
    solver.addEdge(7, t, 15);
    solver.addEdge(8, t, 10);

    // Prints: "Maximum flow: 30"
    System.out.printf("Maximum flow: %d\n", solver.getMaxFlow());
  }
}

```

The pain point then was to use understand the algorithm to make it usable.
The problem was to convert the adjacent graph into a graph with weighted
edges. The first solution did not do that and the concept of extra source
and sink nodes did not exits. Hence, to realize how to map the ends to 
those end required more analysis.
Then, from going through the videos again and reviewing, it made more sense.
The source and sink could be any indexes as along as entrances were directed 
from source and sink from the exits.
Another realization that was made was that the adjacent matrix with value 0
did not need to be converted into an edge. Only those with some value greater
than 0 was transformed as edges of the graph.

The implementation was slightly modified as my implementation.

### Search For Better Algorithm