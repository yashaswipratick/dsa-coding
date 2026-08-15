package com.coding.topics.heap;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
