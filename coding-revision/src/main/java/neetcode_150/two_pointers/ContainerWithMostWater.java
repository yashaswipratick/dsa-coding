package neetcode_150.two_pointers;

/**
 * Problem: Container With Most Water
 * LeetCode: https://leetcode.com/problems/container-with-most-water/
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
public class ContainerWithMostWater {

    // LeetCode method — implement after the interview discussion.

    /**
     * Approach
     * Start at the widest option: Place one boundary at the very far left wall and one at the very far right wall. Calculate the water amount.
     * Move the shorter wall: Look at both walls. Whoever is shorter, move that pointer inward by one step.
     * Repeat: Keep doing this until the two pointers meet. Remember the highest water amount you saw along the way.
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int maxArea = 0;

        while (start <= end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(area, maxArea);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("=== ContainerWithMostWater test cases ===");
        int[] case1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Case 1: case 1");
        System.out.println("Input: " + java.util.Arrays.toString(case1));
        System.out.println(maxArea(case1));
        int[] case2 = new int[]{1, 1, 1, 1};
        System.out.println("Case 2: case 2");
        System.out.println("Input: " + java.util.Arrays.toString(case2));
        System.out.println(maxArea(case2));
        int[] case3 = new int[]{4, 3, 2, 1, 4};
        System.out.println("Case 3: case 3");
        System.out.println("Input: " + java.util.Arrays.toString(case3));
        System.out.println(maxArea(case3));
        System.out.println("All ContainerWithMostWater scenarios reviewed.");
        int[] case4 = new int[]{1, 1};
        System.out.println("Case 4: case 4");
        System.out.println("Input: " + java.util.Arrays.toString(case4));
        System.out.println(maxArea(case4));
        System.out.println("All ContainerWithMostWater scenarios reviewed.");
    }
}