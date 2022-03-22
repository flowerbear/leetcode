package com.orlando.java.self001.from151to200;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Largest Number
 *
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 */
public class Solution0179 {

  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) return "";

    String[] s_num = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      s_num[i] = String.valueOf(nums[i]);
    }

    Arrays.sort(s_num, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
    if (s_num[0].charAt(0) == '0') return "0";

    StringBuilder sb = new StringBuilder();
    for (String s : s_num) sb.append(s);
    return sb.toString();
  }
}
