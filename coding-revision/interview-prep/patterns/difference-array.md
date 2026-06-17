# Pattern: Difference Array

## Signal phrases
- "Range update + point query"
- "Apply many `[l, r] += v` updates, then read array"
- "Flight bookings", "car pooling"

## Idea
`diff[l] += v; diff[r+1] -= v;` then prefix-sum → final array.

## Template

```java
int[] diff = new int[n + 1];
for (int[] op : ops) {
    diff[op[0]] += op[2];
    diff[op[1] + 1] -= op[2];
}
int[] a = new int[n];
a[0] = diff[0];
for (int i = 1; i < n; i++) a[i] = a[i-1] + diff[i];
```

## Problems

| # | Problem | Done |
|---|---|---|
| 1109 |[Corporate Flight Bookings](https://leetcode.com/problems/corporate-flight-bookings/) | [ ] |
| 1094 |[Car Pooling](https://leetcode.com/problems/car-pooling/) | [ ] |
| 370 |[Range Addition](https://leetcode.com/problems/range-addition/) | [ ] |
| 598 |[Range Addition II](https://leetcode.com/problems/range-addition-ii/) | [ ] |
| 1893 |[Check If All Integers Covered](https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/) | [ ] |
| 2381 |[Shifting Letters II](https://leetcode.com/problems/shifting-letters-ii/) | [ ] |
| 2406 |[Divide Intervals Into Min Groups](https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/) | [ ] |
| 2536 |[Increment Submatrices by One](https://leetcode.com/problems/increment-submatrices-by-one/) | [ ] |

## When to upgrade
- Need **range update + range query** → **Segment Tree with lazy propagation** or **Fenwick (BIT)**.
