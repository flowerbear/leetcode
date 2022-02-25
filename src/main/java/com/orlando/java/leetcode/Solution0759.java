package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution0759 {

  class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  };

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> result = new ArrayList<>();
    if (schedule == null | schedule.size() == 0) {
      return result;
    }

    List<Interval> list = new ArrayList<>();
    for (List<Interval> employSchedule : schedule) {
      list.addAll(employSchedule);
    }

    Collections.sort(list, (a, b) -> a.start - b.start);

    Interval prev = list.get(0);

    for (int i = 0; i < list.size(); i++) {
      Interval cur = list.get(i);
      if (prev.end < cur.start) {
        result.add(new Interval(prev.end, cur.start));
        prev = cur;
      } else {
        prev = prev.end < cur.end ? cur : prev;
      }
    }
    return result;
  }
}
