package com.orlando.java.self001;

import java.util.Arrays;

/*
 * Maximal Rectangle
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's
 * and return its area.
 *
 */
public class Solution0085 {

  public int maximalRectangle(char[][] matrix) {

    if (matrix == null || matrix.length == 0) return 0;

    int m = matrix.length, n = matrix[0].length;
    int[] left = new int[n], right = new int[n], height = new int[n];
    int maxA = 0;
    Arrays.fill(right, n);

    for (int i = 0; i < m; i++) {
      int curLeft = 0, curRight = n;
      // Compute height
      for (int j = 0; j < n; j++) height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;

      // Compute left
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          left[j] = Math.max(left[j], curLeft);
        } else {
          left[j] = 0; curLeft = j + 1;
        }
      }

      // Compute right
      for (int j = n - 1; j >=0; j--) {
        if (matrix[i][j] == '1') {
          right[j] = Math.min(right[j], curRight);
        } else {
          right[j] = n; curRight = j;
        }
      }

      // Compute area
      for (int j = 0; j < n; j++) {
        maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
      }
    }
    return maxA;
  }
}
