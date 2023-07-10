package com.orlando.java.self001.from1051to1100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1091 {

    private class Node implements Comparable<Node> {
        // coordinate
        private int x, y;
        // g(node) is the cost of the path from the start node to node
        // f(node) = g(node) + h(node)
        private int g, f;

        private Node(int x, int y, int g, int h) {
            this.x = x; this.y = y; this.g = g; this.f = g + h;
        }

        @Override
        public int compareTo(Node node) {
            return this.f - node.f;
        }
    }

    private static int[][] DIRECTIONS = new int[][]{{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int endX = m - 1, endY = n - 1;
        if (grid[endX][endY] == 1 || grid[0][0] == 1) return -1;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] visited = new int[m * n];
        Arrays.fill(visited, Integer.MAX_VALUE);

        pq.add(new Node(0, 0, 1, Math.max(m, n)));

        while (!pq.isEmpty()) {
            Node node = pq.remove();
            int x = node.x, y = node.y;
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1) continue;

            if (x == endX && y == endY) return node.g;

            if (visited[x * m + y] <= node.g) continue;

            visited[x * m + y] = node.g;

            for (int[] dir : DIRECTIONS) {
                // for each successor
                // successor.g = node.g + distance between successor and node (equals to 1)
                // successor.h = estimate distance from successor to goal
                int g = node.g + 1;
                // h(node) is a heuristic function that
                // estimates the cost of the cheapest path from node to the goal
                // Here we use **Diagonal Distance** as heuristic function,
                // because we can and only can move in eight directions
                int h = Math.max(Math.abs(endX - x), Math.abs(endY - y));
                pq.add(new Node(x + dir[0], y + dir[1], g, h));
            }
        }
        return -1;
    }
}
