# Pattern: Unbounded Knapsack DP

## Signal phrases
- "Coin change — infinite supply"
- "Min number of coins / ways to make amount"
- "Cut rod"
- "Word break"

## Template

```java
int[] dp = new int[amount + 1];
Arrays.fill(dp, amount + 1);
dp[0] = 0;
for (int s = 1; s <= amount; s++)
    for (int c : coins)
        if (s >= c) dp[s] = Math.min(dp[s], dp[s - c] + 1);
return dp[amount] > amount ? -1 : dp[amount];
```

## Count ways template

```java
int[] dp = new int[amount + 1];
dp[0] = 1;
for (int c : coins)               // OUTER: coin (avoids permutations)
    for (int s = c; s <= amount; s++) dp[s] += dp[s - c];
```

> 0/1: iterate s **backward**. Unbounded: iterate s **forward**.

## Problems

| # | Problem | Done |
|---|---|---|
| 322 |[Coin Change](https://leetcode.com/problems/coin-change/) | [ ] |
| 518 |[Coin Change II](https://leetcode.com/problems/coin-change-ii/) | [ ] |
| 377 |[Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/) | [ ] |
| 139 |[Word Break](https://leetcode.com/problems/word-break/) | [ ] |
| 140 |[Word Break II](https://leetcode.com/problems/word-break-ii/) | [ ] |
| 279 |[Perfect Squares](https://leetcode.com/problems/perfect-squares/) | [ ] |
| 983 |[Min Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/) | [ ] |
