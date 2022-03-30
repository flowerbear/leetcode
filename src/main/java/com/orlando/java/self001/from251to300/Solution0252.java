package com.orlando.java.self001.from251to300;

import com.orlando.java.common.Interval;
import com.orlando.java.leetcode.Solution0759;

import java.util.Arrays;

/*
 * Meeting Rooms
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 */
public class Solution0252 {

  public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, (a, b) -> a.start - b.start);
    for (int i = 0; i + 1 < intervals.length; i++) {
      if (intervals[i].end > intervals[i + 1].start) return false;
    }
    return true;
  }
}
