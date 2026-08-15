package com.coding.topics.dp.knapsack;

//PL - https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
public class CountOfSubsetSum {

    static int perfectSum(int[] arr, int target) {

        int[][] dp = new int[arr.length + 1][target + 1];
        //memoization
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                    dp[i][j] = -1;
            }
        }
        //return perfectSumHelper(arr, target, arr.length);
        return perfectSumHelperMemoization(arr, target, arr.length, dp);
    }

    private static int perfectSumHelper(int[] arr, int target, int n) {
        //base case
        if (n == 0) return target == 0 ? 1 : 0;

        // choices - recusrion logic

        if (arr[n - 1] <= target) {
            return perfectSumHelper(arr, target - arr[n - 1], n - 1) + perfectSumHelper(arr, target, n - 1);
        } else {
            return perfectSumHelper(arr, target, n - 1);
        }
    }

    private static int perfectSumHelperMemoization(int[] arr, int target, int n, int[][] dp) {
        //base case
        if (n == 0) return target == 0 ? 1 : 0;

        // choices - recusrion logic

        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        if (arr[n - 1] <= target) {
            dp[n][target] = perfectSumHelperMemoization(arr, target - arr[n - 1], n - 1, dp) + perfectSumHelperMemoization(arr, target, n - 1, dp);
        } else {
            dp[n][target] = perfectSumHelperMemoization(arr, target, n - 1, dp);
        }
        return dp[n][target];
    }

    private static int perfectSumHelperTopDown(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        // Base: with 0 elements, only sum 0 is possible.
        dp[0][0] = 1;
        for (int j = 1; j <= target; j++) {
            dp[0][j] = 0;
        }

        // Build DP table; include j = 0 to correctly handle zero-valued elements.
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        System.out.println(perfectSum(new int[]{5, 2, 3, 10, 6, 8}, 10));
        System.out.println(perfectSum(new int[]{2, 5, 1, 4, 3}, 10));
        System.out.println(perfectSum(new int[]{5, 7, 8}, 3));
        System.out.println(perfectSum(new int[]{35, 2, 8, 22}, 0));
        System.out.println(perfectSum(new int[]{28, 4, 3, 27, 0, 24, 26}, 24));

        System.out.println(perfectSumHelperTopDown(new int[]{5, 2, 3, 10, 6, 8}, 10));
        System.out.println(perfectSumHelperTopDown(new int[]{2, 5, 1, 4, 3}, 10));
        System.out.println(perfectSumHelperTopDown(new int[]{5, 7, 8}, 3));
        System.out.println(perfectSumHelperTopDown(new int[]{35, 2, 8, 22}, 0));
        System.out.println(perfectSumHelperTopDown(new int[]{28, 4, 3, 27, 0, 24, 26}, 24));
    }
}
