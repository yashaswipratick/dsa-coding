package com.coding.topics.slidingwindow;

import java.util.*;

public class Leetcode_438 {

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (char i : p.toCharArray()) {
            pMap.put(i, pMap.getOrDefault(i, 0) + 1);
        }
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (j - i + 1 == p.length()) {
                boolean isAnagram = checkAnagram(sMap, pMap);
                if (isAnagram) {
                    list.add(i);
                }
                char ithC = s.charAt(i);
                if (j - i + 1 == p.length()) {
                    if (sMap.containsKey(ithC)) {
                        sMap.put(ithC, sMap.get(ithC) - 1);
                    }
                    if (sMap.get(ithC) == 0) {
                        sMap.remove(ithC);
                    }
                }
                i++;
            }
            j++;
        }
        return list;
    }

    private static boolean checkAnagram(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        boolean isAnagram = false;
        for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
            if (!sMap.containsKey(entry.getKey())) {
                return false;
            } else if (sMap.containsKey(entry.getKey()) && Objects.equals(sMap.get(entry.getKey()), entry.getValue())) {
                isAnagram = true;
            } else if (sMap.containsKey(entry.getKey()) && !Objects.equals(sMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return isAnagram;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("cbacbabacd", "abc"));
        System.out.println(findAnagrams("aaaaa", "a"));
        System.out.println(findAnagrams("aaaaa", "aa"));
    }
}
