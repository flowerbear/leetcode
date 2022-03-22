package com.orlando.java.self001.from101to150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 */
public class Solution0128 {

  public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) numSet.add(num);

    int result = 0;
    for (int num : nums) {
      if (!numSet.contains(num - 1)) {
        int currNum = num + 1;
        while (numSet.contains(currNum)) {
          currNum++;
        }
        result = Math.max(result, currNum - num);
      }
    }
    return result;
  }
}
