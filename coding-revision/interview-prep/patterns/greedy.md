# Pattern: Greedy

## Signal phrases
- "Min number of meetings / arrows / jumps"
- "Schedule with earliest finish"
- "Reorganize / cool down"
- "Profit / cost with sortable property"

## Recipe
1. Sort by the right key.
2. Sweep, making the locally-best choice.
3. Prove with exchange argument.

## Templates

```java
// Activity selection (max non-overlapping)
Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
int end = Integer.MIN_VALUE, count = 0;
for (int[] iv : intervals)
    if (iv[0] >= end) { count++; end = iv[1]; }

// Jump Game II (min jumps)
int jumps = 0, end = 0, farthest = 0;
for (int i = 0; i < n - 1; i++) {
    farthest = Math.max(farthest, i + a[i]);
    if (i == end) { jumps++; end = farthest; }
}
```

See **topics/greedy.md** for 45 problems.
