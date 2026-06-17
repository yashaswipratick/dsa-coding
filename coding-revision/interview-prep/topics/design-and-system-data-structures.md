# Design & System Data Structures

Problems where you build a custom data structure with specific O(?) guarantees.

## Recipe
1. List the operations and target time-complexities.
2. Pick primitives: HashMap, LinkedHashMap, Doubly-linked list, Heap, Trie, TreeMap.
3. Maintain invariants between them on every op.
4. Use **dummy head & tail** in doubly-linked list to remove null checks.

## Doubly-linked list node template

```java
class Node {
    int key, val;
    Node prev, next;
    Node(int k, int v){ key=k; val=v; }
}
```

## LRU Cache skeleton (O(1) get & put)

```java
class LRUCache {
    int cap;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0,0), tail = new Node(0,0);

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail; tail.prev = head;
    }
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        remove(n); addFront(n);
        return n.val;
    }
    public void put(int key, int val) {
        if (map.containsKey(key)) remove(map.get(key));
        Node n = new Node(key, val);
        addFront(n); map.put(key, n);
        if (map.size() > cap) {
            Node lru = tail.prev;
            remove(lru); map.remove(lru.key);
        }
    }
    private void remove(Node n){ n.prev.next=n.next; n.next.prev=n.prev; map.remove(n.key); }
    private void addFront(Node n){ n.next=head.next; n.prev=head; head.next.prev=n; head.next=n; map.put(n.key,n); }
}
```

## Design problems pattern map

| Problem | Core idea |
|---|---|
| LRU | HashMap + doubly-linked list |
| LFU | HashMap + freq → DLL; minFreq tracker |
| O(1) Insert/Delete/Random | HashMap + ArrayList; swap with last on delete |
| Min Stack | Stack of `(val, currentMin)` |
| Snake Game | Deque + Set of body cells |
| Twitter | userId→tweets, userId→follows; merge K heaps for feed |
| Tic-Tac-Toe | row[], col[], diag, anti-diag counters |
| Hit Counter | Queue / circular buffer |
| Phone Directory | available queue + used set |

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 155 |[Min Stack](https://leetcode.com/problems/min-stack/) | [ ] |
| 225 |[Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/) | [ ] |
| 232 |[Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/) | [ ] |
| 705 |[Design HashSet](https://leetcode.com/problems/design-hashset/) | [ ] |
| 706 |[Design HashMap](https://leetcode.com/problems/design-hashmap/) | [ ] |
| 933 |[Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/) | [ ] |
| 1603 |[Design Parking System](https://leetcode.com/problems/design-parking-system/) | [ ] |
| 1656 |[Design Ordered Stream](https://leetcode.com/problems/design-an-ordered-stream/) | [ ] |
| 2241 |[Design ATM Machine](https://leetcode.com/problems/design-an-atm-machine/) | [ ] |
| 2502 |[Design Memory Allocator](https://leetcode.com/problems/design-memory-allocator/) | [ ] |
| 2353 |[Design a Food Rating System](https://leetcode.com/problems/design-a-food-rating-system/) | [ ] |
| 1396 |[Design Underground System](https://leetcode.com/problems/design-underground-system/) | [ ] |
| 1845 |[Seat Reservation Manager](https://leetcode.com/problems/seat-reservation-manager/) | [ ] |
| 2526 |[Find Consecutive Integers from Data Stream](https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/) | [ ] |
| 379 |[Design Phone Directory](https://leetcode.com/problems/design-phone-directory/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 146 |[LRU Cache](https://leetcode.com/problems/lru-cache/) | [ ] |
| 173 |[BST Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) | [ ] |
| 208 |[Implement Trie](https://leetcode.com/problems/implement-trie-prefix-tree/) | [ ] |
| 211 |[Add and Search Word](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | [ ] |
| 271 |[Encode/Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/) | [ ] |
| 284 |[Peeking Iterator](https://leetcode.com/problems/peeking-iterator/) | [ ] |
| 348 |[Design Tic-Tac-Toe](https://leetcode.com/problems/design-tic-tac-toe/) | [ ] |
| 355 |[Design Twitter](https://leetcode.com/problems/design-twitter/) | [ ] |
| 359 |[Logger Rate Limiter](https://leetcode.com/problems/logger-rate-limiter/) | [ ] |
| 362 |[Design Hit Counter](https://leetcode.com/problems/design-hit-counter/) | [ ] |
| 380 |[Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/) | [ ] |
| 535 |[Encode/Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/) | [ ] |
| 622 |[Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) | [ ] |
| 641 |[Design Circular Deque](https://leetcode.com/problems/design-circular-deque/) | [ ] |
| 1166 |[Design File System](https://leetcode.com/problems/design-file-system/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 295 |[Find Median Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | [ ] |
| 297 |[Serialize/Deserialize Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [ ] |
| 432 |[All O`one Data Structure](https://leetcode.com/problems/all-oone-data-structure/) | [ ] |
| 460 |[LFU Cache](https://leetcode.com/problems/lfu-cache/) | [ ] |
| 588 |[Design In-Memory File System](https://leetcode.com/problems/design-in-memory-file-system/) | [ ] |
| 642 |[Design Search Autocomplete System](https://leetcode.com/problems/design-search-autocomplete-system/) | [ ] |
| 715 |[Range Module](https://leetcode.com/problems/range-module/) | [ ] |
| 716 |[Max Stack](https://leetcode.com/problems/max-stack/) | [ ] |
| 895 |[Maximum Frequency Stack](https://leetcode.com/problems/maximum-frequency-stack/) | [ ] |
| 1206 |[Design Skiplist](https://leetcode.com/problems/design-skiplist/) | [ ] |
| 1622 |[Fancy Sequence](https://leetcode.com/problems/fancy-sequence/) | [ ] |
| 1670 |[Design Front Middle Back Queue](https://leetcode.com/problems/design-front-middle-back-queue/) | [ ] |
| 1825 |[Finding MK Average](https://leetcode.com/problems/finding-mk-average/) | [ ] |
| 1912 |[Design Movie Rental System](https://leetcode.com/problems/design-movie-rental-system/) | [ ] |
| 381 |[Insert Delete GetRandom Duplicates Allowed](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/) | [ ] |

