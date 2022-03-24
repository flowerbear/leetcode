package com.orlando.java.self001.from201to250;

import java.util.HashSet;
import java.util.Set;

/*
 * Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 */
public class Solution0217 {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      if (!set.add(n)) return true;
    }
    return false;
  }
}
