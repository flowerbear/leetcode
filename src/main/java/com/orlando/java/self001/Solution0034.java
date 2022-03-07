package com.orlando.java.self001;

/*
 * Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a
 * given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 */
public class Solution0034 {

  public int[] searchRange(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;

      if (nums[mid] < target) l = mid + 1;
      else if (nums[mid] > target) r = mid - 1;
      else {
        int i = mid, j = mid;
        while ((i >= 0 && nums[i] == target) || (j <= (nums.length -1) && nums[j] == target)) {
          if (i >= 0 && nums[i] == target) i--;
          if (j < nums.length && nums[j] == target) j++;
        }
        return new int[]{++i, --j};
      }
    }
    return new int[]{-1, -1};
  }
}
