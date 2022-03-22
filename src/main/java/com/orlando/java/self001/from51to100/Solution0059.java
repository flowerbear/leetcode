package com.orlando.java.self001.from51to100;

/*
 * Spiral Matrix II
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 */
public class Solution0059 {

  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];

    if (n == 0) return matrix;

    int rowStart = 0, rowEnd = n - 1;
    int colStart = 0, colEnd = n - 1;
    int num = 1;
    while (rowStart <= rowEnd && colStart <= colEnd) {
      for (int i = colStart; i <= colEnd; i++) {
        matrix[rowStart][i] = num++;
      }
      rowStart++;

      for (int i = rowStart; i <= rowEnd; i++) {
        matrix[i][colEnd] = num++;
      }
      colEnd--;

      if (rowStart <= rowEnd) {
        for (int i = colEnd; i >= colStart; i--) {
          matrix[rowEnd][i] = num++;
        }
      }
      rowEnd--;

      if (colStart <= colEnd) {
        for (int i = rowEnd; i >= rowStart; i--) {
          matrix[i][colStart] = num++;
        }
      }
      colStart++;
    }
    return matrix;

  }
}
