# Graphs — Advanced (Topo Sort · Union-Find · Shortest Path · MST)

## 1. Topological Sort
**Use:** course schedule, build order, DAG ordering.

### Kahn (BFS, in-degree)
```java
int[] indeg = new int[n];
for (int[] e : edges) indeg[e[1]]++;
Deque<Integer> q = new ArrayDeque<>();
for (int i = 0; i < n; i++) if (indeg[i] == 0) q.offer(i);
List<Integer> order = new ArrayList<>();
while (!q.isEmpty()) {
    int u = q.poll(); order.add(u);
    for (int v : adj.get(u)) if (--indeg[v] == 0) q.offer(v);
}
if (order.size() < n) /* cycle */;
```

## 2. Union-Find (Disjoint Set Union)
```java
class DSU {
    int[] p, r;
    DSU(int n) { p = new int[n]; r = new int[n]; for (int i=0;i<n;i++) p[i]=i; }
    int find(int x) { return p[x]==x ? x : (p[x] = find(p[x])); }
    boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (r[ra] < r[rb]) { int t=ra; ra=rb; rb=t; }
        p[rb] = ra;
        if (r[ra] == r[rb]) r[ra]++;
        return true;
    }
}
```

## 3. Dijkstra (single-source shortest path, weights ≥ 0)
```java
int[] dist = new int[n]; Arrays.fill(dist, Integer.MAX_VALUE);
dist[src] = 0;
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
pq.offer(new int[]{src, 0});
while (!pq.isEmpty()) {
    int[] cur = pq.poll();
    int u = cur[0], d = cur[1];
    if (d > dist[u]) continue;
    for (int[] nb : graph[u]) {
        int v = nb[0], w = nb[1];
        if (d + w < dist[v]) { dist[v] = d + w; pq.offer(new int[]{v, dist[v]}); }
    }
}
```

## 4. Bellman-Ford (handles negative edges)
```java
Arrays.fill(dist, Integer.MAX_VALUE); dist[src] = 0;
for (int i = 0; i < n - 1; i++)
    for (int[] e : edges)
        if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]])
            dist[e[1]] = dist[e[0]] + e[2];
```

## 5. Floyd-Warshall (all-pairs, n ≤ 400)
```java
for (int k = 0; k < n; k++)
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (d[i][k] + d[k][j] < d[i][j]) d[i][j] = d[i][k] + d[k][j];
```

## 6. MST — Kruskal (DSU + sort edges)
```java
Arrays.sort(edges, (a,b) -> a[2] - b[2]);
DSU dsu = new DSU(n);
int cost = 0;
for (int[] e : edges)
    if (dsu.union(e[0], e[1])) cost += e[2];
```

## 7. Tarjan / Bridges & SCC — rarely asked but used in #1192.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 547 |[Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | [ ] |
| 997 |[Find Town Judge](https://leetcode.com/problems/find-the-town-judge/) | [ ] |
| 1971 |[Find Path in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/) | [ ] |
| 1319 |[Connecting Network Min Ops](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) | [ ] |
| 2316 |[Count Unreachable Pairs](https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/) | [ ] |
| 2492 |[Min Score Path](https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/) | [ ] |
| 2685 |[Count Complete Components](https://leetcode.com/problems/count-the-number-of-complete-components/) | [ ] |
| 1791 |[Find Center of Star Graph](https://leetcode.com/problems/find-center-of-star-graph/) | [ ] |
| 1267 |[Count Servers That Communicate](https://leetcode.com/problems/count-servers-that-communicate/) | [ ] |
| 1101 |[Earliest Moment Everyone Knew](https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/) | [ ] |
| 1102 |[Path With Max Min Value](https://leetcode.com/problems/path-with-maximum-minimum-value/) | [ ] |
| 990 |[Equations Possible](https://leetcode.com/problems/satisfiability-of-equality-equations/) | [ ] |
| 2424 |[Longest Uploaded Prefix](https://leetcode.com/problems/longest-uploaded-prefix/) | [ ] |
| 1466 |[Reorder Routes](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/) | [ ] |
| 1971 | (dup) — Path Exists | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 207 |[Course Schedule](https://leetcode.com/problems/course-schedule/) | [ ] |
| 210 |[Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | [ ] |
| 261 |[Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/) | [ ] |
| 310 |[Min Height Trees](https://leetcode.com/problems/minimum-height-trees/) | [ ] |
| 323 |[Connected Components Undirected](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) | [ ] |
| 399 |[Evaluate Division](https://leetcode.com/problems/evaluate-division/) | [ ] |
| 547 |[Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | [ ] |
| 684 |[Redundant Connection](https://leetcode.com/problems/redundant-connection/) | [ ] |
| 721 |[Accounts Merge](https://leetcode.com/problems/accounts-merge/) | [ ] |
| 743 |[Network Delay Time](https://leetcode.com/problems/network-delay-time/) | [ ] |
| 787 |[Cheapest Flights K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | [ ] |
| 802 |[Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/) | [ ] |
| 1091 |[Shortest Path Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | [ ] |
| 1584 |[Min Cost Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | [ ] |
| 1631 |[Path With Min Effort](https://leetcode.com/problems/path-with-minimum-effort/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 269 |[Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) | [ ] |
| 305 |[Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/) | [ ] |
| 332 |[Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/) | [ ] |
| 685 |[Redundant Connection II](https://leetcode.com/problems/redundant-connection-ii/) | [ ] |
| 765 |[Couples Holding Hands](https://leetcode.com/problems/couples-holding-hands/) | [ ] |
| 778 |[Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | [ ] |
| 815 |[Bus Routes](https://leetcode.com/problems/bus-routes/) | [ ] |
| 847 |[Shortest Path Visiting All Nodes](https://leetcode.com/problems/shortest-path-visiting-all-nodes/) | [ ] |
| 864 |[Shortest Path Get All Keys](https://leetcode.com/problems/shortest-path-to-get-all-keys/) | [ ] |
| 924 |[Min Malware Spread](https://leetcode.com/problems/minimize-malware-spread/) | [ ] |
| 1192 |[Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/) | [ ] |
| 1489 |[Find Critical and Pseudo-Critical Edges in MST](https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/) | [ ] |
| 1697 |[Checking Existence of Edge Length Limited Paths](https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/) | [ ] |
| 1928 |[Min Cost to Reach Destination in Time](https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/) | [ ] |
| 928 |[Min Malware Spread II](https://leetcode.com/problems/minimize-malware-spread-ii/) | [ ] |

