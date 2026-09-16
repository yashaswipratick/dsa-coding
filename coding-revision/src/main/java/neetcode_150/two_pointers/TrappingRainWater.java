package neetcode_150.two_pointers;

/**
 * Problem: Trapping Rain Water
 * LeetCode: https://leetcode.com/problems/trapping-rain-water/
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
public class TrappingRainWater {

    // LeetCode method — implement after the interview discussion.
    public static int trap(int[] height) {
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        lMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }

        rMax[rMax.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=== TrappingRainWater test cases ===");
        int[] case1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Case 1: case 1");
        System.out.println("Input: " + java.util.Arrays.toString(case1));
        System.out.println(TrappingRainWater.trap(case1));
        int[] case2 = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println("Case 2: case 2");
        System.out.println("Input: " + java.util.Arrays.toString(case2));
        System.out.println(TrappingRainWater.trap(case2));
        int[] case3 = new int[]{2, 0, 2};
        System.out.println("Case 3: case 3");
        System.out.println("Input: " + java.util.Arrays.toString(case3));
        System.out.println(TrappingRainWater.trap(case3));
        System.out.println("All TrappingRainWater scenarios reviewed.");
    }
}
