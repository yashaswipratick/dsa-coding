package neetcode_150.arrays_hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem: Top K Frequent Elements
 * LeetCode: https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Interview Template:
 *
 * 1. Clarify Requirements:
 *    -
 *
 * 2. Initial Approach:
 *    -
 *
 * 3. Brute Force:
 *    -
 *
 * 4. Optimization:
 *    -
 *
 * 5. Final Algorithm:
 *    -
 *
 * 6. Time Complexity:
 *    -
 *
 * 7. Space Complexity:
 *    -
 *
 * 8. Edge Cases:
 *    -
 *
 * 9. Senior-Level Follow-ups:
 *    -
 */
public class TopKFrequentElements {

    // LeetCode method — implement after the interview discussion.
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(new int[]{e.getKey(), e.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=== TopKFrequentElements test cases ===");

        int[] case1 = new int[]{1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Case 1: classic frequency case");
        System.out.println("Input: nums = " + java.util.Arrays.toString(case1) + ", k = " + k1);
        System.out.println("Result: " + java.util.Arrays.toString(topKFrequent(case1, k1)));

        int[] case2 = new int[]{-1, -1, -1, -2, -2, -3};
        int k2 = 2;
        System.out.println("Case 2: negative values");
        System.out.println("Input: nums = " + java.util.Arrays.toString(case2) + ", k = " + k2);
        System.out.println("Result: " + java.util.Arrays.toString(topKFrequent(case2, k2)));

        int[] case3 = new int[]{4, 1, -1, 2, -1, 2, 3};
        int k3 = 3;
        System.out.println("Case 3: mixed values and duplicates");
        System.out.println("Input: nums = " + java.util.Arrays.toString(case3) + ", k = " + k3);
        System.out.println("Result: " + java.util.Arrays.toString(topKFrequent(case3, k3)));

        System.out.println("All TopKFrequentElements scenarios reviewed.");
    }
}
