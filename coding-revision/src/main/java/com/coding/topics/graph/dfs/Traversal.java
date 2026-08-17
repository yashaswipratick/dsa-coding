package com.coding.topics.graph.dfs;

import com.coding.topics.graph.AdjacencyListBuilder;

import java.util.ArrayList;

import static com.coding.topics.graph.AdjacencyListBuilder.buildAdjacencyList;

// PL - https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class Traversal {

    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[0] = true;
        dfsHelper(0, visited, adj, res);
        return res;
    }

    private static void dfsHelper(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        visited[i] = true;
        res.add(i);
        for (int j : adj.get(i)) {
            if (!visited[j]) {
                dfsHelper(j, visited, adj, res);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(dfs(buildAdjacencyList(new int[][]{{2, 3, 1}, {0}, {0, 4}, {0}, {2}})));
        System.out.println(dfs(AdjacencyListBuilder
                .buildAdjacencyList(new int[][]{{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}})));
    }
}
