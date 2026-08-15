package com.coding.topics.dp.longest_common_subsequence;

// PL - https://www.geeksforgeeks.org/dsa/printing-longest-common-subsequence/
// Refer LongestCommonSubsequence
public class PrintLongestCommonSubsequence {

    private static String lcs(String s1, String s2) {
        String s = lcsHelper(s1, s2, s1.length(), s2.length());
        //return new StringBuilder(s).reverse().toString();

        //memoization
        String[][] dp = new String[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = "";
                } else {
                    dp[i][j] = null;
                }
            }
        }
        String result = lscHelperMemoization(s1, s2, s1.length(), s2.length(), dp);
        return new StringBuilder(result).reverse().toString();
    }

    private static String lscTopDown(String s1, String s2) {
        String[][] dp = new String[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = "";
                } else {
                    dp[i][j] = null;
                }
            }
        }

        //replace n with i
        //replace m with j
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = s1.charAt(i-1) + dp[i-1][j-1];
                } else {
                    String a = dp[i-1][j];
                    String b = dp[i][j-1];
                    if (a.length() > b.length()) {
                        dp[i][j] = a;
                    } else {
                        dp[i][j] = b;
                    }
                }
            }
        }
        String s = dp[s1.length()][s2.length()];
        return new StringBuilder(s).reverse().toString();
    }

    private static String lscHelperMemoization(String s1, String s2, int n, int m, String[][] dp) {
        //BAse case
        if (n == 0 || m == 0) {
            return ""; // if bot the string is empty then empty sequence is valid answer
        }

        if (dp[n][m] != null) {
            return dp[n][m];
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            dp[n][m] = s1.charAt(n-1) + lscHelperMemoization(s1, s2, n-1, m-1, dp);
        } else {
            String a = lscHelperMemoization(s1, s2, n-1, m, dp);
            String b = lscHelperMemoization(s1, s2, n, m-1, dp);
            if (a.length() > b.length()) {
                dp[n][m] = a;
            } else {
                dp[n][m] = b;
            }
        }
        return dp[n][m];
    }

    private static String lcsHelper(String s1, String s2, int n, int m) {
        //Base case
        if (n == 0 || m == 0) return "";

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return s1.charAt(n-1) + lcsHelper(s1, s2, n-1, m-1);
        } else {
            String s = lcsHelper(s1, s2, n, m-1);
            String b = lcsHelper(s1, s2, n-1, m);
            if (s.length() > b.length()) {
                return s;
            } else {
                return b;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(lcs("AGGTAB", "GXTXAYB")); // Output: 4
        System.out.println(lcs("ABCDGH", "AEDFHR")); // Output: 3

        System.out.println(lscTopDown("AGGTAB", "GXTXAYB")); // Output: 4
        System.out.println(lscTopDown("ABCDGH", "AEDFHR")); // Output: 3
    }
}
