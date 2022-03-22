package com.orlando.java.self001.from51to100;

/*
 * Search in Rotated Sorted Array II
 *
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums,
 * or false if it is not in nums.
 *
 * You must decrease the overall operation steps as much as possible.
 *
 */
public class Solution0081 {

  public boolean search(int[] nums, int target) {
    int start = 0, end = nums.length - 1, mid = -1;

    while (start <= end) {
      mid = start + (end - start) / 2;
      if (nums[mid] == target) return true;

      if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
        if (target > nums[mid] && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
        if (target < nums[mid] && target >= nums[start]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        end--;
      }
    }
    return false;
  }
}
