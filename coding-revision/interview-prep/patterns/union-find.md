# Pattern: Union-Find (Disjoint Set Union)

## Signal phrases
- "Connected components"
- "Redundant connection"
- "Accounts merge"
- "Number of islands II" (dynamic)
- "Equations possible"

## Template

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

With path compression + union by rank: ~O(α(n)) ≈ O(1) per op.

## Problems

| # | Problem | Done |
|---|---|---|
| 200 |[Number of Islands](https://leetcode.com/problems/number-of-islands/) | [ ] |
| 305 |[Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/) | [ ] |
| 547 |[Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | [ ] |
| 684 |[Redundant Connection](https://leetcode.com/problems/redundant-connection/) | [ ] |
| 685 |[Redundant Connection II](https://leetcode.com/problems/redundant-connection-ii/) | [ ] |
| 721 |[Accounts Merge](https://leetcode.com/problems/accounts-merge/) | [ ] |
| 765 |[Couples Holding Hands](https://leetcode.com/problems/couples-holding-hands/) | [ ] |
| 952 |[Largest Component by Common Factor](https://leetcode.com/problems/largest-component-size-by-common-factor/) | [ ] |
| 990 |[Equations Possible](https://leetcode.com/problems/satisfiability-of-equality-equations/) | [ ] |
| 1319 |[Connecting Network Min Ops](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) | [ ] |
| 1584 |[Min Cost Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | [ ] |
| 1697 |[Edge Length Limited Paths](https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/) | [ ] |
