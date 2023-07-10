package com.orlando.java.self001.from401to450;

import java.util.TreeMap;

/*
 * Find Right Interval
 *
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
 *
 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that
 * i may equal j.
 *
 * Return an array of right interval indices for each interval i. If no right interval exists for interval i, then
 * put -1 at index i.
 *
 */
public class Solution0436 {

  public int[] findRightInterval(int[][] intervals) {
    int n = intervals.length, res[] = new int[n];
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) map.put(intervals[i][0], i);
    for (int i = 0; i < n; i++) {
      Integer key = map.ceilingKey(intervals[i][1]);
      res[i] = key != null ? map.get(key) : -1;
    }
    return res;
  }
}

