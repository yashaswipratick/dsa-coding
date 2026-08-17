package com.coding.topics.graph;

import com.coding.topics.graph.bfs.Traversal;

import java.util.ArrayList;

/**
 * Utility to build an adjacency list from a raw int[][] input.
 *
 * Input format:
 *   int[][] raw = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
 *
 * Output: ArrayList<ArrayList<Integer>> where index i holds the neighbors of node i.
 *
 * Node count = raw.length
 * Neighbors of node i = raw[i]
 */
public class AdjacencyListBuilder {

    /**
     * Converts int[][] edge-neighbor array into an ArrayList of ArrayLists.
     *
     * @param raw raw[i] contains direct neighbors of node i
     * @return adjacency list
     */
    public static ArrayList<ArrayList<Integer>> buildAdjacencyList(int[][] raw) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < raw.length; i++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (int neighbor : raw[i]) {
                neighbors.add(neighbor);
            }
            adj.add(neighbors);
        }

        return adj;
    }

    /**
     * Pretty-prints the adjacency list.
     *
     * @param adj adjacency list
     */
    /**
     * Builds an adjacency list from edge pairs for an undirected graph.
     *
     * @param V     total number of vertices (0 to V-1)
     * @param edges edge pairs, e.g. {{0,1},{2,1},{3,4}}
     * @return adjacency list of size V
     */
    public static ArrayList<ArrayList<Integer>> buildFromEdgePairs(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }
        return adj;
    }

    /**
     * Builds an adjacency list from an n×n adjacency matrix.
     * isConnected[i][j] == 1 means there is an edge between i and j.
     *
     * @param isConnected n×n matrix
     * @return adjacency list of size n
     */
    public static ArrayList<ArrayList<Integer>> buildFromMatrix(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }

    public static void print(ArrayList<ArrayList<Integer>> adj) {
        System.out.println("Adjacency List:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("  Node " + i + " -> " + adj.get(i));
        }
    }

    public static void main(String[] args) {
        // Example 1: adj[][] = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}}
        int[][] raw1 = {
            {2, 3, 1},  // Node 0 is connected to 2, 3, 1
            {0},        // Node 1 is connected to 0
            {0, 4},     // Node 2 is connected to 0, 4
            {0},        // Node 3 is connected to 0
            {2}         // Node 4 is connected to 2
        };

        System.out.println("=== Example 1 ===");
        ArrayList<ArrayList<Integer>> adj1 = buildAdjacencyList(raw1);
        print(adj1);

        // BFS traversal on Example 1
        Traversal traversal = new Traversal();
        System.out.println("BFS from node 0: " + traversal.bfs(adj1));

        System.out.println();

        // Example 2: adj[][] = {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}}
        int[][] raw2 = {
            {1, 2},     // Node 0 is connected to 1, 2
            {0, 2},     // Node 1 is connected to 0, 2
            {0, 1, 3, 4}, // Node 2 is connected to 0, 1, 3, 4
            {2},        // Node 3 is connected to 2
            {2}         // Node 4 is connected to 2
        };

        System.out.println("=== Example 2 ===");
        ArrayList<ArrayList<Integer>> adj2 = buildAdjacencyList(raw2);
        print(adj2);

        // BFS traversal on Example 2
        System.out.println("BFS from node 0: " + traversal.bfs(adj2));
    }
}

