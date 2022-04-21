package com.orlando.java.self001.from301to350;

/*
 * Patching Array
 *
 * Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the
 * range [1, n] inclusive can be formed by the sum of some elements in the array.
 *
 * Return the minimum number of patches required.
 *
 */
public class Solution0330 {

  public int minPatches(int[] nums, int n) {
    long miss = 1;
    int i = 0, added = 0;

    while (miss <= n) {
      if (i < nums.length && nums[i] <= miss) {
        miss += nums[i++];
      } else {
        miss += miss;
        added++;
      }
    }
    return added;
  }
}

