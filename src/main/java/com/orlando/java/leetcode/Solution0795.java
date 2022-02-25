package com.orlando.java.leetcode;

public class Solution0795 {


  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    return count(nums, right) - count(nums, left - 1);
  }

  private int count(int[] nums, int bound) {
    int ans = 0, cnt = 0;
    for (int x : nums) {
      cnt = x <= bound ? cnt + 1 : 0;
      ans += cnt;
    }

    return ans;
  }
}
