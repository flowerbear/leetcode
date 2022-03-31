package com.orlando.java.self001.from251to300;

import java.util.Arrays;

/*
 * 3Sum Smaller
 *
 * Given an array of n integers nums and a target, find the number of index triplets i, j,
 * k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 */
public class Solution0259 {

  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int lo = i + 1, hi = nums.length;
      while (lo < hi) {
        if (nums[i] + nums[lo] + nums[hi] < target) {
          result += hi - lo;
          lo++;
        } else {
          hi--;
        }
      }
    }
    return result;
  }

}
