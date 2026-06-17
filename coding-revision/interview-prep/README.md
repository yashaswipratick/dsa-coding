# Coding Interview Prep — Master Plan

A 12-week, Java-focused interview preparation system designed to fix two weaknesses:
1. **Logic building from a problem statement.**
2. **Generating edge cases and test inputs.**

Use this folder like a textbook: read foundations → drill patterns → solve topic problems → track progress.

---

## How to use this repo

| Folder / File | Purpose |
|---|---|
| `README.md` (this file) | Master roadmap, frameworks, edge-case method, index |
| **`topic-wise-schedule.md`** ⭐ | **48-week plan: finish ALL Easy → Medium → Hard of ONE topic, then move to the next** |
| **`mock-interview.md`** 🎤 | **Saturday mock interview protocol — copy the prompt, paste it to the AI, run a real mock** |
| `cheatsheet.md` | "If you see X → use Y" pattern recognition lookup |
| `edge-cases-checklist.md` | Print this. Run it before every submission. |
| `problem-approach-template.md` | Copy for every problem you solve |
| `topics/*.md` | 24 topic deep-dives (concepts + APIs + 45 problems each) |
| `patterns/*.md` | ~30 pattern playbooks (template + curated problems each) |

> **🎯 Start here:** Open [`topic-wise-schedule.md`](topic-wise-schedule.md). One topic at a time, all 3 difficulties, ~2 weeks each. 48 weeks total → ~1,000 problems solved.
> **🎤 Saturdays:** Use [`mock-interview.md`](mock-interview.md) — copy the prompt, paste it into a fresh chat with me, and we'll run a real mock interview with a written post-mortem.

---

## 12-Week Roadmap

| Week | Theme | Topics | Patterns |
|---|---|---|---|
| 1 | Arrays & Hashing foundations | arrays-and-strings, hashing | prefix-sum, two-pointers |
| 2 | Windows & Pointers | two-pointers, sliding-window | sliding-window, fast-slow-pointers |
| 3 | Sorting & Binary Search | sorting, binary-search | modified-binary-search, cyclic-sort |
| 4 | Linked Lists | linked-list | in-place-reversal, fast-slow-pointers |
| 5 | Stacks & Queues | stacks-and-queues, monotonic-stack | monotonic-stack |
| 6 | Trees | trees-binary-tree, binary-search-tree | tree-bfs, tree-dfs |
| 7 | Heaps & Tries | heaps-priority-queue, tries | top-k-elements, two-heaps, k-way-merge |
| 8 | Graphs (BFS/DFS) | graphs-bfs-dfs, matrix-2d-grid | graph-bfs, graph-dfs |
| 9 | Graphs (Advanced) | graphs-advanced | topological-sort, union-find, dijkstra, mst |
| 10 | Backtracking & Greedy | recursion-and-backtracking, greedy | subsets-backtracking, greedy |
| 11 | DP Foundations | dynamic-programming | fibonacci-dp, 0-1-knapsack, unbounded-knapsack |
| 12 | DP Advanced + Misc | dynamic-programming, math-and-number-theory, bit-manipulation, intervals, design-and-system-data-structures | lcs-dp, palindrome-dp, matrix-dp, bitwise-xor, merge-intervals, design |

**Daily commitment:** 2–3 LeetCode problems + 1 topic/pattern reading + 30 min review of mistakes.

---

## The UMPIRE Framework — How to Approach Any Problem

| Step | What to do | Time |
|---|---|---|
| **U**nderstand | Restate the problem in your own words. Clarify input range, types, constraints, return value. | 2 min |
| **M**atch | Match the problem to a known pattern using `cheatsheet.md`. | 2 min |
| **P**lan | Write pseudocode or draw the algorithm. Pick the data structure. State complexity *before* coding. | 5 min |
| **I**mplement | Code cleanly. Name variables well. One sub-problem at a time. | 15 min |
| **R**eview | Dry-run on the given example + 1 edge case from your checklist. | 3 min |
| **E**valuate | State final time/space complexity. Discuss alternatives. | 2 min |

**Rule:** Never start typing code before completing U → M → P.

---

## Logic Building — 7-Step Technique to Decode a Problem

If you "freeze" reading a problem, run this every time:

1. **Restate** the problem in one sentence without jargon. ("Given a list of numbers, return two indices whose values sum to a target.")
2. **List inputs & outputs** literally. Types, sizes, value ranges.
3. **Walk one tiny example by hand** (3–4 elements). Write the output you expect.
4. **Walk one edge example** (empty, 1 element, all same).
5. **Brute force first.** Don't worry about speed. State its time complexity. This *guarantees* you understand the problem.
6. **Find the waste.** Where is brute force doing repeated work? That's where the pattern hides.
7. **Match to cheatsheet.** Use the trigger phrases in `cheatsheet.md` to pick a pattern.

### Worked Example A — Two Sum
> Given `nums = [2,7,11,15]`, `target = 9`, return indices of the two numbers that add to target.

1. Restate: find `i, j` s.t. `nums[i] + nums[j] == target`.
2. Input: `int[]` len 2..10^4, values −10^9..10^9, target int. Output: `int[2]`.
3. Hand walk: `2+7=9` → `[0,1]`.
4. Edge: exactly 2 elements `[3,3], target=6` → `[0,1]` (duplicates allowed!).
5. Brute force: two loops → O(n²).
6. Waste: re-scanning the array for each i. We could *remember* what we've seen.
7. Cheatsheet: "find pair with target sum" + "array unsorted" → **HashMap one-pass**.

### Worked Example B — Word Ladder
> Transform `beginWord` to `endWord` one letter at a time, each intermediate word must be in `wordList`. Return shortest length.

1. Restate: shortest sequence of single-char edits between two words via a dictionary.
2. Input: two strings, list of strings (≤5000 words, length ≤10).
3. Hand walk: `hit → hot → dot → dog → cog` = 5.
4. Edge: `endWord` not in list → 0. `beginWord == endWord`? Per problem, won't happen.
5. Brute force: try all permutations of words → exponential.
6. Waste: we're searching states; we want **shortest** path between states.
7. Cheatsheet: "shortest in unweighted graph" + "transformation steps" → **BFS**. Each word is a node; edges connect words that differ by 1 char.

---

## Edge-Case Generation Method (use for EVERY problem)

Run these categories mentally. Full checklist in `edge-cases-checklist.md`.

**Universal:**
- Empty input (`[]`, `""`, `null`)
- Single element
- Two elements
- All same elements
- Already sorted / reverse sorted
- Negatives, zero, positives mixed
- Max / min boundaries of input range (overflow!)
- Maximum size input (performance)
- Duplicates

**Strings:** single char, all same char, unicode, whitespace, case sensitivity, empty substring.
**Arrays:** off-by-one at indices `0` and `n-1`, target not present.
**Linked Lists:** null head, 1 node, 2 nodes, cycle, k > length.
**Trees:** null root, single node, skewed (linked-list-like), perfect, BST violation.
**Graphs:** disconnected, cycle, self-loop, parallel edges, single node, isolated nodes.
**Matrix:** 1×n, n×1, 1×1, non-square, all zeros.
**DP / Math:** n=0, n=1, integer overflow (`long` vs `int`), negative target.

---

## Index of all material

### Topics (`topics/`)
1. [arrays-and-strings](topics/arrays-and-strings.md)
2. [hashing](topics/hashing.md)
3. [two-pointers](topics/two-pointers.md)
4. [sliding-window](topics/sliding-window.md)
5. [prefix-sum](topics/prefix-sum.md)
6. [binary-search](topics/binary-search.md)
7. [sorting](topics/sorting.md)
8. [recursion-and-backtracking](topics/recursion-and-backtracking.md)
9. [linked-list](topics/linked-list.md)
10. [stacks-and-queues](topics/stacks-and-queues.md)
11. [monotonic-stack](topics/monotonic-stack.md)
12. [trees-binary-tree](topics/trees-binary-tree.md)
13. [binary-search-tree](topics/binary-search-tree.md)
14. [tries](topics/tries.md)
15. [heaps-priority-queue](topics/heaps-priority-queue.md)
16. [graphs-bfs-dfs](topics/graphs-bfs-dfs.md)
17. [graphs-advanced](topics/graphs-advanced.md)
18. [greedy](topics/greedy.md)
19. [dynamic-programming](topics/dynamic-programming.md)
20. [bit-manipulation](topics/bit-manipulation.md)
21. [math-and-number-theory](topics/math-and-number-theory.md)
22. [intervals](topics/intervals.md)
23. [matrix-2d-grid](topics/matrix-2d-grid.md)
24. [design-and-system-data-structures](topics/design-and-system-data-structures.md)

### Patterns (`patterns/`)
- [sliding-window](patterns/sliding-window.md), [two-pointers](patterns/two-pointers.md), [fast-slow-pointers](patterns/fast-slow-pointers.md)
- [merge-intervals](patterns/merge-intervals.md), [cyclic-sort](patterns/cyclic-sort.md), [in-place-reversal](patterns/in-place-reversal.md)
- [tree-bfs](patterns/tree-bfs.md), [tree-dfs](patterns/tree-dfs.md)
- [two-heaps](patterns/two-heaps.md), [subsets-backtracking](patterns/subsets-backtracking.md)
- [modified-binary-search](patterns/modified-binary-search.md), [bitwise-xor](patterns/bitwise-xor.md)
- [top-k-elements](patterns/top-k-elements.md), [k-way-merge](patterns/k-way-merge.md)
- [topological-sort](patterns/topological-sort.md), [union-find](patterns/union-find.md)
- [0-1-knapsack](patterns/0-1-knapsack.md), [unbounded-knapsack](patterns/unbounded-knapsack.md)
- [fibonacci-dp](patterns/fibonacci-dp.md), [palindrome-dp](patterns/palindrome-dp.md)
- [lcs-dp](patterns/lcs-dp.md), [matrix-dp](patterns/matrix-dp.md)
- [greedy](patterns/greedy.md), [trie](patterns/trie.md), [monotonic-stack](patterns/monotonic-stack.md)
- [prefix-sum](patterns/prefix-sum.md), [difference-array](patterns/difference-array.md)
- [dijkstra](patterns/dijkstra.md), [mst](patterns/mst.md), [reservoir-sampling](patterns/reservoir-sampling.md)

---

## Supporting files
- `topic-wise-schedule.md` ⭐ — **48-week topic-by-topic plan**
- `mock-interview.md` 🎤 — **Saturday mock interview protocol & prompt**
- `cheatsheet.md` — pattern recognition lookup
- `edge-cases-checklist.md` — pre-submission checklist
- `problem-approach-template.md` — fill-in-the-blank scratch sheet

