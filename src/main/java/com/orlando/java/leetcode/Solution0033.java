package com.orlando.java.leetcode;

/*
 * Search in Rotated Sorted Array
 *
 */
public class Solution0033 {

  public int search(int[] nums, int target) {

    if (nums.length == 1) return nums[0] == target ? 0 : -1;

    int left = 0, right = nums.length - 1;

    while (right >= left) {
      int mid = (right + left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (target < nums[mid] && target >= nums[left]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[mid] <= nums[right]) {
        if (target > nums[mid] && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}
