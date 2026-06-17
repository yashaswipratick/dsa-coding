# Pattern: Trie (Prefix Tree)

## Signal phrases
- "Prefix search / autocomplete"
- "Word dictionary with wildcards"
- "Longest word built from others"
- Max XOR (binary trie)

## Template

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
    boolean startsWith(String p) {
        Trie n = this;
        for (char c : p.toCharArray()) {
            n = n.kids[c - 'a'];
            if (n == null) return false;
        }
        return true;
    }
}
```

See **topics/tries.md** for 45 problems.
