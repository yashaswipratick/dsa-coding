# Hashing (HashMap & HashSet)

## Core APIs

```java
Map<Integer,Integer> m = new HashMap<>();
m.put(k,v); m.get(k); m.getOrDefault(k,0); m.containsKey(k);
m.merge(k, 1, Integer::sum);                 // count frequency
m.computeIfAbsent(k, x -> new ArrayList<>()).add(v);

Set<Integer> s = new HashSet<>();
s.add(x); s.contains(x); s.remove(x);

// Sorted variants
TreeMap<Integer,Integer> tm = new TreeMap<>();  // floor/ceiling/firstKey
LinkedHashMap<>           // preserves insertion order (LRU base)
```

## Sub-patterns

1. **Lookup complement** — Two Sum-like
2. **Frequency map** — anagrams, top-K
3. **Index map** — last seen index, longest substring
4. **Group by key** — anagrams, parallel courses
5. **Set for O(1) presence** — longest consecutive
6. **Rolling hash** — Rabin-Karp

## Pitfalls

- `Integer` keys use `equals` not `==`. Auto-boxing pitfall: cache only −128..127.
- Iterating + modifying → `ConcurrentModificationException`. Use `Iterator.remove`.
- `hashCode/equals` must be overridden for custom keys.

## Problems

### Easy (15)
| # | Problem | Pattern | Done |
|---|---|---|---|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Complement lookup | [ ] |
| 13 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | Lookup table | [ ] |
| 136 | [Single Number](https://leetcode.com/problems/single-number/) | XOR (set alt) | [ ] |
| 169 | [Majority Element](https://leetcode.com/problems/majority-element/) | Frequency | [ ] |
| 202 | [Happy Number](https://leetcode.com/problems/happy-number/) | Set for cycle | [ ] |
| 205 | [Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/) | Two maps | [ ] |
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | Set | [ ] |
| 219 | [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/) | Map idx | [ ] |
| 242 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) | Frequency | [ ] |
| 268 | [Missing Number](https://leetcode.com/problems/missing-number/) | Set | [ ] |
| 290 | [Word Pattern](https://leetcode.com/problems/word-pattern/) | Bi-map | [ ] |
| 349 | [Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/) | Set | [ ] |
| 350 | [Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | Frequency | [ ] |
| 383 | [Ransom Note](https://leetcode.com/problems/ransom-note/) | Frequency | [ ] |
| 387 | [First Unique Char](https://leetcode.com/problems/first-unique-character-in-a-string/) | Frequency | [ ] |

### Medium (15)
| # | Problem | Pattern | Done |
|---|---|---|---|
| 3 | [Longest Substring No Repeat](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Window + map | [ ] |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Group by key | [ ] |
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | Set | [ ] |
| 138 | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/) | Map old→new | [ ] |
| 146 | [LRU Cache](https://leetcode.com/problems/lru-cache/) | LinkedHashMap | [ ] |
| 187 | [Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/) | Set of seen | [ ] |
| 271 | [Encode/Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/) | Design | [ ] |
| 347 | [Top K Frequent](https://leetcode.com/problems/top-k-frequent-elements/) | Map + bucket | [ ] |
| 380 | [Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/) | Map + array | [ ] |
| 438 | [Find All Anagrams](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | Window + freq | [ ] |
| 525 | [Contiguous Array](https://leetcode.com/problems/contiguous-array/) | Map of prefix-sum | [ ] |
| 560 | [Subarray Sum = K](https://leetcode.com/problems/subarray-sum-equals-k/) | Prefix sum map | [ ] |
| 567 | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | Window + freq | [ ] |
| 692 | [Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | Heap + map | [ ] |
| 994 | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | Map state in BFS | [ ] |

### Hard (15)
| # | Problem | Pattern | Done |
|---|---|---|---|
| 30 | [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) | Word freq | [ ] |
| 37 | [Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | Sets per row/col/box | [ ] |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | Window + freq map | [ ] |
| 126 | [Word Ladder II](https://leetcode.com/problems/word-ladder-ii/) | BFS + parent map | [ ] |
| 149 | [Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/) | Slope map | [ ] |
| 159 | [Longest Substring ≤ 2 Distinct](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | Window + map | [ ] |
| 218 | [Skyline Problem](https://leetcode.com/problems/the-skyline-problem/) | TreeMap | [ ] |
| 269 | [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) | Map adj | [ ] |
| 295 | [Find Median Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | Two heaps | [ ] |
| 336 | [Palindrome Pairs](https://leetcode.com/problems/palindrome-pairs/) | Word→index map | [ ] |
| 432 | [All O`one Data Structure](https://leetcode.com/problems/all-oone-data-structure/) | Map + DLL | [ ] |
| 460 | [LFU Cache](https://leetcode.com/problems/lfu-cache/) | Map + DLL per freq | [ ] |
| 642 | [Design Search Autocomplete](https://leetcode.com/problems/design-search-autocomplete-system/) | Trie + map | [ ] |
| 711 | [Number of Distinct Islands II](https://leetcode.com/problems/number-of-distinct-islands-ii/) | Set of canonical | [ ] |
| 939 | [Minimum Area Rectangle](https://leetcode.com/problems/minimum-area-rectangle/) | Map of x→ys | [ ] |

