package com.orlando.java.self001.from301to350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  public int[][] multiply1(int[][] mat1, int[][] mat2) {
    int r1 = mat1.length, c1 = mat1[0].length, c2 = mat2[0].length;
    int[][] res = new int[r1][c2];
    Map<Integer, List<Integer>> mp = new HashMap<>();
    for (int i = 0; i < r1; ++i) {
      for (int j = 0; j < c1; ++j) {
        if (mat1[i][j] != 0) {
          mp.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
        }
      }
    }
    for (int i = 0; i < r1; ++i) {
      for (int j = 0; j < c2; ++j) {
        if (mp.containsKey(i)) {
          for (int k : mp.get(i)) {
            res[i][j] += mat1[i][k] * mat2[k][j];
          }
        }
      }
    }
    return res;
  }

}

