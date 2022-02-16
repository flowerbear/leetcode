package com.orlando.java.leetcode;

/*
 * Missing Number
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 */
public class Solution0268 {

  public int missingNumber(int[] nums) {
     int xor = 0;
     for (int i = 0; i < nums.length; i++) {
       xor = xor ^ (i + 1) ^ nums[i];
     }
     return xor;
  }
}
