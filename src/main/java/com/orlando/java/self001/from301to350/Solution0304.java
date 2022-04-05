package com.orlando.java.self001.from301to350;

/*
 * Range Sum Query 2D - Immutable
 *
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 *
 *   > Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1)
 *     and lower right corner (row2, col2).
 *
 * Implement the NumMatrix class:
 *
 *   > NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 *   > int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the
 *     rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 */
public class Solution0304 {
  private int[][] sums;

  public Solution0304(int[][] matrix) {
    int row = matrix.length, col = matrix[0].length;
    sums = new int[row + 1][col + 1];
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        sums[i][j] = matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i -1][j -1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
  }
}
