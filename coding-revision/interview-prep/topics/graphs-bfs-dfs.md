# Graphs — BFS & DFS

## Representations
```java
// Adjacency list (most common)
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }

// With weights
List<int[]>[] g = new List[n];   // each entry: {nbr, weight}
```

## DFS template
```java
boolean[] vis = new boolean[n];
void dfs(int u) {
    vis[u] = true;
    for (int v : adj.get(u)) if (!vis[v]) dfs(v);
}
```

## BFS template
```java
Deque<Integer> q = new ArrayDeque<>();
boolean[] vis = new boolean[n];
q.offer(src); vis[src] = true;
int level = 0;
while (!q.isEmpty()) {
    int sz = q.size();
    for (int i = 0; i < sz; i++) {
        int u = q.poll();
        // process u, dist = level
        for (int v : adj.get(u)) if (!vis[v]) { vis[v]=true; q.offer(v); }
    }
    level++;
}
```

## Sub-patterns
1. Connected components count
2. Shortest path in unweighted graph (BFS)
3. All paths (DFS with backtracking)
4. Cycle detection (white/gray/black colors)
5. Bipartite check (2-coloring with BFS)
6. Multi-source BFS (start all sources at level 0)
7. Implicit graph (word ladder, state space)

## Pitfalls
- Forget to mark visited BEFORE recursing → exponential blow-up.
- Directed vs undirected — only add reverse edge if undirected.
- Recursion depth on large graphs → switch to iterative DFS.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 463 |[Island Perimeter](https://leetcode.com/problems/island-perimeter/) | [ ] |
| 733 |[Flood Fill](https://leetcode.com/problems/flood-fill/) | [ ] |
| 997 |[Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/) | [ ] |
| 1971 |[Find Path in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/) | [ ] |
| 2316 |[Count Unreachable Pairs of Nodes](https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/) | [ ] |
| 2924 |[Find Champion II](https://leetcode.com/problems/find-champion-ii/) | [ ] |
| 2492 |[Min Score of Path Between Two Cities](https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/) | [ ] |
| 2685 |[Count Complete Components](https://leetcode.com/problems/count-the-number-of-complete-components/) | [ ] |
| 1791 |[Find Center of Star Graph](https://leetcode.com/problems/find-center-of-star-graph/) | [ ] |
| 1267 |[Count Servers That Communicate](https://leetcode.com/problems/count-servers-that-communicate/) | [ ] |
| 690 |[Employee Importance](https://leetcode.com/problems/employee-importance/) | [ ] |
| 559 |[Max Depth N-ary](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/) | [ ] |
| 589 |[N-ary Preorder](https://leetcode.com/problems/n-ary-tree-preorder-traversal/) | [ ] |
| 590 |[N-ary Postorder](https://leetcode.com/problems/n-ary-tree-postorder-traversal/) | [ ] |
| 1971 | (dup) Path Exists | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 102 |[Level Order](https://leetcode.com/problems/binary-tree-level-order-traversal/) | [ ] |
| 127 |[Word Ladder](https://leetcode.com/problems/word-ladder/) | [ ] |
| 130 |[Surrounded Regions](https://leetcode.com/problems/surrounded-regions/) | [ ] |
| 133 |[Clone Graph](https://leetcode.com/problems/clone-graph/) | [ ] |
| 200 |[Number of Islands](https://leetcode.com/problems/number-of-islands/) | [ ] |
| 207 |[Course Schedule](https://leetcode.com/problems/course-schedule/) | [ ] |
| 210 |[Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | [ ] |
| 261 |[Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/) | [ ] |
| 286 |[Walls and Gates](https://leetcode.com/problems/walls-and-gates/) | [ ] |
| 417 |[Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) | [ ] |
| 542 |[01 Matrix](https://leetcode.com/problems/01-matrix/) | [ ] |
| 695 |[Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | [ ] |
| 785 |[Is Graph Bipartite](https://leetcode.com/problems/is-graph-bipartite/) | [ ] |
| 994 |[Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | [ ] |
| 1466 |[Reorder Routes](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 126 |[Word Ladder II](https://leetcode.com/problems/word-ladder-ii/) | [ ] |
| 269 |[Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) | [ ] |
| 297 |[Serialize/Deserialize Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [ ] |
| 301 |[Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/) | [ ] |
| 332 |[Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/) | [ ] |
| 489 |[Robot Room Cleaner](https://leetcode.com/problems/robot-room-cleaner/) | [ ] |
| 685 |[Redundant Connection II](https://leetcode.com/problems/redundant-connection-ii/) | [ ] |
| 749 |[Contain Virus](https://leetcode.com/problems/contain-virus/) | [ ] |
| 778 |[Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | [ ] |
| 815 |[Bus Routes](https://leetcode.com/problems/bus-routes/) | [ ] |
| 847 |[Shortest Path Visiting All Nodes](https://leetcode.com/problems/shortest-path-visiting-all-nodes/) | [ ] |
| 864 |[Shortest Path Get All Keys](https://leetcode.com/problems/shortest-path-to-get-all-keys/) | [ ] |
| 924 |[Min Malware Spread](https://leetcode.com/problems/minimize-malware-spread/) | [ ] |
| 928 |[Min Malware Spread II](https://leetcode.com/problems/minimize-malware-spread-ii/) | [ ] |
| 854 |[K-Similar Strings](https://leetcode.com/problems/k-similar-strings/) | [ ] |

