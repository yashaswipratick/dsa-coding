# Math & Number Theory

## Must-know
- **GCD** (Euclid): `gcd(a,b) = gcd(b, a%b)`; LCM = `a/gcd * b`
- **Modular arithmetic**: `(a + b) % m`, `(a * b) % m` use `long` to avoid overflow.
- **Modular exponentiation** (fast power):
  ```java
  long pow(long b, long e, long m) {
      long r = 1; b %= m;
      while (e > 0) { if ((e&1)==1) r = r*b%m; b = b*b%m; e >>= 1; }
      return r;
  }
  ```
- **Sieve of Eratosthenes** for primes up to n: O(n log log n).
- **Modular inverse** (prime m): `pow(a, m-2, m)` (Fermat).
- **nCr % p**: precompute factorials + inverses.

## Patterns
1. **Math formula** — derive closed form (sum 1..n)
2. **Catalan numbers** — # of valid BSTs, parens, paths
3. **Combinations / permutations**
4. **Convert bases** (atoi, integer to roman)
5. **Geometry** — points, lines, polygons
6. **Reservoir sampling**

## Pitfalls
- `Math.abs(Integer.MIN_VALUE)` returns negative.
- `int * int` overflows at ~2.1B — cast to `long`.
- Modulo with negatives: `((x % m) + m) % m`.
- Float comparison: use epsilon (1e-9).

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 7 |[Reverse Integer](https://leetcode.com/problems/reverse-integer/) | [ ] |
| 9 |[Palindrome Number](https://leetcode.com/problems/palindrome-number/) | [ ] |
| 13 |[Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | [ ] |
| 66 |[Plus One](https://leetcode.com/problems/plus-one/) | [ ] |
| 67 |[Add Binary](https://leetcode.com/problems/add-binary/) | [ ] |
| 69 |[Sqrt(x)](https://leetcode.com/problems/sqrtx/) | [ ] |
| 168 |[Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/) | [ ] |
| 171 |[Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/) | [ ] |
| 172 |[Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes/) | [ ] |
| 202 |[Happy Number](https://leetcode.com/problems/happy-number/) | [ ] |
| 204 |[Count Primes](https://leetcode.com/problems/count-primes/) | [ ] |
| 263 |[Ugly Number](https://leetcode.com/problems/ugly-number/) | [ ] |
| 326 |[Power of Three](https://leetcode.com/problems/power-of-three/) | [ ] |
| 415 |[Add Strings](https://leetcode.com/problems/add-strings/) | [ ] |
| 1232 |[Check Straight Line](https://leetcode.com/problems/check-if-it-is-a-straight-line/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 8 |[String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/) | [ ] |
| 12 |[Integer to Roman](https://leetcode.com/problems/integer-to-roman/) | [ ] |
| 29 |[Divide Two Integers](https://leetcode.com/problems/divide-two-integers/) | [ ] |
| 43 |[Multiply Strings](https://leetcode.com/problems/multiply-strings/) | [ ] |
| 50 |[Pow(x, n)](https://leetcode.com/problems/powx-n/) | [ ] |
| 60 |[Permutation Sequence](https://leetcode.com/problems/permutation-sequence/) | [ ] |
| 96 |[Unique BSTs (Catalan)](https://leetcode.com/problems/unique-binary-search-trees/) | [ ] |
| 166 |[Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/) | [ ] |
| 365 |[Water and Jug Problem](https://leetcode.com/problems/water-and-jug-problem/) | [ ] |
| 372 |[Super Pow](https://leetcode.com/problems/super-pow/) | [ ] |
| 384 |[Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/) | [ ] |
| 398 |[Random Pick Index (reservoir)](https://leetcode.com/problems/random-pick-index/) | [ ] |
| 470 |[Implement Rand10](https://leetcode.com/problems/implement-rand10-using-rand7/) | [ ] |
| 539 |[Min Time Difference](https://leetcode.com/problems/minimum-time-difference/) | [ ] |
| 1006 |[Clumsy Factorial](https://leetcode.com/problems/clumsy-factorial/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 149 |[Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/) | [ ] |
| 224 |[Basic Calculator](https://leetcode.com/problems/basic-calculator/) | [ ] |
| 233 |[Number of Digit One](https://leetcode.com/problems/number-of-digit-one/) | [ ] |
| 273 |[Integer to English Words](https://leetcode.com/problems/integer-to-english-words/) | [ ] |
| 296 |[Best Meeting Point](https://leetcode.com/problems/best-meeting-point/) | [ ] |
| 391 |[Perfect Rectangle](https://leetcode.com/problems/perfect-rectangle/) | [ ] |
| 458 |[Poor Pigs](https://leetcode.com/problems/poor-pigs/) | [ ] |
| 587 |[Erect the Fence (convex hull)](https://leetcode.com/problems/erect-the-fence/) | [ ] |
| 829 |[Consecutive Numbers Sum](https://leetcode.com/problems/consecutive-numbers-sum/) | [ ] |
| 891 |[Sum of Subseq Widths](https://leetcode.com/problems/sum-of-subsequence-widths/) | [ ] |
| 902 |[Numbers At Most N Given Digit Set](https://leetcode.com/problems/numbers-at-most-n-given-digit-set/) | [ ] |
| 952 |[Largest Component Size by Common Factor](https://leetcode.com/problems/largest-component-size-by-common-factor/) | [ ] |
| 753 |[Cracking the Safe](https://leetcode.com/problems/cracking-the-safe/) | [ ] |
| 932 |[Beautiful Array](https://leetcode.com/problems/beautiful-array/) | [ ] |
| 770 |[Basic Calculator IV](https://leetcode.com/problems/basic-calculator-iv/) | [ ] |

