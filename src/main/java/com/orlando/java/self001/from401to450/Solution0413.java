package com.orlando.java.self001.from401to450;

/*
 * Arithmetic Slices
 *
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any
 * two consecutive elements is the same.
 *
 *   > For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 *
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 */
public class Solution0413 {

  public int numberOfArithmeticSlices(int[] nums) {
    int result = 0;
    for (int i = 2, prev = 0; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        prev++;
        result += prev;
      } else {
        prev = 0;
      }
    }
    return result;
  }
}

