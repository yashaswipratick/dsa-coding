package com.coding.topics.slidingwindow;

public class Leetcode_209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 1;
            int sum = nums[i];
            if (sum >= target) {
                minCount = Math.min(minCount, count);
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                count++;
                if (sum >= target) {
                    break;
                }
            }
            if (sum >= target) {
                minCount = Math.min(count, minCount);
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
