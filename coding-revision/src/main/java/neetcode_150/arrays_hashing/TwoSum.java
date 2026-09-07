package neetcode_150.arrays_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Problem: Two Sum
 * LeetCode: https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    // LeetCode method — implement after the interview discussion.
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(num, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("=== TwoSum test cases ===");

        int[] case1 = new int[]{2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Case 1: classic case");
        System.out.println("Input: nums = " + java.util.Arrays.toString(case1) + ", target = " + target1);
        System.out.println("Result: " + java.util.Arrays.toString(twoSum(case1, target1)));

        int[] case2 = new int[]{3, 2, 4};
        int target2 = 6;
        System.out.println("Case 2: duplicate near target");
        System.out.println("Input: nums = " + java.util.Arrays.toString(case2) + ", target = " + target2);
        System.out.println("Result: " + java.util.Arrays.toString(twoSum(case2, target2)));

        int[] case3 = new int[]{3, 3};
        int target3 = 6;
        System.out.println("Case 3: duplicate values");
        System.out.println("Input: nums = " + java.util.Arrays.toString(case3) + ", target = " + target3);
        System.out.println("Result: " + java.util.Arrays.toString(twoSum(case3, target3)));

        int[] case4 = new int[]{-1, 0, 1, 2};
        int target4 = 1;
        System.out.println("Case 4: negative numbers");
        System.out.println("Input: nums = " + java.util.Arrays.toString(case4) + ", target = " + target4);
        System.out.println("Result: " + java.util.Arrays.toString(twoSum(case4, target4)));

        System.out.println("All TwoSum scenarios reviewed.");
    }
}
