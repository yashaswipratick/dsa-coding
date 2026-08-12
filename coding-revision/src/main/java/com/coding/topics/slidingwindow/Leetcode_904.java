package com.coding.topics.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_904 {

    public static int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int count = 0;
        int maxCount = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int len = 2;

        while (j < fruits.length) {

            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            count++;
            if (map.size() == len) {
                maxCount = Math.max(count, maxCount);
            } else if (map.size() > len) {
                while (map.size() > len) {
                    if (map.containsKey(fruits[i])){
                        map.put(fruits[i], map.get(fruits[i]) -1);
                    }
                    if (map.containsKey(fruits[i]) && map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                    }
                    i++;
                    count--;
                }
                maxCount = Math.max(count, maxCount);
            }
            j++;
        }
        maxCount = Math.max(count, maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0,1,2,2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{2,1,3,2,2}));
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));

    }
}
