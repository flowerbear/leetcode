package com.orlando.java.self001;

import java.util.Arrays;

/*
 * 3Sum Closest
 *
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum
 * is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 */
public class Solution0016 {

  // Similar as 3Sum; result = nums[0] + nums[1] + nums[n - 1]
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length, result = nums[0] + nums[1] + nums[n - 1];

    for (int i = 0; i < n; i++) {
      int l = i + 1, r = n - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum < target) l++;
        else r--;

        result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
      }
    }
    return result;
  }
}
