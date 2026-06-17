# Sliding Window

## When to use (trigger phrases)
- "contiguous subarray / substring"
- "longest / shortest with condition"
- "max / min of size k"
- "exactly K distinct"

## Two flavours

| Flavour | When | Window size |
|---|---|---|
| **Fixed** | "size k" stated | constant |
| **Variable** | "longest / smallest satisfying X" | grows + shrinks |

## Templates

```java
// Fixed window of size k
int sum = 0;
for (int i = 0; i < k; i++) sum += a[i];
int best = sum;
for (int i = k; i < n; i++) {
    sum += a[i] - a[i-k];
    best = Math.max(best, sum);
}

// Variable window
int l = 0, best = 0;
Map<Character,Integer> freq = new HashMap<>();
for (int r = 0; r < s.length(); r++) {
    freq.merge(s.charAt(r), 1, Integer::sum);
    while (/* invalid */) {
        char c = s.charAt(l++);
        if (freq.merge(c, -1, Integer::sum) == 0) freq.remove(c);
    }
    best = Math.max(best, r - l + 1);
}
```

## Pitfalls
- Forget to capture result on every valid window
- Shrink loop runs when window empty — `while (l <= r && bad)`
- "Exactly K" = "atMost K − atMost K-1" trick

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 121 | [Best Time to Buy Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | [ ] |
| 219 | [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/) | [ ] |
| 643 | [Max Avg Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/) | [ ] |
| 1456 | [Max Vowels in Substring of Len K](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) | [ ] |
| 1652 | [Defuse the Bomb](https://leetcode.com/problems/defuse-the-bomb/) | [ ] |
| 1763 | [Longest Nice Substring](https://leetcode.com/problems/longest-nice-substring/) | [ ] |
| 2090 | [K Radius Subarray Averages](https://leetcode.com/problems/k-radius-subarray-averages/) | [ ] |
| 2379 | [Min Recolors K Consecutive Black](https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/) | [ ] |
| 2540 | [Min Common Value](https://leetcode.com/problems/minimum-common-value/) | [ ] |
| 187 | [Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/) | [ ] |
| 1984 | [Min Diff Highest/Lowest K Scores](https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/) | [ ] |
| 2461 | [Max Sum Distinct Subarrays Len K](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/) | [ ] |
| 1100 | [Find K-Length Substrings No Repeated](https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/) | [ ] |
| 1876 | [Substrings of Size 3 All Distinct](https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/) | [ ] |
| 2269 | [Find the K-Beauty of a Number](https://leetcode.com/problems/find-the-k-beauty-of-a-number/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 3 | [Longest Substring No Repeat](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [ ] |
| 209 | [Min Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | [ ] |
| 424 | [Longest Repeating Char Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) | [ ] |
| 438 | [Find All Anagrams](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [ ] |
| 487 | [Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/) | [ ] |
| 567 | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | [ ] |
| 904 | [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/) | [ ] |
| 930 | [Binary Subarrays with Sum](https://leetcode.com/problems/binary-subarrays-with-sum/) | [ ] |
| 1004 | [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) | [ ] |
| 1052 | [Grumpy Bookstore Owner](https://leetcode.com/problems/grumpy-bookstore-owner/) | [ ] |
| 1248 | [Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/) | [ ] |
| 1493 | [Longest Subarray of 1's After Deleting One](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/) | [ ] |
| 1695 | [Max Erasure Value](https://leetcode.com/problems/maximum-erasure-value/) | [ ] |
| 1838 | [Frequency of the Most Frequent](https://leetcode.com/problems/frequency-of-the-most-frequent-element/) | [ ] |
| 2090 | [K Radius Subarray Averages](https://leetcode.com/problems/k-radius-subarray-averages/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 30 | [Substring with Concat of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) | [ ] |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [ ] |
| 159 | [Longest Substring ≤ 2 Distinct](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | [ ] |
| 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [ ] |
| 340 | [Longest Substring ≤ K Distinct](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) | [ ] |
| 480 | [Sliding Window Median](https://leetcode.com/problems/sliding-window-median/) | [ ] |
| 632 | [Smallest Range Covering K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | [ ] |
| 727 | [Min Window Subsequence](https://leetcode.com/problems/minimum-window-subsequence/) | [ ] |
| 862 | [Shortest Subarray Sum ≥ K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) | [ ] |
| 992 | [Subarrays K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/) | [ ] |
| 995 | [Min K Consecutive Bit Flips](https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/) | [ ] |
| 1234 | [Replace Substring Balanced String](https://leetcode.com/problems/replace-the-substring-for-balanced-string/) | [ ] |
| 1425 | [Constrained Subseq Sum](https://leetcode.com/problems/constrained-subsequence-sum/) | [ ] |
| 1438 | [Longest Subarray Abs Diff ≤ Limit](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) | [ ] |
| 1696 | [Jump Game VI](https://leetcode.com/problems/jump-game-vi/) | [ ] |

