package com.coding.topics.mock.interview;

import java.util.HashMap;
import java.util.Map;

// Given a strings, find the length of the longest substring without duplicate characters.
//
//Example 1:
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
//Example 2:
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class MockInterview_1 {

    //count, maxCount. Math.max(count, maxCount)

    // i= 0 to s.length()
    //

    public static int uniqueLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = -1;

        if (s.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() > j - i + 1) {
                j++;
            } else if (map.size() == j - i + 1) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (map.size() < j - i + 1) {
                while (map.size() < j - i + 1) {
                    char cur = s.charAt(i);
                    if (map.containsKey(cur)) {
                        map.put(cur, map.get(cur) - 1);
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
        System.out.println(uniqueLongestSubstring("abcabcbb"));
        System.out.println(uniqueLongestSubstring("bbbbb"));
        System.out.println(uniqueLongestSubstring("pwwkew"));
        System.out.println(uniqueLongestSubstring("dvdf"));
    }
}
