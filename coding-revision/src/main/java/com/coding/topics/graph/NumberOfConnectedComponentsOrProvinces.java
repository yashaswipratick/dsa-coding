package com.coding.topics.graph;

import java.util.ArrayList;

// gfg PL - https://www.geeksforgeeks.org/problems/number-of-provinces/1
// leetcode - https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfConnectedComponentsOrProvinces {

    private static int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, edges, visited);
            }
        }
        return count;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> edges, boolean[] visited) {
        visited[i] = true;
        for (int j : edges.get(i)) {
            if (!visited[j]) {
                dfs(j, edges, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countConnected(5, AdjacencyListBuilder.buildFromEdgePairs(5, new int[][]{{0, 1}, {2, 1}, {3, 4}})));// Expected: 2
        System.out.println(countConnected(7, AdjacencyListBuilder.buildFromEdgePairs(7, new int[][]{{0, 1}, {6, 0}, {2, 4}, {2, 3}, {3, 4}})));// Expected: 3
    }
}
