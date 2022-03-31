package com.orlando.java.self001.from251to300;

/*
 * Single Number II
 *
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements
 * appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 */
public class Solution0260 {

  public int[] singleNumber(int[] nums) {
    int diff = 0;
    for (int num : nums) {
      diff ^= num;
    }

    diff &= -diff;

    int[] result = {0, 0};
    for (int num : nums) {
      if ((num & diff) == 0) result[0] ^= num;
      else result[1] ^= num;
    }
    return result;
  }
}
