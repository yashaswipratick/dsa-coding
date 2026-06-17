# Binary Trees

## Node
```java
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
```

## Traversals

```java
// DFS recursive
void inorder(TreeNode r, List<Integer> out) {
    if (r == null) return;
    inorder(r.left, out);
    out.add(r.val);
    inorder(r.right, out);
}

// BFS (level-order)
void bfs(TreeNode r) {
    if (r == null) return;
    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(r);
    while (!q.isEmpty()) {
        int sz = q.size();          // freeze current level
        for (int i = 0; i < sz; i++) {
            TreeNode n = q.poll();
            if (n.left != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
    }
}

// Iterative inorder
Deque<TreeNode> st = new ArrayDeque<>();
TreeNode cur = root;
while (cur != null || !st.isEmpty()) {
    while (cur != null) { st.push(cur); cur = cur.left; }
    cur = st.pop();
    out.add(cur.val);
    cur = cur.right;
}
```

## Sub-patterns
1. Top-down (pass info DOWN as parameter)
2. Bottom-up (return info UP from children)
3. Path sum / max path / longest path
4. LCA (Lowest Common Ancestor)
5. Construct from traversals
6. Serialize / deserialize
7. Mirror / symmetry

## Pitfalls
- `null` root.
- Recursion stack overflow on skewed trees → consider iterative.
- Diameter / max path: distinguish "longest going through node" vs "best so far".
- Updating a shared field needs `int[1]` (or instance field) since Java has no pass-by-reference.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 94 |[Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | [ ] |
| 100 |[Same Tree](https://leetcode.com/problems/same-tree/) | [ ] |
| 101 |[Symmetric Tree](https://leetcode.com/problems/symmetric-tree/) | [ ] |
| 104 |[Max Depth](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | [ ] |
| 108 |[Convert Sorted Array to BST](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) | [ ] |
| 110 |[Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/) | [ ] |
| 111 |[Min Depth](https://leetcode.com/problems/minimum-depth-of-binary-tree/) | [ ] |
| 112 |[Path Sum](https://leetcode.com/problems/path-sum/) | [ ] |
| 144 |[Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) | [ ] |
| 145 |[Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/) | [ ] |
| 226 |[Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) | [ ] |
| 257 |[Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/) | [ ] |
| 404 |[Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/) | [ ] |
| 543 |[Diameter](https://leetcode.com/problems/diameter-of-binary-tree/) | [ ] |
| 617 |[Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 102 |[Level Order](https://leetcode.com/problems/binary-tree-level-order-traversal/) | [ ] |
| 103 |[Zigzag Level Order](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | [ ] |
| 105 |[Build Tree from Preorder+Inorder](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | [ ] |
| 106 |[Build Tree from Inorder+Postorder](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | [ ] |
| 113 |[Path Sum II](https://leetcode.com/problems/path-sum-ii/) | [ ] |
| 114 |[Flatten Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | [ ] |
| 116 |[Populating Next Right Pointers](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) | [ ] |
| 117 |[Populating Next Right II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/) | [ ] |
| 129 |[Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/) | [ ] |
| 199 |[Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | [ ] |
| 222 |[Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/) | [ ] |
| 236 |[Lowest Common Ancestor](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | [ ] |
| 314 |[Vertical Order Traversal](https://leetcode.com/problems/binary-tree-vertical-order-traversal/) | [ ] |
| 437 |[Path Sum III](https://leetcode.com/problems/path-sum-iii/) | [ ] |
| 662 |[Max Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 124 |[Max Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | [ ] |
| 297 |[Serialize and Deserialize](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [ ] |
| 99 |[Recover BST](https://leetcode.com/problems/recover-binary-search-tree/) | [ ] |
| 145 |[Postorder Iterative](https://leetcode.com/problems/binary-tree-postorder-traversal/) | [ ] |
| 968 |[Binary Tree Cameras](https://leetcode.com/problems/binary-tree-cameras/) | [ ] |
| 987 |[Vertical Order Traversal](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/) | [ ] |
| 834 |[Sum of Distances in Tree](https://leetcode.com/problems/sum-of-distances-in-tree/) | [ ] |
| 863 |[All Nodes Distance K](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) | [ ] |
| 685 |[Redundant Connection II](https://leetcode.com/problems/redundant-connection-ii/) | [ ] |
| 988 |[Smallest String Starting From Leaf](https://leetcode.com/problems/smallest-string-starting-from-leaf/) | [ ] |
| 2096 |[Step-By-Step Directions Between Two Nodes](https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/) | [ ] |
| 437 |[Path Sum III](https://leetcode.com/problems/path-sum-iii/) | [ ] |
| 428 |[Serialize and Deserialize N-ary Tree](https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/) | [ ] |
| 2538 |[Diff Between Max & Min Price Sum](https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum/) | [ ] |
| 431 |[Encode N-ary Tree to Binary Tree](https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/) | [ ] |
