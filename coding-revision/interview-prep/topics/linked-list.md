# Linked List

## Node template
```java
class ListNode { int val; ListNode next; ListNode(int v){val=v;} }
```

## Sub-patterns
1. **Dummy node** — for insert/delete at head
2. **Two-pointer (fast/slow)** — middle, cycle, Nth from end
3. **In-place reversal** — full / between m..n / k-groups
4. **Merge / sort** — merge two, merge K, sort list
5. **Copy with random pointer** — interleave or hashmap
6. **Reorder** — split + reverse + merge

## Templates

```java
// Reverse
ListNode reverse(ListNode head) {
    ListNode prev = null, cur = head;
    while (cur != null) {
        ListNode nxt = cur.next;
        cur.next = prev;
        prev = cur; cur = nxt;
    }
    return prev;
}

// Detect cycle (Floyd)
boolean hasCycle(ListNode head) {
    ListNode s = head, f = head;
    while (f != null && f.next != null) {
        s = s.next; f = f.next.next;
        if (s == f) return true;
    }
    return false;
}

// Dummy for delete
ListNode dummy = new ListNode(0); dummy.next = head;
ListNode prev = dummy;
while (prev.next != null) { /* may unlink prev.next */ }
return dummy.next;
```

## Pitfalls
- Forgetting to advance pointer → infinite loop.
- Null check before `.next.next`.
- Use dummy node for head removal.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 21 |[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | [ ] |
| 83 |[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) | [ ] |
| 141 |[Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | [ ] |
| 160 |[Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | [ ] |
| 203 |[Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/) | [ ] |
| 206 |[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | [ ] |
| 234 |[Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [ ] |
| 237 |[Delete Node in Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/) | [ ] |
| 876 |[Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | [ ] |
| 1290 |[Convert Binary in LL to Integer](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/) | [ ] |
| 1474 |[Delete N Nodes After M Nodes](https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/) | [ ] |
| 1721 |[Swapping Nodes in LL](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/) | [ ] |
| 1836 |[Remove Duplicates from Unsorted LL](https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/) | [ ] |
| 2058 |[Find Min and Max Number of Nodes Between Critical Points](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/) | [ ] |
| 2181 |[Merge Nodes in Between Zeros](https://leetcode.com/problems/merge-nodes-in-between-zeros/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 2 |[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | [ ] |
| 19 |[Remove Nth Node From End](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | [ ] |
| 24 |[Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | [ ] |
| 61 |[Rotate List](https://leetcode.com/problems/rotate-list/) | [ ] |
| 82 |[Remove Duplicates II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) | [ ] |
| 86 |[Partition List](https://leetcode.com/problems/partition-list/) | [ ] |
| 92 |[Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | [ ] |
| 109 |[Convert Sorted List to BST](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) | [ ] |
| 138 |[Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/) | [ ] |
| 142 |[Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | [ ] |
| 143 |[Reorder List](https://leetcode.com/problems/reorder-list/) | [ ] |
| 146 |[LRU Cache](https://leetcode.com/problems/lru-cache/) | [ ] |
| 147 |[Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/) | [ ] |
| 148 |[Sort List](https://leetcode.com/problems/sort-list/) | [ ] |
| 328 |[Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 23 |[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [ ] |
| 25 |[Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [ ] |
| 117 |[Populating Next Right Pointers II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/) | [ ] |
| 138 |[Copy List with Random Pointer (review)](https://leetcode.com/problems/copy-list-with-random-pointer/) | [ ] |
| 432 |[All O`one Data Structure](https://leetcode.com/problems/all-oone-data-structure/) | [ ] |
| 460 |[LFU Cache](https://leetcode.com/problems/lfu-cache/) | [ ] |
| 622 |[Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) | [ ] |
| 707 |[Design Linked List](https://leetcode.com/problems/design-linked-list/) | [ ] |
| 1206 |[Design Skiplist](https://leetcode.com/problems/design-skiplist/) | [ ] |
| 1670 |[Design Front Middle Back Queue](https://leetcode.com/problems/design-front-middle-back-queue/) | [ ] |
| 379 |[Design Phone Directory](https://leetcode.com/problems/design-phone-directory/) | [ ] |
| 1171 |[Remove Zero Sum Consecutive Nodes](https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/) | [ ] |
| 1019 |[Next Greater Node In LL](https://leetcode.com/problems/next-greater-node-in-linked-list/) | [ ] |
| 725 |[Split LL in Parts](https://leetcode.com/problems/split-linked-list-in-parts/) | [ ] |
| 369 |[Plus One Linked List](https://leetcode.com/problems/plus-one-linked-list/) | [ ] |

