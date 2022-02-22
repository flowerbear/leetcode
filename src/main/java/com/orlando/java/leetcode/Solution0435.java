package com.orlando.java.leetcode;

import java.util.Arrays;

public class Solution0435 {
  public int eraseOverlapIntervals(int[][] intervals) {

    if (intervals.length <= 1) return 0;

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
    int end = intervals[0][1];
    int count = 1;

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= end) {
        end = intervals[i][1];
        count++;
      }
    }

    return intervals.length - count;

  }
}
