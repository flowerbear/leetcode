package com.orlando.java.self;

/*
 * Max Area of Island
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 */
public class Solution0695 {

  private int[][] grid;
  private boolean[][] seen;

  private int dfs(int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || seen[i][j] || grid[i][j] == 0) {
      return 0;
    }

    seen[i][j] = true;

    return (1 + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1));
  }

  public int maxAreaOfIsland(int[][] grid) {
    this.grid = grid;
    this.seen = new boolean[grid.length][grid[0].length];

    int result = 0;

    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          result = Math.max(result, dfs(i, j));
        }
      }
    return result;
  }

  public int maxAreaOfIsland1(int[][] grid) {

    if (grid.length == 0) return 0;

    int result = 0;

    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          result = Math.max(result, dfs1(grid, i, j));
        }
      }

    return result;
  }

  private int dfs1(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;

    grid[i][j] = 0;
    return (1 + dfs1(grid, i - 1, j) + dfs1(grid, i + 1, j) + dfs1(grid, i, j - 1) + dfs1(grid, i, j + 1));
  }
}
