package com.orlando.java.self001.from151to200;

import java.util.ArrayList;
import java.util.List;

/*
 * Missing Ranges
 *
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
 *
 */
public class Solution0163 {

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();
    int n = nums.length;
    if (n == 0) {
      if (lower <= upper) {
        result.add(getRange(lower, upper));
      }
      return result;
    }
    if (lower < nums[0]) result.add(getRange(lower, nums[0] - 1));
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1] && nums[i - 1] != nums[i] - 1) {
        result.add(getRange(nums[i - 1] + 1, nums[i] - 1));
      }
    }
    if (upper > nums[n - 1]) result.add(getRange(nums[n - 1] + 1, upper));
    return result;
  }

  private String getRange(int lower, int upper) {
    if (lower == upper) return lower + "";
    return lower + "->" + upper;
  }
}
