# Pattern: Sliding Window

## Signal phrases
- "contiguous subarray / substring"
- "longest / shortest with X"
- "max sum / count window"
- "exactly K distinct"

## Templates

```java
// Variable window
int l = 0, best = 0;
Map<Character,Integer> cnt = new HashMap<>();
for (int r = 0; r < s.length(); r++) {
    cnt.merge(s.charAt(r), 1, Integer::sum);
    while (/* invalid */) {
        char c = s.charAt(l++);
        if (cnt.merge(c, -1, Integer::sum) == 0) cnt.remove(c);
    }
    best = Math.max(best, r - l + 1);
}

// Fixed window
int sum = 0;
for (int i = 0; i < k; i++) sum += a[i];
int best = sum;
for (int i = k; i < n; i++) {
    sum += a[i] - a[i-k];
    best = Math.max(best, sum);
}
```

## "Exactly K" trick
`exactlyK = atMostK − atMostK-1`

## Variations
- Window + frequency map
- Window + monotonic deque (sliding max/min)
- Window + two heaps (sliding median)

## Problems
See **topics/sliding-window.md** for the 15 Easy / 15 Medium / 15 Hard table.

