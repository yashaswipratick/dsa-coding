# DP — Longest Common Subsequence (LCS) Family Cheatsheet

> **Pattern:** Two strings → two params `n`, `m` → `dp[n+1][m+1]`
> **When chars match:** consume both (diagonal).
> **When chars don't match:** move one pointer, take best.

---

## 🔑 LCS Core Pattern

```
Base:   n==0 || m==0 → 0
Match:  1 + solve(n-1, m-1)
No match: max(solve(n, m-1), solve(n-1, m))
Combine: max — optimization
```

---

## 1. Longest Common Subsequence (LCS)
**File:** `LongestCommonSubsequence.java`
**Link:** https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1

**Problem:** Longest subsequence common to both strings (not necessarily contiguous).

**Why this base case:**
- `n == 0` → s1 is exhausted; nothing left to match → LCS = 0.
- `m == 0` → s2 is exhausted; same reason → LCS = 0.
- One empty string can share nothing with the other.

**Base Case:** `n == 0 || m == 0  →  return 0`

**Recursive Choice:**
```java
if (s1.charAt(n-1) == s2.charAt(m-1))
    return 1 + solve(n-1, m-1);
else
    return Math.max(solve(n, m-1), solve(n-1, m));
```

**Tabulation:**
```java
if (s1.charAt(i-1) == s2.charAt(j-1))
    dp[i][j] = 1 + dp[i-1][j-1];
else
    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
// Base: dp[0][*] = dp[*][0] = 0
// Answer: dp[n][m]
```

---

## 2. Print LCS String
**File:** `PrintLongestCommonSubsequence.java`

**Problem:** Return the actual LCS string (not just the length).

**Key Insight:** Recurse like LCS but return string instead of int. When match → prepend char. When no match → take the longer branch. Result built backwards → reverse at end.

**Recursive:**
```java
// Why "" as base: n==0 or m==0 means one string is empty → no common chars → empty string LCS
if (n == 0 || m == 0) return "";
if (s1.charAt(n-1) == s2.charAt(m-1))
    return s1.charAt(n-1) + lcsHelper(n-1, m-1);   // prepend char
else {
    String a = lcsHelper(n-1, m);
    String b = lcsHelper(n, m-1);
    return a.length() > b.length() ? a : b;
}
// Then reverse the result in caller
```

**Memoization:** `String[n+1][m+1]`
- `dp[0][*] = dp[*][0] = ""`; rest = `null`
- Why `""` for base cells: an empty string is the correct LCS when one input is empty — same logic as numeric base case returning 0.
- Check: `if (dp[n][m] != null) return dp[n][m]`

---

## 3. Longest Common Substring
**File:** `LongestCommonSubstring.java`
**Link:** https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

**Key Difference from LCS:** Must be **contiguous**. When chars don't match → **reset to 0** (not propagate).

**Why this base case:**
- `n == 0 || m == 0` → one string is empty; no contiguous overlap possible → 0.
- Same as LCS, but here "streak is broken" at every mismatch (dp resets to 0 in that cell).

**Base Case:** `n == 0 || m == 0  →  return 0`

**Tabulation (preferred — recursive is tricky):**
```java
if (s1.charAt(i-1) == s2.charAt(j-1))
    dp[i][j] = 1 + dp[i-1][j-1];   // extend streak
else
    dp[i][j] = 0;                   // RESET streak (not max like LCS!)
maxLen = Math.max(maxLen, dp[i][j]);
// ⚠️ Answer is maxLen tracked separately, NOT dp[n][m]
```

**Why not dp[n][m]:** The longest streak may end before `(n,m)`. You must track it globally.

---

## 4. Longest Repeating Subsequence
**File:** `LongestRepeatingSubsequence.java`
**Link:** https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

**Problem:** Longest subsequence that appears at least twice in the string (positions must differ).

**Key Insight:** LCS(s, s) but char at index `i` can only match char at index `j` if `i != j`.

**Why this base case:**
- `n == 0 || m == 0` → one pointer exhausted → no repeating subsequence possible → 0.
- Same as standard LCS — we're running LCS on the string with itself, so the base is identical.
- **copy s1 into new String s2 = s1**
- post this step the code is same as LCS only change is when string matches we need to check if the indices are not same to avoid duplicates

**Recursive Choice:**
```java
if (s1.charAt(n-1) == s2.charAt(m-1) && (n-1 != m-1))   // ← extra condition!
    return 1 + solve(n-1, m-1);
else
    return Math.max(solve(n, m-1), solve(n-1, m));
```

**Tabulation:**
```java
if (s1.charAt(i-1) == s2.charAt(j-1) && (i-1 != j-1))   // ← same indices not allowed
    dp[i][j] = 1 + dp[i-1][j-1];
else
    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
// Answer: dp[n][n]  (s2 = s1, same length)
```

---

## 5. Longest Palindromic Subsequence
**File:** `LongestPalindromicSubsequence.java`

**Problem:** Longest subsequence of `s` that is a palindrome.

**Key Insight:**
```java
// A palindromic subsequence = common subsequence of s and its reverse
return lcs(s, new StringBuilder(s).reverse().toString());
```

**No new code needed — just call LCS.**

---

## 6. Minimum Deletions to Make Palindrome
**File:** `MinimumDeletionsInStringToMakeLongestPalindromicSubsequence.java`
**Link:** https://www.geeksforgeeks.org/problems/minimum-deletitions1648/1

**Problem:** Minimum deletions to make string a palindrome.

**Key Insight:** Keep the longest palindromic subsequence; delete the rest.
```
min deletions = n - LongestPalindromicSubsequence(s)
              = n - LCS(s, reverse(s))
```

---

## 7. Minimum Insertions / Deletions to Convert s1 → s2
**File:** `MinimumInsertAndDelete.java`

**Problem:** Min insertions + deletions to convert `s1` to `s2`.

**Key Insight:** Keep LCS (it's already correct). Delete what's in s1 but not LCS. Insert what's in s2 but not LCS.
```
deletions = s1.length() - LCS(s1, s2)
insertions = s2.length() - LCS(s1, s2)
```

---

## 8. Minimum Insertions to Make Palindrome
**File:** `MinimumInsertionsInStringToMakeLongestPalindromicSubsequence.java`

**Key Insight:**
```
min insertions = n - LongestPalindromicSubsequence(s)
```
(Mirror the string around the LPS; characters outside LPS need an insertion.)

---

## 9. Sequence Pattern Matching
**File:** `SequencePatternMatching.java`

**Problem:** Is `s1` a subsequence of `s2`?

**Key Insight:**
```java
return lcs(s1, s2) == s1.length();
// s1 is subsequence of s2 iff their LCS equals all of s1
```

---

## 🔑 LCS Family Quick Map

| Problem | Approach | Answer |
|---------|----------|--------|
| LCS length | Standard LCS | `dp[n][m]` |
| Print LCS string | Return string not int | reversed string |
| Longest Common Substring | Reset to 0 on mismatch | `maxLen` tracked separately |
| Longest Repeating Subseq | LCS(s,s) with `i≠j` guard | `dp[n][n]` |
| Longest Palindromic Subseq | LCS(s, reverse(s)) | `dp[n][n]` |
| Min Deletions → Palindrome | `n - LPS` | direct formula |
| Min Insert+Delete s1→s2 | `n1 - LCS` + `n2 - LCS` | direct formula |
| Min Insertions → Palindrome | `n - LPS` | direct formula |
| Pattern Matching | `LCS == s1.length()` | boolean |

---

## 🔑 LCS Tabulation Template

```java
int[][] dp = new int[n+1][m+1];
// Base: dp[0][*] = dp[*][0] = 0 (Java default int = 0, no explicit init needed)

for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
        if (s1.charAt(i-1) == s2.charAt(j-1))
            dp[i][j] = 1 + dp[i-1][j-1];
        else
            dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
    }
}
return dp[n][m];
```

