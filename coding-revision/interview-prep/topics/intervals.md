# Intervals

## Trigger phrases
- "Overlapping intervals"
- "Merge / insert intervals"
- "Meeting rooms"
- "Free time / busy time"

## Two key tricks
1. **Sort by start** — to detect overlaps then merge.
2. **Sweep events** — split each interval into `(start, +1)` and `(end, -1)`, sort by time, accumulate.

## Templates

```java
// Merge
Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
List<int[]> out = new ArrayList<>();
for (int[] iv : intervals) {
    if (!out.isEmpty() && out.get(out.size()-1)[1] >= iv[0]) {
        out.get(out.size()-1)[1] = Math.max(out.get(out.size()-1)[1], iv[1]);
    } else out.add(iv);
}

// Meeting Rooms II — min heap of end times
Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
PriorityQueue<Integer> heap = new PriorityQueue<>();
for (int[] iv : intervals) {
    if (!heap.isEmpty() && heap.peek() <= iv[0]) heap.poll();
    heap.offer(iv[1]);
}
return heap.size();
```

## Overlap test
Two intervals `[a,b]`, `[c,d]` overlap iff `a < d && c < b` (or `<=` if endpoints touching counts).

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 252 |[Meeting Rooms](https://leetcode.com/problems/meeting-rooms/) | [ ] |
| 228 |[Summary Ranges](https://leetcode.com/problems/summary-ranges/) | [ ] |
| 605 |[Can Place Flowers](https://leetcode.com/problems/can-place-flowers/) | [ ] |
| 1893 |[Check If All Integers Covered](https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/) | [ ] |
| 2406 |[Divide Intervals Into Min Groups](https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/) | [ ] |
| 1854 |[Max Population Year](https://leetcode.com/problems/maximum-population-year/) | [ ] |
| 2848 |[Points That Intersect with Cars](https://leetcode.com/problems/points-that-intersect-with-cars/) | [ ] |
| 1431 |[Kids Greatest Number of Candies](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/) | [ ] |
| 1684 |[Count Number of Consistent Strings](https://leetcode.com/problems/count-the-number-of-consistent-strings/) | [ ] |
| 1991 |[Find Middle Index](https://leetcode.com/problems/find-the-middle-index-in-array/) | [ ] |
| 1356 |[Sort by Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/) | [ ] |
| 1929 |[Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/) | [ ] |
| 1700 |[Number of Students Unable to Eat Lunch](https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/) | [ ] |
| 2410 |[Max Matching of Players With Trainers](https://leetcode.com/problems/maximum-matching-of-players-with-trainers/) | [ ] |
| 2554 |[Max Number of Integers to Choose From a Range I](https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 56 |[Merge Intervals](https://leetcode.com/problems/merge-intervals/) | [ ] |
| 57 |[Insert Interval](https://leetcode.com/problems/insert-interval/) | [ ] |
| 253 |[Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) | [ ] |
| 435 |[Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | [ ] |
| 436 |[Find Right Interval](https://leetcode.com/problems/find-right-interval/) | [ ] |
| 452 |[Min Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) | [ ] |
| 495 |[Teemo Attacking](https://leetcode.com/problems/teemo-attacking/) | [ ] |
| 729 |[My Calendar I](https://leetcode.com/problems/my-calendar-i/) | [ ] |
| 731 |[My Calendar II](https://leetcode.com/problems/my-calendar-ii/) | [ ] |
| 763 |[Partition Labels](https://leetcode.com/problems/partition-labels/) | [ ] |
| 986 |[Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/) | [ ] |
| 1288 |[Remove Covered Intervals](https://leetcode.com/problems/remove-covered-intervals/) | [ ] |
| 1851 |[Min Interval to Include Each Query](https://leetcode.com/problems/minimum-interval-to-include-each-query/) | [ ] |
| 2406 |[Divide Intervals Min Groups](https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/) | [ ] |
| 2580 |[Count Ways Group Overlapping Ranges](https://leetcode.com/problems/count-ways-to-group-overlapping-ranges/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 218 |[Skyline Problem](https://leetcode.com/problems/the-skyline-problem/) | [ ] |
| 352 |[Data Stream as Disjoint Intervals](https://leetcode.com/problems/data-stream-as-disjoint-intervals/) | [ ] |
| 715 |[Range Module](https://leetcode.com/problems/range-module/) | [ ] |
| 732 |[My Calendar III](https://leetcode.com/problems/my-calendar-iii/) | [ ] |
| 757 |[Set Intersection Size at Least Two](https://leetcode.com/problems/set-intersection-size-at-least-two/) | [ ] |
| 759 |[Employee Free Time](https://leetcode.com/problems/employee-free-time/) | [ ] |
| 850 |[Rectangle Area II](https://leetcode.com/problems/rectangle-area-ii/) | [ ] |
| 1024 |[Video Stitching](https://leetcode.com/problems/video-stitching/) | [ ] |
| 1109 |[Corporate Flight Bookings](https://leetcode.com/problems/corporate-flight-bookings/) | [ ] |
| 1326 |[Min Taps Open to Water Garden](https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/) | [ ] |
| 2402 |[Meeting Rooms III](https://leetcode.com/problems/meeting-rooms-iii/) | [ ] |
| 2503 |[Max Points From Grid Queries](https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/) | [ ] |
| 2589 |[Min Time to Complete All Tasks](https://leetcode.com/problems/minimum-time-to-complete-all-tasks/) | [ ] |
| 2271 |[Maximum White Tiles Covered by a Carpet](https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/) | [ ] |
| 2251 |[Number of Flowers in Full Bloom](https://leetcode.com/problems/number-of-flowers-in-full-bloom/) | [ ] |

