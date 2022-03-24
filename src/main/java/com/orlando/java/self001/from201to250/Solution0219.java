package com.orlando.java.self001.from201to250;

import java.util.HashSet;
import java.util.Set;

/*
 * Contains Duplicate II
 *
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in
 * the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 */
public class Solution0219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > k) set.remove(nums[i - k - 1]);
      if (!set.add(nums[i])) return true;
    }

    return false;
  }

}
