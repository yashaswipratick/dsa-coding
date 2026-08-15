package com.coding.topics.dp.longest_common_subsequence;

// PL - https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
public class LongestCommonSubstring {

    // Recursive version — same mental model as tabulation.
    // helper(n, m) = length of common substring ENDING at s1[n-1] and s2[m-1].
    // On mismatch → 0 (streak breaks), exactly like dp[i][j] = 0 in tabulation.
    // We call helper for every (i, j) pair and track global max — same as nested loops in tabulation.
    public static int longCommSubstr(String s1, String s2) {
        int maxLen = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                maxLen = Math.max(maxLen, longCommSubstrHelper(s1, s2, i, j));
            }
        }
        return maxLen;
    }

    // Returns length of common substring ending at s1[n-1] and s2[m-1].
    // Match  → 1 + diagonal
    // Mismatch → 0  (current streak ends here)
    private static int longCommSubstrHelper(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) return 0;

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + longCommSubstrHelper(s1, s2, n - 1, m - 1);
        } else {
            return 0;
        }
    }

    public static int longCommSubstrTopDown(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Recursive (same pattern as tabulation)
        System.out.println(longCommSubstr("ABCDGH", "ACDGHR"));             // 4
        System.out.println(longCommSubstr("jqvdtcfzugvyk", "xvnuyjqvdtcfzyy")); // 8
        System.out.println(longCommSubstr("abc", "acb"));                   // 1
        System.out.println(longCommSubstr("YZ", "yz"));                     // 0

        // Tabulation
        System.out.println(longCommSubstrTopDown("ABCDGH", "ACDGHR"));             // 4
        System.out.println(longCommSubstrTopDown("jqvdtcfzugvyk", "xvnuyjqvdtcfzyy")); // 8
        System.out.println(longCommSubstrTopDown("abc", "acb"));                   // 1
        System.out.println(longCommSubstrTopDown("YZ", "yz"));                     // 0
    }
}
