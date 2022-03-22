package com.orlando.java.self001.from151to200;

/*
 * Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 */
public class Solution0189 {

  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++; end--;
    }
  }
}
