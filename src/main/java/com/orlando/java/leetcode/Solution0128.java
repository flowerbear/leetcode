package com.orlando.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution0128 {

  public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int result = 0;

    for (int num : nums) {
      if (!numSet.contains(num - 1)) {
        int currNum = num;
        int currStreak = 1;

        while (numSet.contains(currNum + 1)) {
          currNum += 1;
          currStreak++;
        }

        result = Math.max(result, currStreak);
      }
    }

    return result;
  }
}
