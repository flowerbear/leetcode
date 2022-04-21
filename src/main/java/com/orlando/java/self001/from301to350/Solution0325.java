package com.orlando.java.self001.from301to350;

import java.util.HashMap;
import java.util.Map;

/*
 * Maximum Size Subarray Sum Equals k
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one,
 * return 0 instead.
 *
 * Note:
 *
 *   > The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 *
 */
public class Solution0325 {

  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, max = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) max = i + 1;
      else if (map.containsKey(sum - k)) {
        max = Math.max(max, i - map.get(sum - k));
      }
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
    }
    return max;
  }

}

