package com.orlando.java.leetcode;

import java.util.Arrays;

public class Solution0252 {

  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    for (int i = 0; i + 1 < intervals.length; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }
    return true;
  }
}
