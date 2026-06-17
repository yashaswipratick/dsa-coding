# Pattern: Two Pointers

## Signal phrases
- Sorted array; pair/triplet/quadruple sum
- Palindrome check; reverse in place
- Remove duplicates / compaction
- Container / area between indices

## Templates

```java
// Opposite ends
int l = 0, r = n - 1;
while (l < r) {
    int s = a[l] + a[r];
    if (s == target) return new int[]{l, r};
    if (s < target) l++; else r--;
}

// Same direction (read + write)
int w = 1;
for (int r = 1; r < n; r++)
    if (a[r] != a[r-1]) a[w++] = a[r];
return w;
```

## Variations
- Three-pointer (3Sum): sort, fix one, two-pointer rest
- Fixed gap (`i`, `i+k`)
- In-place partition (Dutch flag)

See **topics/two-pointers.md** for 45 problems.
