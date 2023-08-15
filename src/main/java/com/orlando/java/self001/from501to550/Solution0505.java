package com.orlando.java.self001.from501to550;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution0505 {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        final int[] dirs = {0, 1, 0, -1, 0};
        Queue<int[]> q = new ArrayDeque<>(Arrays.asList(new int[]{start[0], start[1]}));
        int[][] dist = new int[m][n];
        Arrays.stream(dist).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        dist[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            final int i = q.peek()[0], j = q.peek()[1];
            for (int k = 0; k < 4; k++) {
                int x = i, y = j;
                int steps = dist[i][j];
                while (isValid(maze, x + dirs[k], y + dirs[k + 1])) {
                    x += dirs[k]; y += dirs[k + 1]; steps++;
                }
                if (steps < dist[x][y]) {
                    dist[x][y] = steps;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >=0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }
}

