package com.orlando.java.self001.from351to400;

/*
 * Range Addition
 *
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 *
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray
 * A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 *
 * Return the modified array after all k operations were executed.
 *
 */
public class Solution0370 {

  public int[] getModifiedArray(int length, int[][] updates) {
    int[] nums = new int[length];
    int k = updates.length;
    for (int i = 0; i < k; i++) {
      int start = updates[i][0], end = updates[i][1], inc = updates[i][2];
      nums[start] += inc;
      if (end < length - 1) {
        nums[end + 1] -= inc;
      }
    }

    int sum = 0;
    for (int i = 0; i < length; i++) {
      sum += nums[i];
      nums[i] = sum;
    }
    return nums;
  }
}

