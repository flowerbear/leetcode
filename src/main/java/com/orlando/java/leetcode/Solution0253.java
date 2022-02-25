package com.orlando.java.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution0253 {

  public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0) return 0;

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    Queue<Integer> heap = new LinkedList<>();

    int result = 1;
    heap.offer(intervals[0][1]);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < heap.peek()) {
        result++;
        heap.offer(intervals[i][1]);
      } else {
        heap.offer(Math.max(intervals[i][1], heap.poll()));
      }
    }
    return result;
  }
}
