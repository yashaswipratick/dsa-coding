# Pattern: K-way Merge

## Signal phrases
- "Merge K sorted lists / arrays"
- "Smallest range covering K lists"
- "Kth smallest in N sorted lists"

## Template

```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
for (int i = 0; i < k; i++)
    if (lists[i].length > 0) pq.offer(new int[]{lists[i][0], i, 0});

while (!pq.isEmpty()) {
    int[] cur = pq.poll();
    int val = cur[0], li = cur[1], idx = cur[2];
    result.add(val);
    if (idx + 1 < lists[li].length)
        pq.offer(new int[]{lists[li][idx+1], li, idx+1});
}
```

## Problems

| # | Problem | Done |
|---|---|---|
| 23 |[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [ ] |
| 373 |[Find K Pairs with Smallest Sums](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/) | [ ] |
| 378 |[Kth Smallest in Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) | [ ] |
| 632 |[Smallest Range Covering K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | [ ] |
| 264 |[Ugly Number II](https://leetcode.com/problems/ugly-number-ii/) | [ ] |
| 313 |[Super Ugly Number](https://leetcode.com/problems/super-ugly-number/) | [ ] |
| 786 |[Kth Smallest Prime Fraction](https://leetcode.com/problems/k-th-smallest-prime-fraction/) | [ ] |
