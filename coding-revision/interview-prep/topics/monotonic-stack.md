# Monotonic Stack

## When to use (trigger phrases)
- "Next greater / next smaller element"
- "Previous greater / smaller"
- "Largest rectangle / area"
- "Stock span"
- "Sum of subarray minimums / maximums"

## Idea
Maintain a stack whose values are **monotonic** (increasing or decreasing). When a violating element arrives, pop and process.

## Template — Next Greater Element

```java
int[] nextGreater(int[] a) {
    int n = a.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);
    Deque<Integer> st = new ArrayDeque<>();   // stores indices, values decreasing
    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && a[st.peek()] < a[i]) {
            res[st.pop()] = a[i];
        }
        st.push(i);
    }
    return res;
}
```

## Variations
- **Circular array** → iterate `2n` times, `i % n`.
- **Largest rectangle in histogram** → push indices, on smaller incoming pop and compute area.
- **Sum of subarray mins (#907)** → for each element find # of subarrays where it's min using prev/next smaller.

## Pitfalls
- Decide: indices vs values on the stack (indices are usually safer).
- `<` vs `<=` matters for handling duplicates.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 496 |[Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/) | [ ] |
| 1019 |[Next Greater Node In Linked List](https://leetcode.com/problems/next-greater-node-in-linked-list/) | [ ] |
| 682 |[Baseball Game](https://leetcode.com/problems/baseball-game/) | [ ] |
| 844 |[Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | [ ] |
| 1047 |[Remove All Adjacent Duplicates](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) | [ ] |
| 155 |[Min Stack](https://leetcode.com/problems/min-stack/) | [ ] |
| 232 |[Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/) | [ ] |
| 225 |[Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/) | [ ] |
| 1700 |[Number of Students Unable to Eat Lunch](https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/) | [ ] |
| 933 |[Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/) | [ ] |
| 1021 |[Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/) | [ ] |
| 1614 |[Max Nesting Depth of Parentheses](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/) | [ ] |
| 2696 |[Min String Length After Removing Substrings](https://leetcode.com/problems/minimum-string-length-after-removing-substrings/) | [ ] |
| 1475 |[Final Prices with Special Discount](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/) | [ ] |
| 3174 |[Clear Digits](https://leetcode.com/problems/clear-digits/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 402 |[Remove K Digits](https://leetcode.com/problems/remove-k-digits/) | [ ] |
| 456 |[132 Pattern](https://leetcode.com/problems/132-pattern/) | [ ] |
| 503 |[Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/) | [ ] |
| 739 |[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [ ] |
| 853 |[Car Fleet](https://leetcode.com/problems/car-fleet/) | [ ] |
| 901 |[Online Stock Span](https://leetcode.com/problems/online-stock-span/) | [ ] |
| 907 |[Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/) | [ ] |
| 946 |[Validate Stack Sequences](https://leetcode.com/problems/validate-stack-sequences/) | [ ] |
| 1249 |[Min Remove Make Valid Parens](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/) | [ ] |
| 1762 |[Buildings With Ocean View](https://leetcode.com/problems/buildings-with-an-ocean-view/) | [ ] |
| 1944 |[Visible People in a Queue](https://leetcode.com/problems/number-of-visible-people-in-a-queue/) | [ ] |
| 2104 |[Sum of Subarray Ranges](https://leetcode.com/problems/sum-of-subarray-ranges/) | [ ] |
| 2487 |[Remove Nodes From LL](https://leetcode.com/problems/remove-nodes-from-linked-list/) | [ ] |
| 1003 |[Check If Word Is Valid After Substitutions](https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/) | [ ] |
| 71 |[Simplify Path](https://leetcode.com/problems/simplify-path/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 42 |[Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | [ ] |
| 84 |[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [ ] |
| 85 |[Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | [ ] |
| 316 |[Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/) | [ ] |
| 321 |[Create Maximum Number](https://leetcode.com/problems/create-maximum-number/) | [ ] |
| 768 |[Max Chunks To Make Sorted II](https://leetcode.com/problems/max-chunks-to-make-sorted-ii/) | [ ] |
| 895 |[Maximum Frequency Stack](https://leetcode.com/problems/maximum-frequency-stack/) | [ ] |
| 975 |[Odd Even Jump](https://leetcode.com/problems/odd-even-jump/) | [ ] |
| 1130 |[Min Cost Tree From Leaf Values](https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/) | [ ] |
| 1063 |[Number of Valid Subarrays](https://leetcode.com/problems/number-of-valid-subarrays/) | [ ] |
| 1856 |[Max Subarray Min-Product](https://leetcode.com/problems/maximum-subarray-min-product/) | [ ] |
| 2030 |[Smallest K-Length Subsequence](https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/) | [ ] |
| 1793 |[Max Score of a Good Subarray](https://leetcode.com/problems/maximum-score-of-a-good-subarray/) | [ ] |
| 962 |[Maximum Width Ramp](https://leetcode.com/problems/maximum-width-ramp/) | [ ] |
| 2334 |[Subarray With Elements Greater Than Varying Threshold](https://leetcode.com/problems/subarray-with-elements-greater-than-varying-threshold/) | [ ] |

