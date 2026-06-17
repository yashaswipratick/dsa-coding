# Pattern: Reservoir Sampling

## When to use
- "Pick K items uniformly from a stream of unknown length"
- "Random pick from linked list"

## Algorithm (size 1)

```java
int chosen = -1, i = 0;
for (int x : stream) {
    i++;
    if (rand.nextInt(i) == 0) chosen = x;   // probability 1/i
}
```

## Size K

```java
int[] reservoir = new int[k];
int i = 0;
for (int x : stream) {
    if (i < k) reservoir[i] = x;
    else {
        int j = rand.nextInt(i + 1);
        if (j < k) reservoir[j] = x;
    }
    i++;
}
```

## Problems

| # | Problem | Done |
|---|---|---|
| 382 |[Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/) | [ ] |
| 398 |[Random Pick Index](https://leetcode.com/problems/random-pick-index/) | [ ] |
| 528 |[Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/) | [ ] |
| 519 |[Random Flip Matrix](https://leetcode.com/problems/random-flip-matrix/) | [ ] |
| 710 |[Random Pick with Blacklist](https://leetcode.com/problems/random-pick-with-blacklist/) | [ ] |
