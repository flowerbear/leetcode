package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.List;

/*
 * Summary Ranges
 *
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 *  > "a->b" if a != b
 *  > "a" if a == b
 *
 */
public class Solution0228 {

  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int start = nums[i];
      while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) i++;

      if (start != nums[i])
        result.add(start + "->" + nums[i]);
      else
        result.add("" + start);
    }
    return result;
  }
}
