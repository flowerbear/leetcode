package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

  private class MonotonicQueue {

    private LinkedList<Integer> maxQ = new LinkedList<>();
    void push(int n) {
      while (!maxQ.isEmpty() && maxQ.getLast() < n ) maxQ.pollLast();
      maxQ.addLast(n);
    }
    int max() {
      return maxQ.getFirst();
    }
    void pop(int n) {
      if (n == maxQ.getFirst()) maxQ.pollFirst();
    }
  }

  public int[] maxSlidingWindow1(int[] nums, int k) {

    MonotonicQueue window = new MonotonicQueue();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i < k - 1) window.push(nums[i]);
      else {
        window.push(nums[i]);
        res.add(window.max());
        window.pop(nums[i - k + 1]);
      }
    }

    int[] arr = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      arr[i] = res.get(i);
    }
    return arr;
  }
}
