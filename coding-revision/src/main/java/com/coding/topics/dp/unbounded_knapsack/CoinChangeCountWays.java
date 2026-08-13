package com.coding.topics.dp.unbounded_knapsack;

// PL - https://www.geeksforgeeks.org/problems/coin-change2448/1
public class CoinChangeCountWays {

    public static int count(int coins[], int sum) {
        //Memoization
        int[][] dp = new int[coins.length + 1][sum + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }  else if (i == 0){
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        //return countHelper(coins, sum, coins.length);
        return countHelperMemoization(coins, sum, coins.length, dp);
    }

    private static int countHelper(int[] coins, int sum, int n) {
        //BASe condition
        if (n == 0) return sum == 0 ? 1 : 0;

        // choices - Recusrion logic

        if (coins[n-1] <= sum) {
            return countHelper(coins, sum-coins[n-1], n) + countHelper(coins, sum, n-1);
        } else {
            return countHelper(coins, sum, n-1);
        }
    }

    private static int countHelperMemoization(int[] coins, int sum, int n, int[][] dp) {
        //BASe condition
        if (n == 0) return sum == 0 ? 1 : 0;

        // choices - Recusrion logic

        if (dp[n][sum] != -1) return dp[n][sum];

        if (coins[n-1] <= sum) {
            dp[n][sum] = countHelperMemoization(coins, sum-coins[n-1], n, dp) + countHelperMemoization(coins, sum, n-1, dp);
        } else {
            dp[n][sum] = countHelperMemoization(coins, sum, n-1, dp);
        }
        return dp[n][sum];
    }

    private static int countHelperTopDown(int[] coins, int sum) {
        //BASe condition
        int[][] dp = new int[coins.length + 1][sum + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }  else if (i == 0){
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        // choices - Recusrion logic
        // replace n with i
        // replace sum with j
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][sum];
    }

    private static int countHelperTopDownOptimised(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = coins[i-1]; j <= sum; j++) {
                dp[j] = dp[j-coins[i-1]] + dp[j];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        /*System.out.println(count(new int[]{1, 2, 3}, 4));
        System.out.println(count(new int[]{2, 5, 3, 6}, 10));
        System.out.println(count(new int[]{5,10}, 3));*/

        System.out.println(countHelperTopDown(new int[]{1, 2, 3}, 4));
        System.out.println(countHelperTopDown(new int[]{2, 5, 3, 6}, 10));
        System.out.println(countHelperTopDown(new int[]{5,10}, 3));

        System.out.println(countHelperTopDownOptimised(new int[]{1, 2, 3}, 4));
        System.out.println(countHelperTopDownOptimised(new int[]{2, 5, 3, 6}, 10));
        System.out.println(countHelperTopDownOptimised(new int[]{5,10}, 3));
    }
}
