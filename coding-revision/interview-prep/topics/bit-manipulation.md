# Bit Manipulation

## Java bit ops

| Op | Java | Note |
|---|---|---|
| AND | `a & b` | |
| OR | `a \| b` | |
| XOR | `a ^ b` | a^a=0, a^0=a |
| NOT | `~a` | flips all bits |
| Left shift | `a << k` | × 2^k |
| Right shift (arith) | `a >> k` | keeps sign |
| Right shift (logical) | `a >>> k` | fills 0 |

## Bit tricks
```java
int lowbit = x & (-x);           // isolate lowest set bit
boolean isPow2 = (x > 0) && ((x & (x-1)) == 0);
int popcount = Integer.bitCount(x);
int n0 = Integer.numberOfTrailingZeros(x);
int hb = Integer.highestOneBit(x);

x |= (1 << i);   // set bit i
x &= ~(1 << i);  // clear bit i
x ^= (1 << i);   // toggle bit i
boolean isSet = (x & (1 << i)) != 0;

// Iterate every subset of mask
for (int s = mask; s > 0; s = (s - 1) & mask) { ... }
```

## When to use
- "Single number" / "appears once" → XOR
- Sets up to 20 elements → bitmask
- Bitmask DP (TSP, partition)
- Power-of-two checks

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|------|
| 136 |[Single Number](https://leetcode.com/problems/single-number/) | [ ]  |
| 191 |[Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/) | [ ]  |
| 190 |[Reverse Bits](https://leetcode.com/problems/reverse-bits/) | [ ]  |
| 231 |[Power of Two](https://leetcode.com/problems/power-of-two/) | [ ]  |
| 268 |[Missing Number](https://leetcode.com/problems/missing-number/) | [ ]  |
| 338 |[Counting Bits](https://leetcode.com/problems/counting-bits/) | [ ]  |
| 342 |[Power of Four](https://leetcode.com/problems/power-of-four/) | [ ]  |
| 389 |[Find the Difference](https://leetcode.com/problems/find-the-difference/) | [ ]  |
| 401 |[Binary Watch](https://leetcode.com/problems/binary-watch/) | [ ]  |
| 461 |[Hamming Distance](https://leetcode.com/problems/hamming-distance/) | [ ]  |
| 476 |[Number Complement](https://leetcode.com/problems/number-complement/) | [ ]  |
| 693 |[Binary Number Alternating Bits](https://leetcode.com/problems/binary-number-with-alternating-bits/) | [ ]  |
| 762 |[Prime Number of Set Bits](https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/) | [ ]  |
| 1009 |[Complement of Base 10 Integer](https://leetcode.com/problems/complement-of-base-10-integer/) | [ ]  |
| 1486 |[XOR Operation in an Array](https://leetcode.com/problems/xor-operation-in-an-array/) | [ ]  |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 78 |[Subsets](https://leetcode.com/problems/subsets/) | [ ] |
| 137 |[Single Number II](https://leetcode.com/problems/single-number-ii/) | [ ] |
| 187 |[Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/) | [ ] |
| 201 |[Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/) | [ ] |
| 260 |[Single Number III](https://leetcode.com/problems/single-number-iii/) | [ ] |
| 318 |[Maximum Product Word Lengths](https://leetcode.com/problems/maximum-product-of-word-lengths/) | [ ] |
| 371 |[Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/) | [ ] |
| 421 |[Maximum XOR of Two Numbers](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) | [ ] |
| 477 |[Total Hamming Distance](https://leetcode.com/problems/total-hamming-distance/) | [ ] |
| 540 |[Single Element in Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/) | [ ] |
| 784 |[Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation/) | [ ] |
| 1239 |[Max Length Concat Unique](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/) | [ ] |
| 1442 |[Count Triplets XOR](https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/) | [ ] |
| 1310 |[XOR Queries](https://leetcode.com/problems/xor-queries-of-a-subarray/) | [ ] |
| 1404 |[Steps to Reduce Binary to 1](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 982 |[Triples With Bitwise AND = 0](https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/) | [ ] |
| 1125 |[Smallest Sufficient Team](https://leetcode.com/problems/smallest-sufficient-team/) | [ ] |
| 1255 |[Max Score Words Formed by Letters](https://leetcode.com/problems/maximum-score-words-formed-by-letters/) | [ ] |
| 1434 |[Number of Ways Wear Hats](https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/) | [ ] |
| 1542 |[Find Longest Awesome Substring](https://leetcode.com/problems/find-longest-awesome-substring/) | [ ] |
| 1601 |[Max Achievable Transfer Requests](https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/) | [ ] |
| 1659 |[Max Grid Happiness](https://leetcode.com/problems/maximum-grid-happiness/) | [ ] |
| 1707 |[Maximum XOR With Element](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/) | [ ] |
| 1803 |[Count Pairs With XOR in Range](https://leetcode.com/problems/count-pairs-with-xor-in-a-range/) | [ ] |
| 1879 |[Min XOR Sum of Two Arrays](https://leetcode.com/problems/minimum-xor-sum-of-two-arrays/) | [ ] |
| 1986 |[Min Number of Work Sessions to Finish Tasks](https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/) | [ ] |
| 2002 |[Max Product of Two Palindromic Subseqs](https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/) | [ ] |
| 2151 |[Max Good People Based on Statements](https://leetcode.com/problems/maximum-good-people-based-on-statements/) | [ ] |
| 2305 |[Fair Distribution of Cookies](https://leetcode.com/problems/fair-distribution-of-cookies/) | [ ] |
| 2741 |[Special Permutations](https://leetcode.com/problems/special-permutations/) | [ ] |

