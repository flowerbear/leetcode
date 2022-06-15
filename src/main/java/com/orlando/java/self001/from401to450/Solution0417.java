package com.orlando.java.self001.from401to450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Pacific Atlantic Water Flow
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean
 * touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where
 * heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east,
 * and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from
 * any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell
 * (ri, ci) to both the Pacific and Atlantic oceans.
 *
 */
public class Solution0417 {

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> result = new ArrayList<>();
    int[][] matrix = heights;
    int n = matrix.length, m = matrix[0].length;
    boolean[][] pacific = new boolean[n][m], atlantic = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
      dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
    }
    for (int i = 0; i < m; i++) {
      dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
      dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (pacific[i][j] && atlantic[i][j])
          result.add(Arrays.asList(i, j));
      }
    }
    return result;
  }

  private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
    int n = matrix.length, m = matrix[0].length;
    if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height) return;
    visited[x][y] = true;
    dfs(matrix, visited, matrix[x][y], x, y + 1);
    dfs(matrix, visited, matrix[x][y], x, y - 1);
    dfs(matrix, visited, matrix[x][y], x + 1, y);
    dfs(matrix, visited, matrix[x][y], x - 1, y);
  }
}

