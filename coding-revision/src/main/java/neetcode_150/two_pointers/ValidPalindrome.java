package neetcode_150.two_pointers;

/**
 * Problem: Valid Palindrome
 * LeetCode: https://leetcode.com/problems/valid-palindrome/
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
public class ValidPalindrome {

    // LeetCode method — implement after the interview discussion.
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String lowerCase = s.toLowerCase();
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        String actual = sb.toString();
        sb.reverse();
        System.out.println(sb);
        if (actual.equalsIgnoreCase(sb.toString())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== ValidPalindrome test cases ===");
        String p1 = "A man, a plan, a canal: Panama";
        System.out.println("Case 1: sample input");
        System.out.println("Input: " + p1);
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        String p2 = "race a car";
        System.out.println("Case 2: sample input");
        System.out.println("Input: " + p2);
        System.out.println(isPalindrome("race a car"));
        String p3 = " ";
        System.out.println("Case 3: sample input");
        System.out.println("Input: " + p3);
        System.out.println(isPalindrome(" "));
        System.out.println("All ValidPalindrome scenarios reviewed.");
    }
}
