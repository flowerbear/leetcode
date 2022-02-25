package com.orlando.java.self;

/*
 * Number of Islands
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number
 * of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You
 * may assume all four edges of the grid are all surrounded by water.
 *
 */
public class Solution0200 {

  private char[][] grid;

  private void dfs(int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;

    grid[i][j] = '0';
    dfs(i + 1, j);
    dfs(i - 1, j);
    dfs(i, j + 1);
    dfs(i, j - 1);
  }


  public int numIslands(char[][] grid) {
    this.grid = grid;

    if (grid.length == 0) return 0;

    int result = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; i++) {
        if (grid[i][j] == '1') {
          dfs(i, j);
          result++;
        }
      }
    }
    return result;
  }

  public int numIslands1(char[][] grid) {
    if (grid.length == 0) return 0;

    int result = 0;

    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs1(grid, i, j);
          result++;
        }
      }
    return result;
  }

  private void dfs1(char[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;

    grid[i][j] = '0';
    dfs1(grid, i - 1, j);
    dfs1(grid, i + 1, j);
    dfs1(grid, i, j - 1);
    dfs1(grid, i, j + 1);
  }
}
