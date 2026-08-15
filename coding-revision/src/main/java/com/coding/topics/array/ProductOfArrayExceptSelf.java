package com.coding.topics.array;

import java.util.Arrays;

// Pl - https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length];
        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 0, 2, 3})));
    }
}

