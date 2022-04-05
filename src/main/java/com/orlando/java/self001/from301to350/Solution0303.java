package com.orlando.java.self001.from301to350;

/*
 * Range Sum Query - Immutable
 *
 * Given an integer array nums, handle multiple queries of the following type:
 *
 *   > Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 *
 * Implement the NumArray class:
 *
 *   > NumArray(int[] nums) Initializes the object with the integer array nums.
 *   > int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right
 *     inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 */
public class Solution0303 {

  int[] nums;

  public Solution0303(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[i - 1];
    }
    this.nums = nums;
  }

  public int sumRange(int left, int right) {
    if (left == 0) return nums[right];
    return nums[right] - nums[left - 1];
  }
}
