# Prefix Sum

## When to use
- "Sum of range [l..r]" queried many times
- "Count subarrays with sum = K"
- "Equal partition", "left == right sum"
- 2-D: "sum of submatrix"

## Templates

```java
// 1D
int[] pre = new int[n + 1];
for (int i = 0; i < n; i++) pre[i+1] = pre[i] + a[i];
int rangeSum(int l, int r) { return pre[r+1] - pre[l]; }   // inclusive

// Count subarrays with sum K  — HashMap of prefix counts
Map<Integer,Integer> cnt = new HashMap<>();
cnt.put(0, 1);
int s = 0, ans = 0;
for (int x : a) {
    s += x;
    ans += cnt.getOrDefault(s - K, 0);
    cnt.merge(s, 1, Integer::sum);
}

// 2D prefix
int[][] p = new int[m+1][n+1];
for (int i=0; i<m; i++) for (int j=0; j<n; j++)
    p[i+1][j+1] = mat[i][j] + p[i][j+1] + p[i+1][j] - p[i][j];
```

## Pitfalls
- Off-by-one: `pre` of size `n+1` is easier.
- Initialize `cnt.put(0,1)` for "sum from index 0".
- Use `long` if values can sum to overflow.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 303 | [Range Sum Query Immutable](https://leetcode.com/problems/range-sum-query-immutable/) | [ ] |
| 724 | [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/) | [ ] |
| 1480 | [Running Sum of 1D Array](https://leetcode.com/problems/running-sum-of-1d-array/) | [ ] |
| 1413 | [Min Value Get Positive Step by Step Sum](https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/) | [ ] |
| 2270 | [Number of Ways Split Array](https://leetcode.com/problems/number-of-ways-to-split-array/) | [ ] |
| 2389 | [Longest Subseq Sum ≤ Queries](https://leetcode.com/problems/longest-subsequence-with-limited-sum/) | [ ] |
| 1893 | [Check If All Integers in Range Covered](https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/) | [ ] |
| 1854 | [Max Population Year](https://leetcode.com/problems/maximum-population-year/) | [ ] |
| 1991 | [Find Middle Index in Array](https://leetcode.com/problems/find-the-middle-index-in-array/) | [ ] |
| 1732 | [Find Highest Altitude](https://leetcode.com/problems/find-the-highest-altitude/) | [ ] |
| 1588 | [Sum of All Odd Length Subarrays](https://leetcode.com/problems/sum-of-all-odd-length-subarrays/) | [ ] |
| 1295 | [Find Numbers with Even Number of Digits](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/) | [ ] |
| 1431 | [Kids With Greatest Number of Candies](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/) | [ ] |
| 1450 | [Number of Students Doing Homework](https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/) | [ ] |
| 1854 | (review variant) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 238 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | [ ] |
| 304 | [Range Sum Query 2D Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/) | [ ] |
| 325 | [Max Size Subarray Sum = K](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/) | [ ] |
| 437 | [Path Sum III](https://leetcode.com/problems/path-sum-iii/) | [ ] |
| 523 | [Continuous Subarray Sum (mult of K)](https://leetcode.com/problems/continuous-subarray-sum/) | [ ] |
| 525 | [Contiguous Array](https://leetcode.com/problems/contiguous-array/) | [ ] |
| 528 | [Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/) | [ ] |
| 560 | [Subarray Sum = K](https://leetcode.com/problems/subarray-sum-equals-k/) | [ ] |
| 974 | [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/) | [ ] |
| 1109 | [Corporate Flight Bookings](https://leetcode.com/problems/corporate-flight-bookings/) | [ ] |
| 1314 | [Matrix Block Sum](https://leetcode.com/problems/matrix-block-sum/) | [ ] |
| 1352 | [Product of Last K Numbers](https://leetcode.com/problems/product-of-the-last-k-numbers/) | [ ] |
| 1685 | [Sum of Abs Diffs Sorted Array](https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/) | [ ] |
| 1862 | [Sum of Floored Pairs](https://leetcode.com/problems/sum-of-floored-pairs/) | [ ] |
| 1894 | [Find Student Replacing Chalk](https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 84 | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [ ] |
| 363 | [Max Sum Rectangle ≤ K](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/) | [ ] |
| 410 | [Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/) | [ ] |
| 689 | [Max Sum 3 Non-Overlapping Subarrays](https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/) | [ ] |
| 862 | [Shortest Subarray Sum ≥ K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) | [ ] |
| 1074 | [Number of Submatrices Sum Target](https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/) | [ ] |
| 1191 | [K-Concatenation Max Sum](https://leetcode.com/problems/k-concatenation-maximum-sum/) | [ ] |
| 1234 | [Replace Substring Balanced](https://leetcode.com/problems/replace-the-substring-for-balanced-string/) | [ ] |
| 1546 | [Max Non-Overlap Subarrays Sum K](https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/) | [ ] |
| 1738 | [Find Kth Largest XOR Coord](https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/) | [ ] |
| 1825 | [Finding MK Average](https://leetcode.com/problems/finding-mk-average/) | [ ] |
| 1905 | [Count Sub-Islands](https://leetcode.com/problems/count-sub-islands/) | [ ] |
| 2104 | [Sum of Subarray Ranges](https://leetcode.com/problems/sum-of-subarray-ranges/) | [ ] |
| 2245 | [Max Trailing Zeros in Path of Matrix](https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/) | [ ] |
| 2536 | [Increment Submatrices by One](https://leetcode.com/problems/increment-submatrices-by-one/) | [ ] |

> Tip: filter LeetCode by tag `prefix-sum` for more problems at any difficulty.

