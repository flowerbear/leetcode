package com.orlando.java.self001;

/*
 * Set Matrix Zeroes
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 */
public class Solution0073 {

  public void setZeroes(int[][] matrix) {
    boolean isCol = false;
    int R = matrix.length, C = matrix[0].length;

    for (int i = 0; i < R; i++) {
      if (matrix[i][0] == 0) {
        isCol = true;
      }
      for (int j = 1; j < C; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < R; i++)
      for (int j = 1; j < C; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }

    if (matrix[0][0] == 0) {
      for (int j = 0; j < C; j++)
        matrix[0][j] = 0;
    }

    if (isCol) {
      for (int i = 0; i < R; i++) matrix[i][0] = 0;
    }
  }
}
