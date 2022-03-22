package com.orlando.java.self001.from151to200;

/*
 * Find Peak Element
 *
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 */
public class Solution0162 {

  public int findPeakElement(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  private int helper(int[] nums, int start, int end) {
    if (start == end) return start;
    else {
      int mid1 = start + (end - start) / 2;
      int mid2 = mid1 + 1;
      if (nums[mid1] > nums[mid2]) return helper(nums, start, mid1);
      else return helper(nums, mid2, end);
    }
  }

  public int findPeakElement1(int[] nums) {

    int n = nums.length;

    if (n == 1) return 0;
    if (nums[0] > nums[1]) return 0;
    if (nums[n - 1] > nums[n - 2]) return n - 1;

    int left = 1, right = n - 2;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
      else if (nums[mid] < nums[mid - 1]) right = mid - 1;
      else if (nums[mid] < nums[mid + 1]) left = mid + 1;
    }
    return -1;
  }
}
