package com.coding.topics.dp.longest_common_subsequence;

public class LongestCommonSubstring {

    public int longCommSubstr(String s1, String s2) {
        return longCommSubstrHelper(s1, s2, s1.length(), s2.length(), 0);
    }
    private static int longCommSubstrHelper(String s1, String s2, int n, int m, int count) {
        if (n == 0 || m == 0) return 0;

        int res = count;

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            res = longCommSubstrHelper(s1, s2, n-1, m-1, count + 1);
        } else {
            res = Math.max(res,
                    Math.max(longCommSubstrHelper(s1, s2, n, m-1, 0),
                            longCommSubstrHelper(s1, s2, n-1, m, 0)));
        }
        return res;
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
        System.out.println(longCommSubstrTopDown("ABCDGH", "ACDGHR")); // 4
        System.out.println(longCommSubstrTopDown("jqvdtcfzugvyk", "xvnuyjqvdtcfzyy")); // 8
    }
}
