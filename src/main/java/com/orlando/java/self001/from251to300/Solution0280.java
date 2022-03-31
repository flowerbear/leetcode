package com.orlando.java.self001.from251to300;

/*
 * Wiggle Sort
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 */
public class Solution0280 {

  public void wiggleSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1])) swap(nums, i);
    }
  }

  private void swap(int[] nums, int i) {
    int temp = nums[i - 1];
    nums[i - 1] = nums[i];
    nums[i] = temp;
  }
}
