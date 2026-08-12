package com.coding.topics.dp.knapsack;

//Problem link - https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class Knapsack {

    public static int knapsack(int W, int val[], int wt[]) {

        //memoization
        int t[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= W; j++) {
                t[i][j] = -1;
            }
        }

        //using recursion
        //return knapsackHelper(val, wt, W, val.length);

        //using memoization
        //return knapsackHelperMemoization(val, wt, W, val.length, t);

        //TOP Down
        return knapsackTopDown(W, val, wt);
    }

    public static int knapsackTopDown(int W, int val[], int wt[]) {
        int t[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        //n replaced with i
        //W replaced with j
        for (int i = 1; i <= val.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[val.length][W];
    }

    //using recursion
    private static int knapsackHelper(int[] val, int[] wt, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + knapsackHelper(val, wt, w - wt[n - 1], n - 1), knapsackHelper(val, wt, w, n - 1));
        } else {
            return knapsackHelper(val, wt, w, n - 1);
        }
    }

    //using memoization
    private static int knapsackHelperMemoization(int[] val, int[] wt, int w, int n, int t[][]) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (t[n][w] != -1) {
            return t[n][w];
        }

        if (wt[n - 1] <= w) {
            t[n][w] = Math.max(val[n - 1] + knapsackHelperMemoization(val, wt, w - wt[n - 1], n - 1, t), knapsackHelperMemoization(val, wt, w, n - 1, t));
        } else {
            t[n][w] = knapsackHelperMemoization(val, wt, w, n - 1, t);
        }
        return t[n][w];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        System.out.println(knapsack(W, val, wt));

        int val1[] = {1, 2, 3};
        int wt1[] = {4, 5, 1};
        int W1 = 4;
        System.out.println(knapsack(W1, val1, wt1));

        int val2[] = {10, 8, 6};
        int wt2[] = {1, 7, 9};
        int W2 = 7;
        System.out.println(knapsack(W2, val2, wt2));
    }
}
