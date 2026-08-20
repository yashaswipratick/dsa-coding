# Graph Problems Cheatsheet

> **BFS** → Queue → level-by-level → shortest path / connected components
> **DFS** → Recursion → explore fully → connectivity / islands / flood fill

---

## 🔑 Graph Input Formats

```
1. Adjacency List: ArrayList<ArrayList<Integer>> adj
   adj.get(node) = list of neighbors

2. Edge Pairs: int[][] edges  where edges[i] = {u, v}
   → Build adj list first: AdjacencyListBuilder.buildFromEdgePairs(V, edges)

3. Grid: char[][] or int[][] grid
   → Treat each cell as node, neighbors = up/down/left/right
```

---

## 1. BFS Traversal
**File:** `bfs/Traversal.java`

**Problem:** BFS traversal from node 0, return visited order.

**Pattern:**
```java
Queue<Integer> queue = new LinkedList<>();
boolean[] visited = new boolean[V];
queue.add(0);
visited[0] = true;

while (!queue.isEmpty()) {
    int node = queue.poll();
    result.add(node);
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.add(neighbor);
        }
    }
}
```

**Key:** Mark visited **when enqueuing**, not when dequeuing (prevents duplicates in queue).

---

## 2. DFS Traversal
**File:** `dfs/Traversal.java`

**Pattern:**
```java
void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> result) {
    visited[node] = true;
    result.add(node);
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited, result);
        }
    }
}
```

---

## 3. Number of Connected Components / Provinces
**File:** `NumberOfConnectedComponentsOrProvinces.java`
**Link:** https://www.geeksforgeeks.org/problems/number-of-provinces/1

**Problem:** Count connected components in undirected graph.

**Key Insight:** Each fresh DFS/BFS start = one new component.

**Pattern:**
```java
int count = 0;
for (int i = 0; i < V; i++) {
    if (!visited[i]) {
        count++;            // new component found
        dfs(i, adj, visited);
    }
}
return count;
```

**Input:** Edge pairs `[u,v]` → build adjacency list first.
```java
// Build adj from edge pairs: undirected → add both directions
adj.get(u).add(v);
adj.get(v).add(u);
```

---

## 4. Number of Islands
**File:** `NumberOfIslands.java`
**Link:** https://leetcode.com/problems/number-of-islands/

**Problem:** Count islands (connected `'1'` cells) in a grid.

**Pattern:** Same as Connected Components but on a 2D grid.
```java
int count = 0;
for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
            count++;
            bfs(grid, visited, i, j);   // mark entire island visited
        }
    }
}
```

**BFS spread (4-directional):**
```java
// Check all 4 directions: up, down, left, right
// For each neighbor: bounds check + grid[r][c]=='1' + !visited[r][c]
// When enqueuing: visited[r][c] = true immediately
```

---

## 5. Flood Fill
**File:** `FloodFill.java`
**Link:** https://leetcode.com/problems/flood-fill/

**Problem:** Change color of connected region starting at `(sr, sc)`.

**Key Insight:** BFS from start. Spread only to neighbors with the **same initial color**. Set new color **when enqueuing**.

**Pattern:**
```java
int initialColor = image[sr][sc];
Queue<Pair> queue = new LinkedList<>();
queue.add(new Pair(sr, sc));
image[sr][sc] = color;     // set new color immediately
visited[sr][sc] = true;

while (!queue.isEmpty()) {
    Pair p = queue.poll();
    // For each of 4 neighbors:
    // if in bounds && image[r][c] == initialColor && !visited[r][c]
    //   → enqueue, set image[r][c] = color, visited[r][c] = true
}
```

**Why save initialColor:** The cell's color changes during BFS, so save it before starting.

---

## 🔑 Grid BFS Template

```java
private void bfs(int[][] grid, boolean[][] visited, int startRow, int startCol) {
    int n = grid.length, m = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startRow, startCol});
    visited[startRow][startCol] = true;

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};  // up, down, left, right

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        for (int[] d : dirs) {
            int r = curr[0] + d[0];
            int c = curr[1] + d[1];
            if (r >= 0 && r < n && c >= 0 && c < m && !visited[r][c] && /* condition */) {
                visited[r][c] = true;
                queue.add(new int[]{r, c});
            }
        }
    }
}
```

---

## 🔑 BFS vs DFS Cheat

| Use BFS | Use DFS |
|---------|---------|
| Shortest path (unweighted) | Connected components |
| Level-by-level traversal | Islands / flood fill |
| Minimum steps | Topological sort |

---

## 🔑 Common Mistakes

1. **Mark visited on enqueue** not on dequeue → prevents same node entering queue multiple times.
2. **Build adjacency list** from edge pairs before running DFS/BFS.
3. **Grid bounds check** before accessing `grid[r][c]`: `r >= 0 && r < n && c >= 0 && c < m`.
4. **Save initial color** in Flood Fill before changing anything.

