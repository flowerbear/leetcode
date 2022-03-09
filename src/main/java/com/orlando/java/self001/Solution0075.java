package com.orlando.java.self001;

/*
 * Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
 * color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 */
public class Solution0075 {

  public void sortColors(int[] nums) {
    if (nums == null || nums.length < 2) return;
    int low = 0, high = nums.length - 1;
    for (int i = low; i <= high; ) {
      if (nums[i] == 0) {
        int temp = nums[i];
        nums[i] = nums[low];
        nums[low] = temp;
        i++; low++;
      } else if (nums[i] == 2) {
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;
        high--;
      } else {
        i++;
      }
    }
  }
}
