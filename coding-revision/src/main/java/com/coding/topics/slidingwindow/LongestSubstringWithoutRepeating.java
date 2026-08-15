package com.coding.topics.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// pl - https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = -1;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() > j-i+1) {
                j++;
            } else if (map.size() == j-i+1) {
                max = Math.max(max, j-i+1);
                j++;
            } else {
                while (map.size() < j-i+1) {
                    char cur =  s.charAt(i);
                    if(map.containsKey(cur)) {
                        map.put(cur, map.get(cur) + 1);
                    }
                    if (map.get(cur) == 0) {
                        map.remove(cur);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
