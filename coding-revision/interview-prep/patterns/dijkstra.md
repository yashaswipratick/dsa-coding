# Pattern: Dijkstra's Shortest Path

## When to use
- Weighted graph
- **All weights ≥ 0**
- Single-source shortest path

## Template (min-heap)

```java
int[] dist = new int[n];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[src] = 0;
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
pq.offer(new int[]{src, 0});
while (!pq.isEmpty()) {
    int[] c = pq.poll();
    int u = c[0], d = c[1];
    if (d > dist[u]) continue;
    for (int[] nb : graph[u]) {
        int v = nb[0], w = nb[1];
        if (d + w < dist[v]) {
            dist[v] = d + w;
            pq.offer(new int[]{v, dist[v]});
        }
    }
}
```

Complexity: O((V+E) log V).

## Problems

| # | Problem | Done |
|---|---|---|
| 743 |[Network Delay Time](https://leetcode.com/problems/network-delay-time/) | [ ] |
| 787 |[Cheapest Flights K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | [ ] |
| 778 |[Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | [ ] |
| 1631 |[Path With Min Effort](https://leetcode.com/problems/path-with-minimum-effort/) | [ ] |
| 1976 |[Number of Ways to Arrive at Destination](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/) | [ ] |
| 2045 |[Second Min Time to Reach Destination](https://leetcode.com/problems/second-minimum-time-to-reach-destination/) | [ ] |
| 1928 |[Min Cost Reach Destination in Time](https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/) | [ ] |
| 882 |[Reachable Nodes in Subdivided Graph](https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/) | [ ] |

## If negative weights:
- **Bellman-Ford** O(V·E)
- Detect negative cycle if any distance still decreases on V-th iteration.
