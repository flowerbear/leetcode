package com.orlando.java.self001.from251to300;

/*
 * Find the Duplicate Number
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 */
public class Solution0287 {

  public int findDuplicate(int[] nums) {
    int n = nums.length, low = 1, high = n - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        if (nums[i] <= mid) cnt++;
      }
      if (cnt <= mid) low = mid + 1;
      else high = mid;
    }
    return low;
  }
}
