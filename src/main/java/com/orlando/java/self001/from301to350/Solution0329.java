package com.orlando.java.self001.from301to350;

/*
 * Longest Increasing Path in Matrix
 *
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or
 * move outside the boundary (i.e., wrap-around is not allowed).
 *
 */
public class Solution0329 {

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0) return 0;

    int m = matrix.length, n = matrix[0].length;
    int[][] cache = new int[m][n];

    int max = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        max = Math.max(max, dfs(matrix, i, j, m, n, cache));
      }
    }
    return max;
  }

  private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {

    if (cache[i][j] != 0) return cache[i][j];
    int max = 1;
    for (int[] dir : DIRS) {
      int x = i + dir[0], y = j + dir[1];
      if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) continue;
      max = Math.max(max, 1 + dfs(matrix, x, y, m, n, cache));
    }
    cache[i][j] = max;
    return max;
  }


}

