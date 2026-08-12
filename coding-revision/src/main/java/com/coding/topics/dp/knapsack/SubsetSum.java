package com.coding.topics.dp.knapsack;
//PL - https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class SubsetSum {

    static boolean isSubsetSum(int arr[], int sum) {
        // code here

        //memoization
        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = null;
                }
            }
        }
        //return isSubsetSumHelper(arr, sum, arr.length);
        return isSubsetSumHelperMemoization(arr, sum, arr.length, dp);
    }

    private static boolean isSubsetSumHelper(int[] arr, int sum, int n) {
        //base condition

        if (sum == 0) {
            return true;
        }

        if (n == 0 || sum < 0) {
            return false;
        }

        //choices - contains logic for recursion

        if (arr[n - 1] <= sum) {
            return isSubsetSumHelper(arr, sum - arr[n - 1], n - 1) || isSubsetSumHelper(arr, sum, n - 1);
        } else {
            return isSubsetSumHelper(arr, sum, n - 1);
        }
    }

    private static boolean isSubsetSumHelperMemoization(int[] arr, int sum, int n, Boolean[][] dp) {
        //base condition

        if (sum == 0) {
            return true;
        }

        if (n == 0 || sum < 0) {
            return false;
        }

        //choices - contains logic for recursion

        if (dp[n][sum] != null) {
            return dp[n][sum];
        }

        if (arr[n - 1] <= sum) {
            dp[n][sum] = isSubsetSumHelperMemoization(arr, sum - arr[n - 1], n - 1, dp) || isSubsetSumHelperMemoization(arr, sum, n - 1, dp);
        } else {
            dp[n][sum] = isSubsetSumHelperMemoization(arr, sum, n - 1, dp);
        }
        return dp[n][sum];
    }

    private static boolean isSubsetSumHelperTopDown(int[] arr, int sum) {
        //base condition

        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = null;
                }
            }
        }

        //choices - contains logic for loop

        // replace n(array.length) with i
        // replace sum with j
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        System.out.println(isSubsetSumHelperTopDown(new int[]{3, 34, 4, 12, 5, 2}, 9));
        System.out.println(isSubsetSumHelperTopDown(new int[]{3, 34, 4, 12, 5, 2}, 30));
        System.out.println(isSubsetSumHelperTopDown(new int[]{1, 2, 3}, 6));
    }
}
