package com.coding.topics.hashing;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_128 {

    /**
     * Approach
     * Store all the elements in a HashMap.
     * Iterate through the array starting from index 0.
     * At each index:
     *     Check whether (element - 1) is present in the HashMap.
     *     If it is present, continue to the next element.
     *     Otherwise:
     *         Reset count to 0.
     *         Store nums[i] in a temporary variable called current.
     *         Iterate while the HashMap contains the current element:
     *             Increment count by 1.
     *             Remove the current element from the HashMap.
     *             Increment current by 1.
     *         Update maxCount with the maximum of count and maxCount.
     * Return maxCount after completing the iteration.
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i] - 1;
            if (!map.containsKey(curr)) {
                count = 0;
                curr = nums[i];
                while (map.containsKey(curr)) {
                    count++;
                    map.remove(curr);
                    curr++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2}));
        System.out.println(longestConsecutive(new int[]{-20, -19, -11, -10, -9, -8, -7, -6, -1, 0, 1, 2}));
    }
}
