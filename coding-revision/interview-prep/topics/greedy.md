# Greedy

## When to use
- Local optimum → global optimum
- Activity selection, scheduling
- Interval problems
- Sorting + sweep

## Proof sketch (interview answer)
"Sort by X; assume greedy fails; show contradiction via exchange argument."

## Classic templates

```java
// Activity selection (max non-overlapping)
Arrays.sort(intervals, (a,b) -> a[1] - b[1]);  // sort by end
int end = Integer.MIN_VALUE, count = 0;
for (int[] iv : intervals) {
    if (iv[0] >= end) { count++; end = iv[1]; }
}

// Jump Game II (min jumps)
int jumps = 0, end = 0, farthest = 0;
for (int i = 0; i < n - 1; i++) {
    farthest = Math.max(farthest, i + a[i]);
    if (i == end) { jumps++; end = farthest; }
}
```

## Pitfalls
- Greedy DOES NOT always work — prove it. Counter-example for "coin change" with arbitrary denoms.
- Wrong sort key → wrong answer.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 121 |[Best Time to Buy Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | [ ] |
| 122 |[Best Time II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | [ ] |
| 409 |[Longest Palindrome](https://leetcode.com/problems/longest-palindrome/) | [ ] |
| 455 |[Assign Cookies](https://leetcode.com/problems/assign-cookies/) | [ ] |
| 561 |[Array Partition](https://leetcode.com/problems/array-partition/) | [ ] |
| 605 |[Can Place Flowers](https://leetcode.com/problems/can-place-flowers/) | [ ] |
| 860 |[Lemonade Change](https://leetcode.com/problems/lemonade-change/) | [ ] |
| 944 |[Delete Columns to Make Sorted](https://leetcode.com/problems/delete-columns-to-make-sorted/) | [ ] |
| 976 |[Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/) | [ ] |
| 1217 |[Min Cost Move Chips](https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/) | [ ] |
| 1221 |[Split a String in Balanced](https://leetcode.com/problems/split-a-string-in-balanced-strings/) | [ ] |
| 1403 |[Min Subseq in Non-Increasing Order](https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/) | [ ] |
| 1518 |[Water Bottles](https://leetcode.com/problems/water-bottles/) | [ ] |
| 1903 |[Largest Odd Number in String](https://leetcode.com/problems/largest-odd-number-in-string/) | [ ] |
| 2160 |[Min Sum of 4 Digit After Splitting](https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 45 |[Jump Game II](https://leetcode.com/problems/jump-game-ii/) | [ ] |
| 55 |[Jump Game](https://leetcode.com/problems/jump-game/) | [ ] |
| 134 |[Gas Station](https://leetcode.com/problems/gas-station/) | [ ] |
| 135 | [Candy](https://leetcode.com/problems/candy/) (also Hard) | [ ] |
| 253 |[Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) | [ ] |
| 300 |[Longest Increasing Subseq](https://leetcode.com/problems/longest-increasing-subsequence/) | [ ] |
| 334 |[Increasing Triplet Subseq](https://leetcode.com/problems/increasing-triplet-subsequence/) | [ ] |
| 376 |[Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/) | [ ] |
| 402 |[Remove K Digits](https://leetcode.com/problems/remove-k-digits/) | [ ] |
| 435 |[Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | [ ] |
| 452 |[Min Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) | [ ] |
| 621 |[Task Scheduler](https://leetcode.com/problems/task-scheduler/) | [ ] |
| 763 |[Partition Labels](https://leetcode.com/problems/partition-labels/) | [ ] |
| 767 |[Reorganize String](https://leetcode.com/problems/reorganize-string/) | [ ] |
| 921 |[Min Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 42 |[Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | [ ] |
| 135 |[Candy](https://leetcode.com/problems/candy/) | [ ] |
| 218 |[Skyline Problem](https://leetcode.com/problems/the-skyline-problem/) | [ ] |
| 239 |[Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [ ] |
| 330 |[Patching Array](https://leetcode.com/problems/patching-array/) | [ ] |
| 358 |[Rearrange String k Distance Apart](https://leetcode.com/problems/rearrange-string-k-distance-apart/) | [ ] |
| 391 |[Perfect Rectangle](https://leetcode.com/problems/perfect-rectangle/) | [ ] |
| 502 |[IPO](https://leetcode.com/problems/ipo/) | [ ] |
| 630 |[Course Schedule III](https://leetcode.com/problems/course-schedule-iii/) | [ ] |
| 632 |[Smallest Range Covering K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | [ ] |
| 757 |[Set Intersection Size At Least Two](https://leetcode.com/problems/set-intersection-size-at-least-two/) | [ ] |
| 765 |[Couples Holding Hands](https://leetcode.com/problems/couples-holding-hands/) | [ ] |
| 871 |[Min Refueling Stops](https://leetcode.com/problems/minimum-number-of-refueling-stops/) | [ ] |
| 1326 |[Min Number of Taps Open to Water Garden](https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/) | [ ] |
| 1675 |[Min Deviation in Array](https://leetcode.com/problems/minimize-deviation-in-array/) | [ ] |

