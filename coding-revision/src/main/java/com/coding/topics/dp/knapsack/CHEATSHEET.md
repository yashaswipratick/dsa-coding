# DP — Knapsack Family Cheatsheet

> **How to recall:** Base case → Choices (include/exclude) → Combine rule → Table init → Tabulation formula

---

## 🔑 Quick Identification

```
Array given + capacity/target + choice to pick or skip + asking max/min/count/feasibility
→ Knapsack family
```

---

## 1. 0-1 Knapsack
**File:** `Knapsack.java`
**Link:** https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

**Problem:** Maximize value. Each item can be used **at most once**. Weight ≤ W.

**Why this base case:**
- `n == 0` → no items left to pick, value is 0 regardless of remaining capacity.
- `w == 0` → zero capacity left, cannot add anything, value is 0.
- Together they represent: *empty bag or nothing to pick → nothing gained.*

**Base Case:**
```
n == 0 || w == 0  →  return 0
```

**Recursive Choice:**
```java
if (wt[n-1] <= w)
    return Math.max(val[n-1] + solve(w - wt[n-1], n-1),   // include → n-1
                               solve(w, n-1));              // exclude
else
    return solve(w, n-1);
```

**Memoization init:** `int[n+1][W+1]`, all `-1`, base: `dp[0][*] = dp[*][0] = 0`

**Tabulation:**
```java
// i = items, j = capacity
if (wt[i-1] <= j)
    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
else
    dp[i][j] = dp[i-1][j];
// Answer: dp[n][W]
```

**Combine rule:** `max(include, exclude)` — optimization.

---

## 2. Subset Sum
**File:** `SubsetSum.java`

**Problem:** Does any subset sum exactly to `sum`?

**Why this base case:**
- `sum == 0` → we've already "used up" the exact target; the empty subset achieves it → **true**.  Any number of items remaining doesn't matter; we already succeeded.
- `n == 0` (and sum > 0) → no items left but sum is still > 0; impossible → **false**.
- Order matters: check `sum == 0` first — covers the case `n == 0 && sum == 0` (true).

**Base Case:**
```
sum == 0          →  true   (empty subset is valid)
n == 0 (sum > 0)  →  false
```

**Recursive Choice:**
```java
if (arr[n-1] <= sum)
    return solve(sum - arr[n-1], n-1) || solve(sum, n-1);
else
    return solve(sum, n-1);
```

**Memoization init:** `Boolean[n+1][sum+1]`
- `dp[0][0] = true`, `dp[0][j>0] = false`, `dp[i][0] = true`, rest = `null`
- Cache check: `if (dp[n][sum] != null) return dp[n][sum]`

**Tabulation:**
```java
if (arr[i-1] <= j)
    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
else
    dp[i][j] = dp[i-1][j];
// Base: dp[0][0]=true, dp[0][j>0]=false, dp[i][0]=true
// Answer: dp[n][sum]
```

**Combine rule:** `||` — feasibility.

---

## 3. Equal Subset Sum Partition
**File:** `EqualSubsetSum.java`

**Problem:** Can array split into two subsets with equal sum?

**Key Insight:** Reduce to SubsetSum. If total is odd → false.

```java
int total = Arrays.stream(arr).sum();
if (total % 2 != 0) return false;
return isSubsetSum(arr, total / 2);   // reuse SubsetSum logic
```

**No new DP needed — builds on Subset Sum.**

---

## 4. Count of Subset Sum
**File:** `CountOfSubsetSum.java`
**Link:** https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

**Problem:** How many subsets sum to `target`?

**Why this base case:**
- `n == 0 && target == 0` → no items left AND target is exactly 0 → we found one valid empty subset → return **1**.
- `n == 0 && target > 0` → no items left but target still remains → impossible path → return **0**.
- Both cases are unified as: `n == 0 → return target == 0 ? 1 : 0`.
- **Why NOT `sum == 0 → return 1` separately (like Subset Sum)?** Because arrays can contain 0-value elements. If you short-circuit at `sum == 0`, you'd miss counting subsets that include zeros. The unified base case handles this correctly.

**Base Case:**
```
n == 0  →  target == 0 ? 1 : 0
        (BOTH n and target must reach 0 simultaneously to count as 1 valid subset)
```

**⚠️ Note on zero elements:** With zeros in array, this unified base case handles correctly.

**Recursive Choice:**
```java
if (arr[n-1] <= target)
    return solve(target - arr[n-1], n-1) + solve(target, n-1);
else
    return solve(target, n-1);
```

**Memoization init:** `int[n+1][target+1]`, all `-1`

**Tabulation:**
```java
// Base: dp[0][0]=1, dp[0][j>0]=0, dp[i][0]=1
if (arr[i-1] <= j)
    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
else
    dp[i][j] = dp[i-1][j];
// Answer: dp[n][target]
```

**Combine rule:** `+` — counting.

---

## 🔑 Combination Rules

| Goal | Operator | Example |
|------|----------|---------|
| Feasibility ("possible?") | `\|\|` | Subset Sum |
| Optimization ("max/min?") | `max()` / `min()` | 0-1 Knapsack |
| Counting ("how many?") | `+` | Count of Subset Sum |

---

## 🔑 DP Transformation Steps

```
Step 1 RECURSIVE
   → Identify changing params (become dp table dimensions)
   → Write base cases

Step 2 MEMOIZATION (top-down)
   → dp[n+1][W+1], init sentinel (-1 / null)
   → Init base rows/cols explicitly
   → if (dp[n][w] != sentinel) return dp[n][w]
   → Store: dp[n][w] = result; return dp[n][w];

Step 3 TABULATION (bottom-up)
   → Same dp table, same base init
   → Replace n→i, W→j; loop i=1..n, j=1..W
   → Same formula but use dp[i-1][...] instead of recursive calls
   → Answer: dp[n][W]
```

