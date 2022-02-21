package com.orlando.java.leetcode;

public class Solution0055 {

  public boolean canJump(int[] nums) {
    int n = nums.length, farest = 0;
    
    for (int i = 0; i < n; i++) {
      if (farest < i) return false;
      farest = Math.max(i + nums[i], farest);
    }
    
    return true;
  }
}
