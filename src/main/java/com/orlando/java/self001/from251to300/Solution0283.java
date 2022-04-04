package com.orlando.java.self001.from251to300;

/*
 * Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
 * elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 */
public class Solution0283 {
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;
    int pos = 0;
    for (int n : nums) {
      if (n != 0) nums[pos++] = n;
    }

    while (pos < nums.length) {
      nums[pos++] = 0;
    }
  }
}
