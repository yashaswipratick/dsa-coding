# Problems Cheatsheet — Logic Recall Reference

> **How to use:** When you need to recall the approach for a problem, find it here.
> Each entry has: Problem → Key Insight → Base Case / Init → Recursive Choice → Tabulation Rule → Edge Cases.

---

## 📦 DYNAMIC PROGRAMMING — Knapsack Family

---

### 1. 0-1 Knapsack
**File:** `dp/knapsack/Knapsack.java`
**Link:** https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

**Problem:** Maximize value by picking items where each item can be used at most once, and total weight ≤ W.

**Key Insight:** For each item, you have 2 choices: include it (if wt fits) OR skip it. Take the max.

**Base Case:**
```
n == 0 || w == 0  →  return 0
```

**Recursive Choice:**
```
if (wt[n-1] <= w)
    return max(val[n-1] + solve(w - wt[n-1], n-1),   // include
                           solve(w, n-1))               // exclude
else
    return solve(w, n-1)                                // must exclude
```

**Memoization Table Init:** `dp[n+1][W+1]`, all `-1`, base: `dp[0][*] = dp[*][0] = 0`

**Tabulation Rule:**
```java
if (wt[i-1] <= j)
    dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
else
    dp[i][j] = dp[i-1][j];
// Answer: dp[n][W]
```

**Combination rule:** `max(include, exclude)` — optimization problem.

---

### 2. Subset Sum
**File:** `dp/knapsack/SubsetSum.java`
**Link:** https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

**Problem:** Can you find a subset that sums exactly to `sum`?

**Key Insight:** Subset Sum = 0-1 Knapsack where target is the "capacity" and we want feasibility (||) not max value.

**Base Case:**
```
sum == 0  →  true   (empty subset always works)
n == 0    →  false  (no items left and sum > 0)
```

**Recursive Choice:**
```
if (arr[n-1] <= sum)
    return solve(sum - arr[n-1], n-1) || solve(sum, n-1)
else
    return solve(sum, n-1)
```

**Memoization Table Init:** `Boolean[n+1][sum+1]`
- `dp[0][0] = true`, `dp[0][j≠0] = false`, `dp[i][0] = true`, rest = `null`
- Cache check: `if (dp[n][sum] != null) return dp[n][sum]`

**Tabulation Rule:**
```java
if (arr[i-1] <= j)
    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
else
    dp[i][j] = dp[i-1][j];
// Answer: dp[n][sum]
```

**Combination rule:** `||` — feasibility/existence problem.

---

### 3. Equal Subset Sum Partition
**File:** `dp/knapsack/EqualSubsetSum.java`

**Problem:** Can array be split into two subsets with equal sum?

**Key Insight:** If total sum is odd → false. Otherwise, reduce to SubsetSum(arr, total/2).

**Logic:**
```java
int total = sum of all elements;
if (total % 2 != 0) return false;
return isSubsetSum(arr, total / 2);   // reuse SubsetSum
```

---

### 4. Count of Subset Sum
**File:** `dp/knapsack/CountOfSubsetSum.java`
**Link:** https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

**Problem:** Count how many subsets sum to `target`.

**Key Insight:** Same structure as Subset Sum, but combine with `+` instead of `||`.

**Base Case:**
```
n == 0  →  target == 0 ? 1 : 0
```
*(IMPORTANT: Both n and target must reach 0 together to count as 1 valid subset.
 Separate the two base cases into one unified check.)*

**Recursive Choice:**
```
if (arr[n-1] <= target)
    return solve(target - arr[n-1], n-1) + solve(target, n-1)
else
    return solve(target, n-1)
```

**Memoization:** `dp[n+1][target+1]`, all `-1`

**Tabulation Rule:**
```java
if (arr[i-1] <= j)
    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
else
    dp[i][j] = dp[i-1][j];
// Base: dp[0][0] = 1, dp[0][j≠0] = 0, dp[i][0] = 1
// Answer: dp[n][target]
```

**⚠️ Zero-element edge case:** If array contains `0`, the two-base-case approach (`if n==0 return target==0?1:0`) handles it correctly since `0` can always be included/excluded.

**Combination rule:** `+` — counting problem.

---

## 📦 DYNAMIC PROGRAMMING — Unbounded Knapsack

> **Unbounded = item can be used multiple times.**
> Only change from 0-1 Knapsack: when you include item, keep `n` the same (don't do `n-1`).

---

### 5. Rod Cutting
**File:** `dp/unbounded_knapsack/RodCutting.java`

**Problem:** Cut a rod of length n to maximize revenue.

**Key Insight:** Lengths `{1,2,...,n}` are the "weights", prices are "values". Unbounded — cut same length multiple times.

**Recursive Choice (vs 0-1 Knapsack):**
```
if (length[n-1] <= w)
    return max(price[n-1] + solve(w - length[n-1], n),   // KEEP n (reuse same cut)
                             solve(w, n-1))                // exclude this length
```

**Tabulation Rule:**
```java
if (length[i-1] <= j)
    dp[i][j] = max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                                  ^^^^ same row i (unbounded!)
```

---

### 6. Coin Change — Count Ways
**File:** `dp/unbounded_knapsack/CoinChangeMaximumCountWays.java`
**Link:** https://www.geeksforgeeks.org/problems/coin-change2448/1

**Problem:** Count number of ways to make `sum` using coins (unlimited supply).

**Key Insight:** Unbounded Knapsack + counting = combine with `+`, keep `n` when including.

**Base Case:**
```
n == 0  →  sum == 0 ? 1 : 0
```

**Recursive Choice:**
```
if (coins[n-1] <= sum)
    return solve(sum - coins[n-1], n) + solve(sum, n-1)   // KEEP n
else
    return solve(sum, n-1)
```

**Tabulation Rule:**
```java
if (coins[i-1] <= j)
    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
               ^^^^ same row i
```

**1D Optimized:**
```java
dp[0] = 1;
for each coin: for j from coin to sum: dp[j] += dp[j-coin];
```

---

### 7. Coin Change — Minimum Coins
**File:** `dp/unbounded_knapsack/CoinChangeMinimumCoins.java`
**Link:** https://www.geeksforgeeks.org/problems/number-of-coins1824/1

**Problem:** Minimum number of coins to make `sum`. Return -1 if impossible.

**Key Insight:** Unbounded + minimization. Use `Integer.MAX_VALUE - 1` as "infinity" sentinel to avoid overflow in `1 + INF`.

**Base Case:**
```
sum == 0          →  return 0          (no coins needed)
n == 0 (sum > 0)  →  return INF-1      (impossible)
```

**Recursive Choice:**
```
if (coins[n-1] <= sum)
    return min(1 + solve(sum - coins[n-1], n), solve(sum, n-1))
else
    return solve(sum, n-1)
```

**Final Answer:** `if result >= INF-1 → return -1`

**Tabulation Rule:**
```java
if (coins[i-1] <= j)
    dp[i][j] = min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
```

**1D Optimized:**
```java
dp[0] = 0; dp[j>0] = INF;
for each coin: for j from coin to sum:
    if dp[j-coin] != INF: dp[j] = min(dp[j], 1 + dp[j-coin]);
```

---

## 📦 DYNAMIC PROGRAMMING — Longest Common Subsequence (LCS) Family

> **Pattern:** Two strings, two pointer parameters `n` and `m` → `dp[n+1][m+1]`.
> When characters **match**: consume both. When they **don't match**: move one pointer, take best.

---

### 8. Longest Common Subsequence (LCS)
**File:** `dp/longest_common_subsequence/LongestCommonSubsequence.java`
**Link:** https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1

**Base Case:** `n == 0 || m == 0  →  return 0`

**Recursive Choice:**
```
if (s1[n-1] == s2[m-1])   return 1 + solve(n-1, m-1)
else                       return max(solve(n, m-1), solve(n-1, m))
```

**Tabulation Rule:**
```java
if (s1[i-1] == s2[j-1])   dp[i][j] = 1 + dp[i-1][j-1];
else                       dp[i][j] = max(dp[i][j-1], dp[i-1][j]);
```

---

### 9. Print LCS String
**File:** `dp/longest_common_subsequence/PrintLongestCommonSubsequence.java`

**Key Insight:** Recursive approach — build string bottom-up. When chars match, prepend char + recurse; when they don't, take longer branch.

**Recursive:**
```java
if (s1[n-1] == s2[m-1])  return s1.charAt(n-1) + lcsHelper(n-1, m-1);
else
    String a = solve(n-1, m); String b = solve(n, m-1);
    return a.length() > b.length() ? a : b;
// Then reverse final result (built backwards)
```

**Memoization:** `String[][] dp[n+1][m+1]`, init `dp[0][*] = dp[*][0] = ""`

---

### 10. Longest Common Substring
**File:** `dp/longest_common_subsequence/LongestCommonSubstring.java`
**Link:** https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

**Key Difference from LCS:** Substring must be **contiguous**. When chars don't match, reset to 0 (don't carry over).

**Base Case:** `n == 0 || m == 0  →  return 0`

**⚠️ Recursive is tricky** — requires a `count` parameter to track current streak.

**Tabulation Rule (preferred):**
```java
if (s1[i-1] == s2[j-1])   dp[i][j] = 1 + dp[i-1][j-1];   // extend streak
else                       dp[i][j] = 0;                    // reset streak
maxLen = max(maxLen, dp[i][j]);
// Answer: maxLen (NOT dp[n][m])
```

**⚠️ Answer is `maxLen` tracked separately, not `dp[n][m]`!**

---

### 11. Longest Palindromic Subsequence
**File:** `dp/longest_common_subsequence/LongestPalindromicSubsequence.java`

**Key Insight:** Longest Palindromic Subsequence = LCS(s, reverse(s))

```java
return lcs(s, new StringBuilder(s).reverse().toString());
```

---

### 12. Minimum Insertions / Deletions to Make Strings Equal
**File:** `dp/longest_common_subsequence/MinimumInsertAndDelete.java`

**Key Insight:**
- Common part (LCS) stays. Delete from s1 what's not in LCS. Insert to s2 what's not in LCS.
- `deletions = s1.length() - LCS`
- `insertions = s2.length() - LCS`

---

### 13. Minimum Insertions to Make Palindrome
**File:** `dp/longest_common_subsequence/MinimumInsertionsInStringToMakeLongestPalindromicSubsequence.java`

**Key Insight:** `min insertions = n - LongestPalindromicSubsequence(s)`

---

### 14. Sequence Pattern Matching
**File:** `dp/longest_common_subsequence/SequencePatternMatching.java`

**Key Insight:** s1 is a subsequence of s2 iff `LCS(s1, s2) == s1.length()`

---

## 📊 GRAPH PROBLEMS

> **BFS pattern:** `visited[start] = true` → enqueue → while queue: poll → process neighbors.
> **DFS pattern:** `visited[i] = true` → for each neighbor: if !visited → recurse.

---

### 15. BFS Traversal
**File:** `graph/bfs/Traversal.java`

**Pattern:**
```java
Queue<Integer> q = new LinkedList<>();
q.add(0); visited[0] = true;
while (!q.isEmpty()) {
    int node = q.poll();
    result.add(node);
    for (int neighbor : adj.get(node))
        if (!visited[neighbor]) { visited[neighbor] = true; q.add(neighbor); }
}
```

---

### 16. DFS Traversal
**File:** `graph/dfs/Traversal.java`

**Pattern:**
```java
void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {
    visited[node] = true;
    result.add(node);
    for (int neighbor : adj.get(node))
        if (!visited[neighbor]) dfs(neighbor, adj, visited, result);
}
```

---

### 17. Number of Connected Components / Provinces
**File:** `graph/NumberOfConnectedComponentsOrProvinces.java`
**Link:** https://www.geeksforgeeks.org/problems/number-of-provinces/1

**Key Insight:** Count how many times you start a fresh DFS/BFS (each fresh start = new component).

**Input note:** Problem gives edge pairs `[u,v]` → build adjacency list first with `buildFromEdgePairs(V, edges)`.

```java
for (int i = 0; i < V; i++) {
    if (!visited[i]) { count++; dfs(i, adj, visited); }
}
```

---

### 18. Number of Islands
**File:** `graph/NumberOfIslands.java`
**Link:** https://leetcode.com/problems/number-of-islands/

**Key Insight:** Grid BFS. Iterate all cells; when you find unvisited `'1'`, increment count and BFS to mark the whole island visited.

**4-directional neighbors:** up, down, left, right. Check bounds + `grid[r][c] == '1'` + `!visited`.

```java
for each cell (i,j): if !visited[i][j] && grid[i][j]=='1': count++; bfs(i,j);
```

---

### 19. Flood Fill
**File:** `graph/FloodFill.java`
**Link:** https://leetcode.com/problems/flood-fill/

**Key Insight:** BFS from starting cell. Only spread to neighbors with the **same initial color**. Mark cell with new color when enqueuing.

```java
int initialColor = image[sr][sc];
// BFS: enqueue neighbor only if image[r][c] == initialColor && !visited
// Set image[r][c] = color when enqueuing
```

---

## 🔺 HEAP / PRIORITY QUEUE

---

### 20. Kth Largest Element
**File:** `heap/KthLargestElement.java`
**Link:** https://leetcode.com/problems/kth-largest-element-in-an-array/

**Key Insight:** Maintain a **min-heap of size k**. When heap grows beyond k, evict the minimum. The root is the kth largest.

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
for (int num : nums) {
    minHeap.add(num);
    if (minHeap.size() > k) minHeap.poll();  // remove smallest
}
return minHeap.peek();  // kth largest
```

**Pattern:** "Top-K largest" → min-heap of size K (evict small)
**Pattern:** "Top-K smallest" → max-heap of size K (evict large)

---

### 21. Top K Frequent Elements
**File:** `heap/TopKFrequentElements.java`
**Link:** https://leetcode.com/problems/top-k-frequent-elements/

**Key Insight:**
1. Build frequency map.
2. Use min-heap ordered by frequency. Keep size ≤ k. Evict least frequent.

```java
Map<Integer,Integer> freq = new HashMap<>();
PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
for each entry: heap.add({value, frequency}); if (heap.size() > k) heap.poll();
```

---

## 🔍 BINARY SEARCH

> **Template:** `while (start <= end)` · `mid = start + (end-start)/2` · narrow one side.

---

### 22. Binary Search (Classic)
**File:** `binary_Search/BinarySearch.java`
**Link:** https://leetcode.com/problems/binary-search/

```java
if (nums[mid] == target) return mid;
else if (nums[mid] < target) start = mid + 1;
else end = mid - 1;
```

---

### 23. Search in Rotated Sorted Array
**File:** `binary_Search/SearchInRotatedSortedArray.java`
**Link:** https://leetcode.com/problems/search-in-rotated-sorted-array/

**Key Insight:** At least one half is always sorted. Check which half is sorted, then check if target is in that sorted half.

```java
if (nums[start] <= nums[mid]) {  // left half sorted
    if (target in [nums[start], nums[mid]]) end = mid - 1;
    else start = mid + 1;
} else {                          // right half sorted
    if (target in [nums[mid], nums[end]]) start = mid + 1;
    else end = mid - 1;
}
```

---

### 24. Find Peak Element
**File:** `binary_Search/PeakElement.java`

**Key Insight:** If `nums[mid] > nums[mid+1]` → peak is in left half (include mid). Else → peak is in right half.

```java
while (start < end) {   // Note: strict <, not <=
    if (nums[mid] > nums[mid+1]) end = mid;    // peak could be mid itself
    else start = mid + 1;
}
return start;  // single element left = peak
```

---

## 📐 ARRAYS

---

### 25. Maximum Subarray (Kadane's Algorithm)
**File:** `array/MaximumSubarray.java`
**Link:** https://leetcode.com/problems/maximum-subarray/

**Key Insight:** At each position, either extend the current subarray or start fresh.

```java
maxEnding = max(maxEnding + nums[i], nums[i]);  // extend or restart
res = max(res, maxEnding);
```

**Why it works:** If `maxEnding` becomes negative, starting fresh is always better.

---

### 26. Product of Array Except Self
**File:** `array/ProductOfArrayExceptSelf.java`
**Link:** https://leetcode.com/problems/product-of-array-except-self/

**Key Insight:** Two passes — prefix product left→right, then suffix product right→left.

```java
// Pass 1: res[i] = product of all elements to the LEFT of i
res[0] = 1;
for i in 1..n: res[i] = res[i-1] * nums[i-1];

// Pass 2: multiply each res[i] by product of all elements to the RIGHT
suffix = 1;
for i in n-1..0: res[i] *= suffix; suffix *= nums[i];
```

**No division needed. O(n) time, O(1) extra space (output array doesn't count).**

---

### 27. Trapping Rain Water
**File:** `array/TrappingRainWater.java`
**Link:** https://leetcode.com/problems/trapping-rain-water/

**Key Insight:** Water at position `i` = `min(maxLeft[i], maxRight[i]) - height[i]`.

```java
// Build lMax[i] = max height from 0 to i (left wall)
// Build rMax[i] = max height from i to n-1 (right wall)
// Water at i = min(lMax[i], rMax[i]) - height[i]
res += min(lMax[i], rMax[i]) - height[i];
```

---

## 🧠 Combination Rules Quick Reference

| Problem Type | Combine With |
|---|---|
| Feasibility — "is it possible?" | `\|\|` (OR) |
| Optimization — "max/min value?" | `max(...)` / `min(...)` |
| Counting — "how many ways?" | `+` |
| Existence — "find the value/string?" | Build/track separately |

---

## 🔑 DP Transformation Steps (Always Follow This)

```
Step 1: Recursive solution
   → Identify parameters that change (these become dp table dimensions)
   → Write base cases

Step 2: Memoization (top-down)
   → Add dp table, initialize to sentinel (-1 / null / INF)
   → Init base case cells
   → Before computing: if dp[n][...] != sentinel → return dp[n][...]
   → Store result in dp[n][...] before returning

Step 3: Tabulation (bottom-up)
   → Same dp table
   → Replace recursive calls by replacing n→i, w/sum→j
   → Loop i from 1 to n, j from 1 to W/sum
   → dp[i][j] = same formula as memoization but uses table lookups
   → Answer: dp[n][W] or tracked global max (for substring problems)
```

---

## 🔑 Graph Template

```
- BFS → Queue, visited array, process level by level → shortest path
- DFS → Recursion, visited array, explore fully → connectivity/cycle
- Grid BFS → 4-directional neighbors, check bounds + condition
- Edge pairs → build adjacency list first with V vertices
```

