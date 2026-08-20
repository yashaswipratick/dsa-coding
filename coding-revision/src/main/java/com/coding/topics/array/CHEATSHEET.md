# Array Problems Cheatsheet

> **Prefix product, running max/min, two-pass techniques** are the core patterns here.

---

## 1. Maximum Subarray (Kadane's Algorithm)
**File:** `MaximumSubarray.java`
**Link:** https://leetcode.com/problems/maximum-subarray/

**Problem:** Find contiguous subarray with maximum sum.

**Key Insight:** At each position, either **extend** current subarray or **start fresh**. Starting fresh is better when the running sum is negative.

**Pattern:**
```java
int maxEndingHere = nums[0];
int result = nums[0];

for (int i = 1; i < nums.length; i++) {
    maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
    // ↑ restart if extending gives worse result
    result = Math.max(result, maxEndingHere);
}
return result;
```

**Why it works:** If `maxEndingHere` becomes negative, `nums[i]` alone is always better than `maxEndingHere + nums[i]`.

**Time:** O(n) | **Space:** O(1)

---

## 2. Product of Array Except Self
**File:** `ProductOfArrayExceptSelf.java`
**Link:** https://leetcode.com/problems/product-of-array-except-self/

**Problem:** Return array where `result[i]` = product of all elements except `nums[i]`. No division allowed.

**Key Insight:** Two passes.
- **Pass 1 (left→right):** `result[i]` = product of all elements **to the left** of `i`.
- **Pass 2 (right→left):** Multiply `result[i]` by product of all elements **to the right** of `i`.

**Pattern:**
```java
int n = nums.length;
int[] result = new int[n];

// Pass 1: prefix products (left of i)
result[0] = 1;
for (int i = 1; i < n; i++) {
    result[i] = result[i-1] * nums[i-1];
}

// Pass 2: multiply by suffix products (right of i)
int suffix = 1;
for (int i = n - 1; i >= 0; i--) {
    result[i] *= suffix;
    suffix *= nums[i];
}
return result;
```

**Time:** O(n) | **Space:** O(1) extra (output array doesn't count)

---

## 3. Trapping Rain Water
**File:** `TrappingRainWater.java`
**Link:** https://leetcode.com/problems/trapping-rain-water/

**Problem:** Given bar heights, how much water can be trapped?

**Key Insight:** Water at position `i` = `min(maxLeft[i], maxRight[i]) - height[i]`.
- `maxLeft[i]` = tallest bar from index 0 to i (left wall)
- `maxRight[i]` = tallest bar from index i to n-1 (right wall)
- Water fills up to the shorter wall

**Pattern:**
```java
int n = height.length;
int[] lMax = new int[n];
int[] rMax = new int[n];

// Build left max
lMax[0] = height[0];
for (int i = 1; i < n; i++) lMax[i] = Math.max(lMax[i-1], height[i]);

// Build right max
rMax[n-1] = height[n-1];
for (int i = n-2; i >= 0; i--) rMax[i] = Math.max(rMax[i+1], height[i]);

// Accumulate water
int water = 0;
for (int i = 0; i < n; i++) {
    water += Math.min(lMax[i], rMax[i]) - height[i];
}
return water;
```

**Time:** O(n) | **Space:** O(n)

**Two-pointer O(1) space alternative:**
```java
// Move pointer from side with smaller max (it determines the water level)
int left = 0, right = n-1, lMax = 0, rMax = 0, water = 0;
while (left < right) {
    if (height[left] <= height[right]) {
        if (height[left] >= lMax) lMax = height[left];
        else water += lMax - height[left];
        left++;
    } else {
        if (height[right] >= rMax) rMax = height[right];
        else water += rMax - height[right];
        right--;
    }
}
```

---

## 🔑 Pattern Summary

| Problem | Technique | Key Line |
|---------|-----------|----------|
| Max Subarray | Kadane's — running max | `maxHere = max(nums[i], maxHere + nums[i])` |
| Product Except Self | Two-pass prefix/suffix product | `result[i] = leftProduct * rightProduct` |
| Trapping Rain Water | Precompute lMax/rMax arrays | `water += min(lMax[i], rMax[i]) - height[i]` |

---

## 🔑 Common Array Tricks

```
Prefix sum:   preSum[i] = preSum[i-1] + arr[i]
              → range sum [l,r] = preSum[r] - preSum[l-1]

Two pass:     First pass builds prefix info (left → right)
              Second pass uses suffix info (right → left)
              Used in: Product except self, Trapping rain water

Kadane:       maxHere = max(arr[i], maxHere + arr[i])
              Used in: Max subarray, Max product subarray
```

