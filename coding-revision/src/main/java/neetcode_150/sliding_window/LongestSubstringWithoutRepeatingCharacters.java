package neetcode_150.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: Longest Substring Without Repeating Characters
 * LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
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
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Approach
     *
     * Here is the exact logical structure of the code you wrote, broken down into sequential, actionable points:
     * ## ⚙️ Logical Steps Inside Your Loop
     *
     *    1. Acquire and Track the New Character
     *    * Fetch the character at the current right boundary (j).
     *       * Increment its frequency count inside the tracking map.
     *    2. Detect Constraint Violation
     *    * Check if the count of the newly added character has exceeded 1 (which means a duplicate has entered the window).
     *    3. Shrink to Restore Window Validity
     *    * Run an inner cycle only while the current character's count remains greater than 1:
     *       * Identify the character at the left boundary (i).
     *          * Decrement its frequency count in the tracking map.
     *          * Move the left boundary (i) one step forward to compress the window.
     *       4. Record the Best Valid Result
     *    * Once the inner cycle ends (guaranteeing the window contains no duplicates), calculate the current window size (j - i + 1).
     *       * Compare it against the running maximum and update the global highest length.
     *    5. Advance the Window Expansion
     *    * Shift the right boundary (j) one step forward to process the next character in the string.
     *
     * ------------------------------
     *
     * @param s
     * @return
     */
    // Revisit
    // LeetCode method — implement after the interview discussion.
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }
            max = Math.max(max, (j - i + 1));
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("=== LongestSubstringWithoutRepeatingCharacters test cases ===");
        String case1 = "abcabcbb";
        System.out.println("Case 1: sample input");
        System.out.println("Input: " + case1);
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(case1));
        String case2 = "bbbbb";
        System.out.println("Case 2: sample input");
        System.out.println("Input: " + case2);
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(case2));
        System.out.println("All LongestSubstringWithoutRepeatingCharacters scenarios reviewed.");
    }
}
