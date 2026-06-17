# Recursion & Backtracking

## Mental model
- **Recursion**: solve a problem by reducing to a smaller version of itself.
- **Backtracking**: try a choice → recurse → undo the choice.

## Template

```java
void backtrack(State state, List<List<Integer>> result) {
    if (isGoal(state)) { result.add(new ArrayList<>(state.path)); return; }
    for (Choice c : choices(state)) {
        if (!isValid(c, state)) continue;       // pruning
        apply(c, state);                        // make choice
        backtrack(state, result);
        undo(c, state);                         // undo choice
    }
}
```

## Sub-patterns
1. **Subsets** — include / exclude
2. **Permutations** — used[] flag
3. **Combinations** — start index
4. **Partitioning** — palindrome partition, word break II
5. **Grid / board** — N-Queens, Sudoku, Word Search
6. **Build string / expr** — restore IPs, add operators

## Pitfalls
- Forget `new ArrayList<>(current)` → all results share same reference.
- Duplicate handling: sort + `if (i > start && a[i]==a[i-1]) continue;`
- Stack depth on long inputs.
- Pruning is not optional on Hard problems.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 21 |[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | [ ] |
| 70 |[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | [ ] |
| 104 |[Max Depth Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | [ ] |
| 226 |[Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) | [ ] |
| 231 |[Power of Two](https://leetcode.com/problems/power-of-two/) | [ ] |
| 257 |[Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/) | [ ] |
| 344 |[Reverse String](https://leetcode.com/problems/reverse-string/) | [ ] |
| 401 |[Binary Watch](https://leetcode.com/problems/binary-watch/) | [ ] |
| 509 |[Fibonacci Number](https://leetcode.com/problems/fibonacci-number/) | [ ] |
| 543 |[Diameter Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/) | [ ] |
| 559 |[Max Depth N-ary Tree](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/) | [ ] |
| 589 |[N-ary Tree Preorder](https://leetcode.com/problems/n-ary-tree-preorder-traversal/) | [ ] |
| 617 |[Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/) | [ ] |
| 700 |[Search in a BST](https://leetcode.com/problems/search-in-a-binary-search-tree/) | [ ] |
| 938 |[Range Sum of BST](https://leetcode.com/problems/range-sum-of-bst/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 17 |[Letter Combinations of Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | [ ] |
| 22 |[Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) | [ ] |
| 39 |[Combination Sum](https://leetcode.com/problems/combination-sum/) | [ ] |
| 40 |[Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | [ ] |
| 46 |[Permutations](https://leetcode.com/problems/permutations/) | [ ] |
| 47 |[Permutations II](https://leetcode.com/problems/permutations-ii/) | [ ] |
| 77 |[Combinations](https://leetcode.com/problems/combinations/) | [ ] |
| 78 |[Subsets](https://leetcode.com/problems/subsets/) | [ ] |
| 79 |[Word Search](https://leetcode.com/problems/word-search/) | [ ] |
| 90 |[Subsets II](https://leetcode.com/problems/subsets-ii/) | [ ] |
| 93 |[Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/) | [ ] |
| 131 |[Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) | [ ] |
| 216 |[Combination Sum III](https://leetcode.com/problems/combination-sum-iii/) | [ ] |
| 491 |[Non-decreasing Subsequences](https://leetcode.com/problems/non-decreasing-subsequences/) | [ ] |
| 698 |[Partition K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 10 |[Regex Matching](https://leetcode.com/problems/regular-expression-matching/) | [ ] |
| 37 |[Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | [ ] |
| 44 |[Wildcard Matching](https://leetcode.com/problems/wildcard-matching/) | [ ] |
| 51 |[N-Queens](https://leetcode.com/problems/n-queens/) | [ ] |
| 52 |[N-Queens II](https://leetcode.com/problems/n-queens-ii/) | [ ] |
| 60 |[Permutation Sequence](https://leetcode.com/problems/permutation-sequence/) | [ ] |
| 87 |[Scramble String](https://leetcode.com/problems/scramble-string/) | [ ] |
| 126 |[Word Ladder II](https://leetcode.com/problems/word-ladder-ii/) | [ ] |
| 140 |[Word Break II](https://leetcode.com/problems/word-break-ii/) | [ ] |
| 212 |[Word Search II](https://leetcode.com/problems/word-search-ii/) | [ ] |
| 282 |[Expression Add Operators](https://leetcode.com/problems/expression-add-operators/) | [ ] |
| 301 |[Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/) | [ ] |
| 425 |[Word Squares](https://leetcode.com/problems/word-squares/) | [ ] |
| 489 |[Robot Room Cleaner](https://leetcode.com/problems/robot-room-cleaner/) | [ ] |
| 980 |[Unique Paths III](https://leetcode.com/problems/unique-paths-iii/) | [ ] |

