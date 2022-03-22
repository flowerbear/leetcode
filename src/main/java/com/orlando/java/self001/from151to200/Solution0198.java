package com.orlando.java.self001.from151to200;

/*
 * House Robber
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security
 * systems connected and it will automatically contact the police if two adjacent houses were broken into on
 * the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of
 * money you can rob tonight without alerting the police.


 *
 */
public class Solution0198 {

  public int rob(int[] nums) {
    int prev1 = 0, prev2 = 0;
    for (int n : nums) {
      int temp = prev1;
      prev1 = Math.max(prev2 + n, prev1);
      prev2 = temp;
    }

    return prev1;
  }
}
