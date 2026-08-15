package com.coding.topics.dp.longest_common_subsequence;


//PL - https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
public class LongestPalindromicSubsequence {

    /**
     * Reverse the given string and store it in reverse variable.
     * Now you have two string one is actual and one is reversed.
     * In lcs concept also you need two string to find lcs.
     * here use lcs logic and get the output.
     * @param s
     * @return
     */
    private static int longestPalinSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        //return longestPalinSubseqHelper(s, reversed, s.length(), reversed.length());

        //memoization
        int[][] dp = new int[s.length()+1][reversed.length()+1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= reversed.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        return longestPalinSubseqHelperMemoization(s, reversed, s.length(), reversed.length(), dp);
    }

    private static int longestPalinSubseqHelperMemoization(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            dp[n][m] =  1+ longestPalinSubseqHelperMemoization(s1, s2, n-1, m-1, dp);
        } else {
            dp[n][m] = Math.max(longestPalinSubseqHelperMemoization(s1, s2, n-1, m, dp), longestPalinSubseqHelperMemoization(s1, s2, n, m-1, dp));
        }
        return dp[n][m];
    }

    private static int longestPalinSubseqHelper(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) return 0;

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + longestPalinSubseqHelper(s1, s2, n - 1, m-1);
        } else {
            return Math.max(longestPalinSubseqHelper(s1, s2, n - 1, m), longestPalinSubseqHelper(s1, s2, n, m - 1));
        }
    }

    private static int longestPalinSubseqTopDown(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[s.length()+1][reversed.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= reversed.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= reversed.length(); j++) {
                if (s.charAt(i-1) == reversed.charAt(j-1)) {
                    dp[i][j] =  1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s.length()][reversed.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestPalinSubseq("bbabcbcab"));
        System.out.println(longestPalinSubseq("abcd"));
        System.out.println(longestPalinSubseq("agbdba"));

        System.out.println(longestPalinSubseqTopDown("bbabcbcab"));
        System.out.println(longestPalinSubseqTopDown("abcd"));
        System.out.println(longestPalinSubseqTopDown("agbdba"));
    }
}
