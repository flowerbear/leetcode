package com.orlando.java.self001.from351to400;

import java.util.TreeSet;

/*
 * Max Sum of Rectangle No Large Than K
 *
 * Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum
 * is no larger than k.
 *
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 *
 */
public class Solution0363 {

  // https://www.quora.com/Given-an-array-of-integers-A-and-an-integer-k-find-a-subarray-that-contains-the-largest-sum-subject-to-a-constraint-that-the-sum-is-less-than-k
  public int maxSumSubmatrix(int[][] matrix, int k) {
    int row = matrix.length;
    if (row == 0) return 0;
    int col = matrix[0].length, m = Math.min(row, col), n = Math.max(row, col);

    boolean colIsBig = col > row;
    int result = Integer.MIN_VALUE;

    for (int i = 0; i < m; i++) {
      int[] array = new int[n];

      // Sum from row j to i
      for (int j = i; j >=0; j--) {
        int val = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        // traverse every column/row and sum up
        for (int h = 0; h < n; h++) {
          array[h] += colIsBig ? matrix[j][h] : matrix[h][j];
          val += array[h];
          Integer subres = set.ceiling(val - k);
          if (subres != null) {
            result = Math.max(result, val - subres);
          }
          set.add(val);
        }
      }
    }
    return result;
  }
}

