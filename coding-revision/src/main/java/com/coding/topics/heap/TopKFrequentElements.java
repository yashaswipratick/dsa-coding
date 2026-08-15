package com.coding.topics.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : nums) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll()[0];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
