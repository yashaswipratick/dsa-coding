package neetcode_150.arrays_hashing;

/**
 * Problem: Valid Anagram
 * LeetCode: https://leetcode.com/problems/valid-anagram/
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
public class ValidAnagram {

    // LeetCode method — implement after the interview discussion.
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== ValidAnagram test cases ===");

        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Case 1: exact anagram");
        System.out.println("Input: s = " + s1 + ", t = " + t1);
        System.out.println("Result: " + isAnagram(s1, t1));

        String s2 = "rat";
        String t2 = "car";
        System.out.println("Case 2: different strings");
        System.out.println("Input: s = " + s2 + ", t = " + t2);
        System.out.println("Result: " + isAnagram(s2, t2));

        String s3 = "aacc";
        String t3 = "ccaa";
        System.out.println("Case 3: repeated characters");
        System.out.println("Input: s = " + s3 + ", t = " + t3);
        System.out.println("Result: " + isAnagram(s3, t3));

        String s4 = "aa";
        String t4 = "ab";
        System.out.println("Case 4: different length");
        System.out.println("Input: s = " + s4 + ", t = " + t4);
        System.out.println("Result: " + isAnagram(s4, t4));

        System.out.println("All ValidAnagram scenarios reviewed.");
    }
}
