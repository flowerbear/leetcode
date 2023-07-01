package com.orlando.java.self001.from301to350;

/*
 * Burst Balloons
 *
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an
 * array nums. You are asked to burst all the balloons.
 *
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes
 * out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 *
 * Return the maximum coins you can collect by bursting the balloons wisely.
 *
 */
public class Solution0312 {

  // dp[i][j] in here means, the maximum coins we get after we burst all the balloons between i and j in the
  // original array.
  public int maxCoins(int[] iNums) {
    int[] nums = new int[iNums.length + 2];
    int n = 1;
    for (int x : iNums) if (x > 0) nums[n++] = x;
    nums[0] = nums[n++] = 1;


    int[][] dp = new int[n][n];
    for (int k = 2; k < n; ++k)
      for (int left = 0; left < n - k; ++left) {
        int right = left + k;
        for (int i = left + 1; i < right; ++i)
          dp[left][right] = Math.max(dp[left][right],
                  nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
      }

    return dp[0][n - 1];
  }
}

