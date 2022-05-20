package com.orlando.java.self001.from401to450;

import java.util.Arrays;

/*
 * Non-overlapping Intervals
 *
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
 * you need to remove to make the rest of the intervals non-overlapping.
 *
 */
public class Solution0435 {

  public int eraseOverlapIntervals(int[][] intervals) {
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

