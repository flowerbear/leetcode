package com.orlando.java.leetcode;

/*
 * House Robber II
 *
 */
public class Solution0213 {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];

    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  private int rob(int[] nums, int lo, int hi) {
    int prev1 = 0, prev2 = 0;
    for (int i = lo; i <= hi; i++) {
      int temp = prev1;
      prev1 = Math.max(prev2 + nums[i], prev1);
      prev2 = temp;
    }
    return prev1;
  }
}
