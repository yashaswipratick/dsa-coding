# Pattern: Cyclic Sort

## Signal phrases
- "Array contains numbers 1..n"
- "Find the missing / duplicate / smallest missing positive"
- "Sort in O(n) time, O(1) space"

## Idea
Place value `v` at index `v-1` (or `v` if 0-based). After one pass, mismatched indices reveal missing or duplicate.

## Template

```java
int i = 0;
while (i < n) {
    int correct = a[i] - 1;
    if (a[i] > 0 && a[i] <= n && a[i] != a[correct]) {
        int t = a[i]; a[i] = a[correct]; a[correct] = t;
    } else i++;
}
// scan for misplaced
for (int j = 0; j < n; j++) if (a[j] != j + 1) return j + 1;
```

## Problems

| # | Problem | Done |
|---|---|---|
| 268 |[Missing Number](https://leetcode.com/problems/missing-number/) | [ ] |
| 287 |[Find Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [ ] |
| 41 |[First Missing Positive](https://leetcode.com/problems/first-missing-positive/) | [ ] |
| 442 |[Find All Duplicates in Array](https://leetcode.com/problems/find-all-duplicates-in-an-array/) | [ ] |
| 448 |[Find All Numbers Disappeared](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/) | [ ] |
| 645 |[Set Mismatch](https://leetcode.com/problems/set-mismatch/) | [ ] |
| 765 |[Couples Holding Hands](https://leetcode.com/problems/couples-holding-hands/) | [ ] |
