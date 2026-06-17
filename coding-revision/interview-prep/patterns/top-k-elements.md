# Pattern: Top-K (Heap)

## Signal phrases
- "Top K largest / smallest / frequent"
- "Kth element"
- "K closest"

## Trick
- **Top K largest** → maintain **min-heap** of size K, push and pop excess.
- **Top K smallest** → **max-heap** of size K.

## Template

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();   // min-heap
for (int x : a) {
    pq.offer(x);
    if (pq.size() > k) pq.poll();
}
// pq now contains K largest, top is K-th largest
```

## Quickselect alternative — O(n) avg

```java
int qs(int[] a, int lo, int hi, int k) {
    int p = partition(a, lo, hi);
    if (p == k) return a[p];
    return p < k ? qs(a, p+1, hi, k) : qs(a, lo, p-1, k);
}
```

## Problems

| # | Problem | Done |
|---|---|---|
| 215 |[Kth Largest in Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | [ ] |
| 347 |[Top K Frequent](https://leetcode.com/problems/top-k-frequent-elements/) | [ ] |
| 692 |[Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | [ ] |
| 973 |[K Closest Points](https://leetcode.com/problems/k-closest-points-to-origin/) | [ ] |
| 658 |[Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/) | [ ] |
| 703 |[Kth Largest in Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | [ ] |
| 451 |[Sort Chars by Frequency](https://leetcode.com/problems/sort-characters-by-frequency/) | [ ] |
| 1985 |[Find Kth Largest Integer](https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/) | [ ] |

Full list in **topics/heaps-priority-queue.md**.
