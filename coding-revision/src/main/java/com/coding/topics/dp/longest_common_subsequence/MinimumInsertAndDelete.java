package com.coding.topics.dp.longest_common_subsequence;

//PL - https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
public class MinimumInsertAndDelete {

    /**
     * Find lcs of the string.
     * To get min number of insertion and deletion to make s1 as s2
     *  find number of deletion = s1.length - lcs.length
     *  find number of insertion - s2.length - lcs.length
     *  add both deletion and insertion to get the result.
     * @param s1
     * @param s2
     * @return
     */
    public static int minOperations(String s1, String s2) {
        int lcsLen = lscHelper(s1, s2, s1.length(), s2.length());
        //deletion
        int deletion = s1.length() - lcsLen;
        //insertion
        int insertion = s2.length() - lcsLen;
        //return deletion + insertion;
        //momoization
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
        int lcsMemLen = lscHelperMemoization(s1, s2, s1.length(), s2.length(), dp);
        int deletionMemLen =  s1.length() - lcsMemLen;
        int insertionMemLen =  s2.length() - lcsMemLen;
        return deletionMemLen + insertionMemLen;
    }

    private static int lscHelper(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lscHelper(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(lscHelper(s1, s2, n - 1, m), lscHelper(s1, s2, n, m - 1));
        }
    }

    private static int lscHelperMemoization(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + lscHelperMemoization(s1, s2, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(lscHelperMemoization(s1, s2, n - 1, m, dp), lscHelperMemoization(s1, s2, n, m - 1, dp));
        }
        return dp[n][m];
    }

    private static int minOperationsTopDown(String s1, String s2) {

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

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }  else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //logic for minimum number of insertion and deletion required to transform s1 to s2
        int lcsLength = dp[s1.length()][s2.length()];
        //deletion
        int deletion = s1.length() - lcsLength;
        int insrtion = s2.length() - lcsLength;
        return deletion + insrtion;
    }

    public static void main(String[] args) {
        System.out.println(minOperations("heap", "pea")); // Output: 3
        System.out.println(minOperations("geeksforgeeks", "geeks")); // Output: 8
        System.out.println(minOperations("abc", "def")); // Output: 6

        System.out.println(minOperationsTopDown("heap", "pea")); // Output: 3
        System.out.println(minOperationsTopDown("geeksforgeeks", "geeks")); // Output: 8
        System.out.println(minOperationsTopDown("abc", "def")); // Output: 6
    }
}
