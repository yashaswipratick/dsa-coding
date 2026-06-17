# Pattern: Prefix Sum

## Signal phrases
- "Sum of range [l..r]" queried many times
- "Count subarrays with sum K"
- "Equal partition", "left == right sum"
- 2-D: "sum of submatrix"

## Templates

```java
int[] pre = new int[n + 1];
for (int i = 0; i < n; i++) pre[i+1] = pre[i] + a[i];
int rangeSum(int l, int r) { return pre[r+1] - pre[l]; }

// Subarray sum = K via hashmap
Map<Integer,Integer> cnt = new HashMap<>();
cnt.put(0, 1);
int s = 0, ans = 0;
for (int x : a) {
    s += x;
    ans += cnt.getOrDefault(s - K, 0);
    cnt.merge(s, 1, Integer::sum);
}
```

See **topics/prefix-sum.md** for 45 problems.
