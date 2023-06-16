package com.orlando.java.self001.from751to800;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0785 {

    boolean res = true;

    boolean[] color;
    boolean[] visited;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) traverse(graph, v);
        }
        return res;
    }

    private void traverse(int[][] graph, int v) {
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

    public boolean isBipartite1(int[][] graph) {
        int n = graph.length;
        color =  new boolean[n];
        visited =  new boolean[n];

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                // 改为使用 BFS 函数
                bfs(graph, v);
            }
        }

        return res;
    }

    // 从 start 节点开始进行 BFS 遍历
    private void bfs(int[][] graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty() && res) {
            int v = q.poll();
            // 从节点 v 向所有相邻节点扩散
            for (int w : graph[v]) {
                if (!visited[w]) {
                    // 相邻节点 w 没有被访问过
                    // 那么应该给节点 w 涂上和节点 v 不同的颜色
                    color[w] = !color[v];
                    // 标记 w 节点，并放入队列
                    visited[w] = true;
                    q.offer(w);
                } else {
                    // 相邻节点 w 已经被访问过
                    // 根据 v 和 w 的颜色判断是否是二分图
                    if (color[w] == color[v]) {
                        // 若相同，则此图不是二分图
                        res = false;
                        return;
                    }
                }
            }
        }
    }
}

