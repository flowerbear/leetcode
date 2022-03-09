package com.orlando.java.self001;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
 * array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class Solution0056 {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    LinkedList<int[]> result = new LinkedList<>();
    for (int[] interval : intervals) {
      if (result.isEmpty() || result.getLast()[1] < interval[0]) {
        result.add(interval);
      } else {
        result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}
