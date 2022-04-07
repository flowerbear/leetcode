package com.orlando.java.self001;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Minimum Operations to Halve Array Sum
 *
 * You are given an array nums of positive integers. In one operation, you can choose any number from nums and
 * reduce it to exactly half the number. (Note that you may choose this reduced number in future operations.)
 *
 * Return the minimum number of operations to reduce the sum of nums by at least half.
 *
 */
public class Solution2208 {

  public int halveArray(int[] nums) {
    double s = 0, k = 0; int i = 0;
    PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int x : nums) {
      pq.offer((double)x);
      s += x;
    }
    while (s - k > s /2) {
      double x = pq.poll();
      x /= 2;
      k += x;
      pq.offer(x);
      i++;
    }
    return i;
  }
}
