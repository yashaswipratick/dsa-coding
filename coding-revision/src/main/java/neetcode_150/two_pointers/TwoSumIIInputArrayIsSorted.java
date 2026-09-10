package neetcode_150.two_pointers;

/**
 * Problem: Two Sum II - Input Array Is Sorted
 * LeetCode: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
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
public class TwoSumIIInputArrayIsSorted {

    // LeetCode method — implement after the interview discussion.
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] res = new int[2];
        while (start <= end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=== TwoSumIIInputArrayIsSorted test cases ===");
        int[] case1 = new int[]{2, 7, 11, 15};
        System.out.println("Case 1: case 1");
        System.out.println("Input: " + java.util.Arrays.toString(case1));
        printArray(twoSum(case1, 9));
        ;
        int[] case2 = new int[]{2, 3, 4};
        System.out.println("Case 2: case 2");
        System.out.println("Input: " + java.util.Arrays.toString(case2));
        printArray(twoSum(case2, 6));
        System.out.println("All TwoSumIIInputArrayIsSorted scenarios reviewed.");

        int[] case3 = new int[]{-1, 0};
        System.out.println("Case 2: case 2");
        System.out.println("Input: " + java.util.Arrays.toString(case3));
        printArray(twoSum(case3, -1));

        System.out.println("All TwoSumIIInputArrayIsSorted scenarios reviewed.");
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
