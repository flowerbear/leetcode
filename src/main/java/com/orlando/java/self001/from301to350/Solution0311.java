package com.orlando.java.self001.from301to350;

/*
 * Sparse Matrix Multiplication
 *
 * Given two sparse matrices A and B, return the result of AB.
 *
 * You may assume that A's column number is equal to B's row number.
 *
 */
public class Solution0311 {

  public int[][] multiply(int[][] A, int[][] B) {
    int[][] v = new int[A.length][B[0].length];
    for (int i = 0; i < v.length; i++) {
      for (int k = 0; k < A[0].length; k++) {
        if (A[i][k] != 0) {
          for (int j = 0; j < v[0].length; j++) {
            v[i][j] += A[i][k] * B[k][j];
          }
        }
      }
    }
    return v;
  }

}

