# Dynamic Programming

The "boss-level" topic. Don't fear it — follow a checklist.

## DP Diagnostic Checklist
1. **Optimal substructure?** Can answer be built from smaller answers?
2. **Overlapping subproblems?**
3. **State definition** — minimum info that uniquely identifies a sub-problem.
4. **Transition** — recurrence.
5. **Base case(s).**
6. **Order** so each cell depends on already-computed cells.
7. **Space optimization** — often roll to 1-D or O(1).

## DP families

| Family | dp signature | Example |
|---|---|---|
| 1-D Fibonacci | dp[i] | Climbing Stairs, House Robber |
| 0/1 Knapsack | dp[i][w] / dp[w] | Partition Equal Subset Sum |
| Unbounded Knapsack | dp[amount] | Coin Change |
| LIS | dp[i] | Longest Increasing Subseq |
| LCS (2 strings) | dp[i][j] | Edit Distance, LCS |
| Palindrome | dp[i][j] | Longest Palindromic Subseq |
| Matrix path | dp[i][j] | Unique Paths, Min Path Sum |
| Interval DP | dp[i][j] | Burst Balloons |
| State-machine | dp[i][state] | Stock with cooldown |
| Bitmask DP | dp[mask] | TSP, Assign Tasks |
| Tree DP | dfs returns tuple | House Robber III |
| Digit DP | dp[pos][tight] | Count numbers ≤ N |

## Templates

```java
// 0/1 Knapsack (1-D)
boolean[] dp = new boolean[target + 1];
dp[0] = true;
for (int x : nums)
    for (int s = target; s >= x; s--)
        dp[s] |= dp[s - x];

// LCS
int[][] dp = new int[m+1][n+1];
for (int i=1;i<=m;i++) for (int j=1;j<=n;j++)
    dp[i][j] = a.charAt(i-1)==b.charAt(j-1)
        ? dp[i-1][j-1] + 1
        : Math.max(dp[i-1][j], dp[i][j-1]);

// Memoization (top-down)
Map<String,Integer> memo = new HashMap<>();
int solve(int i, int j) {
    String key = i + "," + j;
    if (memo.containsKey(key)) return memo.get(key);
    int ans = 0;
    memo.put(key, ans);
    return ans;
}
```

## Pitfalls
- Wrong iteration order.
- Memo key missing a parameter.
- 0/1: iterate inner loop **backwards**. Unbounded: forwards.
- Using `int` for counts that overflow → `long` or `% MOD`.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 53 |[Max Subarray](https://leetcode.com/problems/maximum-subarray/) | [ ] |
| 70 |[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | [ ] |
| 118 |[Pascals Triangle](https://leetcode.com/problems/pascals-triangle/) | [ ] |
| 119 |[Pascals Triangle II](https://leetcode.com/problems/pascals-triangle-ii/) | [ ] |
| 121 |[Buy Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | [ ] |
| 198 |[House Robber](https://leetcode.com/problems/house-robber/) | [ ] |
| 256 |[Paint House](https://leetcode.com/problems/paint-house/) | [ ] |
| 338 |[Counting Bits](https://leetcode.com/problems/counting-bits/) | [ ] |
| 392 |[Is Subsequence](https://leetcode.com/problems/is-subsequence/) | [ ] |
| 509 |[Fibonacci](https://leetcode.com/problems/fibonacci-number/) | [ ] |
| 746 |[Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/) | [ ] |
| 1025 |[Divisor Game](https://leetcode.com/problems/divisor-game/) | [ ] |
| 1137 |[N-th Tribonacci](https://leetcode.com/problems/n-th-tribonacci-number/) | [ ] |
| 1646 |[Get Max in Generated Array](https://leetcode.com/problems/get-maximum-in-generated-array/) | [ ] |
| 1869 |[Longer Contiguous Segment of Ones than Zeros](https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 5 |[Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | [ ] |
| 62 |[Unique Paths](https://leetcode.com/problems/unique-paths/) | [ ] |
| 63 |[Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) | [ ] |
| 64 |[Min Path Sum](https://leetcode.com/problems/minimum-path-sum/) | [ ] |
| 91 |[Decode Ways](https://leetcode.com/problems/decode-ways/) | [ ] |
| 139 |[Word Break](https://leetcode.com/problems/word-break/) | [ ] |
| 152 |[Max Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | [ ] |
| 213 |[House Robber II](https://leetcode.com/problems/house-robber-ii/) | [ ] |
| 264 |[Ugly Number II](https://leetcode.com/problems/ugly-number-ii/) | [ ] |
| 300 |[LIS](https://leetcode.com/problems/longest-increasing-subsequence/) | [ ] |
| 322 |[Coin Change](https://leetcode.com/problems/coin-change/) | [ ] |
| 416 |[Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | [ ] |
| 494 |[Target Sum](https://leetcode.com/problems/target-sum/) | [ ] |
| 516 |[Longest Palindromic Subseq](https://leetcode.com/problems/longest-palindromic-subsequence/) | [ ] |
| 518 |[Coin Change II](https://leetcode.com/problems/coin-change-ii/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 10 |[Regex Matching](https://leetcode.com/problems/regular-expression-matching/) | [ ] |
| 32 |[Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | [ ] |
| 44 |[Wildcard Matching](https://leetcode.com/problems/wildcard-matching/) | [ ] |
| 72 |[Edit Distance](https://leetcode.com/problems/edit-distance/) | [ ] |
| 97 |[Interleaving String](https://leetcode.com/problems/interleaving-string/) | [ ] |
| 115 |[Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) | [ ] |
| 123 |[Buy/Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | [ ] |
| 132 |[Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/) | [ ] |
| 174 |[Dungeon Game](https://leetcode.com/problems/dungeon-game/) | [ ] |
| 188 |[Buy/Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) | [ ] |
| 312 |[Burst Balloons](https://leetcode.com/problems/burst-balloons/) | [ ] |
| 354 |[Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/) | [ ] |
| 410 |[Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/) | [ ] |
| 446 |[Arithmetic Slices II](https://leetcode.com/problems/arithmetic-slices-ii-subsequence/) | [ ] |
| 887 |[Super Egg Drop](https://leetcode.com/problems/super-egg-drop/) | [ ] |

