package com.orlando.java.self001.from101to150;

/*
 * Single Number II
 *
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 */
public class Solution0137 {

  public int singleNumber(int[] nums) {
    int x1 = 0, x2 = 0, mask = 0;

    for (int i : nums) {
      x2 ^= x1 & i;
      x1 ^= i;
      mask = ~(x1 & x2);
      x2 &= mask;
      x1 &= mask;
    }
    return x1;
  }
}
