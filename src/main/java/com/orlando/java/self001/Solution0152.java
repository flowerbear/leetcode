package com.orlando.java.self001;

/*
 * Maximum Product Subarray
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
 * and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 */
public class Solution0152 {

  public int maxProduct(int[] nums) {
    int result = nums[0];
    for (int i = 1, imax = 0, imin = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        int tmp = imax;
        imax = imin; imin = tmp;
      }

      imax = Math.max(nums[i], imax * nums[i]);
      imin = Math.min(nums[i], imin * nums[i]);

      result = Math.max(result, imax);
    }
    return result;
  }
}
