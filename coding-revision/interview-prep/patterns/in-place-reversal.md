# Pattern: In-place Linked List Reversal

## Signal phrases
- "Reverse linked list" (whole / between m..n / every k nodes)
- "Reorder list"
- No extra memory allowed

## Templates

```java
// Reverse whole
ListNode reverse(ListNode head) {
    ListNode prev = null, cur = head;
    while (cur != null) {
        ListNode nxt = cur.next;
        cur.next = prev;
        prev = cur; cur = nxt;
    }
    return prev;
}

// Reverse between m..n — use dummy
ListNode dummy = new ListNode(0); dummy.next = head;
ListNode pre = dummy;
for (int i = 0; i < m - 1; i++) pre = pre.next;
ListNode cur = pre.next;
for (int i = 0; i < n - m; i++) {
    ListNode nxt = cur.next;
    cur.next = nxt.next;
    nxt.next = pre.next;
    pre.next = nxt;
}
return dummy.next;
```

## Problems

| # | Problem | Done |
|---|---|---|
| 206 |[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | [ ] |
| 92 |[Reverse LL II](https://leetcode.com/problems/reverse-linked-list-ii/) | [ ] |
| 24 |[Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | [ ] |
| 25 |[Reverse k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [ ] |
| 61 |[Rotate List](https://leetcode.com/problems/rotate-list/) | [ ] |
| 143 |[Reorder List](https://leetcode.com/problems/reorder-list/) | [ ] |
| 234 |[Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [ ] |

Full list in **topics/linked-list.md**.
