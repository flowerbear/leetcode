package com.orlando.java.self001.from251to300;

import java.util.Arrays;

/*
 * Longest Increasing Subsequence
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the
 * order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 */
public class Solution0300 {

  public int lengthOfLIS(int[] nums) {
    int result = 1, n = nums.length;
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

  public int lengthOfLIS1(int[] nums) {
    // tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
    int[] tails = new int[nums.length];
    int size = 0;
    // (1) if x is larger than all tails, append it, increase the size by 1
    // (2) if tails[i-1] < x <= tails[i], update tails[i]
    for (int x : nums) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tails[m] < x)
          i = m + 1;
        else
          j = m;
      }
      tails[i] = x;
      if (i == size) ++size;
    }
    return size;
  }
}
