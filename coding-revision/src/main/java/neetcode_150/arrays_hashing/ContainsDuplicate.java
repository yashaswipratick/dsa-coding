package neetcode_150.arrays_hashing;

import java.util.HashSet;

/**
 * Problem: Contains Duplicate
 * LeetCode: https://leetcode.com/problems/contains-duplicate/
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
public class ContainsDuplicate {

    // LeetCode method — implement after the interview discussion.
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== ContainsDuplicate test cases ===");

        int[] case1 = new int[]{1, 2, 3, 1};
        System.out.println("Case 1: duplicate near end");
        System.out.println("Input: " + java.util.Arrays.toString(case1));
        System.out.println("Result: " + containsDuplicate(case1));

        int[] case2 = new int[]{1, 2, 3, 4};
        System.out.println("Case 2: unique values");
        System.out.println("Input: " + java.util.Arrays.toString(case2));
        System.out.println("Result: " + containsDuplicate(case2));

        int[] case3 = new int[]{1, 1, 1, 1};
        System.out.println("Case 3: all values repeated");
        System.out.println("Input: " + java.util.Arrays.toString(case3));
        System.out.println("Result: " + containsDuplicate(case3));

        System.out.println("All ContainsDuplicate scenarios reviewed.");
    }
}
