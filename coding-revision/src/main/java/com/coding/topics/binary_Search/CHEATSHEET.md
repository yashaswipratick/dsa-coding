# Binary Search Cheatsheet

> **Template:** `while (start <= end)` · `mid = start + (end-start)/2` · narrow one side each iteration.
> **Key:** Never compute `(start + end)/2` — risks integer overflow for large indices.

---

## 🔑 Binary Search Template

```java
int start = 0, end = nums.length - 1;
while (start <= end) {
    int mid = start + (end - start) / 2;
    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) start = mid + 1;   // target is in right half
    else end = mid - 1;                              // target is in left half
}
return -1;  // not found
```

---

## 1. Classic Binary Search
**File:** `BinarySearch.java`
**Link:** https://leetcode.com/problems/binary-search/

**Problem:** Find `target` in sorted array. Return index, or -1.

**Pattern:** Standard template above.

**Time:** O(log n) | **Space:** O(1)

---

## 2. Search in Rotated Sorted Array
**File:** `SearchInRotatedSortedArray.java`
**Link:** https://leetcode.com/problems/search-in-rotated-sorted-array/

**Problem:** Find `target` in array that was sorted but then rotated at some pivot.

**Key Insight:** At any `mid`, **at least one half is always sorted**. Check which half is sorted, then check if target falls in that range.

**Pattern:**
```java
int start = 0, end = nums.length - 1;
while (start <= end) {
    int mid = start + (end - start) / 2;
    if (nums[mid] == target) return mid;

    if (nums[start] <= nums[mid]) {       // LEFT half is sorted
        if (target >= nums[start] && target < nums[mid])
            end = mid - 1;                // target in left half
        else
            start = mid + 1;             // target in right half
    } else {                              // RIGHT half is sorted
        if (target > nums[mid] && target <= nums[end])
            start = mid + 1;             // target in right half
        else
            end = mid - 1;               // target in left half
    }
}
return -1;
```

**Why `nums[start] <= nums[mid]`:** If left boundary ≤ mid, no rotation happened in that half.

---

## 3. Find Peak Element
**File:** `PeakElement.java`
**Link:** https://leetcode.com/problems/find-peak-element/

**Problem:** Find index of any peak element (greater than its neighbors). Array has no two adjacent equal elements.

**Key Insight:** If `nums[mid] > nums[mid+1]`, the peak is in the left half (could be `mid` itself). Otherwise, the peak must be in the right half (because `nums[mid+1]` is larger, so going right will eventually hit a peak).

**Pattern:**
```java
int start = 0, end = nums.length - 1;
while (start < end) {   // Note: strict < (not <=) — converge to single element
    int mid = start + (end - start) / 2;
    if (nums[mid] > nums[mid + 1])
        end = mid;        // peak is at mid or to the left — include mid
    else
        start = mid + 1;  // peak is strictly to the right
}
return start;   // start == end, single element = peak
```

**Why `while (start < end)` not `start <= end`:** We converge to one element, so stop when `start == end`. If we used `<=`, we'd need an extra check.

---

## 🔑 Comparison: Three Problems

| Problem | Condition to go right | Condition to go left |
|---------|----------------------|----------------------|
| Classic BS | `nums[mid] < target` | `nums[mid] > target` |
| Rotated Array | target in sorted right half | target in sorted left half |
| Peak Element | `nums[mid] <= nums[mid+1]` | `nums[mid] > nums[mid+1]` |

---

## 🔑 When to Use Which Loop Variant

| Variant | Use When | Notes |
|---------|----------|-------|
| `while (start <= end)` | Searching for exact value | `start` and `end` can cross |
| `while (start < end)` | Converging to one element (peak) | `start == end` is answer |
| `while (start + 1 < end)` | When mid ± 1 causes issues | Leaves 2 elements for manual check |

---

## 🔑 Common Binary Search Mistakes

1. **Overflow:** Use `mid = start + (end-start)/2`, not `(start+end)/2`.
2. **Infinite loop:** When doing `end = mid` (not `mid-1`), you must use `start < end`.
3. **Off-by-one:** For `end = mid` pattern → use `while (start < end)`, not `<=`.
4. **Sorted check for rotated array:** `nums[start] <= nums[mid]` (use `<=` to handle duplicates at start == mid).

