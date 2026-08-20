package com.coding.topics.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r =  image.length;
        int c = image[0].length;

        boolean[][] visited = new boolean[r][c];
        bfs(image, sr, sc, color, visited);
        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int color, boolean[][] visited) {
        int initialColor = image[sr][sc];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        visited[sr][sc] = true;
        image[sr][sc] = color;

        int n = image.length;
        int m = image[sr].length;

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int i = poll.first;
            int j = poll.second;

            enqueu(image,i, j-1, n,m, color, initialColor, visited, queue);
            enqueu(image,i, j+1, n,m, color, initialColor, visited, queue);
            enqueu(image,i+1, j, n,m, color, initialColor, visited, queue);
            enqueu(image,i+1, j, n,m, color, initialColor, visited, queue);
        }
    }

    private void enqueu(int[][] image, int i, int j, int n, int m, int color, int initialColor, boolean[][] visited, Queue<Pair> queue) {
        if (i >= 0 && j >= 0 && i < n && j < m) {
            if (initialColor == image[i][j] && !visited[i][j]) {
                queue.add(new  Pair(i, j));
                image[i][j] = color;
                visited[i][j] = true;
            }
        }
    }

    public static void main(String[] args) {

    }

    static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
