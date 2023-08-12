package com.orlando.java.self001.from451to500;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution0490 {

    // BFS
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        final int m = maze.length, n = maze[0].length, dirs[] = {0, 1, 0, -1, 0};
        Queue<int[]> q = new ArrayDeque<>(Arrays.asList(new int[]{start[0], start[1]}));
        boolean[][] seen = new boolean[m][n];
        seen[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            final int i = q.peek()[0], j = q.peek()[1];
            for (int k = 0; k < 4; k++) {
                int x = i, y = j;
                while (isValid(maze, x + dirs[k], y + dirs[k + 1])) {
                    x += dirs[k]; y += dirs[k + 1];
                }
                if (x == destination[0] && y == destination[1]) return true;
                if (seen[x][y]) continue;
                q.offer(new int[]{x, y});
                seen[x][y] = true;
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0;
    }

    // DFS
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        boolean[][] seen = new boolean[maze.length][maze[0].length];
        return dfs(maze, seen, start[0], start[1], destination);
    }

    private boolean dfs(int[][] maze, boolean[][] seen, int x, int y, int[] destination) {

        final int[] dirs = {0, 1, 0, -1, 0};
        if (x == destination[0] && y == destination[1]) return true;
        if (seen[x][y]) return false;
        seen[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int newX = x, newY = y;
            while (isValid(maze, newX + dirs[k], newY + dirs[k + 1])) {
                newX += dirs[k]; newY += dirs[k + 1];
            }
            if (dfs(maze, seen, newX, newY, destination)) return true;
        }
        return false;
    }
}