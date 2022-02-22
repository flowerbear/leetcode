package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution0056 {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> result = new LinkedList<>();
    for (int[] interval :  intervals) {
      if (result.isEmpty() || result.getLast()[1] < interval[0]) {
        result.add(interval);
      } else {
        result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}
