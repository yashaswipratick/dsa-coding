# Pattern: Monotonic Stack

## Signal phrases
- "Next greater / smaller element"
- "Previous greater / smaller"
- "Largest rectangle"
- "Stock span"
- "Sum of subarray minimums"

## Template (next greater)

```java
int[] res = new int[n]; Arrays.fill(res, -1);
Deque<Integer> st = new ArrayDeque<>();   // indices, values decreasing
for (int i = 0; i < n; i++) {
    while (!st.isEmpty() && a[st.peek()] < a[i])
        res[st.pop()] = a[i];
    st.push(i);
}
```

## Largest rectangle in histogram template

```java
Deque<Integer> st = new ArrayDeque<>();
int best = 0;
for (int i = 0; i <= n; i++) {
    int h = (i == n) ? 0 : a[i];
    while (!st.isEmpty() && h < a[st.peek()]) {
        int top = st.pop();
        int width = st.isEmpty() ? i : i - st.peek() - 1;
        best = Math.max(best, a[top] * width);
    }
    st.push(i);
}
```

See **topics/monotonic-stack.md** for 45 problems.
