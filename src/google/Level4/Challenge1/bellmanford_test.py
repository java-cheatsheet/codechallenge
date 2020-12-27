# https://www.techiedelight.com/determine-negative-weight-cycle-graph/

# define infinity as maximum value of the integer
INF = float('inf')
 
 
# Function to run Bellman-Ford algorithm from given source
def BellmanFord(edges, source, time):
 
    # cost stores shortest-path information
    cost = [time] * N
 
    # Initially all vertices except source vertex have a weight of infinity
    cost[source] = 0
 
    # Relaxation step (run V-1 times)
    for _ in range(N-1):
        # consider all edges from u to v having weight w
        for (u, v, w) in edges:
            # if the cost to the destination u can be
            # shortened by taking the edge u -> v
            if cost[u] != time and cost[u] + w < cost[v]:
                # update cost to the lower value
                cost[v] = cost[u] + w
 
    # Run relaxation step once more for N'th time to
    # check for negative-weight cycles
    for (u, v, w) in edges:
        # if the cost to the destination u can be
        # shortened by taking the edge u -> v
        if cost[u] != time and cost[u] + w < cost[v]:
            return True
 
    return False

# returns a List of graph edges 
def MakeEdge(adjMatrix):
    edges = []
    for v in range(N):
        for u in range(N):
            if adjMatrix[v][u] and adjMatrix[v][u] != time:
                # edge from source v to dest u having specified weight
                edges.append((v, u, adjMatrix[v][u]))

    return edges


if __name__ == '__main__':
 
    # given adjacency representation of matrix
    # adjMatrix = [
    #     [0, INF, -2, INF],
    #     [4, 0, -3, INF],
    #     [INF, INF, 0, 2],
    #     [INF, -1, INF, 0]
    # ]
    
    # adjMatrix = [
    #     [0, 2, 2, 2, -1],
    #     [9, 0, 2, 2, -1],
    #     [9, 3, 0, 2, -1],
    #     [9, 3, 2, 0, -1],
    #     [9, 3, 2, 2, 0]
    # ]
    # # N is number of vertices in the graph
    # N = 5
    # time = 1

    adjMatrix = [
        [0, 1, 1, 1, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 0, 1, 1],
        [1, 1, 1, 0, 1],
        [1, 1, 1, 1, 0]
        ]
    N = 5
    time = 3

    # # Negative Weight Cycle
    # adjMatrix = [
    #       [0, 3, 1, 8, INF],
    #       [2, 0, 9, 4, INF],
    #       [-5, INF, 0, INF, -2],
    #       [INF, INF, 1, 0, INF],
    #       [INF, INF, INF, 0, 0]
    # ]
    # N = 5
    # time = 10


    
    edges =  MakeEdge(adjMatrix)

    # run Bellman-Ford algorithm from each vertex as source
    # and check for any Negative Weight Cycle
    for i in range(N):
        if BellmanFord(edges, i, time):
            print("Negative Weight Cycle Found!!")
            break

