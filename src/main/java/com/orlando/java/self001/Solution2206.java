package com.orlando.java.self001;

import java.util.HashSet;
import java.util.Set;

/*
 * Divide Array Into Equal Pairs
 *
 * You are given an integer array nums consisting of 2 * n integers.
 *
 * You need to divide nums into n pairs such that:
 *
 *   > Each element belongs to exactly one pair.
 *   > The elements present in a pair are equal.
 *
 * Return true if nums can be divided into n pairs, otherwise return false.
 *
 */
public class Solution2206 {

  public boolean divideArray(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        set.remove(num);
      }
    }
    return set.isEmpty();
  }
}
