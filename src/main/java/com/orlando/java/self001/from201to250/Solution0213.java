package com.orlando.java.self001.from201to250;

/*
 * House Robber II
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the
 * last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the
 * police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money
 * you can rob tonight without alerting the police.
 *
 */
public class Solution0213 {

  public int rob(int[] nums) {
    if (nums.length == 1) return  nums[0];
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  private int rob(int[] nums, int lo, int hi) {
    int prev1 = 0, prev2 = 0;
    for (int i = lo; i < hi; i++) {
      int temp = prev1;
      prev1 = Math.max(prev2 + nums[i], prev1);
      prev2 = temp;
    }
    return prev1;
  }
}
