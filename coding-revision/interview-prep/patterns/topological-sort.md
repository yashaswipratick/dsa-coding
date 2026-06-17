# Pattern: Topological Sort

## Signal phrases
- "Course prerequisites"
- "Build order / task order"
- "Alien dictionary"
- "Detect cycle in directed graph"

## Kahn's algorithm (BFS, in-degree)

```java
int[] indeg = new int[n];
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
for (int[] e : edges) { adj.get(e[0]).add(e[1]); indeg[e[1]]++; }

Deque<Integer> q = new ArrayDeque<>();
for (int i = 0; i < n; i++) if (indeg[i] == 0) q.offer(i);

List<Integer> order = new ArrayList<>();
while (!q.isEmpty()) {
    int u = q.poll(); order.add(u);
    for (int v : adj.get(u)) if (--indeg[v] == 0) q.offer(v);
}
if (order.size() < n) return null;   // cycle
```

## DFS (post-order reverse) alternative
Use 3 colors (white/gray/black). Cycle if you re-enter a gray node.

## Problems

| # | Problem | Done |
|---|---|---|
| 207 |[Course Schedule](https://leetcode.com/problems/course-schedule/) | [ ] |
| 210 |[Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | [ ] |
| 269 |[Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) | [ ] |
| 310 |[Min Height Trees](https://leetcode.com/problems/minimum-height-trees/) | [ ] |
| 444 |[Sequence Reconstruction](https://leetcode.com/problems/sequence-reconstruction/) | [ ] |
| 1136 |[Parallel Courses](https://leetcode.com/problems/parallel-courses/) | [ ] |
| 1494 |[Parallel Courses II](https://leetcode.com/problems/parallel-courses-ii/) | [ ] |
| 1857 |[Largest Color Value in DAG](https://leetcode.com/problems/largest-color-value-in-a-directed-graph/) | [ ] |
| 2050 |[Parallel Courses III](https://leetcode.com/problems/parallel-courses-iii/) | [ ] |
| 2392 |[Build a Matrix With Conditions](https://leetcode.com/problems/build-a-matrix-with-conditions/) | [ ] |
