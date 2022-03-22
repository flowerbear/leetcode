package com.orlando.java.self001.from51to100;

/*
 * Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in
 * the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 */
public class Solution0055 {

  public boolean canJump(int[] nums) {
    int curFarthest = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > curFarthest) return false;
      curFarthest = Math.max(i + nums[i], curFarthest);
      if (curFarthest >= nums.length - 1) return true;
    }

    return true;
  }
}
