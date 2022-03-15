package com.orlando.java.self001;

/*
 * Surrounded Regions
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 */
public class Solution0130 {

  public void solve(char[][] board) {
    int m = board.length;
    if (m == 0) return;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O')
        dfs(board, i, 0, m, n);
      if (board[i][n - 1] == 'O')
        dfs(board, i, n - 1, m, n);
    }

    for (int i = 0; i < n; i++) {
      if (board[0][i] == 'O')
        dfs(board, 0, i, m, n);
      if (board[m - 1][i] == 'O')
        dfs(board, m - 1, i, m, n);
    }

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
        if (board[i][j] == '#') board[i][j] = 'O';
      }
  }

  private void dfs(char[][] board, int x, int y, int m, int n) {
    if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;
    board[x][y] = '#';
    dfs(board, x - 1, y, m, n);
    dfs(board, x + 1, y, m, n);
    dfs(board, x, y - 1, m, n);
    dfs(board, x, y + 1, m, n);
  }
}
