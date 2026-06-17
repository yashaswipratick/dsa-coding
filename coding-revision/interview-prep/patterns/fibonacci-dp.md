# Pattern: Fibonacci-style 1-D DP

## Signal phrases
- "Climbing stairs" / "N-th tribonacci"
- "House robber" (pick or skip)
- "Decode ways"
- "Min cost to reach top"

## Template

```java
int dp_prev2 = base0, dp_prev1 = base1;
for (int i = 2; i <= n; i++) {
    int dp_i = f(dp_prev1, dp_prev2);
    dp_prev2 = dp_prev1; dp_prev1 = dp_i;
}
return dp_prev1;
```

## Problems

| # | Problem | Done |
|---|---|---|
| 70 |[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | [ ] |
| 509 |[Fibonacci](https://leetcode.com/problems/fibonacci-number/) | [ ] |
| 746 |[Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/) | [ ] |
| 198 |[House Robber](https://leetcode.com/problems/house-robber/) | [ ] |
| 213 |[House Robber II](https://leetcode.com/problems/house-robber-ii/) | [ ] |
| 337 |[House Robber III](https://leetcode.com/problems/house-robber-iii/) | [ ] |
| 91 |[Decode Ways](https://leetcode.com/problems/decode-ways/) | [ ] |
| 1137 |[N-th Tribonacci](https://leetcode.com/problems/n-th-tribonacci-number/) | [ ] |
| 740 |[Delete and Earn](https://leetcode.com/problems/delete-and-earn/) | [ ] |
| 790 |[Domino and Tromino Tiling](https://leetcode.com/problems/domino-and-tromino-tiling/) | [ ] |
