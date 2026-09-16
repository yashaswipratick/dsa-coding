package neetcode_150.sliding_window;

/**
 * Problem: Best Time to Buy and Sell Stock
 * LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * Interview Template:
 * <p>
 * 1. Clarify Requirements:
 * -
 * <p>
 * 2. Initial Approach:
 * -
 * <p>
 * 3. Brute Force:
 * -
 * <p>
 * 4. Optimization:
 * -
 * <p>
 * 5. Final Algorithm:
 * -
 * <p>
 * 6. Time Complexity:
 * -
 * <p>
 * 7. Space Complexity:
 * -
 * <p>
 * 8. Edge Cases:
 * -
 * <p>
 * 9. Senior-Level Follow-ups:
 * -
 */
public class BestTimeToBuyAndSellStock {

    // LeetCode method — implement after the interview discussion.

    //Revisit
    public static int maxProfit(int[] prices) {
        int buyingPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // find minimum at every index and override if price[i] < buying price.
            buyingPrice = Math.min(buyingPrice, prices[i]);

            //calculate profit by substracting minimum from current index element
            //if the subtraction is greate than profit override the value.
            profit = Math.max(profit, prices[i] - buyingPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("=== BestTimeToBuyAndSellStock test cases ===");
        int[] case1 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("Case 1: case 1");
        System.out.println("Input: " + java.util.Arrays.toString(case1));
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(case1));
        int[] case2 = new int[]{7, 6, 4, 3, 1};
        System.out.println("Case 2: case 2");
        System.out.println("Input: " + java.util.Arrays.toString(case2));
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(case2));
        System.out.println("All BestTimeToBuyAndSellStock scenarios reviewed.");
    }
}
