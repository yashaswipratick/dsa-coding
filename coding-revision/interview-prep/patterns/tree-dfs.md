# Pattern: Tree DFS

## Signal phrases
- "Path sum / max path"
- "Diameter"
- "Validate tree property"
- "LCA"
- "Construct from traversals"

## Templates

```java
// Top-down (pass info down)
void dfs(TreeNode n, int sum) {
    if (n == null) return;
    sum += n.val;
    if (n.left == null && n.right == null) { /* leaf logic */ }
    dfs(n.left, sum); dfs(n.right, sum);
}

// Bottom-up (return info up)
int height(TreeNode n) {
    if (n == null) return 0;
    int l = height(n.left), r = height(n.right);
    diameter = Math.max(diameter, l + r);
    return 1 + Math.max(l, r);
}
```

## Variations
- Iterative DFS with explicit stack
- Return tuple (need wrapper class in Java)
- LCA: return non-null if matching descendant found

## Problems

| # | Problem | Done |
|---|---|---|
| 104 |[Max Depth](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | [ ] |
| 110 |[Balanced Tree](https://leetcode.com/problems/balanced-binary-tree/) | [ ] |
| 112 |[Path Sum](https://leetcode.com/problems/path-sum/) | [ ] |
| 113 |[Path Sum II](https://leetcode.com/problems/path-sum-ii/) | [ ] |
| 124 |[Max Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | [ ] |
| 129 |[Sum Root to Leaf](https://leetcode.com/problems/sum-root-to-leaf-numbers/) | [ ] |
| 236 |[LCA](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | [ ] |
| 437 |[Path Sum III](https://leetcode.com/problems/path-sum-iii/) | [ ] |
| 543 |[Diameter](https://leetcode.com/problems/diameter-of-binary-tree/) | [ ] |
| 863 |[All Nodes Distance K](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) | [ ] |
| 968 |[Binary Tree Cameras](https://leetcode.com/problems/binary-tree-cameras/) | [ ] |

Full list in **topics/trees-binary-tree.md**.
