package com.coding.topics.dp.longest_common_subsequence;

// PL - https://leetcode.com/problems/is-subsequence/description/
public class SequencePatternMatching {

    private static boolean isSubsequence(String s1, String s2) {

        /*int subsequenceHelperLen = isSubsequenceHelper(s1, s2, s1.length(), s2.length());
        if (subsequenceHelperLen == s1.length()) return true;*/

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        int subsequenceHelperMemoization = isSubsequenceHelperMemoization(s1, s2, s1.length(), s2.length(), dp);
        if (subsequenceHelperMemoization == s1.length()) {
            return true;
        }
        return false;
    }

    private static int isSubsequenceHelper(String s1, String s2, int n, int m) {
        //Base case
        if (n == 0 || m == 0) return 0;

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return 1 + isSubsequenceHelper(s1, s2, n-1, m-1);
        } else {
            return Math.max(isSubsequenceHelper(s1, s2, n, m-1), isSubsequenceHelper(s1, s2, n-1, m));
        }
    }

    private static int isSubsequenceHelperMemoization(String s1, String s2, int n, int m, int[][] dp) {
        //Base case
        if (n == 0 || m == 0) return 0;


        if (dp[n][m] != -1) return dp[n][m];

        //choices
        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            dp[n][m] =  1 + isSubsequenceHelperMemoization(s1, s2, n-1, m-1, dp);
        } else {
            dp[n][m] = Math.max(isSubsequenceHelperMemoization(s1, s2, n, m-1, dp), isSubsequenceHelperMemoization(s1, s2, n-1, m, dp));
        }
        return dp[n][m];
    }

    private static boolean isSubsequenceHelperTopDown(String s1, String s2) {
        //Base case
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }  else {
                    dp[i][j] = -1;
                }
            }
        }

        //choices
        //replace n with i
        //replace m with j

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] =  1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int len = dp[s1.length()][s2.length()];
        return len == s1.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // Output: 4
        System.out.println(isSubsequence("axc", "ahbgdc")); // Output: 3

        System.out.println(isSubsequenceHelperTopDown("abc", "ahbgdc")); // Output: 4
        System.out.println(isSubsequenceHelperTopDown("axc", "ahbgdc")); // Output: 3
    }
}
