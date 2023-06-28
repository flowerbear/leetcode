package com.orlando.java.self001.from651to700;

import java.util.HashSet;

public class Solution0694 {

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        HashSet<String> isLands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 888);
                    isLands.add(sb.toString());
                }
            }
        }
        return isLands.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append(dir).append(',');

        dfs(grid, i - 1, j, sb, 1);
        dfs(grid, i + 1, j, sb, 2);
        dfs(grid, i, j - 1, sb, 3);
        dfs(grid, i, j + 1, sb, 4);

        sb.append(-dir).append(',');
    }
}

