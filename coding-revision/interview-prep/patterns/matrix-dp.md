# Pattern: Matrix DP (Grid)

## Signal phrases
- "Unique paths in grid"
- "Min path sum"
- "Dungeon game"
- "Max square / rectangle of 1s"

## Template

```java
int[][] dp = new int[m][n];
dp[0][0] = grid[0][0];
for (int i = 1; i < m; i++) dp[i][0] = dp[i-1][0] + grid[i][0];
for (int j = 1; j < n; j++) dp[0][j] = dp[0][j-1] + grid[0][j];
for (int i = 1; i < m; i++)
    for (int j = 1; j < n; j++)
        dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
```

## Dungeon-style (work backward from bottom-right)

```java
for (int i = m-1; i >= 0; i--)
    for (int j = n-1; j >= 0; j--) {
        int need = Math.min(down, right) - grid[i][j];
        dp[i][j] = Math.max(1, need);
    }
```

## Problems

| # | Problem | Done |
|---|---|---|
| 62 |[Unique Paths](https://leetcode.com/problems/unique-paths/) | [ ] |
| 63 |[Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) | [ ] |
| 64 |[Min Path Sum](https://leetcode.com/problems/minimum-path-sum/) | [ ] |
| 120 |[Triangle](https://leetcode.com/problems/triangle/) | [ ] |
| 174 |[Dungeon Game](https://leetcode.com/problems/dungeon-game/) | [ ] |
| 221 |[Maximal Square](https://leetcode.com/problems/maximal-square/) | [ ] |
| 304 |[Range Sum Query 2D](https://leetcode.com/problems/range-sum-query-2d-immutable/) | [ ] |
| 329 |[Longest Increasing Path Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | [ ] |
| 542 |[01 Matrix](https://leetcode.com/problems/01-matrix/) | [ ] |
| 931 |[Min Falling Path Sum](https://leetcode.com/problems/minimum-falling-path-sum/) | [ ] |
| 980 |[Unique Paths III](https://leetcode.com/problems/unique-paths-iii/) | [ ] |
| 1289 |[Min Falling Path Sum II](https://leetcode.com/problems/minimum-falling-path-sum-ii/) | [ ] |
| 1463 |[Cherry Pickup II](https://leetcode.com/problems/cherry-pickup-ii/) | [ ] |
