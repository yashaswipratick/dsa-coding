package neetcode_150.arrays_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: Longest Consecutive Sequence
 * LeetCode: https://leetcode.com/problems/longest-consecutive-sequence/
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
public class LongestConsecutiveSequence {

    // LeetCode method — implement after the interview discussion.
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int count = 0;
        int maxCount = 0;
        for (int i : nums) {
            if (!set.contains(i-1)) {
                int temp = i;
                while (set.contains(temp)) {
                    count++;
                    temp++;
                }
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println("=== LongestConsecutiveSequence test cases ===");
        int[] case1 = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println("Case 1: case 1");
        System.out.println("Input: " + java.util.Arrays.toString(case1));
        System.out.println(LongestConsecutiveSequence.longestConsecutive(case1));
        int[] case2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Case 2: case 2");
        System.out.println("Input: " + java.util.Arrays.toString(case2));
        System.out.println(LongestConsecutiveSequence.longestConsecutive(case2));
        int[] case3 = new int[]{1, 2, 0, 1};
        System.out.println("Case 3: case 3");
        System.out.println("Input: " + java.util.Arrays.toString(case3));
        System.out.println(LongestConsecutiveSequence.longestConsecutive(case3));
        System.out.println("All LongestConsecutiveSequence scenarios reviewed.");
    }
}
