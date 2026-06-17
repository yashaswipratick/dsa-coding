# Pattern: Tree BFS (Level-Order)

## Signal phrases
- "Level order" / "level by level"
- "Right side view"
- "Min depth" (BFS terminates earlier than DFS)
- "Connect nodes at same level"

## Template

```java
Deque<TreeNode> q = new ArrayDeque<>();
q.offer(root);
while (!q.isEmpty()) {
    int sz = q.size();
    List<Integer> level = new ArrayList<>();
    for (int i = 0; i < sz; i++) {
        TreeNode n = q.poll();
        level.add(n.val);
        if (n.left != null) q.offer(n.left);
        if (n.right != null) q.offer(n.right);
    }
    result.add(level);
}
```

## Variations
- Capture only first/last node of each level (right/left view)
- Reverse direction every level (zigzag)
- Tag with column/row index (vertical order)

## Problems

| # | Problem | Done |
|---|---|---|
| 102 |[Level Order](https://leetcode.com/problems/binary-tree-level-order-traversal/) | [ ] |
| 107 |[Level Order Bottom](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/) | [ ] |
| 103 |[Zigzag Level Order](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | [ ] |
| 116 |[Populating Next Right Pointers](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) | [ ] |
| 117 |[Populating Next Right II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/) | [ ] |
| 199 |[Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | [ ] |
| 111 |[Min Depth](https://leetcode.com/problems/minimum-depth-of-binary-tree/) | [ ] |
| 662 |[Max Width](https://leetcode.com/problems/maximum-width-of-binary-tree/) | [ ] |
| 314 |[Vertical Order](https://leetcode.com/problems/binary-tree-vertical-order-traversal/) | [ ] |
| 515 |[Find Largest in Each Row](https://leetcode.com/problems/find-largest-value-in-each-tree-row/) | [ ] |

Full list in **topics/trees-binary-tree.md**.
