# Two Pointers

## When to use
- Sorted array problems (pair / triplet sum, dedup)
- Palindrome / substring checks
- In-place array compaction
- Linked list cycle / middle (see fast-slow pattern)

## Sub-patterns

1. **Opposite ends converging** — `l=0, r=n-1`, move based on comparison
2. **Same-direction (fast + slow / read + write)** — overwrite in place
3. **Fixed gap** — `i` and `i+k`
4. **Multi-pointer** (3Sum, 4Sum) — fix outer, two-pointer rest

## Templates

```java
// Opposite ends
int l = 0, r = n - 1;
while (l < r) {
    int sum = a[l] + a[r];
    if (sum == target) return new int[]{l, r};
    if (sum < target) l++; else r--;
}

// Read + write (dedup sorted)
int w = 1;
for (int r = 1; r < n; r++) {
    if (a[r] != a[r-1]) a[w++] = a[r];
}
return w;

// 3Sum skeleton
Arrays.sort(a);
for (int i = 0; i < n-2; i++) {
    if (i > 0 && a[i] == a[i-1]) continue;     // skip dup
    int l = i+1, r = n-1;
    while (l < r) { /* opposite-ends pair sum = -a[i] */ }
}
```

## Pitfalls
- Forget to skip duplicates → repeated triplets
- Off-by-one: `l < r` vs `l <= r`
- "Two pointers" only works on **sorted** input for pair-sum

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 26 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | [ ] |
| 27 | [Remove Element](https://leetcode.com/problems/remove-element/) | [ ] |
| 28 | [Find the Index of First Occurrence](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) | [ ] |
| 88 | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) | [ ] |
| 125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | [ ] |
| 167 | [Two Sum II — Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | [ ] |
| 234 | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [ ] |
| 283 | [Move Zeroes](https://leetcode.com/problems/move-zeroes/) | [ ] |
| 344 | [Reverse String](https://leetcode.com/problems/reverse-string/) | [ ] |
| 345 | [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/) | [ ] |
| 392 | [Is Subsequence](https://leetcode.com/problems/is-subsequence/) | [ ] |
| 455 | [Assign Cookies](https://leetcode.com/problems/assign-cookies/) | [ ] |
| 541 | [Reverse String II](https://leetcode.com/problems/reverse-string-ii/) | [ ] |
| 925 | [Long Pressed Name](https://leetcode.com/problems/long-pressed-name/) | [ ] |
| 977 | [Squares of Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | [ ] |
| 15 | [3Sum](https://leetcode.com/problems/3sum/) | [ ] |
| 16 | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | [ ] |
| 18 | [4Sum](https://leetcode.com/problems/4sum/) | [ ] |
| 19 | [Remove Nth Node From End](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | [ ] |
| 75 | [Sort Colors](https://leetcode.com/problems/sort-colors/) | [ ] |
| 80 | [Remove Duplicates II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) | [ ] |
| 142 | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | [ ] |
| 151 | [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/) | [ ] |
| 209 | [Min Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | [ ] |
| 287 | [Find Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [ ] |
| 443 | [String Compression](https://leetcode.com/problems/string-compression/) | [ ] |
| 524 | [Longest Word in Dictionary by Deleting](https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/) | [ ] |
| 845 | [Longest Mountain in Array](https://leetcode.com/problems/longest-mountain-in-array/) | [ ] |
| 1004 | [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 4 | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | [ ] |
| 42 | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | [ ] |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [ ] |
| 159 | [Longest Substring ≤ 2 Distinct](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | [ ] |
| 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [ ] |
| 259 | [3Sum Smaller](https://leetcode.com/problems/3sum-smaller/) | [ ] |
| 295 | [Median Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | [ ] |
| 340 | [Longest Substring ≤ K Distinct](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) | [ ] |
| 363 | [Max Sum Rectangle ≤ K](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/) | [ ] |
| 632 | [Smallest Range Covering K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | [ ] |
| 719 | [Find K-th Smallest Pair Distance](https://leetcode.com/problems/find-k-th-smallest-pair-distance/) | [ ] |
| 826 | [Most Profit Assigning Work](https://leetcode.com/problems/most-profit-assigning-work/) | [ ] |
| 992 | [Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/) | [ ] |
| 1438 | [Longest Subarray Abs Diff ≤ Limit](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) | [ ] |
| 1499 | [Max Value of Equation](https://leetcode.com/problems/max-value-of-equation/) | [ ] |

