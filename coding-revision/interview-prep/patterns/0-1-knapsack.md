# Pattern: 0/1 Knapsack DP

## Signal phrases
- "Pick or skip with capacity"
- "Subset sum = target"
- "Partition into equal subsets"
- "Target sum (assign + / −)"

## 2-D template

```java
boolean[][] dp = new boolean[n+1][target+1];
for (int i = 0; i <= n; i++) dp[i][0] = true;
for (int i = 1; i <= n; i++)
    for (int s = 1; s <= target; s++) {
        dp[i][s] = dp[i-1][s];
        if (s >= a[i-1]) dp[i][s] |= dp[i-1][s - a[i-1]];
    }
return dp[n][target];
```

## 1-D space-optimized

```java
boolean[] dp = new boolean[target + 1];
dp[0] = true;
for (int x : a)
    for (int s = target; s >= x; s--)   // iterate BACKWARD for 0/1
        dp[s] |= dp[s - x];
```

## Problems

| # | Problem | Done |
|---|---|---|
| 416 |[Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | [ ] |
| 494 |[Target Sum](https://leetcode.com/problems/target-sum/) | [ ] |
| 474 |[Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/) | [ ] |
| 879 |[Profitable Schemes](https://leetcode.com/problems/profitable-schemes/) | [ ] |
| 1049 |[Last Stone Weight II](https://leetcode.com/problems/last-stone-weight-ii/) | [ ] |
| 956 |[Tallest Billboard](https://leetcode.com/problems/tallest-billboard/) | [ ] |
| 1235 |[Max Profit in Job Scheduling](https://leetcode.com/problems/maximum-profit-in-job-scheduling/) | [ ] |
