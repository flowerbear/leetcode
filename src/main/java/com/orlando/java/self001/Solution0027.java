package com.orlando.java.self001;

/*
 * Remove Element
 *
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The relative order of the elements may be changed.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 */
public class Solution0027 {

  public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) return 0;
    int i = 0;
    for (int n : nums) {
      if (n != val) {
        nums[i++] = n;
      }
    }
    return i;
  }
}
