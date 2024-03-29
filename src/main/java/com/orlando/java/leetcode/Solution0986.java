package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Interval List Intersections
 *
 */
public class Solution0986 {

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> result = new ArrayList<>();

    int i = 0, j = 0;

    while (i < firstList.length && j < secondList.length) {
      int lo = Math.max(firstList[i][0], secondList[j][0]);
      int hi = Math.min(firstList[i][1], secondList[j][1]);

      if (lo <= hi) {
        result.add(new int[]{lo, hi});
      }

      if (firstList[i][1] < secondList[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return result.toArray(new int[result.size()][]);
  }
}
