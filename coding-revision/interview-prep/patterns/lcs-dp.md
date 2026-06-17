# Pattern: LCS-style 2-D String DP

## Signal phrases
- "Longest common subsequence / substring"
- "Edit distance"
- "Distinct subsequences"
- "Interleaving string"
- "Min ASCII delete sum"

## Template

```java
int[][] dp = new int[m+1][n+1];
for (int i = 1; i <= m; i++)
    for (int j = 1; j <= n; j++)
        dp[i][j] = a.charAt(i-1) == b.charAt(j-1)
            ? dp[i-1][j-1] + 1
            : Math.max(dp[i-1][j], dp[i][j-1]);
return dp[m][n];
```

## Edit distance

```java
dp[i][j] = a.charAt(i-1) == b.charAt(j-1)
    ? dp[i-1][j-1]
    : 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
```

## Problems

| # | Problem | Done |
|---|---|---|
| 72 |[Edit Distance](https://leetcode.com/problems/edit-distance/) | [ ] |
| 97 |[Interleaving String](https://leetcode.com/problems/interleaving-string/) | [ ] |
| 115 |[Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) | [ ] |
| 583 |[Delete Op for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/) | [ ] |
| 712 |[Min ASCII Delete Sum](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/) | [ ] |
| 1035 |[Uncrossed Lines](https://leetcode.com/problems/uncrossed-lines/) | [ ] |
| 1143 |[Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | [ ] |
| 1312 |[Min Insertions to Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/) | [ ] |
| 718 |[Max Length of Repeated Subarray](https://leetcode.com/problems/maximum-length-of-repeated-subarray/) | [ ] |
| 392 |[Is Subsequence](https://leetcode.com/problems/is-subsequence/) | [ ] |
