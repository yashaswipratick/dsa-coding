# Binary Search

## When to use
- **Sorted** array → find value or insertion point.
- **Rotated** sorted array → modified BS.
- **Min/max value** with a monotonic `canDo(x)` check → "binary search the answer".
- 2-D sorted matrix.

## Templates

```java
// Classic
int bs(int[] a, int t) {
    int lo = 0, hi = a.length - 1;
    while (lo <= hi) {
        int m = lo + (hi - lo) / 2;
        if (a[m] == t) return m;
        if (a[m] < t) lo = m + 1; else hi = m - 1;
    }
    return -1;
}

// Lower bound (first index >= t)
int lower(int[] a, int t) {
    int lo = 0, hi = a.length;
    while (lo < hi) {
        int m = lo + (hi - lo) / 2;
        if (a[m] < t) lo = m + 1; else hi = m;
    }
    return lo;
}

// Binary search the answer
int minCapacity(int[] weights, int days) {
    int lo = Arrays.stream(weights).max().getAsInt();
    int hi = Arrays.stream(weights).sum();
    while (lo < hi) {
        int m = lo + (hi - lo) / 2;
        if (canShip(weights, days, m)) hi = m; else lo = m + 1;
    }
    return lo;
}
```

## Pitfalls
- `(lo + hi) / 2` may overflow — use `lo + (hi - lo) / 2`.
- Pick **one** template and stick to it. Mixing causes infinite loops.
- For "find leftmost / rightmost", use lower/upper bound forms.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 35 | [Search Insert Position](https://leetcode.com/problems/search-insert-position/) | [ ] |
| 69 | [Sqrt(x)](https://leetcode.com/problems/sqrtx/) | [ ] |
| 70 | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | [ ] |
| 268 | [Missing Number](https://leetcode.com/problems/missing-number/) | [ ] |
| 278 | [First Bad Version](https://leetcode.com/problems/first-bad-version/) | [ ] |
| 367 | [Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/) | [ ] |
| 374 | [Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/) | [ ] |
| 392 | [Is Subsequence](https://leetcode.com/problems/is-subsequence/) | [ ] |
| 441 | [Arranging Coins](https://leetcode.com/problems/arranging-coins/) | [ ] |
| 704 | [Binary Search](https://leetcode.com/problems/binary-search/) | [ ] |
| 744 | [Find Smallest Letter > Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/) | [ ] |
| 852 | [Peak Index Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/) | [ ] |
| 1539 | [Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number/) | [ ] |
| 1608 | [Special Array With X Elements ≥ X](https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/) | [ ] |
| 2089 | [Find Target Indices After Sorting](https://leetcode.com/problems/find-target-indices-after-sorting-array/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | [ ] |
| 34 | [Find First and Last Position](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | [ ] |
| 74 | [Search 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/) | [ ] |
| 81 | [Search Rotated II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) | [ ] |
| 153 | [Find Min Rotated](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | [ ] |
| 162 | [Find Peak Element](https://leetcode.com/problems/find-peak-element/) | [ ] |
| 240 | [Search 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/) | [ ] |
| 275 | [H-Index II](https://leetcode.com/problems/h-index-ii/) | [ ] |
| 287 | [Find Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [ ] |
| 540 | [Single Element Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/) | [ ] |
| 658 | [Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/) | [ ] |
| 875 | [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) | [ ] |
| 1011 | [Capacity to Ship within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | [ ] |
| 1283 | [Smallest Divisor ≤ Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/) | [ ] |
| 1482 | [Min Days to Make m Bouquets](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 4 | [Median Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | [ ] |
| 154 | [Find Min Rotated II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/) | [ ] |
| 174 | [Dungeon Game](https://leetcode.com/problems/dungeon-game/) | [ ] |
| 295 | [Find Median Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | [ ] |
| 302 | [Smallest Rectangle Black Pixels](https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/) | [ ] |
| 354 | [Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/) | [ ] |
| 410 | [Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/) | [ ] |
| 644 | [Max Avg Subarray II](https://leetcode.com/problems/maximum-average-subarray-ii/) | [ ] |
| 668 | [Kth Smallest in Mult Table](https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/) | [ ] |
| 719 | [Find K-th Smallest Pair Distance](https://leetcode.com/problems/find-k-th-smallest-pair-distance/) | [ ] |
| 778 | [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | [ ] |
| 786 | [K-th Smallest Prime Fraction](https://leetcode.com/problems/k-th-smallest-prime-fraction/) | [ ] |
| 878 | [Nth Magical Number](https://leetcode.com/problems/nth-magical-number/) | [ ] |
| 1095 | [Find in Mountain Array](https://leetcode.com/problems/find-in-mountain-array/) | [ ] |
| 1923 | [Longest Common Subpath](https://leetcode.com/problems/longest-common-subpath/) | [ ] |


