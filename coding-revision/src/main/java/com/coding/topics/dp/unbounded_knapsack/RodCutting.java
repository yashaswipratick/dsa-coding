package com.coding.topics.dp.unbounded_knapsack;

public class RodCutting {

    // same as 0-1 knapsack
    // only difference is
    //  1. when item is considered so it can be considered again so we will not do n-1 instead we will keep it as n.
    //  2. when item is not considered then we will do n-1.
    public static int cutRod(int[] price) {
        //create value array
        int[] length = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            length[i] = i+1;
        }

        //Memoization
        int[][] dp = new int[length.length+1][price.length+1];

        for (int i = 0; i <= length.length; i++) {
            for (int j = 0; j <= price.length; j++) {
                dp[i][j] = -1;
            }

        }
        //return cutRodHelper(length, price, length.length, price.length);
        return cutRodHelperMemoization(length, price, length.length, price.length, dp);
    }

    private static int cutRodHelper(int[] length, int[] price, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (length[n - 1] <= w) {
            return Math.max(price[n - 1] + cutRodHelper(length, price, w - length[n - 1], n), cutRodHelper(length, price, w, n - 1));
        } else {
            return cutRodHelper(length, price, w, n - 1);
        }
    }

    private static int cutRodHelperMemoization(int[] length, int[] price, int w, int n, int dp[][]) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (length[n - 1] <= w) {
            dp[n][w] = Math.max(price[n - 1] + cutRodHelper(length, price, w - length[n - 1], n), cutRodHelper(length, price, w, n - 1));
        } else {
            dp[n][w] = cutRodHelper(length, price, w, n - 1);
        }
        return dp[n][w];
    }

    private static int cutRodHelperTopDown(int[] length, int[] price, int w) {
        int[][] dp = new int[length.length+1][w+1];

        for (int i = 0; i <= length.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= length.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[price.length][w];
    }



    public static void main(String[] args) {
        System.out.println(cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(cutRod(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(cutRod(new int[]{3}));

        int[] price1 = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        int[] length = new int[price1.length];
        for (int i = 0; i < price1.length; i++) {
            length[i] = i+1;
        }
        System.out.println(cutRodHelperTopDown(length, price1, length.length));

        int[] price2 = new int[]{3, 5, 8, 9, 10, 17, 17, 20};
        int[] length2 = new int[price2.length];
        for (int i = 0; i < price2.length; i++) {
            length2[i] = i+1;
        }
        System.out.println(cutRodHelperTopDown(length2, price2, length2.length));

        int[] price3 = new int[]{3};
        int[] length3 = new int[price3.length];
        for (int i = 0; i < price3.length; i++) {
            length3[i] = i+1;
        }
        System.out.println(cutRodHelperTopDown(length3, price3, length3.length));
    }
}
