package com.orlando.java.self001.from1to50;

/*
 * Jump Game II
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 */
public class Solution0045 {

  public int jump(int[] nums) {
    int result = 0, curEnd = 0, curFarthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (i > curFarthest) return -1;
      curFarthest = Math.max(curFarthest, i + nums[i]);
      if (i == curEnd) {
        result++;
        curEnd = curFarthest;
        if (curEnd >= nums.length - 1) break;
      }
    }
    return result;
  }
}
