# Sorting

## Built-in
| Use | Call | Notes |
|---|---|---|
| Primitive | `Arrays.sort(int[])` | Dual-pivot quicksort, NOT stable |
| Object | `Arrays.sort(T[], cmp)` | TimSort, stable |
| List | `list.sort(cmp)` | Stable |

```java
Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
Integer[] arr = IntStream.of(nums).boxed().toArray(Integer[]::new);
Arrays.sort(arr, Comparator.reverseOrder());
```

## Sub-patterns
1. Sort then sweep (intervals, group anagrams)
2. Custom comparator (largest number, frog jump)
3. Counting / bucket sort (small int range)
4. Quickselect — Kth in O(n) avg
5. Merge sort variants (count inversions, sort list)

## Pitfalls
- `(a,b) -> a-b` overflows. Use `Integer.compare`.
- `Arrays.sort(int[])` is not stable.

## Quickselect
```java
int quickselect(int[] a, int k) {
    int lo = 0, hi = a.length - 1;
    while (true) {
        int p = partition(a, lo, hi);
        if (p == k - 1) return a[p];
        if (p < k - 1) lo = p + 1; else hi = p - 1;
    }
}
```

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 88 |[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) | [ ] |
| 169 |[Majority Element](https://leetcode.com/problems/majority-element/) | [ ] |
| 242 |[Valid Anagram](https://leetcode.com/problems/valid-anagram/) | [ ] |
| 252 |[Meeting Rooms](https://leetcode.com/problems/meeting-rooms/) | [ ] |
| 268 |[Missing Number](https://leetcode.com/problems/missing-number/) | [ ] |
| 350 |[Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | [ ] |
| 414 |[Third Maximum Number](https://leetcode.com/problems/third-maximum-number/) | [ ] |
| 561 |[Array Partition](https://leetcode.com/problems/array-partition/) | [ ] |
| 905 |[Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/) | [ ] |
| 922 |[Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/) | [ ] |
| 944 |[Delete Columns to Make Sorted](https://leetcode.com/problems/delete-columns-to-make-sorted/) | [ ] |
| 1051 |[Height Checker](https://leetcode.com/problems/height-checker/) | [ ] |
| 1122 |[Relative Sort Array](https://leetcode.com/problems/relative-sort-array/) | [ ] |
| 1356 |[Sort Integers by Number of 1 Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/) | [ ] |
| 1859 |[Sorting the Sentence](https://leetcode.com/problems/sorting-the-sentence/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 56 |[Merge Intervals](https://leetcode.com/problems/merge-intervals/) | [ ] |
| 57 |[Insert Interval](https://leetcode.com/problems/insert-interval/) | [ ] |
| 75 |[Sort Colors](https://leetcode.com/problems/sort-colors/) | [ ] |
| 148 |[Sort List](https://leetcode.com/problems/sort-list/) | [ ] |
| 179 |[Largest Number](https://leetcode.com/problems/largest-number/) | [ ] |
| 215 |[Kth Largest Element](https://leetcode.com/problems/kth-largest-element-in-an-array/) | [ ] |
| 274 |[H-Index](https://leetcode.com/problems/h-index/) | [ ] |
| 324 |[Wiggle Sort II](https://leetcode.com/problems/wiggle-sort-ii/) | [ ] |
| 347 |[Top K Frequent](https://leetcode.com/problems/top-k-frequent-elements/) | [ ] |
| 451 |[Sort Chars by Frequency](https://leetcode.com/problems/sort-characters-by-frequency/) | [ ] |
| 539 |[Min Time Difference](https://leetcode.com/problems/minimum-time-difference/) | [ ] |
| 692 |[Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | [ ] |
| 853 |[Car Fleet](https://leetcode.com/problems/car-fleet/) | [ ] |
| 973 |[K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) | [ ] |
| 1305 |[All Elements in Two BSTs](https://leetcode.com/problems/all-elements-in-two-binary-search-trees/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 4 |[Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | [ ] |
| 23 |[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [ ] |
| 41 |[First Missing Positive](https://leetcode.com/problems/first-missing-positive/) | [ ] |
| 164 |[Maximum Gap](https://leetcode.com/problems/maximum-gap/) | [ ] |
| 218 |[The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/) | [ ] |
| 220 |[Contains Duplicate III](https://leetcode.com/problems/contains-duplicate-iii/) | [ ] |
| 269 |[Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) | [ ] |
| 315 |[Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | [ ] |
| 327 |[Count of Range Sum](https://leetcode.com/problems/count-of-range-sum/) | [ ] |
| 354 |[Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/) | [ ] |
| 493 |[Reverse Pairs](https://leetcode.com/problems/reverse-pairs/) | [ ] |
| 502 |[IPO](https://leetcode.com/problems/ipo/) | [ ] |
| 632 |[Smallest Range Covering K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | [ ] |
| 891 |[Sum of Subsequence Widths](https://leetcode.com/problems/sum-of-subsequence-widths/) | [ ] |
| 1383 |[Maximum Performance of a Team](https://leetcode.com/problems/maximum-performance-of-a-team/) | [ ] |

> URL format: prepend `https://` to each path.

