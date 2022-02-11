package com.orlando.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    Given a binary array nums, return the maximum length of a contiguous subarray with
    an equal number of 0 and 1.
 */
public class Solution0525 {
  public int findMaxLength(int[] nums) {

    if (nums == null || nums.length == 0) {
      return 0;
    }

    int sum = 0, max = 0;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      sum += (nums[i] == 0 ? -1 : nums[i]);
      if (map.containsKey(sum)) {
        max = Math.max(max, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
    }

    return max;
  }
}
