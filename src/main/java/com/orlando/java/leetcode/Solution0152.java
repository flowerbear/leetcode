package com.orlando.java.leetcode;

/*
 * Maximum Product Subarray
 *
 */
public class Solution0152 {

  public int maxProduct(int[] nums) {
    int result = nums[0];

    for (int i = 1, imax = result, imin = result; i < nums.length; i++) {
      if (nums[i] < 0) {
        int tmp = imax;
        imax = imin;
        imin = tmp;
      }

      imax = Math.max(nums[i], imax * nums[i]);
      imin = Math.min(nums[i], imin * nums[i]);

      result = Math.max(result, imax);
    }

    return result;
  }
}
