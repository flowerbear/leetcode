package com.orlando.java.self001.from201to250;

/*
 * Maximal Square
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and
 * return its area.
 *
 */
public class Solution0221 {

  public int maximalSquare(char[][] matrix) {
    int r = matrix.length, c = matrix[0].length;
    int[][] dp = new int[r + 1][c + 1];
    int result = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (matrix[i][j] == '1') {
          dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
          result = Math.max(dp[i + 1][j + 1], result);
        }
      }
    }
    return result * result;
  }
}
