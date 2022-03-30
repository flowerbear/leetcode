package com.orlando.java.self001.from201to250;

import java.util.LinkedList;

/*
 * Sliding Window Maximum
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
 * of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 *
 * Return the max sliding window.
 *
 */
public class Solution0239 {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    LinkedList<Integer> dq = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (!dq.isEmpty() && dq.peek() < i - k + 1) {
        dq.poll();
      }
      while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
        dq.pollLast();
      }
      dq.offer(i);
      if (i - k + 1 >= 0) {
        result[i - k + 1] = nums[dq.peek()];
      }
    }
    return result;
  }
}
