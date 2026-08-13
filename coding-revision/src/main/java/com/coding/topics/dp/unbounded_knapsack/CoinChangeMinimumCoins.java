package com.coding.topics.dp.unbounded_knapsack;

//PL - https://www.geeksforgeeks.org/problems/number-of-coins1824/1
public class CoinChangeMinimumCoins {

    public static int minCoins(int coins[], int sum) {
        int[][] dp = new int[coins.length + 1][sum + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        /*int ans = minCoinsHelper(coins, sum, coins.length);
        return ans >= Integer.MAX_VALUE-1 ? -1 : ans;*/

        int ans = minCoinsHelperMemoization(coins, sum, coins.length, dp);
        return ans >= Integer.MAX_VALUE - 1 ? -1 : ans;
    }

    private static int minCoinsHelper(int[] coins, int sum, int n) {

        //base case
        if (sum == 0) return 0;
        if (n == 0) return Integer.MAX_VALUE - 1;

        //choices - Recursive code

        if (coins[n - 1] <= sum) {
            return Math.min(1 + minCoinsHelper(coins, sum - coins[n - 1], n), minCoinsHelper(coins, sum, n - 1));
        } else {
            return minCoinsHelper(coins, sum, n - 1);
        }
    }

    private static int minCoinsHelperMemoization(int[] coins, int sum, int n, int[][] dp) {
        //base case
        if (sum == 0) return 0;
        if (n == 0) return Integer.MAX_VALUE - 1;

        //choices - Recursive code
        if (dp[n][sum] != -1) return dp[n][sum];

        if (coins[n - 1] <= sum) {
            dp[n][sum] = Math.min(1 + minCoinsHelperMemoization(coins, sum - coins[n - 1], n, dp), minCoinsHelperMemoization(coins, sum, n - 1, dp));
        } else {
            dp[n][sum] = minCoinsHelperMemoization(coins, sum, n - 1, dp);
        }
        return dp[n][sum];
    }

    private static int minCoinsHelperTopDown(int[] coins, int sum) {
        //base case
        int[][] dp = new int[coins.length + 1][sum + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        //choices - Recursive code

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][sum];
    }

    private static int minCoinsHelperTopDownOptimisation(int[] coins, int sum) {
        //base case
        int INF = Integer.MAX_VALUE - 1;
        int[] dp = new int[sum + 1];
        dp[0] = 0;
        for (int j = 1; j <= sum; j++) dp[j] = INF;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                if (dp[j - coins[i]] != INF) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }
        return dp[sum] == INF ? -1 : dp[sum];
    }

    public static void main(String[] args) {
        /*System.out.println(minCoins(new int[]{25, 10, 5}, 30));
        System.out.println(minCoins(new int[]{9, 6, 5, 1}, 19));
        System.out.println(minCoins(new int[]{5, 1}, 0));
        System.out.println(minCoins(new int[]{4, 6, 2}, 5));*/

        System.out.println(minCoinsHelperTopDown(new int[]{25, 10, 5}, 30));
        System.out.println(minCoinsHelperTopDown(new int[]{9, 6, 5, 1}, 19));
        System.out.println(minCoinsHelperTopDown(new int[]{5, 1}, 0));
        System.out.println(minCoinsHelperTopDown(new int[]{4, 6, 2}, 5));

        System.out.println(minCoinsHelperTopDownOptimisation(new int[]{25, 10, 5}, 30));
        System.out.println(minCoinsHelperTopDownOptimisation(new int[]{9, 6, 5, 1}, 19));
        System.out.println(minCoinsHelperTopDownOptimisation(new int[]{5, 1}, 0));
        System.out.println(minCoinsHelperTopDownOptimisation(new int[]{4, 6, 2}, 5));
    }
}
