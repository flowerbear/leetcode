package com.orlando.java.self001.from351to400;

/*
 * Combination Sum IV
 *
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations
 * that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 *
 */
public class Solution0377 {

  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i - nums[j] >= 0) {
          dp[i] = dp[i] + dp[i - nums[j]];
        }
      }
    }
    return dp[target];
  }
}

