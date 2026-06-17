# Edge Cases Checklist — Run BEFORE submitting

Use this every single time. Tick mentally; if your solution would break, fix it before clicking "Run".

---

## Universal (every problem)

- [ ] Empty input — `[]`, `""`, `null`
- [ ] Single element
- [ ] Two elements (smallest "non-trivial" case)
- [ ] All elements identical
- [ ] Already sorted ascending
- [ ] Already sorted descending
- [ ] Negative numbers, zero, positives mixed
- [ ] Min / max boundary values of the input range (`Integer.MIN_VALUE`, `MAX_VALUE`)
- [ ] **Overflow** — use `long` if sum/product can exceed `2^31-1`
- [ ] Max-size input — does it fit in time? In memory?
- [ ] Target / key not present
- [ ] Target / key appears multiple times

---

## Arrays

- [ ] First and last index access (off-by-one)
- [ ] Index = `n-1` doesn't go out of bounds in inner loop
- [ ] Modifying while iterating
- [ ] All negatives → answer like "max subarray sum" should still return a negative number, not 0
- [ ] Array contains the target multiple times
- [ ] Sub-array of length 0 or full length
- [ ] 2D array: `rows=0`, `cols=0`, jagged rows

---

## Strings

- [ ] Empty string
- [ ] Single character
- [ ] All same character ("aaaaa")
- [ ] Unicode / non-ASCII (`length()` vs `codePointCount`)
- [ ] Case sensitivity ("A" vs "a")
- [ ] Leading / trailing whitespace
- [ ] Multiple consecutive spaces
- [ ] String contains only digits / only letters
- [ ] Palindromic input
- [ ] Pattern longer than text

---

## Linked Lists

- [ ] `head == null`
- [ ] Single node
- [ ] Two nodes
- [ ] Cycle (last node points back)
- [ ] `k > length` (for rotate / reverse-in-groups)
- [ ] `k == 0` or `k == length`
- [ ] Removing head node
- [ ] Removing tail node
- [ ] All nodes have same value (for dedup problems)
- [ ] Always use a **dummy node** for insertion/removal problems

---

## Trees

- [ ] `root == null`
- [ ] Single node
- [ ] Only left children (skewed → recursion stack)
- [ ] Only right children (skewed)
- [ ] Perfect / complete tree
- [ ] All nodes same value
- [ ] BST: violated property at deep node
- [ ] Negative node values (affects path sum)
- [ ] Path includes single node (length 1 path)

---

## Graphs

- [ ] Empty graph (0 nodes)
- [ ] Single node, no edges
- [ ] Disconnected components
- [ ] Self-loops (node → node)
- [ ] Parallel / duplicate edges
- [ ] Cycle (directed and undirected)
- [ ] DAG vs cyclic
- [ ] Negative-weight edges (Dijkstra fails!)
- [ ] Negative cycle (Bellman-Ford fails!)
- [ ] Start == target
- [ ] Target unreachable

---

## Matrix / 2D Grid

- [ ] `m == 0` or `n == 0`
- [ ] 1×1 grid
- [ ] 1×n single row
- [ ] n×1 single column
- [ ] Non-square (m ≠ n)
- [ ] All cells same value
- [ ] All blocked / all open (for path problems)
- [ ] Start cell == end cell
- [ ] Boundary cells (corners, edges)
- [ ] Out-of-bounds in 4/8 directional neighbor check

---

## Numeric / Math

- [ ] `n == 0`, `n == 1`
- [ ] Negative input
- [ ] Integer overflow on `int + int`, `int * int`
- [ ] Division by zero
- [ ] `Math.abs(Integer.MIN_VALUE)` overflows! (returns negative)
- [ ] Modulo with negative numbers (`%` in Java can return negative)
- [ ] Floating point comparison (use epsilon, never `==`)

---

## Dynamic Programming

- [ ] Base case: `dp[0]` initialized correctly
- [ ] Base case: empty input returns 0 / 1 / -1 (depends on problem)
- [ ] Result is the value, not the size, of the DP cell?
- [ ] Off-by-one when string indexing (`s.substring(i, j+1)`)
- [ ] Memoization key includes ALL changing parameters
- [ ] Iteration order (bottom-up): does cell `(i,j)` depend on already-filled cells?

---

## Backtracking / Recursion

- [ ] Base case fires before recursion (otherwise stack overflow)
- [ ] Undo state changes after recursive call (true backtracking)
- [ ] Pass copy vs reference of collection (`new ArrayList<>(current)`)
- [ ] Pruning conditions don't accidentally skip valid answers
- [ ] Duplicates in input — sort + skip-when-equal-to-previous

---

## Sliding Window

- [ ] Window of size 0 or 1
- [ ] Window covers entire array
- [ ] Shrinking condition runs even when window is already empty
- [ ] Result captured at every valid window, not just at the end

---

## Binary Search

- [ ] `lo == hi`
- [ ] `lo > hi` exit condition
- [ ] `mid = lo + (hi - lo) / 2` (avoid overflow)
- [ ] Off-by-one: `<=` vs `<` in loop, `mid+1` vs `mid`
- [ ] Target smaller than all / larger than all
- [ ] All elements equal

---

## Final pre-submit micro-routine

1. Re-read the problem statement once more.
2. Re-read your loop bounds.
3. Walk the **smallest non-trivial input** by hand through your code.
4. Walk the **largest boundary** mentally for overflow.
5. Confirm return type matches (`int` vs `long`, `List<List<Integer>>` vs `int[][]`).

