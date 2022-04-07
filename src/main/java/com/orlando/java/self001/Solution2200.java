package com.orlando.java.self001;

import java.util.ArrayList;
import java.util.List;

/*
 * Find All K-Distant Indices in an Array
 *
 * You are given a 0-indexed integer array nums and two integers key and k. A k-distant index is an index i of nums
 * for which there exists at least one index j such that |i - j| <= k and nums[j] == key.
 *
 * Return a list of all k-distant indices sorted in increasing order.
 *
 */
public class Solution2200 {

  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0, j = 0; i < nums.length; i++) {
      if (nums[i] == key) {
        for (j = Math.max(j, i - k); j <= i + k && j < nums.length; j++) {
          result.add(j);
        }
      }
    }
    return result;
  }
}
