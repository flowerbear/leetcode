package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0163 {

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();

    int next = lower;

    for (int i = 0; i < nums.length; i++) {
      if (lower == Integer.MAX_VALUE) return result;
      if (nums[i] < next) {
        continue;
      }
      if (nums[i] == next) {
        next++;
        continue;
      }
      result.add(getRange(next, nums[i] - 1));
    }

    if (next <= upper) {
      result.add(getRange(next, upper));
    }

    return result;
  }

  private String getRange(int n1, int n2) {
    return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
  }
}
