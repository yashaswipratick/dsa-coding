# Pattern: Minimum Spanning Tree

## When to use
- "Connect all nodes with min total cost"
- "Min cost to connect points"

## Kruskal (DSU + sort edges)

```java
Arrays.sort(edges, (a,b) -> a[2] - b[2]);
DSU dsu = new DSU(n);
int cost = 0, used = 0;
for (int[] e : edges) {
    if (dsu.union(e[0], e[1])) { cost += e[2]; used++; }
    if (used == n - 1) break;
}
```

Complexity: O(E log E).

## Prim (heap)

```java
boolean[] inMST = new boolean[n];
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
pq.offer(new int[]{0, 0});
int cost = 0, taken = 0;
while (taken < n) {
    int[] c = pq.poll();
    if (inMST[c[0]]) continue;
    inMST[c[0]] = true; cost += c[1]; taken++;
    for (int[] nb : graph[c[0]]) if (!inMST[nb[0]]) pq.offer(nb);
}
```

## Problems

| # | Problem | Done |
|---|---|---|
| 1135 |[Connecting Cities With Min Cost](https://leetcode.com/problems/connecting-cities-with-minimum-cost/) | [ ] |
| 1168 |[Optimize Water Distribution in a Village](https://leetcode.com/problems/optimize-water-distribution-in-a-village/) | [ ] |
| 1489 |[Find Critical & Pseudo-Critical Edges in MST](https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/) | [ ] |
| 1584 |[Min Cost Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | [ ] |
| 1697 |[Edge Length Limited Paths](https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/) | [ ] |
