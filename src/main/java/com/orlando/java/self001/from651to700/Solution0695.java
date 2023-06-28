package com.orlando.java.self001.from651to700;

public class Solution0695 {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length, result = 0;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}

