package com.orlando.java.leetcode;

/*
 * Number of Islands
 *
 */
public class Solution0200 {

  int y;
  int x;
  char[][] g;

  public int numIslands(char[][] grid) {
    g = grid;

    int result = 0;

    y = g.length;
    if (y == 0) return 0;
    x = g[0].length;

    for (int i = 0 ; i < y; i++) {
      for (int j = 0; j < x; j++) {
        if (g[i][j] == '1') {
          dfs(i, j);
          result++;
        }
      }
    }

    return result;
  }

  private void dfs(int i, int j) {
    if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;

    g[i][j] = '0';
    dfs(i + 1, j);
    dfs(i - 1, j);
    dfs(i, j + 1);
    dfs(i, j - 1);
  }
}
