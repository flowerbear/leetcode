package com.orlando.java.self001.from351to400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Largest Divisible Subset
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i],
 * answer[j]) of elements in this subset satisfies:
 *
 *   > answer[i] % answer[j] == 0, or
 *   > answer[j] % answer[i] == 0
 *
 * If there are multiple solutions, return any of them.
 *
 */
public class Solution0368 {

  //Use DP to track max Set and pre index.
  public List<Integer> largestDivisibleSubset(int[] nums) {
    int len = nums.length;
    Arrays.sort(nums);
    int[] count = new int[len], pre = new int[len];
    int max = 0, index = -1;
    for (int i = 0; i < len; i++) {
      count[i] = 1;
      pre[i] = -1;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0) {
          if (1 + count[j] > count[i]) {
            count[i] = count[j] + 1;
            pre[i] = j;
          }
        }
      }
      if (count[i] > max) {
        max = count[i];
        index = i;
      }
    }
    List<Integer> result = new ArrayList<>();
    while (index != -1) {
      result.add(nums[index]);
      index = pre[index];
    }
    return result;
  }
}

