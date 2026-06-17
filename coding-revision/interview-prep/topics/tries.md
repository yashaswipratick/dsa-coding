# Tries (Prefix Trees)

## When to use
- "Prefix search", "autocomplete"
- "Longest common prefix among many words"
- "Word dictionary"
- XOR maximization on binary tries

## Template (array variant for lowercase)

```java
class Trie {
    Trie[] kids = new Trie[26];
    boolean end;

    void insert(String w) {
        Trie n = this;
        for (char c : w.toCharArray()) {
            int k = c - 'a';
            if (n.kids[k] == null) n.kids[k] = new Trie();
            n = n.kids[k];
        }
        n.end = true;
    }

    boolean search(String w) { return find(w, true); }
    boolean startsWith(String p) { return find(p, false); }

    private boolean find(String s, boolean full) {
        Trie n = this;
        for (char c : s.toCharArray()) {
            n = n.kids[c - 'a'];
            if (n == null) return false;
        }
        return !full || n.end;
    }
}
```

## Sub-patterns
1. Plain prefix dictionary
2. Word search on grid + trie (#212)
3. Bit-trie for max XOR (#421)
4. Trie with `.` wildcards (#211)
5. Replace words (#648)

## Pitfalls
- Memory: 26 pointers per node — large words can blow up. Use `HashMap<Character,Trie>` if alphabet is large.
- For DFS into trie on grid: prune by deleting words after found to avoid duplicates.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 14 |[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | [ ] |
| 720 |[Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/) | [ ] |
| 1268 |[Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/) | [ ] |
| 1023 |[Camelcase Matching](https://leetcode.com/problems/camelcase-matching/) | [ ] |
| 1858 |[Longest Word With All Prefixes](https://leetcode.com/problems/longest-word-with-all-prefixes-of-its-prefixes-in-the-dictionary/) | [ ] |
| 386 |[Lexicographical Numbers](https://leetcode.com/problems/lexicographical-numbers/) | [ ] |
| 1948 |[Delete Duplicate Folders in System](https://leetcode.com/problems/delete-duplicate-folders-in-system/) | [ ] |
| 1707 |[Maximum XOR With an Element](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/) | [ ] |
| 1804 |[Implement Trie II](https://leetcode.com/problems/implement-trie-ii-prefix-tree/) | [ ] |
| 2306 |[Naming a Company](https://leetcode.com/problems/naming-a-company/) | [ ] |
| 1233 |[Remove Sub-Folders](https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/) | [ ] |
| 2416 |[Sum of Prefix Scores of Strings](https://leetcode.com/problems/sum-of-prefix-scores-of-strings/) | [ ] |
| 1858 | [Longest Word With All Prefixes (alt)](https://leetcode.com/problems/longest-word-with-all-prefixes-of-its-prefixes-in-the-dictionary/) | [ ] |
| 2707 |[Extra Characters in a String](https://leetcode.com/problems/extra-characters-in-a-string/) | [ ] |
| 3043 |[Find the Length of the Longest Common Prefix](https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 208 |[Implement Trie](https://leetcode.com/problems/implement-trie-prefix-tree/) | [ ] |
| 211 |[Add and Search Word](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | [ ] |
| 421 |[Max XOR of Two Numbers](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) | [ ] |
| 648 |[Replace Words](https://leetcode.com/problems/replace-words/) | [ ] |
| 676 |[Implement Magic Dictionary](https://leetcode.com/problems/implement-magic-dictionary/) | [ ] |
| 677 |[Map Sum Pairs](https://leetcode.com/problems/map-sum-pairs/) | [ ] |
| 692 |[Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | [ ] |
| 720 |[Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/) | [ ] |
| 745 |[Prefix and Suffix Search](https://leetcode.com/problems/prefix-and-suffix-search/) | [ ] |
| 820 |[Short Encoding of Words](https://leetcode.com/problems/short-encoding-of-words/) | [ ] |
| 1268 |[Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/) | [ ] |
| 1707 |[Maximum XOR With an Element](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/) | [ ] |
| 1804 |[Implement Trie II](https://leetcode.com/problems/implement-trie-ii-prefix-tree/) | [ ] |
| 1948 |[Delete Duplicate Folders in System](https://leetcode.com/problems/delete-duplicate-folders-in-system/) | [ ] |
| 2416 |[Sum of Prefix Scores of Strings](https://leetcode.com/problems/sum-of-prefix-scores-of-strings/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 212 |[Word Search II](https://leetcode.com/problems/word-search-ii/) | [ ] |
| 336 |[Palindrome Pairs](https://leetcode.com/problems/palindrome-pairs/) | [ ] |
| 425 |[Word Squares](https://leetcode.com/problems/word-squares/) | [ ] |
| 472 |[Concatenated Words](https://leetcode.com/problems/concatenated-words/) | [ ] |
| 588 |[Design In-Memory File System](https://leetcode.com/problems/design-in-memory-file-system/) | [ ] |
| 642 |[Design Search Autocomplete System](https://leetcode.com/problems/design-search-autocomplete-system/) | [ ] |
| 745 |[Prefix and Suffix Search](https://leetcode.com/problems/prefix-and-suffix-search/) | [ ] |
| 1032 |[Stream of Characters](https://leetcode.com/problems/stream-of-characters/) | [ ] |
| 1166 |[Design File System](https://leetcode.com/problems/design-file-system/) | [ ] |
| 1707 |[Maximum XOR With Element](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/) | [ ] |
| 1803 |[Count Pairs With XOR in Range](https://leetcode.com/problems/count-pairs-with-xor-in-a-range/) | [ ] |
| 1938 |[Max Genetic Diff Query](https://leetcode.com/problems/maximum-genetic-difference-query/) | [ ] |
| 2104 |[Sum of Subarray Ranges](https://leetcode.com/problems/sum-of-subarray-ranges/) | [ ] |
| 2227 |[Encrypt and Decrypt Strings](https://leetcode.com/problems/encrypt-and-decrypt-strings/) | [ ] |
| 2416 |[Sum of Prefix Scores of Strings](https://leetcode.com/problems/sum-of-prefix-scores-of-strings/) | [ ] |

