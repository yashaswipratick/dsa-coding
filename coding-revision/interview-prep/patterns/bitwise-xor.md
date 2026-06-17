# Pattern: Bitwise XOR

## Key facts
- `a ^ a = 0`
- `a ^ 0 = a`
- XOR is commutative & associative
- `x & (-x)` isolates lowest set bit

## Signal phrases
- "Single number among duplicates"
- "Missing number"
- "Two single numbers"
- "Max XOR pair"

## Templates

```java
// Single Number (one unique, rest pair)
int x = 0;
for (int v : a) x ^= v;
return x;

// Two singles (#260) — split using a set bit of x_ab
int xab = 0;
for (int v : a) xab ^= v;
int bit = xab & -xab;
int x = 0, y = 0;
for (int v : a) if ((v & bit) == 0) x ^= v; else y ^= v;
```

## Problems

| # | Problem | Done |
|---|---|---|
| 136 |[Single Number](https://leetcode.com/problems/single-number/) | [ ] |
| 137 |[Single Number II](https://leetcode.com/problems/single-number-ii/) | [ ] |
| 260 |[Single Number III](https://leetcode.com/problems/single-number-iii/) | [ ] |
| 268 |[Missing Number](https://leetcode.com/problems/missing-number/) | [ ] |
| 389 |[Find the Difference](https://leetcode.com/problems/find-the-difference/) | [ ] |
| 421 |[Maximum XOR of Two Numbers](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) | [ ] |
| 1310 |[XOR Queries](https://leetcode.com/problems/xor-queries-of-a-subarray/) | [ ] |
| 1442 |[Count Triplets XOR](https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/) | [ ] |
| 1707 |[Maximum XOR With Element](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/) | [ ] |
| 1803 |[Count Pairs With XOR in Range](https://leetcode.com/problems/count-pairs-with-xor-in-a-range/) | [ ] |

Full list in **topics/bit-manipulation.md**.
