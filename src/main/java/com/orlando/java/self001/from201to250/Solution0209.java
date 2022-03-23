package com.orlando.java.self001.from201to250;

/*
 * Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 *
 */
public class Solution0209 {

  // Two pointers
  public int minSubArrayLen(int target, int[] nums) {
    int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

    while (j < nums.length) {
      sum += nums[j];
      j++;
      while (sum >= target) {
        min = Math.min(min, j - i);
        sum -= nums[i];
        i++;
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
