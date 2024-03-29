package com.orlando.java.self001.from151to200;

/*
 * Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority
 * element always exists in the array.
 *
 */
public class Solution0169 {

  // Boyer-Moore Majority Vote Algorithm
  public int majorityElement(int[] nums) {
    int major = nums[0], count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        count++;
        major = nums[i];
      } else if (major == nums[i]) {
        count++;
      } else {
        count--;
      }
    }
    return major;
  }
}
