# Pattern: Two Heaps

## Signal phrases
- "Median in a stream"
- "Maintain two halves" (lower / upper)
- "Sliding window median"
- "Schedule with two priorities" (IPO)

## Idea
- **Max-heap** stores the smaller half.
- **Min-heap** stores the larger half.
- Median = top(s) when sizes differ by ≤ 1.

## Template

```java
PriorityQueue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
PriorityQueue<Integer> hi = new PriorityQueue<>();

void add(int x) {
    lo.offer(x); hi.offer(lo.poll());        // balance content
    if (hi.size() > lo.size()) lo.offer(hi.poll());  // balance sizes
}

double median() {
    return lo.size() > hi.size() ? lo.peek()
            : (lo.peek() + hi.peek()) / 2.0;
}
```

## Problems

| # | Problem | Done |
|---|---|---|
| 295 |[Find Median Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | [ ] |
| 480 |[Sliding Window Median](https://leetcode.com/problems/sliding-window-median/) | [ ] |
| 502 |[IPO](https://leetcode.com/problems/ipo/) | [ ] |
| 1825 |[Finding MK Average](https://leetcode.com/problems/finding-mk-average/) | [ ] |
| 1383 |[Max Performance of a Team](https://leetcode.com/problems/maximum-performance-of-a-team/) | [ ] |
| 1985 |[Find Kth Largest Integer](https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/) | [ ] |
