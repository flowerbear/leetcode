package com.orlando.java.leetcode;

import java.util.Arrays;

/*
 * Longest Increasing Subsequence
 *
 */
public class Solution0300 {

  public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tails[m] < x) {
          i = m + 1;
        } else {
          j = m;
        }
      }
      tails[i] = x;
      if (i == size) size++;
    }
    return size;
  }

  public int lengthOfLISDP(int[] nums) {
    int result = 1, n = nums.length;;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          result = Math.max(result, dp[i]);
        }
      }
    }
    return result;
  }
}
