# Pattern: Merge Intervals

## Signal phrases
- "Overlapping intervals"
- "Merge / insert intervals"
- "Meeting rooms"
- "Min number of rooms / arrows / groups"

## Template

```java
Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
List<int[]> out = new ArrayList<>();
for (int[] iv : intervals) {
    if (!out.isEmpty() && out.get(out.size()-1)[1] >= iv[0]) {
        out.get(out.size()-1)[1] = Math.max(out.get(out.size()-1)[1], iv[1]);
    } else out.add(iv);
}
```

## Overlap rule
`[a,b]` and `[c,d]` overlap iff `a < d && c < b`.

## Variations
- Sort by start vs by end (greedy ≠ same problem)
- Sweep events `(time, +1/-1)`

See **topics/intervals.md** for 45 problems.
