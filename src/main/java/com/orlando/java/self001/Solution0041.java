package com.orlando.java.self001;

/*
 * First Missing Positive
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 */
public class Solution0041 {

  // If num is 5, swap to nums[4]
  // Return first place where the number is not right, place + 1;
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) return 1;
    for (int i = 0; i < nums.length; i++) {
        int curr = nums[i];
        while (curr - 1 >= 0 && curr - 1 < nums.length && curr != nums[curr - 1]) {
          int next = nums[curr - 1];
          nums[curr - 1] = curr;
          curr = next;
        }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) return i + 1;
    }
    return nums.length + 1;
  }
}
