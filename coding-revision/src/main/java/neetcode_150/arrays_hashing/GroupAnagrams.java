package neetcode_150.arrays_hashing;

import java.util.*;

/**
 * Problem: Group Anagrams
 * LeetCode: https://leetcode.com/problems/group-anagrams/
 * <p>
 * Interview Template:
 * <p>
 * 1. Clarify Requirements:
 * -
 * <p>
 * 2. Initial Approach:
 * -
 * <p>
 * 3. Brute Force:
 * -
 * <p>
 * 4. Optimization:
 * -
 * <p>
 * 5. Final Algorithm:
 * -
 * <p>
 * 6. Time Complexity:
 * -
 * <p>
 * 7. Space Complexity:
 * -
 * <p>
 * 8. Edge Cases:
 * -
 * <p>
 * 9. Senior-Level Follow-ups:
 * -
 */
public class GroupAnagrams {

    // LeetCode method — implement after the interview discussion.
    public static List<List<String>> groupAnagrams(String[] nums) {
        Map<String, List<String>> map = new HashMap<>();

        for (String i : nums) {
            char[] c = i.toCharArray();
            Arrays.sort(c);
            String s = new String(c);

            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(i);
                map.put(s, list);
            } else {
                map.get(s).add(i);
            }
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        System.out.println("=== GroupAnagrams test cases ===");

        String[] case1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Case 1: classic anagram groups");
        System.out.println("Input: " + java.util.Arrays.toString(case1));
        System.out.println(groupAnagrams(case1));

        String[] case2 = new String[]{"", "a", "aa", "ab", "ba"};
        System.out.println("Case 2: empty and single-letter edge cases");
        System.out.println("Input: " + java.util.Arrays.toString(case2));
        System.out.println(groupAnagrams(case2));

        String[] case3 = new String[]{"listen", "silent", "triangle", "integral", "schoolmaster", "the"};
        System.out.println("Case 3: larger repeated-letter groups");
        System.out.println("Input: " + java.util.Arrays.toString(case3));
        System.out.println(groupAnagrams(case3));

        System.out.println("All GroupAnagrams scenarios reviewed.");
    }
}
