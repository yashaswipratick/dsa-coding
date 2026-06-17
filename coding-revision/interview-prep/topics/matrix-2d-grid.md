# Matrix / 2-D Grid

## Setup
```java
int m = grid.length, n = grid[0].length;
int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
```

## Sub-patterns
1. Islands / flood fill (DFS or BFS)
2. Multi-source BFS (rotting oranges)
3. Matrix DP (unique paths, min path)
4. Spiral / rotate / transpose
5. Search 2D matrix (sorted)
6. Backtracking on grid (word search)

## Template — flood fill DFS
```java
void dfs(int[][] g, int i, int j) {
    if (i<0||i>=g.length||j<0||j>=g[0].length||g[i][j]!=1) return;
    g[i][j] = 0;
    for (int[] d : dirs) dfs(g, i+d[0], j+d[1]);
}
```

## Pitfalls
- Bounds check first.
- 4-dir vs 8-dir neighbors.
- Modifying input vs cloning.

## Problems

### Easy (15)
| # | Problem | Done |
|---|---|---|
| 463 |[Island Perimeter](https://leetcode.com/problems/island-perimeter/) | [ ] |
| 733 |[Flood Fill](https://leetcode.com/problems/flood-fill/) | [ ] |
| 766 |[Toeplitz Matrix](https://leetcode.com/problems/toeplitz-matrix/) | [ ] |
| 832 |[Flipping an Image](https://leetcode.com/problems/flipping-an-image/) | [ ] |
| 867 |[Transpose Matrix](https://leetcode.com/problems/transpose-matrix/) | [ ] |
| 999 |[Available Captures for Rook](https://leetcode.com/problems/available-captures-for-rook/) | [ ] |
| 661 |[Image Smoother](https://leetcode.com/problems/image-smoother/) | [ ] |
| 1572 |[Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/) | [ ] |
| 2022 |[Convert 1D Array Into 2D Array](https://leetcode.com/problems/convert-1d-array-into-2d-array/) | [ ] |
| 1886 |[Determine Whether Matrix Can Be Obtained By Rotation](https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/) | [ ] |
| 1351 |[Count Negative Numbers in Sorted Matrix](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/) | [ ] |
| 2643 |[Row With Maximum Ones](https://leetcode.com/problems/row-with-maximum-ones/) | [ ] |
| 1380 |[Lucky Numbers in a Matrix](https://leetcode.com/problems/lucky-numbers-in-a-matrix/) | [ ] |
| 1252 |[Cells with Odd Values in a Matrix](https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/) | [ ] |
| 1582 |[Special Positions in a Binary Matrix](https://leetcode.com/problems/special-positions-in-a-binary-matrix/) | [ ] |

### Medium (15)
| # | Problem | Done |
|---|---|---|
| 36 |[Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | [ ] |
| 48 |[Rotate Image](https://leetcode.com/problems/rotate-image/) | [ ] |
| 54 |[Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) | [ ] |
| 59 |[Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/) | [ ] |
| 62 |[Unique Paths](https://leetcode.com/problems/unique-paths/) | [ ] |
| 64 |[Min Path Sum](https://leetcode.com/problems/minimum-path-sum/) | [ ] |
| 73 |[Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/) | [ ] |
| 74 |[Search 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/) | [ ] |
| 79 |[Word Search](https://leetcode.com/problems/word-search/) | [ ] |
| 130 |[Surrounded Regions](https://leetcode.com/problems/surrounded-regions/) | [ ] |
| 200 |[Number of Islands](https://leetcode.com/problems/number-of-islands/) | [ ] |
| 240 |[Search 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/) | [ ] |
| 289 |[Game of Life](https://leetcode.com/problems/game-of-life/) | [ ] |
| 417 |[Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) | [ ] |
| 994 |[Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | [ ] |

### Hard (15)
| # | Problem | Done |
|---|---|---|
| 37 |[Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | [ ] |
| 51 |[N-Queens](https://leetcode.com/problems/n-queens/) | [ ] |
| 85 |[Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | [ ] |
| 174 |[Dungeon Game](https://leetcode.com/problems/dungeon-game/) | [ ] |
| 212 |[Word Search II](https://leetcode.com/problems/word-search-ii/) | [ ] |
| 296 |[Best Meeting Point](https://leetcode.com/problems/best-meeting-point/) | [ ] |
| 305 |[Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/) | [ ] |
| 317 |[Shortest Dist from All Buildings](https://leetcode.com/problems/shortest-distance-from-all-buildings/) | [ ] |
| 329 |[Longest Increasing Path in Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | [ ] |
| 407 |[Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii/) | [ ] |
| 489 |[Robot Room Cleaner](https://leetcode.com/problems/robot-room-cleaner/) | [ ] |
| 778 |[Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | [ ] |
| 815 |[Bus Routes](https://leetcode.com/problems/bus-routes/) | [ ] |
| 864 |[Shortest Path Get All Keys](https://leetcode.com/problems/shortest-path-to-get-all-keys/) | [ ] |
| 980 |[Unique Paths III](https://leetcode.com/problems/unique-paths-iii/) | [ ] |

