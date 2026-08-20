package com.coding.topics.graph;

import java.util.LinkedList;
import java.util.Queue;

// PL - https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != '0') {
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int row = poll.row;
            int col = poll.col;

            if (row > 0 && !visited[row - 1][col] && grid[row - 1][col] == '1') {
                queue.add(new Pair(row - 1, col));
                visited[row - 1][col] = true;
            }
            if (row < grid.length - 1 && !visited[row + 1][col] && grid[row + 1][col] == '1') {
                queue.add(new Pair(row + 1, col));
                visited[row + 1][col] = true;
            }
            if (col > 0 && !visited[row][col - 1] && grid[row][col - 1] == '1') {
                queue.add(new Pair(row, col - 1));
                visited[row][col - 1] = true;
            }
            if (col < grid[0].length - 1 && !visited[row][col + 1] && grid[row][col + 1] == '1') {
                queue.add(new Pair(row, col + 1));
                visited[row][col + 1] = true;
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();

        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(sol.numIslands(grid1)); // Expected: 1
    }

    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
