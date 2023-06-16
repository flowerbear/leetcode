package com.orlando.java.self001.from851to900;

import java.util.LinkedList;
import java.util.List;

public class Solution0886 {


    boolean res = true;
    private boolean[] color;
    private boolean[] visited;

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int v) {
        if (!res) return;
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]) {
                    res = false;
                    return;
                }
            }
        }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n, dislikes);
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        for (int v = 1; v <= n; v++) {
            if (!visited[v]) traverse(graph, v);
        }
        return res;
    }
}

