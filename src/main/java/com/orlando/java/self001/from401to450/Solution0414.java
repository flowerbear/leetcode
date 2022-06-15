package com.orlando.java.self001.from401to450;

/*
 * Third Maximum Number
 *
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not
 * exist, return the maximum number.
 *
 */
public class Solution0414 {

  public int thirdMax(int[] nums) {
    long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > firstMax) {
        thirdMax = secondMax; secondMax = firstMax; firstMax = nums[i];
      } else if (nums[i] > secondMax && nums[i] < firstMax) {
        thirdMax = secondMax; secondMax = nums[i];
      } else if (nums[i] > thirdMax && nums[i] < secondMax) {
        thirdMax = nums[i];
      }
    }
    return (int) (thirdMax == Long.MIN_VALUE ? firstMax : thirdMax);
  }
}

