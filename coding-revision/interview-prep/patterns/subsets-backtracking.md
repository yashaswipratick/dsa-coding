# Pattern: Subsets / Backtracking

## Signal phrases
- "All subsets / combinations / permutations"
- "All paths / words / valid configurations"
- "N-queens / Sudoku"
- "Word search"

## Template

```java
void backtrack(int start, List<Integer> path) {
    result.add(new ArrayList<>(path));
    for (int i = start; i < n; i++) {
        if (i > start && a[i] == a[i-1]) continue;   // dup skip (sorted)
        path.add(a[i]);
        backtrack(i + 1, path);      // i+1 for subsets/combinations
        path.remove(path.size() - 1);
    }
}
```

## Permutations template

```java
void permute(boolean[] used, List<Integer> path) {
    if (path.size() == n) { result.add(new ArrayList<>(path)); return; }
    for (int i = 0; i < n; i++) {
        if (used[i]) continue;
        if (i > 0 && a[i] == a[i-1] && !used[i-1]) continue; // dup skip
        used[i] = true; path.add(a[i]);
        permute(used, path);
        path.remove(path.size()-1); used[i] = false;
    }
}
```

## Pitfalls
- Forget `new ArrayList<>(path)` when adding to result.
- Forget to undo state.
- Pruning matters on Hard problems.

See **topics/recursion-and-backtracking.md** for 45 problems.
