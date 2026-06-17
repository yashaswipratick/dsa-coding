# Binary Search Tree (BST)

## Property
For every node: `left.val < node.val < right.val` (strict, or non-strict for variants).

In-order traversal of a BST = **sorted ascending**.

## Sub-patterns
1. Validate BST (use min/max bounds)
2. Insert / Delete
3. Kth smallest / largest (inorder traversal)
4. Range queries
5. LCA in BST — `val` tells you direction
6. Convert sorted array/list → height-balanced BST
7. BST iterator (controlled inorder)

## Templates

```java
// Validate
boolean valid(TreeNode n, long lo, long hi) {
    if (n == null) return true;
    if (n.val <= lo || n.val >= hi) return false;
    return valid(n.left, lo, n.val) && valid(n.right, n.val, hi);
}

// Delete node
TreeNode del(TreeNode r, int k) {
    if (r == null) return null;
    if (k < r.val) r.left  = del(r.left, k);
    else if (k > r.val) r.right = del(r.right, k);
    else {
        if (r.left == null) return r.right;
        if (r.right == null) return r.left;
        TreeNode succ = r.right;
        while (succ.left != null) succ = succ.left;
        r.val = succ.val;
        r.right = del(r.right, succ.val);
    }
    return r;
}
```

## Pitfalls
- `Integer.MIN/MAX` bounds — use `long` to compare safely.
- Equal values: problem-dependent (most LC use strict `<`).
- Skewed BST = linked list → O(n).

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 108 |[Convert Sorted Array to BST](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) | [ ] |
| 235 |[LCA of BST](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | [ ] |
| 270 |[Closest BST Value](https://leetcode.com/problems/closest-binary-search-tree-value/) | [ ] |
| 530 |[Min Absolute Diff in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/) | [ ] |
| 538 |[Convert BST to Greater Tree](https://leetcode.com/problems/convert-bst-to-greater-tree/) | [ ] |
| 653 |[Two Sum IV BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) | [ ] |
| 700 |[Search in a BST](https://leetcode.com/problems/search-in-a-binary-search-tree/) | [ ] |
| 783 |[Min Distance Between BST Nodes](https://leetcode.com/problems/minimum-distance-between-bst-nodes/) | [ ] |
| 897 |[Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree/) | [ ] |
| 938 |[Range Sum BST](https://leetcode.com/problems/range-sum-of-bst/) | [ ] |
| 1305 |[All Elements 2 BSTs](https://leetcode.com/problems/all-elements-in-two-binary-search-trees/) | [ ] |
| 1469 |[Find All Lonely Nodes](https://leetcode.com/problems/find-all-the-lonely-nodes/) | [ ] |
| 2236 |[Root Equals Sum of Children](https://leetcode.com/problems/root-equals-sum-of-children/) | [ ] |
| 2331 |[Evaluate Boolean Binary Tree](https://leetcode.com/problems/evaluate-boolean-binary-tree/) | [ ] |
| 671 |[Second Min Node in BT](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 95 |[Unique BSTs II](https://leetcode.com/problems/unique-binary-search-trees-ii/) | [ ] |
| 96 |[Unique BSTs](https://leetcode.com/problems/unique-binary-search-trees/) | [ ] |
| 98 |[Validate BST](https://leetcode.com/problems/validate-binary-search-tree/) | [ ] |
| 109 |[Convert Sorted List to BST](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) | [ ] |
| 173 |[BST Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) | [ ] |
| 222 |[Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/) | [ ] |
| 230 |[Kth Smallest in BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | [ ] |
| 235 |[LCA of BST](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | [ ] |
| 285 |[Inorder Successor BST](https://leetcode.com/problems/inorder-successor-in-bst/) | [ ] |
| 426 |[Convert BST to Doubly LL](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/) | [ ] |
| 449 |[Serialize/Deserialize BST](https://leetcode.com/problems/serialize-and-deserialize-bst/) | [ ] |
| 450 |[Delete Node in BST](https://leetcode.com/problems/delete-node-in-a-bst/) | [ ] |
| 510 |[Inorder Successor BST II](https://leetcode.com/problems/inorder-successor-in-bst-ii/) | [ ] |
| 701 |[Insert into BST](https://leetcode.com/problems/insert-into-a-binary-search-tree/) | [ ] |
| 1382 |[Balance BST](https://leetcode.com/problems/balance-a-binary-search-tree/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 99 |[Recover BST](https://leetcode.com/problems/recover-binary-search-tree/) | [ ] |
| 220 |[Contains Duplicate III](https://leetcode.com/problems/contains-duplicate-iii/) | [ ] |
| 315 |[Count of Smaller After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | [ ] |
| 327 |[Count of Range Sum](https://leetcode.com/problems/count-of-range-sum/) | [ ] |
| 352 |[Data Stream as Disjoint Intervals](https://leetcode.com/problems/data-stream-as-disjoint-intervals/) | [ ] |
| 493 |[Reverse Pairs](https://leetcode.com/problems/reverse-pairs/) | [ ] |
| 715 |[Range Module](https://leetcode.com/problems/range-module/) | [ ] |
| 729 |[My Calendar I](https://leetcode.com/problems/my-calendar-i/) | [ ] |
| 731 |[My Calendar II](https://leetcode.com/problems/my-calendar-ii/) | [ ] |
| 732 |[My Calendar III](https://leetcode.com/problems/my-calendar-iii/) | [ ] |
| 218 |[The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/) | [ ] |
| 2179 |[Count Good Triplets in an Array](https://leetcode.com/problems/count-good-triplets-in-an-array/) | [ ] |
| 855 |[Exam Room](https://leetcode.com/problems/exam-room/) | [ ] |
| 2407 |[Longest Increasing Subseq II](https://leetcode.com/problems/longest-increasing-subsequence-ii/) | [ ] |
| 2519 |[Count the Number of K-Big Indices](https://leetcode.com/problems/count-the-number-of-k-big-indices/) | [ ] |

