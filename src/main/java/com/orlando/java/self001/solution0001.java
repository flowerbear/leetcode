package com.orlando.java.self001;

import java.util.HashMap;
import java.util.Map;

/*
 * Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
 * to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
*
 */
public class solution0001 {

  // Hashmap => nums[i], i
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[0];

    Map<Integer, Integer> subMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int sub = target - nums[i];
      if (subMap.containsKey(sub)) {
        return new int[]{i, subMap.get(sub)};
      } else {
        subMap.put(nums[i], i);
      }
    }
    return new int[0];
  }
}
