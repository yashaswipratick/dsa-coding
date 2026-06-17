# Stacks & Queues

## Java picks
| Need | Use |
|---|---|
| Stack | `Deque<Integer> st = new ArrayDeque<>(); st.push(x); st.pop(); st.peek();` |
| Queue (FIFO) | `Deque<Integer> q = new ArrayDeque<>(); q.offer(x); q.poll(); q.peek();` |
| Min/Max queue | `Deque` with monotonic invariant |
| Priority queue | `PriorityQueue<>` (min-heap default) |

⚠️ Avoid `java.util.Stack` (legacy, synchronized).

## Sub-patterns
1. **Parenthesis matching** — push open, pop on close
2. **Expression evaluation** — operand stack + operator stack
3. **Min-stack** — pair `(val, currentMin)`
4. **Monotonic stack** — next greater / smaller (see `monotonic-stack.md`)
5. **BFS using queue**
6. **Sliding window using deque**

## Templates

```java
// Valid Parentheses
Deque<Character> st = new ArrayDeque<>();
for (char c : s.toCharArray()) {
    if (c=='(') st.push(')');
    else if (c=='[') st.push(']');
    else if (c=='{') st.push('}');
    else if (st.isEmpty() || st.pop()!=c) return false;
}
return st.isEmpty();
```

## Pitfalls
- `ArrayDeque` does NOT allow `null`.
- `peek()` vs `element()` — peek returns null, element throws.
- For stack of `int`, use `Deque<Integer>`, not raw `int[]` unless size known.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 20 |[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | [ ] |
| 155 |[Min Stack](https://leetcode.com/problems/min-stack/) | [ ] |
| 225 |[Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/) | [ ] |
| 232 |[Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/) | [ ] |
| 234 |[Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [ ] |
| 496 |[Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/) | [ ] |
| 682 |[Baseball Game](https://leetcode.com/problems/baseball-game/) | [ ] |
| 844 |[Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | [ ] |
| 933 |[Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/) | [ ] |
| 1021 |[Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/) | [ ] |
| 1047 |[Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) | [ ] |
| 1614 |[Max Nesting Depth of Parentheses](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/) | [ ] |
| 2073 |[Time Needed to Buy Tickets](https://leetcode.com/problems/time-needed-to-buy-tickets/) | [ ] |
| 2696 |[Min String Length After Removing Substrings](https://leetcode.com/problems/minimum-string-length-after-removing-substrings/) | [ ] |
| 3174 |[Clear Digits](https://leetcode.com/problems/clear-digits/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 71 |[Simplify Path](https://leetcode.com/problems/simplify-path/) | [ ] |
| 150 |[Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | [ ] |
| 173 |[Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) | [ ] |
| 227 |[Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/) | [ ] |
| 341 |[Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/) | [ ] |
| 394 |[Decode String](https://leetcode.com/problems/decode-string/) | [ ] |
| 402 |[Remove K Digits](https://leetcode.com/problems/remove-k-digits/) | [ ] |
| 456 |[132 Pattern](https://leetcode.com/problems/132-pattern/) | [ ] |
| 503 |[Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/) | [ ] |
| 622 |[Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) | [ ] |
| 641 |[Design Circular Deque](https://leetcode.com/problems/design-circular-deque/) | [ ] |
| 739 |[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [ ] |
| 921 |[Min Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/) | [ ] |
| 946 |[Validate Stack Sequences](https://leetcode.com/problems/validate-stack-sequences/) | [ ] |
| 1249 |[Min Remove to Make Valid Parens](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 32 |[Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | [ ] |
| 42 |[Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | [ ] |
| 84 |[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [ ] |
| 85 |[Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | [ ] |
| 224 |[Basic Calculator](https://leetcode.com/problems/basic-calculator/) | [ ] |
| 239 |[Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [ ] |
| 295 |[Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | [ ] |
| 316 |[Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/) | [ ] |
| 321 |[Create Maximum Number](https://leetcode.com/problems/create-maximum-number/) | [ ] |
| 591 |[Tag Validator](https://leetcode.com/problems/tag-validator/) | [ ] |
| 726 |[Number of Atoms](https://leetcode.com/problems/number-of-atoms/) | [ ] |
| 770 |[Basic Calculator IV](https://leetcode.com/problems/basic-calculator-iv/) | [ ] |
| 772 |[Basic Calculator III](https://leetcode.com/problems/basic-calculator-iii/) | [ ] |
| 895 |[Maximum Frequency Stack](https://leetcode.com/problems/maximum-frequency-stack/) | [ ] |
| 1944 |[Number of Visible People in a Queue](https://leetcode.com/problems/number-of-visible-people-in-a-queue/) | [ ] |

