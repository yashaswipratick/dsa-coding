# Pattern: Modified Binary Search

## Signal phrases
- "Sorted **rotated** array"
- "Find peak / mountain"
- "Bitonic array"
- "Binary search on answer" (min/max with monotonic predicate)
- 2-D sorted matrix

## Template — Rotated array

```java
int search(int[] a, int t) {
    int lo = 0, hi = a.length - 1;
    while (lo <= hi) {
        int m = lo + (hi - lo) / 2;
        if (a[m] == t) return m;
        if (a[lo] <= a[m]) {                  // left half sorted
            if (a[lo] <= t && t < a[m]) hi = m - 1;
            else lo = m + 1;
        } else {                              // right half sorted
            if (a[m] < t && t <= a[hi]) lo = m + 1;
            else hi = m - 1;
        }
    }
    return -1;
}
```

## Template — BS on answer

```java
int lo = minPossible, hi = maxPossible;
while (lo < hi) {
    int m = lo + (hi - lo) / 2;
    if (canDo(m)) hi = m; else lo = m + 1;
}
return lo;
```

See **topics/binary-search.md** for 45 problems.
