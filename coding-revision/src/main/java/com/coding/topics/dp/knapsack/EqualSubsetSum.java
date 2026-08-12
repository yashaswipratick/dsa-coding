package com.coding.topics.dp.knapsack;

// PL - https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
public class EqualSubsetSum {

    static boolean equalPartition(int arr[]) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        if (total % 2 != 0) return false;

        //memoization
        Boolean[][] dp = new Boolean[arr.length + 1][(total / 2) + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= total / 2; j++) {
                if ( i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                }  else {
                    dp[i][j] = null;
                }
            }
        }

        //return equalPartitionHelper(arr, total / 2, arr.length);
        return equalPartitionHelperMemoization(arr, total / 2, arr.length, dp);
    }

    private static boolean equalPartitionHelper(int[] arr, int sum, int n) {
        if (sum == 0) return true;

        if (n == 0) return false;

        //choices - recursion logic
        if (arr[n - 1] <= sum) {
            return equalPartitionHelper(arr, sum - arr[n - 1], n - 1) || equalPartitionHelper(arr, sum, n - 1);
        } else {
            return equalPartitionHelper(arr, sum, n - 1);
        }
    }

    private static boolean equalPartitionHelperMemoization(int[] arr, int sum, int n, Boolean[][] dp) {
        if (sum == 0) return true;

        if (n == 0) return false;

        //choices - recursion logic

        if (dp[n][sum] != null) return dp[n][sum];

        if (arr[n - 1] <= sum) {
            dp[n][sum] = equalPartitionHelper(arr, sum - arr[n - 1], n - 1) || equalPartitionHelper(arr, sum, n - 1);
        } else {
            dp[n][sum] = equalPartitionHelper(arr, sum, n - 1);
        }
        return dp[n][sum];
    }

    private static boolean equalPartitionTopDown(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        if (total % 2 != 0) return false;

        int sum = total / 2;

        Boolean[][] dp = new Boolean[arr.length + 1][(total / 2) + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= total / 2; j++) {
                if ( i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                }  else {
                    dp[i][j] = null;
                }
            }
        }

        // replace n(arr.length) with i
        // replace sum with j
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        System.out.println(equalPartitionTopDown(new int[]{1, 5, 11, 5}));
        System.out.println(equalPartitionTopDown(new int[]{1, 3, 5}));
    }
}
