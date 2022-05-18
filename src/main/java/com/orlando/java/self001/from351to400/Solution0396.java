package com.orlando.java.self001.from351to400;

/*
 * Rotate Function
 *
 * You are given an integer array nums of length n.
 *
 * Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function
 * F on nums as follow:
 *
 *   > F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
 *
 * Return the maximum value of F(0), F(1), ..., F(n-1).
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 *
 */
public class Solution0396 {

  // F(k) = F(k - 1) + sum - nBk[0]
  public int maxRotateFunction(int[] nums) {

    int sum = 0, len = nums.length, f = 0;

    for (int i = 0; i < len; i++) {
      f += i * nums[i];
      sum += nums[i];
    }

    int max = f;
    for (int i = len - 1; i >= 1; i--) {
      f += sum - len * nums[i];
      max = Math.max(max, f);
    }

    return max;
  }
}

