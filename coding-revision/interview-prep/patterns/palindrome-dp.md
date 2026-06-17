# Pattern: Palindrome DP

## Signal phrases
- "Longest palindromic substring / subsequence"
- "Min insertions / deletions to make palindrome"
- "Count palindromic substrings"
- "Palindrome partitioning"

## Substring DP

```java
boolean[][] dp = new boolean[n][n];
for (int i = n-1; i >= 0; i--)
    for (int j = i; j < n; j++)
        dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<2 || dp[i+1][j-1]);
```

## Subsequence DP

```java
int[][] dp = new int[n][n];
for (int i = n-1; i >= 0; i--) {
    dp[i][i] = 1;
    for (int j = i+1; j < n; j++)
        dp[i][j] = s.charAt(i)==s.charAt(j)
            ? dp[i+1][j-1] + 2
            : Math.max(dp[i+1][j], dp[i][j-1]);
}
return dp[0][n-1];
```

## Expand around center — O(n²)
Two cases: odd length (center = i), even length (center = i, i+1).

## Problems

| # | Problem | Done |
|---|---|---|
| 5 |[Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | [ ] |
| 9 |[Palindrome Number](https://leetcode.com/problems/palindrome-number/) | [ ] |
| 125 |[Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | [ ] |
| 131 |[Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) | [ ] |
| 132 |[Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/) | [ ] |
| 214 |[Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/) | [ ] |
| 266 |[Palindrome Permutation](https://leetcode.com/problems/palindrome-permutation/) | [ ] |
| 336 |[Palindrome Pairs](https://leetcode.com/problems/palindrome-pairs/) | [ ] |
| 516 |[Longest Palindromic Subseq](https://leetcode.com/problems/longest-palindromic-subsequence/) | [ ] |
| 647 |[Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/) | [ ] |
| 680 |[Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/) | [ ] |
| 730 |[Count Different Palindromic Subseqs](https://leetcode.com/problems/count-different-palindromic-subsequences/) | [ ] |
| 1216 |[Valid Palindrome III](https://leetcode.com/problems/valid-palindrome-iii/) | [ ] |
| 1312 |[Min Insertions for Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/) | [ ] |
| 1745 |[Palindrome Partitioning IV](https://leetcode.com/problems/palindrome-partitioning-iv/) | [ ] |
