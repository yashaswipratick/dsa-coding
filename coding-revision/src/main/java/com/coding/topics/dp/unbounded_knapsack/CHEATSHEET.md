# DP — Unbounded Knapsack Cheatsheet

> **Unbounded = same item can be used multiple times.**
> **Only change from 0-1 Knapsack:** when including an item, keep `n` (don't do `n-1`).

---

## 🔑 Key Difference: 0-1 vs Unbounded

| | 0-1 Knapsack | Unbounded Knapsack |
|---|---|---|
| Include item | `solve(w - wt[n-1], n-1)` | `solve(w - wt[n-1], n)` ← same n |
| Table include | `dp[i-1][j-wt[i-1]]` | `dp[i][j-wt[i-1]]` ← same row |

---

## 1. Rod Cutting
**File:** `RodCutting.java`

**Problem:** Cut rod of length n to maximize revenue. Same length can be cut multiple times.

**Setup:** Create `length[] = {1,2,...,n}`, `price[]` given. Treat as Unbounded Knapsack.

**Why this base case:**
- `n == 0` → no cut lengths available; nothing can be cut, revenue = 0.
- `w == 0` → rod length remaining is 0; nothing to cut, revenue = 0.
- Same as 0-1 Knapsack: empty set of choices or zero capacity → zero profit.

**Base Case:**
```
n == 0 || w == 0  →  return 0
```

**Recursive Choice:**
```java
if (length[n-1] <= w)
    return Math.max(price[n-1] + solve(w - length[n-1], n),   // include → KEEP n
                                 solve(w, n-1));                // exclude → n-1
else
    return solve(w, n-1);
```

**Tabulation:**
```java
if (length[i-1] <= j)
    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                                      ^^^^ same row i (unbounded!)
else
    dp[i][j] = dp[i-1][j];
// Answer: dp[n][W]
```

---

## 2. Coin Change — Count Ways
**File:** `CoinChangeMaximumCountWays.java`
**Link:** https://www.geeksforgeeks.org/problems/coin-change2448/1

**Problem:** Count number of ways to make `sum` using coins. Unlimited supply.

**Why this base case:**
- `n == 0 && sum == 0` → no coin types left AND sum reached exactly 0 → **1 valid way** (the empty selection).
- `n == 0 && sum > 0` → no coin types left but sum not yet reached → **0 ways** (impossible).
- Unified: `n == 0 → sum == 0 ? 1 : 0`.

**Base Case:**
```
n == 0  →  sum == 0 ? 1 : 0
```

**Recursive Choice:**
```java
if (coins[n-1] <= sum)
    return solve(sum - coins[n-1], n) + solve(sum, n-1);   // include → KEEP n
else
    return solve(sum, n-1);
```

**Tabulation:**
```java
// Base: dp[i][0] = 1 (1 way to make 0), dp[0][j>0] = 0
if (coins[i-1] <= j)
    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
               ^^^^ same row i
else
    dp[i][j] = dp[i-1][j];
// Answer: dp[n][sum]
```

**1D Optimized O(n×sum) time, O(sum) space:**
```java
int[] dp = new int[sum + 1];
dp[0] = 1;
for (int i = 0; i < coins.length; i++)
    for (int j = coins[i]; j <= sum; j++)
        dp[j] += dp[j - coins[i]];
// Answer: dp[sum]
```

**Combine rule:** `+` — counting.

---

## 3. Coin Change — Minimum Coins
**File:** `CoinChangeMinimumCoins.java`
**Link:** https://www.geeksforgeeks.org/problems/number-of-coins1824/1

**Problem:** Minimum coins to make `sum`. Return -1 if impossible.

**Key Insight:** Use `Integer.MAX_VALUE - 1` as "infinity" sentinel to avoid `1 + MAX_VALUE` overflow.

**Why this base case:**
- `sum == 0` → target already achieved; **0 more coins** needed, regardless of n. Check this FIRST.
- `n == 0 (sum > 0)` → no coin types left but sum still > 0; this path is impossible → return **INF-1** (a sentinel for "impossible").
- Why `INF - 1` instead of `-1`? Because the caller does `1 + solve(...)`. If we returned `-1`, `1 + (-1) = 0` would be wrongly treated as a valid answer. `INF - 1` stays large even after `+1`.

**Base Case:**
```
sum == 0           →  return 0          (no coins needed)
n == 0 (sum > 0)   →  return INF-1      (impossible path)
```

**Recursive Choice:**
```java
if (coins[n-1] <= sum)
    return Math.min(1 + solve(sum - coins[n-1], n),   // include → KEEP n
                        solve(sum, n-1));               // exclude
else
    return solve(sum, n-1);
```

**Final answer check:** `result >= INF-1 → return -1`

**Memoization table init:**
- `dp[0][0] = 0`, `dp[0][j>0] = INF-1`, `dp[i][0] = 0`, rest = `-1`

**Tabulation:**
```java
// Base: dp[i][0] = 0, dp[0][j>0] = INF-1
if (coins[i-1] <= j)
    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
else
    dp[i][j] = dp[i-1][j];
// Answer: dp[n][sum] >= INF-1 ? -1 : dp[n][sum]
```

**1D Optimized:**
```java
int[] dp = new int[sum + 1];
Arrays.fill(dp, Integer.MAX_VALUE);
dp[0] = 0;
for (int coin : coins)
    for (int j = coin; j <= sum; j++)
        if (dp[j - coin] != Integer.MAX_VALUE)
            dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
// Answer: dp[sum] == MAX_VALUE ? -1 : dp[sum]
```

**Combine rule:** `min(include, exclude)` — minimization.

---

## 🔑 Unbounded vs 0-1 Summary

```
0-1 Knapsack recursive include:  solve(w - wt[n-1], n-1)  ← n decreases
Unbounded recursive include:     solve(w - wt[n-1], n)    ← n stays same

0-1 Tabulation include:  dp[i-1][j - wt[i-1]]  ← row i-1 (previous item)
Unbounded Tabulation:    dp[i][j - wt[i-1]]    ← row i   (same item again)
```

