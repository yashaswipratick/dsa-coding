package com.coding.topics.graph.bfs;

import com.coding.topics.graph.AdjacencyListBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// PL - https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
public class Traversal {

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            res.add(poll);
            for (int i : adj.get(poll)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // adj[][] = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}}
        int[][] raw1 = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        System.out.println(bfs(AdjacencyListBuilder.buildAdjacencyList(raw1)));

        // adj[][] = {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}}
        int[][] raw2 = {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        System.out.println(bfs(AdjacencyListBuilder.buildAdjacencyList(raw2)));
    }
}
