package neetcode_150.arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Encode and Decode Strings
 * LeetCode: https://leetcode.com/problems/encode-and-decode-strings/
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
public class EncodeAndDecodeStrings {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int hashIndex = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, hashIndex));
            list.add(str.substring(hashIndex + 1, hashIndex + 1 + length));
            i = hashIndex + 1 + length;
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("Hello", "World", "!@#$%^&*"));
        String encode = encode(strs);
        List<String> decode = decode(encode);
        System.out.println(decode);

        List<String> strs1 = new ArrayList<>(Arrays.asList(""));
        String encode1 = encode(strs1);
        List<String> decode1 = decode(encode1);
        System.out.println(decode1);

        List<String> strs2 = new ArrayList<>(Arrays.asList("", ""));
        String encode2 = encode(strs2);
        List<String> decode2 = decode(encode2);
        System.out.println(decode2);

        List<String> strs3 = new ArrayList<>();
        String encode3 = encode(strs3);
        List<String> decode3 = decode(encode3);
        System.out.println(decode3);
    }
}
