# Pattern: Fast & Slow Pointers (Tortoise & Hare)

## Signal phrases
- "Cycle in linked list / array"
- "Middle of linked list"
- "Happy number" / cycle detection in sequence
- "Find duplicate using O(1) space" (LC 287)
- "Palindrome linked list"

## Templates

```java
// Cycle detection
ListNode s = head, f = head;
while (f != null && f.next != null) {
    s = s.next; f = f.next.next;
    if (s == f) return true;
}
return false;

// Cycle entry
ListNode s = head, f = head;
while (f != null && f.next != null) {
    s = s.next; f = f.next.next;
    if (s == f) break;
}
if (f == null || f.next == null) return null;
s = head;
while (s != f) { s = s.next; f = f.next; }
return s;

// Middle of list
ListNode s = head, f = head;
while (f != null && f.next != null) { s = s.next; f = f.next.next; }
return s;
```

## Problems (samples)

### Easy
| # | Problem | Done |
|---|---|---|
| 141 |[Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | [ ] |
| 202 |[Happy Number](https://leetcode.com/problems/happy-number/) | [ ] |
| 876 |[Middle of LL](https://leetcode.com/problems/middle-of-the-linked-list/) | [ ] |
| 234 |[Palindrome LL](https://leetcode.com/problems/palindrome-linked-list/) | [ ] |
| 160 |[Intersection of Two LL](https://leetcode.com/problems/intersection-of-two-linked-lists/) | [ ] |

### Medium
| # | Problem | Done |
|---|---|---|
| 142 |[Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | [ ] |
| 287 |[Find Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [ ] |
| 143 |[Reorder List](https://leetcode.com/problems/reorder-list/) | [ ] |
| 19 |[Remove Nth from End](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | [ ] |
| 457 |[Circular Array Loop](https://leetcode.com/problems/circular-array-loop/) | [ ] |

### Hard
| # | Problem | Done |
|---|---|---|
| 25 |[Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [ ] |
| 23 |[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [ ] |

> Full list in **topics/linked-list.md** and **topics/two-pointers.md**.
