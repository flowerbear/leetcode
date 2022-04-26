package com.orlando.java.self001.from301to350;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Moving Average from Data Stream
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 */
public class Solution0346 {

  public static class MovingAverage {
    private Queue<Integer> q;
    private Long sum;
    private int max;

    public MovingAverage(int size) {
      q = new LinkedList<>();
      sum = 0l;
      max = size;
    }

    public double next(int val) {
      if (q.size() < max) {
        q.offer(val);
        sum += val;
        return (double) sum / q.size();
      } else {
        int first = q.poll();
        sum -= first;
        q.offer(val);
        sum += val;
        return (double) sum / q.size();
      }
    }
  }
}

