package com.orlando.java.self001.from101to150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Triangle
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on
 * the current row, you may move to either index i or index i + 1 on the next row.
 *
 */
public class Solution0120 {

  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) return 0;

    int m = triangle.size();
    int[] dp = new int[m];
    for (int i = 0; i < m; i++) {
      dp[i] = triangle.get(m - 1).get(i);
    }

    for (int i = m - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
      }
    }
    return dp[0];
  }
}
