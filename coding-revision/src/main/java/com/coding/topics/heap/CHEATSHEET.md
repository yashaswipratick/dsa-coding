# Heap / Priority Queue Cheatsheet

> **Min-Heap:** `new PriorityQueue<>()` → smallest at top → `peek()` gives minimum
> **Max-Heap:** `new PriorityQueue<>(Comparator.reverseOrder())` → largest at top

---

## 🔑 Heap Quick Reference

| Want Top-K **Largest** | Use **Min-Heap** of size K | Evict the smallest |
|---|---|---|
| Want Top-K **Smallest** | Use **Max-Heap** of size K | Evict the largest |

**Why opposite?** You keep K elements. The min of the K-largest is the Kth largest → that's what `peek()` returns.

---

## 1. Kth Largest Element
**File:** `KthLargestElement.java`
**Link:** https://leetcode.com/problems/kth-largest-element-in-an-array/

**Problem:** Find the Kth largest element in an array.

**Key Insight:** Min-Heap of size K. When size exceeds K, evict the minimum. Remaining K elements are the K largest; root is the smallest of them = Kth largest.

**Pattern:**
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // min at top
for (int num : nums) {
    minHeap.add(num);
    if (minHeap.size() > k) {
        minHeap.poll();   // remove smallest — it's not in top-K
    }
}
return minHeap.peek();    // Kth largest
```

**Time:** O(n log k) | **Space:** O(k)

---

## 2. Top K Frequent Elements
**File:** `TopKFrequentElements.java`
**Link:** https://leetcode.com/problems/top-k-frequent-elements/

**Problem:** Return K most frequent elements.

**Steps:**
1. Build frequency map.
2. Use Min-Heap ordered by **frequency** of size K. Evict least frequent when size > K.

**Pattern:**
```java
// Step 1: frequency map
Map<Integer, Integer> freq = new HashMap<>();
for (int num : nums) freq.merge(num, 1, Integer::sum);

// Step 2: min-heap by frequency (size K)
PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
    minHeap.add(new int[]{entry.getKey(), entry.getValue()});
    if (minHeap.size() > k) minHeap.poll();  // evict least frequent
}

// Step 3: extract result
int[] result = new int[k];
for (int i = k - 1; i >= 0; i--) result[i] = minHeap.poll()[0];
return result;
```

**Time:** O(n log k) | **Space:** O(n)

---

## 🔑 PriorityQueue API Reference

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();          // min-heap
PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // max-heap

// Custom comparator (e.g. by frequency)
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);  // min by index 1

pq.add(x);      // insert
pq.poll();      // remove and return min (or max for max-heap)
pq.peek();      // view min without removing
pq.size();      // current size
pq.isEmpty();   // check empty
```

---

## 🔑 Common Heap Patterns

| Pattern | Heap Type | Use Case |
|---------|-----------|----------|
| Kth largest | Min-Heap size K | Streaming data |
| Kth smallest | Max-Heap size K | Streaming data |
| Top-K frequent | Min-Heap by frequency, size K | Frequency problems |
| Merge K sorted lists | Min-Heap with (value, listIndex, elementIndex) | K-way merge |
| Running median | Two heaps: max-heap + min-heap | Sliding median |

