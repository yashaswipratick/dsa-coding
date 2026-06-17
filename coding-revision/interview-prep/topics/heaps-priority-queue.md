# Heaps / Priority Queue

## Java
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

// Custom: by 2nd element ascending
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

pq.offer(x); pq.poll(); pq.peek(); pq.size();
```
- `offer/poll`: O(log n)
- `peek`: O(1)

## Sub-patterns
1. **Top-K** — heap of size K (opposite direction)
2. **K-way merge** — push heads of K lists
3. **Two heaps** — running median (max-heap lower half, min-heap upper)
4. **Sweep with events** — meeting rooms II
5. **Greedy scheduling** — task scheduler, reorganize string
6. **Dijkstra** — min-heap of (dist, node)

## Templates

```java
// Kth largest
PriorityQueue<Integer> pq = new PriorityQueue<>();  // min-heap of size k
for (int x : a) {
    pq.offer(x);
    if (pq.size() > k) pq.poll();
}
return pq.peek();

// Two-heap median
PriorityQueue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
PriorityQueue<Integer> hi = new PriorityQueue<>();
void add(int x) {
    lo.offer(x); hi.offer(lo.poll());
    if (hi.size() > lo.size()) lo.offer(hi.poll());
}
double median() {
    return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) / 2.0;
}
```

## Pitfalls
- `PriorityQueue` is min-heap by default.
- `remove(Object)` is O(n). For lazy deletion: keep a `removed` map.
- For `comparator` overflow: use `Integer.compare`.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 703 |[Kth Largest in Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | [ ] |
| 1046 |[Last Stone Weight](https://leetcode.com/problems/last-stone-weight/) | [ ] |
| 1337 |[Weakest Rows in Matrix](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/) | [ ] |
| 1464 |[Max Product Two Elements](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/) | [ ] |
| 1985 |[Find Kth Largest Integer in Array](https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/) | [ ] |
| 506 |[Relative Ranks](https://leetcode.com/problems/relative-ranks/) | [ ] |
| 2208 |[Min Operations to Halve Array Sum](https://leetcode.com/problems/minimum-operations-to-halve-array-sum/) | [ ] |
| 2231 |[Largest Number After Digit Swaps by Parity](https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/) | [ ] |
| 2974 |[Min Number Game](https://leetcode.com/problems/minimum-number-game/) | [ ] |
| 3066 |[Min Operations to Exceed Threshold II](https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/) | [ ] |
| 2558 |[Take Gifts From Richest Pile](https://leetcode.com/problems/take-gifts-from-the-richest-pile/) | [ ] |
| 2099 |[Find Subseq of Length K Largest Sum](https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/) | [ ] |
| 3264 |[Final Array State After K Multiplication](https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/) | [ ] |
| 1962 |[Remove Stones to Min Total](https://leetcode.com/problems/remove-stones-to-minimize-the-total/) | [ ] |
| 1845 |[Seat Reservation Manager](https://leetcode.com/problems/seat-reservation-manager/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 215 |[Kth Largest Element](https://leetcode.com/problems/kth-largest-element-in-an-array/) | [ ] |
| 253 |[Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) | [ ] |
| 264 |[Ugly Number II](https://leetcode.com/problems/ugly-number-ii/) | [ ] |
| 313 |[Super Ugly Number](https://leetcode.com/problems/super-ugly-number/) | [ ] |
| 347 |[Top K Frequent](https://leetcode.com/problems/top-k-frequent-elements/) | [ ] |
| 373 |[Find K Pairs Smallest Sum](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/) | [ ] |
| 378 |[Kth Smallest in Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) | [ ] |
| 451 |[Sort Chars by Frequency](https://leetcode.com/problems/sort-characters-by-frequency/) | [ ] |
| 621 |[Task Scheduler](https://leetcode.com/problems/task-scheduler/) | [ ] |
| 632 |[Smallest Range Covering K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | [ ] |
| 658 |[Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/) | [ ] |
| 692 |[Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | [ ] |
| 767 |[Reorganize String](https://leetcode.com/problems/reorganize-string/) | [ ] |
| 973 |[K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) | [ ] |
| 1642 |[Furthest Building You Can Reach](https://leetcode.com/problems/furthest-building-you-can-reach/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 23 |[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [ ] |
| 218 |[Skyline Problem](https://leetcode.com/problems/the-skyline-problem/) | [ ] |
| 239 |[Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [ ] |
| 295 |[Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | [ ] |
| 358 |[Rearrange String k Distance Apart](https://leetcode.com/problems/rearrange-string-k-distance-apart/) | [ ] |
| 407 |[Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii/) | [ ] |
| 480 |[Sliding Window Median](https://leetcode.com/problems/sliding-window-median/) | [ ] |
| 502 |[IPO](https://leetcode.com/problems/ipo/) | [ ] |
| 630 |[Course Schedule III](https://leetcode.com/problems/course-schedule-iii/) | [ ] |
| 759 |[Employee Free Time](https://leetcode.com/problems/employee-free-time/) | [ ] |
| 778 |[Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | [ ] |
| 871 |[Min Refueling Stops](https://leetcode.com/problems/minimum-number-of-refueling-stops/) | [ ] |
| 786 |[K-th Smallest Prime Fraction](https://leetcode.com/problems/k-th-smallest-prime-fraction/) | [ ] |
| 668 |[Kth Smallest in Multiplication Table](https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/) | [ ] |
| 2402 |[Meeting Rooms III](https://leetcode.com/problems/meeting-rooms-iii/) | [ ] |

