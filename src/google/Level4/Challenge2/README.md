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
### First Example
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
- [Network Flow Algorithms Starting Here](https://www.youtube.com/watch?v=LdOnanfc5TM&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=33&t=3s)
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

Functional example:

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

### Understanding Dinic's
- https://en.wikipedia.org/wiki/Dinic%27s_algorithm
- https://www.youtube.com/watch?v=M6cm8UeeziI&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=42
- https://github.com/ADJA/algos/blob/master/Graphs/Dinic.cpp
- https://www.geeksforgeeks.org/dinics-algorithm-maximum-flow
- https://www.hackerearth.com/practice/algorithms/graphs/maximum-flow/tutorial
- https://www.geeksforgeeks.org/dinics-algorithm-maximum-flow
- https://surajshetiya.github.io/Google-foobar/#round-4
- https://github.com/nkapliev/google-foo.bar/blob/master/problems/4.2_escape_pods.py
- http://www.cs.ust.hk/mjg_lib/Classes/COMP572_Fall07/Notes/index.htm



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
- [ ] https://vitaminac.github.io/Simple-Bootstrap-Linux-System/
- [ ] https://hbr.org/2018/01/why-people-really-quit-their-jobs
- [ ] https://play.picoctf.org/practice?category=6&page=1
- [ ] https://architectelevator.com/architecture/famous-architects-sketch/
- [ ] https://github.com/topjohnwu/Magisk
- [ ] https://www.8bitmen.com/youtube-database-how-does-it-store-so-many-videos-without-running-out-of-storage-space/
- [ ] https://github.com/facebook/zstd
- [ ] https://github.com/topjohnwu/Magisk
- [ ] https://tolisec.com/ssh-backdoor-botnet-with-research-infection-technique
- [ ] https://www.infoq.com/articles/whats-the-next-step-for-data-management
- [ ] https://opensource.com/
- [ ] https://secret.club/2021/01/14/vbox-escape.html
- [ ] https://www.linuxjournal.com/
- [ ] https://www.weave.works/blog/the-gitops-pipeline
- [ ] https://github.com/kubermatic/
- [ ] https://github.com/open-telemetry/opentelemetry-go/contribute
- [ ] https://github.com/SaturnsVoid/GoBot2
- [ ] https://architectelevator.com/architecture/failure-doesnt-respect-abstraction/
- [ ] Fast polynomial multiplication for programming contests (Java) https://www.davideisenstat.com/simplertimes
- [ ] https://graphics.stanford.edu/~seander/bithacks.html | https://github.com/gibsjose/BitHacks
- [ ] https://www.cs.cmu.edu/~15451-f18/lectures Download
- [ ] https://www.vice.com/en/article/n7vqew/the-hacker-who-archived-parler-explains-how-she-did-it-and-what-comes-next
- [ ] https://github.com/d0nk/parler-tricks
- [ ] https://gist.github.com/Parler-Analysis/2c023fd2e053fba5bc85b09209f606eb

