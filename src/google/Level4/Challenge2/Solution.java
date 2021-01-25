package google.Level4.Challenge2;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;


public class Solution {

  public static int solution(int[] entrances, int[] exits, int[][] path) {
    NetworkFlowBase solver = new Dinics(entrances, exits, path);
    return solver.getMaxFlow();
  }

  public static void main(String[] args) {

    // Second Example
    //    int[] entrances = new int[]{0};
    //    int[] exits = new int[]{3};
    //    int[][] path = new int[][]{{0, 7, 0, 0}, {0, 0, 6, 0}, {0, 0, 0, 8}, {9, 0, 0, 0}};

    // First Example
    int[] entrances = new int[]{0,1};
    int[] exits = new int[]{4, 5};
    int[][] path = new int[][]{
            {0, 0, 4, 6, 0, 0},
            {0, 0, 5, 2, 0, 0},
            {0, 0, 0, 0, 4, 4},
            {0, 0, 0, 0, 6, 6},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
    };

    //
    System.out.printf("Maximum flow: %d\n", solution(entrances,exits,path));
  }
}


/**
 * Edge - Data structure to represent weighted edges
 * in the network flow graph.
 */
class Edge {
  int from, to;
  Edge residual;
  int flow;
  final int capacity;

  public Edge( int from, int to, int capacity ) {
    this.from = from;
    this.to = to;
    this.capacity = capacity;
  }

  public boolean isResidual() {
    return capacity == 0;
  }

  public int remainingCapacity() {
    return capacity - flow;
  }

  public void augment(int bottleNeck) {
    flow += bottleNeck;
    residual.flow -= bottleNeck;
  }
}


/**
 * NetworkFlowBase - An abstract base class with
 * basic functionalities to find max flow in a graph.
 */
abstract class NetworkFlowBase {

  // Maximum flow that can occur in the edge of the graph.
  protected final int MAX_VAL;

  /**
   * Adjacent matrix of a graph.
   */
  private int[][] path;

  // Adjacent nodes from source and sink, respectively.
  private int[] entrances, exits;

  // n = Number of nodes, s = Source, t = Sink in a graph.
  protected final int n, s, t;

  /**
   * Indicates whether the network flow algorithm has ran.
   * The solver only needs to run once because it always
   * yields the same result.
   */
  protected boolean solved;

  // The maximum flow in the graph.
  protected int maxFlow;

  // Adjacency list representing the flow graph.
  protected List<Edge>[] graph;

  /**
   * Creates an instance of a flow network solver.
   *
   * Use the {@link #addEdge} method to add edges
   * to the graph.
   *
   * @param entrances - The index of the source nodes, 0 <= s < n
   * @param exits - The index of the sink nodes, 0 <= t < n and t != s
   * @param path - The number of nodes in the graph including s and t.
   */
  public NetworkFlowBase( int[] entrances, int[] exits, int[][] path ) {
    MAX_VAL = 20000;

    this.path = path;
    this.entrances =  entrances;
    this.exits = exits;
    int pathLen  = path.length;
    this.n = pathLen + 2;
    this.s = n - 1;
    this.t = n - 2;

    setup();
  }

  // Creates a complete graph from {@link #path}
  private void setup() {
    initializeEmptyFlowGraph();

    // Add edges from source to entrances
    for (int i : entrances) {
      addEdge(s, i, MAX_VAL);
    }

    // Add edges from exists to sink
    for (int j : exits) {
      addEdge(j, t, MAX_VAL);
    }

    int noExitNodes = path.length-exits.length;
    // Add edges with values > 0
    for ( int i = 0; i <= noExitNodes; i++ ) {
      for ( int j = 0; j < n-2; j++ ) {

        // Remove all exit rows as all exit rows
        // contains 0 values
        if ( path[i][j] > 0 ) {
          addEdge(i, j, path[i][j]);
        }
      }
    }
  }

  // Constructs an empty graph with n nodes including s and t.
  @SuppressWarnings("unchecked")
  private void initializeEmptyFlowGraph() {
    graph = new List[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<Edge>();
    }
  }

  /**
   * Adds a directed edge (and its residual edge) to the flow graph.
   *
   * @param from - The index of the node the directed edge starts at.
   * @param to - The index of the node the directed edge ends at.
   * @param capacity - The capacity of the edge
   */
  public void addEdge(int from, int to, int capacity ) {

    if ( capacity <= 0 ) {
      throw new IllegalArgumentException("Forward edge capacity <= 0");
    }

    Edge e1 = new Edge(from, to, capacity);
    Edge e2 = new Edge(to, from, 0);
    e1.residual = e2;
    e2.residual = e1;
    graph[from].add(e1);
    graph[to].add(e2);
  }

  /**
   * Returns the residual graph after the solver has been executed.
   *
   * This allows you to inspect the{@link Edge#flow} and
   * {@link Edge#capacity} values of each edge.
   *
   * This is useful if you are debugging or want to figure
   * out which edges were used during the max flow.
   */
  protected List<Edge>[] getGraph() {
    execute();
    return graph;
  }

  // Returns the maximum flow from the source to the sink.
  public int getMaxFlow() {
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
  protected abstract void solve();
}

/**
 * Dinic's Algorithm implementation.
 *
 * Also implements Shimon Even and Alon Itai optimization.
 *
 * Source: https://www.youtube.com/watch?v=M6cm8UeeziI&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=42
 */
class Dinics extends NetworkFlowBase {

  private int[] level;

  /**
   * Creates an instance of a flow network solver.
   *
   * Use the {@link #addEdge} method to add edges to
   * the graph.
   *
   * @param n - The number of nodes in the graph including
   *         source and sink nodes.
   * @param s - The index of the source node,
   *         0 <= s < n
   * @param t - The index of the sink node,
   *         0 <= t < n, t != s
   */
  public Dinics(int[] entrances, int[] exits, int[][] path) {
    super(entrances, exits, path);
    level = new int[n];
  }

  /**
   * Dinic's implementation.
   */
  @Override
  protected void solve() {

    // This is part of the Shimon Even and Alon Itai
    // optimization of pruning dead-ends as part of
    // the DFS phase.
    // next[i] indicates the next edge index to take in
    // the adjacency list for node i.
    int[] next = new int[n];

    while ( bfs() ) {
      Arrays.fill(next, 0);

      // Find max flow by adding all augmenting path flows.
      int f = dfs( s, next, MAX_VAL );
      while ( f != 0  ) {
        maxFlow += f;
        f = dfs(s, next, MAX_VAL);
      }
    }
  }

  /**
   * Returns whether we were able to reach the sink node.
   *
   * Do a BFS from source to sink and compute the depth/level of each node
   * which is the minimum number of edges from that node to the source.
   *
   * @return boolean true if {@link #t} is reached.
   */
  private boolean bfs() {
    Arrays.fill(level, -1);
    Queue<Integer> q = new ArrayDeque<>(n);
    q.offer(s);
    level[s] = 0;

    while ( !q.isEmpty() ) {
      int node = q.poll();

      for ( Edge edge : graph[node] ) {

        if ( edge.remainingCapacity() > 0
                && level[edge.to] == -1 ) {
          level[edge.to] = level[node] + 1;
          q.offer(edge.to);
        }
      }
    }

    return level[t] != -1;
  }

  /**
   * Depth first search implementation.
   *
   * @param at Source index.
   * @param next 0 filled array.
   * @param flow Bottleneck value in the flow.
   *
   * @return Bottleneck value in the flow.
   */
  private int dfs(int at, int[] next, int flow) {

    if ( at == t ) {
      return flow;
    }

    final int numEdges = graph[at].size();

    while ( next[at] < numEdges ) {
      Edge edge = graph[at].get(next[at]);
      int cap = edge.remainingCapacity();

      if ( cap > 0 && ( level[edge.to] == level[at] + 1 )) {

        int bottleNeck = dfs( edge.to, next, flow > cap ? cap : flow);

        if ( bottleNeck > 0 ) {
          edge.augment(bottleNeck);
          return bottleNeck;
        }
      }
      next[at]++;
    }

    return 0;
  }
}
