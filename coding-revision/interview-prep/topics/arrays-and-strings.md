# Arrays & Strings

The foundation. ~40% of all interview problems live here.

## Core Java APIs

```java
int[] a = new int[n];
Arrays.fill(a, -1);
Arrays.sort(a);                   // O(n log n)
int[] copy = Arrays.copyOfRange(a, 1, 4);

List<Integer> list = new ArrayList<>();
list.add(x); list.remove(i); list.get(i);

String s = "abc";
char c = s.charAt(0);
char[] arr = s.toCharArray();
String rev = new StringBuilder(s).reverse().toString();
String[] parts = s.split(" ");
String joined = String.join(",", parts);

// Frequency count
int[] freq = new int[26];
for (char c : s.toCharArray()) freq[c - 'a']++;
```

## Sub-patterns inside this topic

1. **Frequency counting** — `int[26]` or `HashMap`
2. **Two-pointer scans** — opposite ends or same direction
3. **Prefix sum** — cumulative
4. **In-place modification** — read pointer + write pointer
5. **Kadane's algorithm** — max subarray
6. **Dutch National Flag** — 3-way partition
7. **String building** — always `StringBuilder` (never `s += c` in a loop)

## Pitfalls

- `String` is immutable; concatenation in loop is O(n²). Use `StringBuilder`.
- `s.length()` counts UTF-16 code units, not code points.
- Negative numbers in "max subarray" — answer can be negative (initialize `max = arr[0]`, not `0`).
- `Arrays.asList(int[])` returns `List<int[]>` of length 1! Use streams or `Integer[]`.

## Template — Kadane

```java
int kadane(int[] a) {
    int best = a[0], cur = a[0];
    for (int i = 1; i < a.length; i++) {
        cur = Math.max(a[i], cur + a[i]);
        best = Math.max(best, cur);
    }
    return best;
}
```

## Template — Dutch National Flag (3-way partition)

```java
void sortColors(int[] a) {
    int lo = 0, mid = 0, hi = a.length - 1;
    while (mid <= hi) {
        if (a[mid] == 0) { int t=a[lo]; a[lo++]=a[mid]; a[mid++]=t; }
        else if (a[mid] == 2) { int t=a[hi]; a[hi--]=a[mid]; a[mid]=t; }
        else mid++;
    }
}
```

## Problems

### Easy (15)
| # | Problem | Pattern | Key insight | Done |
|---|---|---|---|---|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Hashing | Store seen → look up complement | [ ] |
| 26 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Two pointers | Write pointer trails | [ ] |
| 27 | [Remove Element](https://leetcode.com/problems/remove-element/) | Two pointers | Overwrite in place | [ ] |
| 53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | Kadane | Reset when running sum negative | [ ] |
| 88 | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) | Two pointers | Fill from back | [ ] |
| 121 | [Best Time to Buy & Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Single pass | Track min so far | [ ] |
| 125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | Two pointers | Skip non-alphanumeric | [ ] |
| 136 | [Single Number](https://leetcode.com/problems/single-number/) | XOR | a^a=0 | [ ] |
| 169 | [Majority Element](https://leetcode.com/problems/majority-element/) | Boyer-Moore | Cancel votes | [ ] |
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | HashSet | Add returns false on dup | [ ] |
| 242 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) | Frequency | int[26] | [ ] |
| 268 | [Missing Number](https://leetcode.com/problems/missing-number/) | XOR or sum | n(n+1)/2 − sum | [ ] |
| 283 | [Move Zeroes](https://leetcode.com/problems/move-zeroes/) | Two pointers | Swap non-zero forward | [ ] |
| 344 | [Reverse String](https://leetcode.com/problems/reverse-string/) | Two pointers | Swap ends | [ ] |
| 387 | [First Unique Character](https://leetcode.com/problems/first-unique-character-in-a-string/) | Frequency | int[26] then second pass | [ ] |

### Medium (15)
| # | Problem | Pattern | Key insight | Done |
|---|---|---|---|---|
| 3 | [Longest Substring Without Repeat](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Sliding window | Map char→last index | [ ] |
| 11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Two pointers | Move the shorter side | [ ] |
| 15 | [3Sum](https://leetcode.com/problems/3sum/) | Sort + two pointers | Fix one, two-pointer rest | [ ] |
| 31 | [Next Permutation](https://leetcode.com/problems/next-permutation/) | Array manip | Find pivot, swap, reverse suffix | [ ] |
| 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Modified BS | Half is sorted | [ ] |
| 36 | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | Hash sets | Encode row/col/box keys | [ ] |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Hash | Sorted string as key | [ ] |
| 56 | [Merge Intervals](https://leetcode.com/problems/merge-intervals/) | Sort + sweep | Compare end with next start | [ ] |
| 75 | [Sort Colors](https://leetcode.com/problems/sort-colors/) | Dutch flag | 3 pointers | [ ] |
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | HashSet | Only start from sequence beginning | [ ] |
| 152 | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | DP | Track min AND max (neg flips) | [ ] |
| 189 | [Rotate Array](https://leetcode.com/problems/rotate-array/) | Reverse trick | Reverse 3 times | [ ] |
| 238 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | Prefix product | Left × right | [ ] |
| 271 | [Encode/Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/) | Design | Length prefix | [ ] |
| 347 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | Bucket sort | Buckets by frequency | [ ] |

### Hard (15)
| # | Problem | Pattern | Key insight | Done |
|---|---|---|---|---|
| 4 | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | BS on partition | Binary search the cut | [ ] |
| 23 | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | Heap / D&C | Min-heap of heads | [ ] |
| 32 | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | Stack/DP | Stack of indices | [ ] |
| 41 | [First Missing Positive](https://leetcode.com/problems/first-missing-positive/) | Cyclic sort | Place i at index i-1 | [ ] |
| 42 | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | Two pointers | min(maxL,maxR)−h | [ ] |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | Sliding window | Shrink when all matched | [ ] |
| 84 | [Largest Rectangle Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Monotonic stack | Pop when next smaller | [ ] |
| 85 | [Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | Histogram | Row-by-row #84 | [ ] |
| 124 | [Binary Tree Max Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Tree DFS | Gain from each side | [ ] |
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | HashSet | (also listed Medium) | [ ] |
| 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | Monotonic deque | Indices in decreasing order | [ ] |
| 295 | [Find Median Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | Two heaps | Balance sizes | [ ] |
| 354 | [Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/) | LIS | Sort + LIS on heights | [ ] |
| 363 | [Max Sum Rectangle ≤ K](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/) | Prefix + TreeSet | Compress 2D to 1D | [ ] |
| 480 | [Sliding Window Median](https://leetcode.com/problems/sliding-window-median/) | Two heaps / TreeMap | Lazy delete | [ ] |

