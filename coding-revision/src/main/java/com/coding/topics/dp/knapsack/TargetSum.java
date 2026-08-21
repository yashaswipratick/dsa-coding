package com.coding.topics.dp.knapsack;


// Problem - https://leetcode.com/problems/target-sum/description/
public class TargetSum {

    static int countSubsetSum(int[] arr, int target) {
        //find total sum for all elements in array
        int sum = 0;
        for (int i = 0; i <arr.length; i++) {
            sum += arr[i];
        }

        // Guard: if (target + sum) is odd, partition is impossible
        if ((target + sum) % 2 != 0) return 0;
        // Guard: if |target| > sum, no valid partition exists (covers both positive and negative targets)
        if (Math.abs(target) > sum) return 0;

        //formula
        int subsetSum = (target + sum) / 2;

        //count number of subset sum - recursive
        //return countSubsetSumHelper(arr, subsetSum, arr.length);

        //memoization
        int[][] dp = new int[arr.length + 1][subsetSum + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= subsetSum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        return countSubsetSumHelperMemoized(arr, subsetSum, arr.length, dp);
    }

    private static int countSubsetSumHelper(int[] arr, int sum, int n) {
        if (n==0) return sum == 0 ? 1: 0;

        if (arr[n-1] <= sum) {
            return countSubsetSumHelper(arr, sum-arr[n-1], n-1) + countSubsetSumHelper(arr, sum, n-1);
        } else {
            return countSubsetSumHelper(arr, sum, n-1);
        }
    }

    private static int countSubsetSumHelperMemoized(int[] arr, int sum, int n, int[][] dp) {
        if (n==0) return sum == 0 ? 1: 0;

        if (dp[n][sum] != -1) return dp[n][sum];

        if (arr[n-1] <= sum) {
            dp[n][sum] = countSubsetSumHelper(arr, sum-arr[n-1], n-1) + countSubsetSumHelper(arr, sum, n-1);
        } else {
            dp[n][sum] = countSubsetSumHelper(arr, sum, n-1);
        }
        return dp[n][sum];
    }

    private static int countSubsetSumHelperTopDown(int[] arr, int target) {

        //find total sum for all elements in array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Guard: if (target + sum) is odd, partition is impossible
        if ((target + sum) % 2 != 0) return 0;
        // Guard: if |target| > sum, no valid partition exists (covers both positive and negative targets)
        if (Math.abs(target) > sum) return 0;

        //formula
        int subsetSum = (target + sum) / 2;


        int[][] dp = new int[arr.length + 1][subsetSum + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= subsetSum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1; // empty set, sum=0 → 1 way
                } else if (i == 0) {
                    dp[i][j] = 0; // no elements, sum>0 → 0 ways
                } else if (j == 0) {
                    dp[i][j] = 1; // any elements, sum=0 → 1 way (empty subset)
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        //replace n -> i
        //replace sum -> j
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= subsetSum; j++) {  // start from 0 to handle zero elements
                if (arr[i-1] <= j) {
                    dp[i][j] =  dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][subsetSum];
    }

    public static void main(String[] args) {
        System.out.println(countSubsetSumHelperTopDown(new int[]{1, 1, 2, 3}, 1)); // expected: 3
        System.out.println(countSubsetSumHelperTopDown(new int[]{1}, 2));           // expected: 0 (impossible, 1+2=3 is odd)
        System.out.println(countSubsetSumHelperTopDown(new int[]{1, 1}, 0));        // expected: 2 (+1-1 and -1+1)
        System.out.println(countSubsetSumHelperTopDown(new int[]{1,1,1,1,1}, 3));  // expected: 5
        System.out.println(countSubsetSumHelperTopDown(new int[]{0}, 0));  // expected: 2
        System.out.println(countSubsetSumHelperTopDown(new int[]{1,1,1,1}, -1000));  // expected: 2
    }
}
