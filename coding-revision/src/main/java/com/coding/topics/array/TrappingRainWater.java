package com.coding.topics.array;

// Pl - https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {

    public static int trap(int[] height) {
        int[] lMax=new int[height.length];
        int[] rMax=new int[height.length];
        int res = 0;

        lMax[0]=height[0];
        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }

        rMax[rMax.length-1] = height[height.length-1];
        for (int i = height.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            res += (Math.min(lMax[i], rMax[i]) - height[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}
