# Pattern Recognition Cheat Sheet

The single most valuable file in this repo. Print it. Stick it next to your monitor.

---

## Table 1 — Trigger phrases → Pattern

Scan the problem statement for these clues.

| If you see in problem… | Likely pattern | Why |
|---|---|---|
| "contiguous subarray / substring", "max/min of size k", "longest substring with…" | **Sliding Window** | Maintain a window and slide it |
| "pair / triplet with target sum", "sorted array", "remove duplicates in place" | **Two Pointers** | Move from both ends or same direction |
| "cycle in linked list / array", "middle of linked list", "happy number" | **Fast & Slow Pointers** | Tortoise & hare detects cycles |
| "overlapping intervals", "merge ranges", "meeting rooms" | **Merge Intervals** | Sort by start, sweep |
| "numbers 1..n with one missing / duplicate", "in-place sort 1..n" | **Cyclic Sort** | Place value v at index v-1 |
| "reverse linked list", "reverse every k nodes", "reorder list" | **In-place Linked List Reversal** | 3-pointer prev/curr/next |
| "level by level", "shortest path in unweighted graph", "min depth" | **BFS (tree or graph)** | Queue, layer count |
| "all paths", "tree-recurse subtree", "preorder/inorder/postorder" | **DFS** | Recursion or stack |
| "median in stream", "schedule with two halves" | **Two Heaps** (max-heap + min-heap) | Median = top of each |
| "all subsets / permutations / combinations", "N-queens", "Sudoku" | **Subsets / Backtracking** | Recurse + undo choice |
| "sorted rotated array", "find peak", "smallest in rotated", "search in matrix" | **Modified Binary Search** | Compare with neighbors / pivot |
| "single number among duplicates", "missing number", "swap without temp" | **Bitwise XOR** | a^a=0 |
| "Kth largest / smallest", "top K frequent", "K closest points" | **Top-K Heap** | Min-heap of size K |
| "merge K sorted lists / arrays", "smallest range covering K lists" | **K-way Merge** | Min-heap of heads |
| "task scheduling", "course prerequisites", "build order", "DAG" | **Topological Sort** | Kahn's BFS or DFS post-order |
| "connected components", "redundant connection", "accounts merge", "islands count" | **Union-Find (DSU)** | union + find with path compression |
| "max value with weight ≤ W, pick or skip" | **0/1 Knapsack DP** | dp[i][w] |
| "min coins to make amount", "unbounded picks" | **Unbounded Knapsack DP** | dp[amount] |
| "nth Fibonacci-like", "climb stairs", "house robber" | **Fibonacci DP (1-D)** | dp[i] = f(dp[i-1], dp[i-2]) |
| "longest palindromic substring/subseq", "min insertions to palindrome" | **Palindrome DP** | dp[i][j] expand or compare ends |
| "longest common subsequence/substring", "edit distance", "interleaving string" | **LCS DP (2-D string)** | dp[i][j] over two strings |
| "unique paths in grid", "min path sum", "dungeon game" | **Matrix DP** | dp[i][j] from neighbors |
| "earliest deadline", "minimum number of meeting rooms", "jump game II" | **Greedy** | Local optimal → global |
| "prefix words", "autocomplete", "longest common prefix in many words" | **Trie** | 26-ary tree of chars |
| "next greater / smaller element", "largest rectangle in histogram", "stock span" | **Monotonic Stack** | Stack keeps increasing/decreasing |
| "range sum query", "count subarrays with sum K" | **Prefix Sum** | preSum[r] - preSum[l-1] |
| "range update + point query (or vice versa) on array, many updates" | **Difference Array / BIT** | diff[l]+=v, diff[r+1]-=v |
| "shortest path with weights ≥ 0" | **Dijkstra** | Min-heap of (dist, node) |
| "shortest path with negative weights", "k stops" | **Bellman-Ford** | Relax E edges V-1 times |
| "all-pairs shortest path", n ≤ 400 | **Floyd-Warshall** | O(V³) DP |
| "min spanning tree" | **Kruskal (DSU) or Prim (heap)** | Greedy edges |
| "stream of unknown length, pick K uniformly" | **Reservoir Sampling** | Replace with prob k/i |
| "two-player optimal play, win/loss" | **Game DP / Minimax** | dp[state] = best of opponent |
| "count bits / power of two / subsets via mask" | **Bit Manipulation / Bitmask DP** | n & (n-1), 1<<n |
| "LRU / LFU cache", "design Twitter feed" | **HashMap + DoublyLinkedList / Heap** | O(1) get/put |

---

## Table 2 — Data structure selection

| Need | Pick | Java class |
|---|---|---|
| O(1) average lookup by key | HashMap | `HashMap<K,V>` |
| Sorted keys, range queries, floor/ceil | TreeMap | `TreeMap<K,V>` |
| Maintain insertion order | LinkedHashMap | `LinkedHashMap<K,V>` |
| Top / smallest element fast | Heap | `PriorityQueue<>` |
| Bottom AND top fast (dequeue both ends) | Deque | `ArrayDeque<>` |
| Sorted unique set with range ops | TreeSet | `TreeSet<>` |
| FIFO queue, BFS | Queue | `ArrayDeque<>` (faster than `LinkedList`) |
| LIFO stack | Stack | `ArrayDeque<>` (`push/pop/peek`) — avoid `java.util.Stack` |
| Counting frequencies | HashMap<K,Integer> | `getOrDefault + put` or `merge(k,1,Integer::sum)` |
| Disjoint sets / unions | Union-Find | hand-rolled `int[] parent, rank` |
| Prefix-based string search | Trie | hand-rolled `TrieNode[26]` |
| Range sum + point update | Fenwick (BIT) | hand-rolled `int[] bit` |
| Range query + range update | Segment Tree | hand-rolled |
| Ordered with k-th element / count less | Tree multiset | `TreeMap<Integer,Integer>` (Java has no built-in TreeMultiset) |

**Java gotchas:**
- `Arrays.sort(int[])` is dual-pivot quicksort (O(n²) worst case adversarial). For objects it's stable mergesort.
- `int[]` boxes to `Integer[]` if you need `Arrays.sort(arr, Comparator)`.
- `PriorityQueue` is a *min*-heap by default. Max-heap: `new PriorityQueue<>(Comparator.reverseOrder())`.
- `HashMap` allows one null key; `TreeMap` does not.
- Use `Long.compare(a,b)` not `(int)(a-b)` to avoid overflow in comparators.

---

## Table 3 — Input size → Expected complexity → Technique

| n (input size) | Acceptable complexity | Typical technique |
|---|---|---|
| n ≤ 10 | O(n!) | Brute permutation, backtracking |
| n ≤ 20 | O(2ⁿ) | Bitmask DP, subset enumeration |
| n ≤ 100 | O(n⁴) | Triple-nested loop + extra |
| n ≤ 500 | O(n³) | Floyd-Warshall, interval DP |
| n ≤ 5,000 | O(n²) | 2-D DP, LCS, LPS |
| n ≤ 10⁵ | O(n log n) | Sort, heap, binary search, segment tree |
| n ≤ 10⁶ | O(n) | Sliding window, two pointers, prefix sum, hashing |
| n ≤ 10⁸ | O(log n) or O(√n) | Pure binary search, math formula |
| n > 10⁹ | O(1) or O(log n) | Math, bit tricks, Fermat's little, matrix expo |

**Rule of thumb:** Java runs ~10⁸ simple ops/sec. Multiply your operation count by your constant factor.

---

## Table 4 — Output type → Likely algorithm family

| Asked to return… | Most common family |
|---|---|
| The count of something | DP, combinatorics, prefix-sum |
| The min/max value | DP, greedy, binary-search-the-answer |
| All possible answers | Backtracking |
| A boolean (exists?) | DFS/BFS, DP, two-pointers |
| The shortest path / minimum steps | BFS (unweighted) or Dijkstra |
| Kth element | Heap or Quickselect |
| The index/indices | Hashing, two-pointers, binary search |
| Modified input in place | Two pointers, cyclic sort |

---

## Table 5 — Binary-Search-the-Answer triggers

If the problem asks for **min/max value** AND you can write a `boolean canDoItWith(x)` that is monotonic, binary-search `x`. Examples:
- Minimum days to ship packages
- Split array largest sum
- Koko eating bananas
- Capacity to ship within D days
- Find smallest divisor given threshold

---

## Quick decision flow

```
START
 │
 ├── Sorted array / search target? ───────► Binary Search / Two Pointers
 │
 ├── Contiguous window of size k or condition? ──► Sliding Window
 │
 ├── Pair/triplet sum, palindrome check? ──► Two Pointers
 │
 ├── Linked list cycle/middle/k-th from end? ──► Fast & Slow Pointers
 │
 ├── All combinations/permutations/subsets? ──► Backtracking
 │
 ├── Top K / Kth / Median in stream? ──► Heap
 │
 ├── Graph: shortest in unweighted? ──► BFS
 ├── Graph: shortest weighted ≥0? ──► Dijkstra
 ├── Graph: connectivity / components / cycle? ──► Union-Find or DFS
 ├── Graph: ordering with deps? ──► Topological Sort
 │
 ├── Min/Max with overlapping subproblems? ──► DP
 │     ├── 1 variable changes ─► 1-D DP
 │     ├── 2 strings/arrays ──► 2-D DP
 │     ├── pick or skip with capacity ──► 0/1 Knapsack
 │     └── unlimited supply ──► Unbounded Knapsack
 │
 ├── Next greater/smaller? ──► Monotonic Stack
 │
 ├── Many range sums? ──► Prefix Sum
 ├── Many range updates? ──► Difference Array / BIT
 │
 └── None match? ──► Brute force, then optimize the waste.
```

