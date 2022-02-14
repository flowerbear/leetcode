package com.orlando.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false
 * if every element is distinct.
 */
public class Solution0217 {

  public boolean containsDuplicate(int[] nums) {
    int BIT_SIZE = 8;
    byte[] posMark = new byte[Integer.MAX_VALUE / BIT_SIZE + 1];
    byte[] negMark = new byte[Integer.MAX_VALUE / BIT_SIZE + 1];

    for (int i : nums) {
      boolean sign = i >= 0;
      i = sign ? i : -i;
      int hash = i >> 3;
      int index = i & 7;
      int check = 1 << index;
      if ((sign && (posMark[hash] & check) != 0) || (!sign && (negMark[hash] & check) != 0)) {
        return true;
      }
      if (sign) {
        posMark[hash] |= check;
      } else {
        negMark[hash] |= check;
      }
    }
    return false;
  }

  public boolean containsDuplicate1(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (!set.add(i)) return true;
    }
    return false;
  }
}
